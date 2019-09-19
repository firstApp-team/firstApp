package com.springboot.controller;

import com.springboot.model.Blog;
import com.springboot.model.User;
import com.springboot.service.BlogService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    User user1;
    ModelAndView mv = new ModelAndView();
    int gn_bid;

    @RequestMapping(value = "/blog",method= RequestMethod.POST)
    public ModelAndView getBlog(User user){
        user1 = userService.Sel(user.getName());
        Map map = new HashMap();
        if(user1==null) {
            mv.setViewName("err");
            mv.addObject("message","fail");
            return mv;
        }
        List<Blog> blog = blogService.SelBlog(user1.getId());
        List<Blog> otherBlog = blogService.SelOtherBlog(user1.getId());
        mv.setViewName("blog");
        for(Blog b:blog){
            map.put(b.getBid(), b.getBname());
        }
       // Map tempMap = new HashMap<Integer,String>();
        Map otherMap = new HashMap<Integer,String>();
        for(Blog b:otherBlog){
            otherMap.put(b.getBid(),b.getBname());
        }
        mv.addObject("map",map);
        mv.addObject("otherMap",otherMap);
        return mv;
    }

    @RequestMapping(value = "/newBlog")
    public ModelAndView InsBlog(Blog blog){
        mv.setViewName("newBlog");
        return mv;
    }

    @RequestMapping("/donewBlog")
    public String doRegist(Blog blog,Map<String,Object> map){
        blog.setUid(user1.getId());
        blogService.InsBlog(blog);
        return "success";
    }

    @RequestMapping(value = "/editBlog")
    public ModelAndView ShowBlog(int bid){
        mv.setViewName("editBlog");
        gn_bid = bid;
        Blog blog1 = blogService.ShowBlog(bid);
        mv.addObject("blog",blog1);
        return mv;
    }

    @RequestMapping(value = "/doeditBlog")
    public String EditBlog(Blog blog){
        blog.setBid(gn_bid);
        blogService.EditBlog(blog);
        return "success";
    }

    @RequestMapping(value = "/OtherBlog")
    public ModelAndView ShowOtherBlog(int bid){
        mv.setViewName("otherBlog");
        gn_bid = bid;
        Blog blog = blogService.ShowBlog(bid);
        mv.addObject("blog",blog);
        User fuser = userService.SelUser(blog.getUid());
        mv.addObject("user",fuser);


        User user = new User();
        user.setFid(blog.getUid());
        user.setId(user1.getId());
        int cnt = userService.SelFriend(user);
        mv.addObject("flag",cnt);
        Map map = new LinkedHashMap();
        List<Blog> remark = blogService.SelRemark(bid);
        for(Blog b:remark){
            User u = userService.SelUser(b.getUid());
            //暂时处理不了同一个人评论同一个博客，又不想创建新的对象
            map.put(b.getRid()+"楼："+u.getName(),b.getText());
        }

        mv.addObject("map",map);
        return mv;
    }

    @RequestMapping("/dofirend")
    public String doFriend(int id){
        user1.setFid(id);
        userService.InsFriend(user1);
        return "success";
    }

    @RequestMapping(value = "/dodelfirend")
    public String doDelFriend(int id){
        user1.setFid(id);
        userService.DelFriend(user1);
        return "success";
    }

    @RequestMapping("/doremark")
    public String doRemark(String remark){
        Blog blog = new Blog();
        blog.setBid(gn_bid);
        blog.setUid(user1.getId());
        blog.setText(remark);
        blogService.InsRemark(blog);
        return "success";
    }
}
