package com.example.ddd.domain.repository;

import com.example.ddd.domain.model.entity.User;

public interface UserRepository {

    void save();

    User query(Long id);
}
