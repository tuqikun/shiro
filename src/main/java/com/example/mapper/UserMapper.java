package com.example.mapper;/*
 *Created by tutu on 2018/4/16
 */

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
     public void insert(User user);
}
