package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by duyuqiang on 2019/9/4.
 */
@RestController
public class MainController {
    @RequestMapping(value="/")
    String home(){
        return "Hello world";
    }
}
