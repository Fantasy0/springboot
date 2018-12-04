package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.dao.SysPermissionMapper;
import com.example.mybatisdemo.entity.SysPermission;
import com.example.mybatisdemo.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SysPermissionServiceImpl extends BaseService<SysPermission> implements SysPermissionService {
    @Resource
    SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(long userId) {
        return sysPermissionMapper.selectPermissionByUserId(userId);
    }
}
