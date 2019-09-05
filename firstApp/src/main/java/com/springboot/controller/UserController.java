package com.springboot.controller;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public String GetUser(){
        return userService.Sel().toString();
    }
}
