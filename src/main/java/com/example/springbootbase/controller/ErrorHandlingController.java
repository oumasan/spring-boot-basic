package com.example.springbootbase.controller;

import com.example.springbootbase.model.BaseResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandlingController {

    Logger logger = LoggerFactory.getLogger(ErrorHandlingController.class);

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponseModel handleValidationException(MethodArgumentNotValidException e) {
        logger.error(e.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",")));
        return new BaseResponseModel(false, "5000");
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // レスポンスのステータスコード、ここでは500
    public BaseResponseModel handleException(Exception e) {
        logger.error(e.getMessage());
        return new BaseResponseModel(false, "5000");
    }
}