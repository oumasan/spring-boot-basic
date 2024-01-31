package com.example.springbootbase.controller;
import com.example.springbootbase.model.UserModel;
import com.example.springbootbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<UserModel> getHelloStrings() {
        return userService.getUsers();
    }
}