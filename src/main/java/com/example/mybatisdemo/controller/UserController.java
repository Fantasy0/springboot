package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.service.RedisService;
import com.example.mybatisdemo.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    RedisService redisService;
    @Resource
    UserService userService;
    @ApiOperation(value="查看所有用户", notes="查看所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "页数", paramType = "query"),
            @ApiImplicitParam(dataType = "Integer", name = "pageSize", value = "每页数量", paramType = "query")
    })
    @GetMapping("/getAll")
    public BaseDTO getAllUser(@RequestParam(required = false ,defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false ,defaultValue = "10") Integer pageSize) {
        PageInfo<User> userListPageInfo = userService.selectAllUser(pageNum,pageSize);
        List<User> userList = userListPageInfo.getList();
        Map<String, Object> userMap = new HashMap<>(16);
        userMap.put("userList", userList);
        userMap.put("pageNum", userListPageInfo.getPageNum());
        userMap.put("totalRow", userListPageInfo.getTotal());
        userMap.put("totalPage", userListPageInfo.getPages());
        return BaseDTO.successBaseDTO(userMap);
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiImplicitParam(name = "user" ,value = "用户信息",dataType = "User",required = true)
    @PostMapping("/saveUser")
    public BaseDTO saveUser(@RequestBody User user) {
        try {
            redisService.set(user.getName(),user);
            userService.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return BaseDTO.failBaseDTO();
        }
        return BaseDTO.successBaseDTO("saved username in redis");
    }
    @GetMapping(value = "/getuserfromredis")
    public Object getRedis(@RequestParam String key) {
        return redisService.get(key);
    }
}
