package com.example.springbootbase.service;

import com.example.springbootbase.entity.UserEntity;
import com.example.springbootbase.exception.ExclusionException;
import com.example.springbootbase.model.BaseResponseModel;
import com.example.springbootbase.model.UserModel;
import com.example.springbootbase.repository.UsersMapper;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackForClassName={"Exception"})
    public BaseResponseModel updateUser(UserModel user) {
        UserEntity userEntity = modelMapper.map(user , UserEntity.class);
        int updatedCount = usersMapper.update(userEntity);
        // 排他制御
        if (updatedCount == 0) {
            throw new ExclusionException();
        }
        return new BaseResponseModel();
    }

    @Override
    @Transactional(rollbackForClassName={"Exception"})
    public BaseResponseModel deleteUser(UserModel user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        int deletedCount = usersMapper.delete(userEntity);
        // 排他制御
        if (deletedCount == 0) {
            throw new ExclusionException();
        }
        return new BaseResponseModel();
    }
}
