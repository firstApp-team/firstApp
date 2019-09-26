package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Mapper
public interface UserMapper{
//    查询
    User checkLoginUser(User user);

    //查询是否存在同名用户
    int selectUserName(String username);

//    注册
    void registUser(User user);

    //根据uid查询用户
    User selectUser(String userId);

    //加好友
    void insertFriend(User user);

    //查询好友
    int selectFriend(User user);

    //删除好友
    void deleteFriend(User user);
}
