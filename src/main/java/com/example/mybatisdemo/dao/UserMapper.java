package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.utils.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
}