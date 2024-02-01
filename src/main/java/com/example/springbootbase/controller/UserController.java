package com.example.springbootbase.controller;
import com.example.springbootbase.model.BaseResponseModel;
import com.example.springbootbase.model.UserModel;
import com.example.springbootbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String test() {
        return "test";
    }
    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public BaseResponseModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }
}