package com.qfedu.sport.service;

import com.qfedu.sport.domain.Address;
import com.qfedu.sport.vo.Result;

import java.util.List;

public interface AddressService {


    Result selectAllAddress(int uid);


    Result updateAddress(Address address);

    Result selectById(Integer id);

    Result delById(Integer id);
}
