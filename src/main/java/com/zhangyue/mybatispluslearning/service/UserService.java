package com.zhangyue.mybatispluslearning.service;

import com.zhangyue.mybatispluslearning.domain.User;
import com.zhangyue.mybatispluslearning.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> queryAllUsers();
}
