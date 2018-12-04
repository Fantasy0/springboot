package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.dao.SysUserMapper;
import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }
}
