package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Mapper
public interface UserMapper{
//    查询
    User Sel(User user);

    //查询是否存在同名用户
    int SelUsername(String username);

//    注册
    void Regist(User user);

    //根据uid查询用户
    User SelUser(int id);

    //加好友
    void InsFriend(User user);

    //查询好友
    int SelFriend(User user);

    //删除好友
    void DelFriend(User user);
}
