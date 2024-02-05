package com.example.springbootbase.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springbootbase.model.AuthForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private DaoAuthenticationProvider provider;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthForm form) {
        try {
            // DaoAuthenticationProviderを用いた認証
            // UserDetailService.loadUserByUsernameが動く
            provider.authenticate(new UsernamePasswordAuthenticationToken(form.getUserName(), form.getPassword()));
            // JWTトークンの生成
            String token = JWT.create().withClaim("username",form.getUserName())
                    .sign(Algorithm.HMAC256("__secret__"));
            // トークンをクライアントに返す
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-AUTH-TOKEN", token);
            return new ResponseEntity(httpHeaders, HttpStatus.OK);
        } catch (AuthenticationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
