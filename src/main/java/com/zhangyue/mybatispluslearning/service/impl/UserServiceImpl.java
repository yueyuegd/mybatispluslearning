package com.zhangyue.mybatispluslearning.service.impl;

import com.zhangyue.mybatispluslearning.domain.User;
import com.zhangyue.mybatispluslearning.dto.UserDTO;
import com.zhangyue.mybatispluslearning.mapper.UserMapper;
import com.zhangyue.mybatispluslearning.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> queryAllUsers() {
        List<User> userList = userMapper.selectList(null);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
