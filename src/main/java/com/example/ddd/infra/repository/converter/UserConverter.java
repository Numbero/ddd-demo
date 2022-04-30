package com.example.ddd.infra.repository.converter;


import com.example.ddd.common.Converter;
import com.example.ddd.domain.model.entity.User;
import com.example.ddd.infra.repository.model.UserDO;

public class UserConverter implements Converter<User, UserDO> {
    @Override
    public UserDO serialize(User user) {
        return new UserDO();
    }

    @Override
    public User deserialize(UserDO userDO) {
        return new User();
    }
}
