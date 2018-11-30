package com.example.mybatisdemo.controller;

import com.example.PersonService;
import com.example.mybatisdemo.base.BaseDTO;
import com.example.mybatisdemo.entity.FastJsonTest;
import com.example.mybatisdemo.entity.TestPerson;
import com.example.mybatisdemo.service.PerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Value("${spring.person.name}")
    String name;
    @Value("${spring.person.age}")
    Integer age;
    @Resource
    PersonService personService;
    @Resource
    PerService perService;
    @GetMapping("getUser")
    public BaseDTO getUser(){
        List<TestPerson> list = perService.selectPerson();
        Map<String, Object> map = new HashMap<>(16);
        map.put("person", list);
        return BaseDTO.successBaseDTO(map);
    }
    @GetMapping("getUser2")
    public String getUser2() {
        personService.sayHello();
        log.info(name + "," + age);
        return "name：" + name + ",age:" + age;
    }
    @GetMapping("fastJson")
    public FastJsonTest getFastJson() {
            return new FastJsonTest(1, "admin",new Date());
    }
}
