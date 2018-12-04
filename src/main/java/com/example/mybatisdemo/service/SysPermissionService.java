package com.example.mybatisdemo.service;

import java.util.List;

public interface SysPermissionService {
    List<String>  selectPermissionByUserId(long userId);
}
