package com.example.springbootbase.service;

import com.example.springbootbase.controller.ErrorHandlingController;
import com.example.springbootbase.entity.AuthEntity;
import com.example.springbootbase.entity.UserEntity;
import com.example.springbootbase.repository.AuthMapper;
import com.example.springbootbase.repository.UsersMapper;
import com.example.springbootbase.security.LoginUserDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(LoginUserDetailsService.class);

    @Autowired
    private AuthMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("LoginUserDetailsService.loadUserByUsername: " + username);
        AuthEntity auth = mapper.findByName(username);
        if (auth == null) {
            throw new UsernameNotFoundException("username not found.");
        }
        logger.info("username:" + username + " found ");
        return new LoginUserDetails(auth);
    }
}
