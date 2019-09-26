package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyuqiang on 2019/9/5.
 */
//TODO 清理无用注释
//TODO 使用域概念命名连接地址 例如 添加好友地址为/friend/add 添加好友页面地址为/friend/add.html
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    ModelAndView mv = new ModelAndView();

    @RequestMapping(value="/login")
    public ModelAndView getLoger(){
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value="/dologin")
    public ModelAndView doLogin(User user, HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8"); //转码
        //TODO 校验后的提示信息直接显示在登陆页面中,不要跳转.
        /**
         * 进行用户密码校验
         */
        if(user.getName()==""){
            mv.setViewName("login");
            try {
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('用户名不能为空，请输入！');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }else if(user.getPassword()==""){
            mv.setViewName("login");
            try {
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('密码不能为空，请输入！');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }
        //获取是否存在登陆人信息
        User reg_user = userService.checkLoginUser(user);
        if(reg_user == null){
            mv.setViewName("login");
            try {
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('用户名或者密码错误，请重新输入！');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }
        //TODO 增加密码校验
        //将登录人信息封装在request中
        request.getSession().setAttribute("userName",reg_user.getName());
        request.getSession().setAttribute("userId",reg_user.getId());
        //跳转到blog页面
        mv.setViewName("redirect:/blog/show");
        return mv;
    }

    @RequestMapping(value="/register")
    public ModelAndView getRegister(User user){
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/doregist")
    public ModelAndView doRegist(User user,String queryPassword,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        //设置登录人ID
        user.setId();
        PrintWriter out = response.getWriter();
        //是否需要写个共有方法
        if(user.getName() == ""){//判断用户名是否为空
            mv.setViewName("register");
            try {
                out.flush();
                out.print("<script>");
                out.println("alert('用户名不能为空，请输入！');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }else if(user.getPassword()==""){ //判断密码是否为空
            mv.setViewName("register");
            try {
                out.flush();
                out.print("<script>");
                out.println("alert('密码不能为空，请输入！');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }else if(!(user.getPassword().equals(queryPassword))){ //判断密码是否一致
            mv.setViewName("register");
            try {
                out.flush();
                out.print("<script>");
                out.println("alert('密码与确认密码不一致，请重新输入!');");
                out.println("history.back();");
                out.println("</script>");
            }catch (Exception e){
                e.printStackTrace();
            }
            return mv;
        }
        //判断是否存在同名用户
        //TODO 本功能需调整为前台ajax动态检查

        //插入用户信息
        userService.registUser(user);
        mv.setViewName("success");
        mv.addObject("msg","注册成功");
        mv.addObject("ie","login");
        return mv;
    }

    @RequestMapping(value = "/ajax")
    @ResponseBody
    public Map<String,String> ajax(String name){
        Map map = new HashMap<String,String>();
        int flag = userService.selectUserName(name);
        if(flag != 0){
            map.put("result","true");
        }else {
            map.put("result","false");
        }
        return map;
    }
}
