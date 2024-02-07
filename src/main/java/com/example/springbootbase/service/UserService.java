package com.example.springbootbase.service;

import com.example.springbootbase.exception.ExclusionException;
import com.example.springbootbase.model.BaseResponseModel;
import com.example.springbootbase.model.UserModel;

import java.util.List;

/**
 * ユーザーサービスインターフェース
 */
public interface UserService {
    List<UserModel> getUsers();
    BaseResponseModel createUser(UserModel user);
    BaseResponseModel updateUser(UserModel user) throws ExclusionException;
    BaseResponseModel deleteUser(UserModel user);
}
