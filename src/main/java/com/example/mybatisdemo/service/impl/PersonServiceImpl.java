package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.dao.TestPersonMapper;
import com.example.mybatisdemo.entity.TestPerson;
import com.example.mybatisdemo.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private TestPersonMapper testPersonMapper;
    @Override
    public List<TestPerson> selectPerson() {
        return testPersonMapper.selectPerson();
    }
}
