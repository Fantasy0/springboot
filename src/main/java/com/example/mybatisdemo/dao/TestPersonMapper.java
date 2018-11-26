package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.entity.TestPerson;
import com.example.mybatisdemo.utils.MyMapper;

import java.util.List;

public interface TestPersonMapper extends MyMapper<TestPerson> {
    /**
     * 查询用户信息
     * @return 返回用户信息
     */
    List<TestPerson> selectPerson();
}