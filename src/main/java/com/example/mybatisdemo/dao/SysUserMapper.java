package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.utils.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName);
}