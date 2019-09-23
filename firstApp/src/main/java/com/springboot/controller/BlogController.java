package com.springboot.controller;

import com.springboot.model.Blog;
import com.springboot.model.User;
import com.springboot.service.BlogService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    ModelAndView mv = new ModelAndView();

//    @RequestMapping("/showallblog")
//    public ModelAndView getAllBlog(HttpSession session){
//        List<Blog> Recommend_blog = null;
//            if(session.getAttribute("username") == null){
//                Recommend_blog = blogService.SelrecommendBlog();
//        }else{
//            //获取登录用户ID
//            Object uid = session.getAttribute("userid");
//            int userid = Integer.parseInt(uid.toString());
//            //获取非登陆人的博客信息
//            Recommend_blog = blogService.SelOtherBlog(userid);
//        }
//        mv.setViewName("showallblog");
//
//        mv.addObject("recommendblog",Recommend_blog);
//        return mv;
//    }

    @RequestMapping(value = "/blog")
    public ModelAndView getBlog(HttpSession session){
        List<Blog> Recommend_blog = null;
        if(session.getAttribute("username") == null){
            Recommend_blog = blogService.SelrecommendBlog();
        }else{
            //获取登录用户ID
            Object uid = session.getAttribute("userid");
            int userid = Integer.parseInt(uid.toString());
            //获取非登陆人的博客信息
            Recommend_blog = blogService.SelOtherBlog(userid);
            //获取登录人的博客信息
            List<Blog> blog = blogService.SelBlog(userid);
            mv.addObject("blog",blog);
        }
        mv.setViewName("blog");
        mv.addObject("recommendblog",Recommend_blog);
        return mv;
    }

//    @RequestMapping(value = "/blog")
//    public ModelAndView getBlog(HttpSession session){
//        //获取登录用户ID
//        Object uid = session.getAttribute("userid");
//        //获得推荐blog
//        List<Blog> Recommend_blog = blogService.SelrecommendBlog();
//
//        //如果是登录状态
//       if(uid!=null){
//           int userid = Integer.parseInt(uid.toString());
//           mv.setViewName("blog");
//           //获取登录人的博客信息
//           List<Blog> blog = blogService.SelBlog(userid);
//           mv.addObject("blog",blog);
//
//           //获取非登陆人的博客信息
//           Recommend_blog = blogService.SelOtherBlog(userid);
//       }
//
//        mv.addObject("recommendblog",Recommend_blog);
//        return mv;
//    }

    @RequestMapping(value = "/newBlog")
    public ModelAndView InsBlog(){
        mv.setViewName("newBlog");
        return mv;
    }

    @RequestMapping(value="/donewBlog")
    public ModelAndView doRegist(Blog blog,HttpSession session){
        //获取登录人的id
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        //设置博客所属人的ID
        blog.setUid(userid);
        //插入博客表
        blogService.InsBlog(blog);
        mv.setViewName("success");
        mv.addObject("msg","发布成功");
        mv.addObject("ie","blog");
        return mv;
    }

    @RequestMapping(value = "/editBlog")
    public ModelAndView ShowBlog(Blog blog,HttpSession session){
        String username = session.getAttribute("username").toString();
        mv.setViewName("editBlog");
        //获取博客的信息
        Blog blog1 = blogService.ShowBlog(blog.getBid());
        mv.addObject("blog",blog1);
        return mv;
    }

    @RequestMapping(value = "/doeditBlog")
    public ModelAndView EditBlog(Blog blog,int flag){
        mv.setViewName("success");
        /*flag=1表示修改成功，flag=2表示删除成功*/
        if(flag == 1){
            blog.setBid(blog.getBid());
            blogService.EditBlog(blog);
            mv.addObject("msg","修改成功");
        }else if(flag == 2){
            blogService.DelBlog(blog.getBid());
            mv.addObject("msg","删除成功");
        }
        //解决跳转问题
        mv.addObject("ie","blog");
        return mv;
    }

    @RequestMapping(value = "/OtherBlog")
    public ModelAndView ShowOtherBlog(int bid,HttpSession session){
        mv.setViewName("otherBlog");
        //获取博客信息
        Blog blog = blogService.ShowBlog(bid);
        //显示博客内容
        mv.addObject("blog",blog);
        //获得博客所属人信息
        User fuser = userService.SelUser(blog.getUid());
        //显示博客所属人信息
        mv.addObject("user",fuser);

        //没有登录直接跳
        if(session.getAttribute("userid")!=null){
            //定义登陆人对象
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            User user = userService.SelUser(userid);
            //设置博客所属人id
            user.setFid(blog.getUid());

            //判断是否已经是好友，如果是1则在页面上显示删好友，如果是0则显示加好友
            int cnt = userService.SelFriend(user);
            mv.addObject("flag",cnt);
            //将博客所属人id更改为登陆人id
            blog.setUid(userid);
        }
        Map map = new LinkedHashMap();
        //获取评论信息
        List<Blog> remark = blogService.SelRemark(blog);
        for(Blog b:remark){
            User u = userService.SelUser(b.getUid());
            map.put(b,u);
        }
        //显示评论信息
        mv.addObject("map",map);
        return mv;
    }

    @RequestMapping("/dofirend")
    public ModelAndView doFriend(int fid,int bid,HttpSession session){
        mv.setViewName("success");
        User user = new User();
        //获取登录人ID
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        //设置登录人id
        user.setId(userid);
        //设置博客所属人id
        user.setFid(fid);
        //添加好友
        userService.InsFriend(user);
        mv.addObject("msg","好友添加成功");
        mv.addObject("ie","OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping(value = "/dodelfirend")
    public ModelAndView doDelFriend(int fid,int bid,HttpSession session){
        mv.setViewName("success");
        User user = new User();
        //获取登陆人id
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        //设置要删除的朋友id
        user.setFid(fid);
        //设置登陆人id
        user.setId(userid);
        //删除好友
        userService.DelFriend(user);
        mv.addObject("msg","删除好友成功");
        mv.addObject("ie","OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping("/doremark")
    public ModelAndView doRemark(String remark,int bid,HttpSession session){
        mv.setViewName("success");
        //获取登陆人id
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        Blog blog = new Blog();
        //设置博客id
        blog.setBid(bid);
        //设置登陆人id
        blog.setUid(userid);
        //设置评论内容
        blog.setText(remark);
        //插入评论表
        blogService.InsRemark(blog);
        mv.addObject("msg","评论成功");
        mv.addObject("ie","OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping("/dodelremark")
    public ModelAndView delRemark(int rid,int bid){
        mv.setViewName("success");
        //调用删除评论 功能
        blogService.Delremark(rid);
        mv.addObject("msg","评论删除成功");
        mv.addObject("ie","OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping("/doexit")
    public ModelAndView doexit(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        mv.setViewName("exituser");
        mv.addObject("ie","blog");
        return mv;
    }
}
