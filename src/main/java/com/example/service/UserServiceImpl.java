package com.example.service;/*
 *Created by tutu on 2018/4/16
 */

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
            userMapper.insert(user);
    }
}
