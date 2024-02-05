package com.example.springbootbase.controller;

import com.example.springbootbase.entity.AuthEntity;
import com.example.springbootbase.repository.AuthMapper;
import com.example.springbootbase.security.LoginUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Controller処理前後
 */
public class AppInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AppInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        logger.info(request.getMethod() + ":" + request.getRequestURI());
        return true;
    }
}
