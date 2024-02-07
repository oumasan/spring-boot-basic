package com.example.springbootbase.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * カスタム例外
 * 認証トークンなし例外
 */
public class NoAuthenticationTokenException extends AuthenticationException {
    public NoAuthenticationTokenException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoAuthenticationTokenException(String msg) {
        super(msg);
    }
}
