package com.example.ddd.infra.repository;

import com.example.ddd.domain.model.entity.User;
import com.example.ddd.domain.repository.UserRepository;
import com.example.ddd.infra.repository.dao.UserDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserDAO userDAO;

    @Override
    public void save() {

    }

    @Override
    public User query(Long id) {
        return null;
    }
}
