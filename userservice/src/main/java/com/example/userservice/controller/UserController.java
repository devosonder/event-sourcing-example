package com.example.userservice.controller;

import com.example.userservice.model.UserServiceUser;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserServiceUser create(@RequestBody UserServiceUser user) {
        return userService.create(user);
    }

    @GetMapping("/")
    public UserServiceUser get(String id) {
        return userService.get(id);
    }
}
