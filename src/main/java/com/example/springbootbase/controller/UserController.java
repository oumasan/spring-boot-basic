package com.example.springbootbase.controller;
import com.example.springbootbase.model.BaseResponseModel;
import com.example.springbootbase.model.UserModel;
import com.example.springbootbase.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String test() {
        return "test";
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/users")
    public BaseResponseModel createUser(@Valid @RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @PutMapping("/users")
    public BaseResponseModel updateUser(@Valid @RequestBody UserModel user) {
        return userService.updateUser(user);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @DeleteMapping("/users")
    public BaseResponseModel deleteUser(@Valid @RequestBody UserModel user) {
        return userService.deleteUser(user);
    }
}