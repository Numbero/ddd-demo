package com.example.ddd.infra.repository.dao;

import com.example.ddd.infra.repository.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDAO {

    @Resource
    private UserMapper userMapper;


}
