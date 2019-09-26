package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by duyuqiang on 2019/9/4.
 */
@RestController
public class MainController {
    @RequestMapping(value="/aaa")
    public ModelAndView home(){
//        ModelAndView mv = new ModelAndView("redirect:/showallblog");
//        mv.setViewName("showallblog");
        ModelAndView mv = new ModelAndView("redirect:/blog/show");
        return mv;
    }
}
