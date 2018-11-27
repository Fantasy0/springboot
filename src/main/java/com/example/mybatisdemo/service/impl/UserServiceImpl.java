package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.dao.UserMapper;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl extends BaseService<User> implements UserService  {
    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public PageInfo<User> selectAllUser(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList =  userMapper.selectAllUser();
        return new PageInfo<>(userList);
    }

}
