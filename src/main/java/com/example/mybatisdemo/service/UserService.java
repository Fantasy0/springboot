package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    PageInfo<User> selectAllUser(Integer pageNum,Integer pageSize);

    void saveUser(User user);
}
