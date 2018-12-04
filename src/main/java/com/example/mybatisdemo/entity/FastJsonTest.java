package com.example.mybatisdemo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class FastJsonTest {
    @JsonIgnore
    private Integer id;

    private String name;
    @JSONField(format = "yyyy-mm-dd")
    private Date date;
}
