package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/user/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean success = userService.register(user);
        if (success) {
            response.put("success", true);
            response.put("message", "Registration successful");
        } else {
            response.put("success", false);
            response.put("message", "Account already exists");
        }
        return response;
    }
}