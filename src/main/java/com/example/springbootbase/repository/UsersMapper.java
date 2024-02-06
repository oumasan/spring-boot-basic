package com.example.springbootbase.repository;

import com.example.springbootbase.entity.AuthEntity;
import com.example.springbootbase.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ユーザーマッパー
 */
@Mapper
@Repository
public interface UsersMapper {

    /**
     * ユーザー情報全取得
     * @return ユーザーリスト
     */
    List<UserEntity> findAll();

    int insert(UserEntity user);

    int update(UserEntity user);

    int delete(UserEntity user);
}
