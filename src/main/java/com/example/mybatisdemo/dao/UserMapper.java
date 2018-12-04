package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.utils.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    String getPassword(String username);

    String getRole(String username);

    List<User> selectAllUser();
}