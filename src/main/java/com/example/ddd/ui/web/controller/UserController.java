package com.example.ddd.ui.web.controller;

import com.example.ddd.infra.repository.dao.UserDAO;
import com.example.ddd.infra.repository.model.UserDO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Resource
    private UserDAO userDAO;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        List<UserDO> users = userDAO.selectUsers();
        return "ok";
    }

}
