package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    //显示好友
    List<User> showFriend(String id);

    //确认好友
    void queryFriend(String fid);

    //检查申请好友请求
    List<User> selectQueryFriend(String id);

    //删除好友请求
    void deleteQueryFriend(String id);
}
