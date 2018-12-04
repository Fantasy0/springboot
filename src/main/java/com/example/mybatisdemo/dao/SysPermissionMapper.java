package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.entity.SysPermission;
import com.example.mybatisdemo.utils.MyMapper;

import java.util.List;

public interface SysPermissionMapper extends MyMapper<SysPermission> {
    List<String> selectPermissionByUserId( long userId);
}