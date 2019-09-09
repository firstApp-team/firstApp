package com.springboot.controller;

import com.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Controller
public class UserController {
    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public ModelAndView GetUser(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");//返回文件名
        mv.addObject("message","hello kitty");

        //类
        User user = new User();
        user.setId(2);
        user.setName("b");
        mv.addObject("user",user);

        //List
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mv.addObject("bookList",list);

        //Map
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan","北京");
        map.put("lisi","上海");
        map.put("wangwu","深圳");
        mv.addObject("map",map);

        return mv;
    }

    @RequestMapping("/show")
    public Map<String,String> getMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("key1","value-1");
        map.put("key2","value-2");
        return map;
    }
}
