package com.zhangyue.mybatispluslearning.User.service.impl;

import com.zhangyue.mybatispluslearning.User.entity.User;
import com.zhangyue.mybatispluslearning.User.mapper.UserMapper;
import com.zhangyue.mybatispluslearning.User.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyue
 * @since 2019-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
