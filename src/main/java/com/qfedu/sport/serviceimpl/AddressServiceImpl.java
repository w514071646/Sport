package com.qfedu.sport.serviceimpl;

import com.qfedu.sport.dao.AddressMapper;
import com.qfedu.sport.domain.Address;
import com.qfedu.sport.service.AddressService;
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
    public List<Address> selectAllAddress(int uid) {


        return addressMapper.selectAllAddress(uid);
    }
    //修改地址信息
    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateByPrimaryKey(address);
    }


}
