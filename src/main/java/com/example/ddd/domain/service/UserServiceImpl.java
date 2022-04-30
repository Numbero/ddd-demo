package com.example.ddd.domain.service;

import com.example.ddd.app.service.UserService;
import com.example.ddd.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

}
