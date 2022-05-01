package com.example.ddd.infra.repository.model;

import lombok.Data;

@Data
public class UserDO {

    private Long id;

    private String name;

    private String password;

    private String phone;

}
