package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.SysUser;

public interface SysUserService {
    SysUser findByUserName(String userName);
}
