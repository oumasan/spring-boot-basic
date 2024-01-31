package com.example.springbootbase.service;

import com.example.springbootbase.model.UserModel;

import java.util.List;

/**
 * ユーザーサービスインターフェース
 */
public interface UserService {
    List<UserModel> getUsers();
}
