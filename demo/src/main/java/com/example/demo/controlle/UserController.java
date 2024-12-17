package com.example.demo.controlle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user/hi")
    public  String hello(){
        return  "Hi~~~";
    }
}
