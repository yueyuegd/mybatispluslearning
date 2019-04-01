package com.zhangyue.mybatispluslearning.controller;


import com.zhangyue.mybatispluslearning.common.Result;
import com.zhangyue.mybatispluslearning.dto.UserDTO;
import com.zhangyue.mybatispluslearning.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.zhangyue.mybatispluslearning.common.Result.success;

@RestController
@RequestMapping(value = "mybatisplus/userController")
@Api(value = "与用户有关的API接口")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有用户")
    public Result<List<UserDTO>> userList() {
        System.out.println(("----- selectAll method test ------"));
        List<UserDTO> userList = userService.queryAllUsers();
        userList.forEach(System.out::println);
        return success(userList);
    }
}

