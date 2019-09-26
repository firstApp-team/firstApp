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
    public User checkLoginUser(User user){
        return userMapper.checkLoginUser(user);
    }

    @Override
    public void registUser(User user){
        userMapper.registUser(user);
    }

    @Override
    public User selectUser(String userId){return userMapper.selectUser(userId);}

    @Override
    public void insertFriend(User user) {userMapper.insertFriend(user);}

    @Override
    public int selectFriend(User user) {return userMapper.selectFriend(user);}

    @Override
    public void deleteFriend(User user) {userMapper.deleteFriend(user);}

    @Override
    public int selectUserName(String username) {return userMapper.selectUserName(username);}
}
