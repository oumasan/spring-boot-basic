package com.example.springbootbase.service;

import com.example.springbootbase.entity.UserEntity;
import com.example.springbootbase.model.BaseResponseModel;
import com.example.springbootbase.model.UserModel;
import com.example.springbootbase.repository.UsersMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザーサービス実装
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * ユーザー情報全取得
     * @return ユーザーリスト
     */
    @Override
    public List<UserModel> getUsers() {
        List<UserEntity> userEntityList = usersMapper.findAll();
        return modelMapper.map(userEntityList , new TypeToken<List<UserModel>>() {}.getType());
    }

    @Override
    public BaseResponseModel createUser(UserModel user) {
        UserEntity userEntity = modelMapper.map(user , UserEntity.class);
        usersMapper.insert(userEntity);
        return new BaseResponseModel();
    }

    @Override
    public BaseResponseModel updateUser(UserModel user) {
        // TODO 排他制御
        UserEntity userEntity = modelMapper.map(user , UserEntity.class);
        usersMapper.update(userEntity);
        return new BaseResponseModel();
    }
}
