package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Repository;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Repository
@Mapper
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public interface UserMapper {
    User Sel();
}
