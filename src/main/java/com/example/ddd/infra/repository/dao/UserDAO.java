package com.example.ddd.infra.repository.dao;

import com.example.ddd.infra.repository.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO {

    int insert(UserDO record);

    void deleteUserById(@Param("id") Long id);

    void updateUser(UserDO user);

    List<UserDO> selectUsers();

}
