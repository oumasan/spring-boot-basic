package com.example.springbootbase.security;

import com.example.springbootbase.entity.AuthEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class LoginUserDetails implements UserDetails {

    private final AuthEntity user;

    public LoginUserDetails(AuthEntity user, String role) {
        this.user = user;

    }

    // ユーザーが持つ権限を返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    // ユーザーアカウントが有効期限切れでないかを判定する
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // ユーザーアカウントがロックされていないかを判定する
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 認証情報が有効期限切れでないかを判定する
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
