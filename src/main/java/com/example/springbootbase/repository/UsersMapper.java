package com.example.springbootbase.repository;

import com.example.springbootbase.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ユーザーマッパー
 */
@Mapper
public interface UsersMapper {

    /**
     * ユーザー情報全取得
     * @return ユーザーリスト
     */
    List<UserEntity> getAll();
}
