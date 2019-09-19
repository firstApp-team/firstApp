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
    public User Sel(String name){
        return userMapper.Sel(name);
    }

    @Override
    public void Regist(String name){
        userMapper.Regist(name);
    }

    @Override
    public User SelUser(int id){return userMapper.SelUser(id);}

    @Override
    public void InsFriend(User user) {userMapper.InsFriend(user);}

    @Override
    public int SelFriend(User user) {return userMapper.SelFriend(user);}

    @Override
    public void DelFriend(User user) {userMapper.DelFriend(user);}
}
