package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        User loggedInUser = userService.login(user.getAccount(), user.getPwd());
        if (loggedInUser != null) {
            return loggedInUser;
        } else {
            return null; // or throw an exception
        }
    }
}