package com.example.sdd.service;

import com.example.sdd.dao.UserMapper;
import com.example.sdd.entity.User;
import com.example.sdd.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    //user login service
    public User login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return userMapper.login(userName, passwordMd5);
    }

    //user register with MD5 encoding
    public int register(String userName, String password, String email)
    {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        User temp_usr = new User();
        temp_usr.setEmail(email);
        temp_usr.setUserName(userName);
        temp_usr.setPassword(passwordMd5);
        return userMapper.insert(temp_usr);
    }
}
