package com.qfedu.sport.serviceimpl;

import com.qfedu.sport.dao.AddressMapper;
import com.qfedu.sport.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;



}
