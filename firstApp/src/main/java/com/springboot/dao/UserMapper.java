package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Mapper
public interface UserMapper{
//    查询
    User Sel();

//    注册

}
