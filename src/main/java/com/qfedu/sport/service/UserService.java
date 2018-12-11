package com.qfedu.sport.service;

import com.qfedu.sport.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 发送邮箱验证码
     * @param email 需要注册的邮箱账号
     * @return 返回验证码是否成功信息
     */
    public Result EmailCode(String email);

    /**
     * 邮箱注册账号
     * @param email 邮箱账号
     * @param code 邮箱验证码
     * @return 返回注册是否成功信息
     */
    public Result regist(String email, String password,String code);

    /**
     * 登录
     * @param email 用户输入的邮箱账号
     * @param password 用户输入的密码
     * @return 返回是否登录成功信息
     */
    public Result login(String email, String password, String token, HttpServletRequest request, HttpServletResponse response);

    /**
     * 登出
     * @param token 用户登录凭证令牌
     * @return 返回是否登出成功信息
     */
    public Result loginOut(String token);

    public Result updatePassword(String email, String password, String code);
}
