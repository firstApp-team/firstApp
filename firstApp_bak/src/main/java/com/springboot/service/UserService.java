package com.springboot.service;

import com.springboot.dao.UserMapper;
import com.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Service
public class UserService implements  UserMapper{
    @Autowired
    UserMapper userMapper;

    @Override
    public User Sel(){
        return userMapper.Sel();
    }
}
