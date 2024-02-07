package com.example.springbootbase.controller;

import com.example.springbootbase.constants.ErrorConstants;
import com.example.springbootbase.exception.ExclusionException;
import com.example.springbootbase.exception.NoAuthenticationTokenException;
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

/**
 * 例外ハンドラ
 */
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
        return new BaseResponseModel(false, ErrorConstants.VALIDATION);
    }

    @ExceptionHandler({NoAuthenticationTokenException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponseModel handleAuthenticationException(NoAuthenticationTokenException e) {
        logger.error(e.getMessage());
        return new BaseResponseModel(false, ErrorConstants.AUTH);
    }

    @ExceptionHandler({ExclusionException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public BaseResponseModel handleExclusionException(ExclusionException e) {
        logger.info("Exclusion exception occurs");
        return new BaseResponseModel(false, ErrorConstants.EXCLUSION);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponseModel handleException(Exception e) {
        logger.error(e.getMessage());
        return new BaseResponseModel(false, ErrorConstants.SYSTEM);
    }
}