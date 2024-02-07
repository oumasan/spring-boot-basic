package com.example.springbootbase.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootbase.exception.NoAuthenticationTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class AuthorizeFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(AuthorizeFilter.class);
    private final AntPathRequestMatcher matcher = new AntPathRequestMatcher("/login");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!matcher.matches(request)) {
            logger.info("AuthorizeFilter.doFilterInternal");
            // ヘッダーの認証トークンチェック
            String xAuthToken = request.getHeader("X-AUTH-TOKEN");
            if (xAuthToken == null || !xAuthToken.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }
            // tokenの検証と認証
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("__secret__")).build().verify(xAuthToken.substring(7));
            // ユーザーネームの取得
            String userName = decodedJWT.getClaim("username").toString();
            // ユーザーの権限を作成
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
            // ログイン状態の設定
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userName, null, Collections.singletonList(authority)));
        }
        filterChain.doFilter(request, response);
    }
}
