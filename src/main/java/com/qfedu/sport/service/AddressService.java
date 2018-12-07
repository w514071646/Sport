package com.qfedu.sport.service;

import com.qfedu.sport.domain.Address;
import com.qfedu.sport.vo.Result;

import java.util.List;

public interface AddressService {


    List<Address> selectAllAddress(int uid);


    int updateAddress(Address address);
}
