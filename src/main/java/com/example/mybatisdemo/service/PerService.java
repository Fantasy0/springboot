package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.TestPerson;

import java.util.List;

public interface PerService {
    /**
     * 查询用户信息
     * @return 返回用户信息
     */
    List<TestPerson> selectPerson();
}
