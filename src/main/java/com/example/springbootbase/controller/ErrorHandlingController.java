package com.example.springbootbase.controller;

import com.example.springbootbase.model.BaseResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // レスポンスのステータスコード、ここでは500
    public BaseResponseModel handleException(Exception e) {
        return new BaseResponseModel(false, "5000");
    }
}