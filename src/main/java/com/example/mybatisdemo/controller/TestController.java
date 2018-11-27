package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import com.example.mybatisdemo.entity.TestPerson;
import com.example.mybatisdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Value("${pocket.name}")
    String name;
    @Value("${pocket.age}")
    Integer age;
    @Resource
    PersonService personService;
    @GetMapping("getUser")
    public BaseDTO getUser(){
        List<TestPerson> list = personService.selectPerson();
        Map<String, Object> map = new HashMap<>(16);
        map.put("person", list);
        return BaseDTO.successBaseDTO(map);
    }
    @GetMapping("getUser2")
    public String getUser2(){
        System.out.println(name);
        return "name："+name+"age:"+age;
    }
}
