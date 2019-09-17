package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Mapper
public interface UserMapper{
//    查询
    User Sel(String name);

//    注册
    void Regist(String name);

    //根据uid查询用户
    User SelUser(int id);

    //加好友
    void InsFriend(User user);
}
