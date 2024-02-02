package com.example.springbootbase.config;

import com.example.springbootbase.controller.AppInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * インターセプターの登録
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    AppInterceptor interceptor() {
        return new AppInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor());
    }
}
