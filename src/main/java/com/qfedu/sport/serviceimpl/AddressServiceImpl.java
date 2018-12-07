package com.qfedu.sport.serviceimpl;

import com.qfedu.sport.dao.AddressMapper;
import com.qfedu.sport.domain.Address;
import com.qfedu.sport.service.AddressService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    //查询所有收货地址
    @Override
    public Result selectAllAddress(int uid) {

        if (addressMapper.selectAllAddress(uid).size()>0||addressMapper.selectAllAddress(uid) != null) {
            return Result.success(addressMapper.selectAllAddress(uid));
        }else {
            return  Result.error(CodeMsg.ERROR);
        }
    }
    //修改地址信息
    @Override
    public Result updateAddress(Address address) {
        if (addressMapper.updateByPrimaryKey(address) > 0) {
           return Result.success( addressMapper.updateByPrimaryKey(address));
        }else {
            return  Result.error(CodeMsg.ERROR);
        }
    }

    //查询指定收货地址信息
    @Override
    public Result selectById(Integer id) {
        if (addressMapper.selectById(id) !=null) {
            return Result.success(addressMapper.selectById(id));
        }else {
            return  Result.error(CodeMsg.ERROR);
        }
    }
    //删除指定收货地址
    @Override
    public Result delById(Integer id) {
        return Result.success(addressMapper.deleteByPrimaryKey(id));
    }


}
