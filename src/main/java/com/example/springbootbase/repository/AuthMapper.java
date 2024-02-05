package com.example.springbootbase.repository;

import com.example.springbootbase.entity.AuthEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    AuthEntity findByName(String userName);
}
