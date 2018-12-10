package com.qfedu.sport.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.sport.constant.SystemCon;
import com.qfedu.sport.dao.JedisUtil;
import com.qfedu.sport.dao.UserMapper;
import com.qfedu.sport.domain.User;
import com.qfedu.sport.service.UserService;
import com.qfedu.sport.token.TokenUtil;
import com.qfedu.sport.util.StringUtil;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private UserMapper userMapper;

    JedisUtil jedisUtil = new JedisUtil("10.8.162.65",6379,"gaoyue123");

    @Override
    public Result EmailCode(String email) {
        Random random = new Random();
        //生成随机的6位数验证码
        String code="";
        for (int i=0;i<6;i++)
        {
            code+=random.nextInt(10);
        }

        jedisUtil.addStr(email,code, TimeUnit.MINUTES,3);

        //建立邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom(sender);
        //接收者
        message.setTo(email);
        //发送的标题
        message.setSubject("运动App验证码");
        //发送的内容
        message.setText("您本次的验证码为:"+code);
        jms.send(message);
        return Result.success(null);
    }

    @Override
    public Result regist(String email, String password, String code) {
        User user = userMapper.selectByEmail(email);
        System.out.println("email2:" + email);
        //判断邮箱是否已经注册
        if (user != null) {
            return Result.error(CodeMsg.ERROR);
        } else {
            User user1 = new User();
            user1.setEmail(email);
            user1.setPassword(password);
            return userMapper.insertSelective(user1) > 0 ? Result.success(null) : Result.error(CodeMsg.ERROR);
        }
    }

    @Override
    public Result login(String email, String password, String token, HttpServletRequest request, HttpServletResponse response) {
        if (token != null && token.length() > 0) {
            String value=jedisUtil.getHash(SystemCon.TOKENHASH,"token:"+token);
            if(StringUtil.checkNoEmpty(value)){
                User user=JSON.parseObject(value,User.class);
                Result result = new Result();
                result.setData(user);
                result.setMsg("登录有效");
                result.setCode(0);
                return result;
            }else{
                return Result.error(CodeMsg.ERROR);
            }
        } else {
            //获取登录的用户对象
            User user=userMapper.selectByEmail(email);
            //校验用户名是否存在
            if(user!=null){
                if(Objects.equals(user.getPassword(),password)){
                    //登录成功
                    //生成令牌
                    String origenToken= TokenUtil.createToken(JSON.toJSONString(user),user.getId());
                    //存储令牌到Redis
                    //采用Hash类型 存储的键为固定字符串+Token 存储的值是对应用户信息的json字符串
                    jedisUtil.addHash(SystemCon.TOKENHASH,"token:"+origenToken,JSON.toJSONString(user));
                    //返回值需要携带生成Token和对应的登录信息
                    Result result = new Result();
                    result.setCode(0);
                    result.setMsg("登录成功");
                    result.setData(origenToken);
                    result.setOther(user);
                    return result;
                }
            }
            return Result.error(CodeMsg.ERROR);
        }
    }


}
