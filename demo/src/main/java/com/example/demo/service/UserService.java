package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String account, String pwd) {
        return userMapper.findByAccountAndPwd(account, pwd);
    }

    public boolean register(User user) {
        if (userMapper.findByAccount(user.getAccount()) != null) {
            return false; // Account already exists
        }
        userMapper.save(user);
        return true;
    }
}