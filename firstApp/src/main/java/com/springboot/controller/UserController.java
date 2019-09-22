package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyuqiang on 2019/9/5.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/login")
    public ModelAndView getLoger(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value="/dologin")
    public ModelAndView doLogin(User user,HttpServletRequest request){
        ModelAndView mv=new ModelAndView();

        /**
         * 进行用户密码校验
         */
        if(user.getName()==""){
            mv.setViewName("err");
            mv.addObject("msg","用户名不能为空");
            mv.addObject("ie","login");
            return mv;
        }else if(user.getPassword()==""){
            mv.setViewName("err");
            mv.addObject("msg","密码不能为空");
            mv.addObject("ie","login");
            return mv;
        }
        //获取是否存在登陆人信息
        User reg_user = userService.Sel(user);
        if(reg_user == null){
            mv.setViewName("err");
            mv.addObject("msg","该用户不存在");
            mv.addObject("ie","login");
            return mv;
        }
        //将登录人信息封装在request中
        request.getSession().setAttribute("username",reg_user.getName());
        request.getSession().setAttribute("userid",reg_user.getId());
        //跳转到blog页面
        mv.setViewName("redirect:/blog");
        return mv;
    }

    @RequestMapping(value="/register")
    public ModelAndView getRegister(User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("registered");
        return mv;
    }

    @RequestMapping("/doregist")
    public ModelAndView doRegist(User user,String queryPassword){
        ModelAndView mv = new ModelAndView();

        //是否需要写个共有方法
        if(user.getName() == ""){//判断用户名是否为空
            mv.setViewName("err");
            mv.addObject("msg","用户名不能为空");
            mv.addObject("ie","register");
            return mv;
        }else if(user.getPassword()==""){ //判断密码是否为空
            mv.setViewName("err");
            mv.addObject("msg","密码不能为空");
            mv.addObject("ie","register");
            return mv;
        }else if(user.getPassword().equals(queryPassword)){ //判断密码是否一致
            mv.setViewName("err");
            mv.addObject("msg","密码与确认密码不一致");
            mv.addObject("ie","register");
            return mv;
        }
        //判断是否存在同名用户
        int flag = userService.SelUsername(user.getName());
        if(flag != 0){
            mv.setViewName("err");
            mv.addObject("msg","该用户名已存在");
            mv.addObject("ie","register");
            return mv;
        }
        //插入用户信息
        userService.Regist(user);
        mv.setViewName("success");
        mv.addObject("msg","注册成功");
        mv.addObject("ie","login");
        return mv;
    }

//    @RequestMapping(value="/getUser", method = RequestMethod.POST)
//    public ModelAndView GetUser(User user,Map<String,Object> map){
//        User user1 = userService.Sel(user.getName());
//
//        ModelAndView mv = new ModelAndView();
//
//        if(user1==null) {
//            mv.setViewName("err");
//            mv.addObject("message","fail");
//            return mv;
//        }
//        else{
//            map.put("msg","登录成功");
//        }
//
//        mv.setViewName("welcome");//返回文件名
//
//
//        mv.addObject("message","hello kitty");
//
//        //类
//        mv.addObject("user",user);
//
//        //List
//        List<String> list = new ArrayList<String>();
//        list.add("java");
//        list.add("c++");
//        list.add("oracle");
//        mv.addObject("bookList",list);
//
//        //Map
////        Map<String,String> map = new HashMap<String,String>();
//        map.put("zhangsan","北京");
//        map.put("lisi","上海");
//        map.put("wangwu","深圳");
//        mv.addObject("map",map);
//
//        return mv;
//    }

    @RequestMapping("/show")
    public Map<String,String> getMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("key1","value-1");
        map.put("key2","value-2");
        return map;
    }
}
