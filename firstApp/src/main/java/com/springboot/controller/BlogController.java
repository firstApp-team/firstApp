package com.springboot.controller;

import com.springboot.model.Blog;
import com.springboot.model.User;
import com.springboot.service.BlogService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//TODO 清理无用注释
@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    ModelAndView mv = new ModelAndView();

    //获取页面入口
    @RequestMapping(value="/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("redirect:/blog/show");
        return mv;
    }


  @RequestMapping(value = "/blog/show")
    public ModelAndView getBlog(HttpSession session, HttpServletResponse response){
        //定义推荐博客
        List<Blog> recommendBlog = null;
        //TODO 使用驼峰命名法,大量方法和变量存在本问题,自行检查,也包括Mapper和Service中的,同时方法命名需要调整,取消简写,如selBlog改为selectBlog,尽可能的让方法名可以说明方法功能
        //TODO 接上条 在UserService中直接使用sel作为查询,在BlogService中改成了SelBlog ,不够统一,推荐使用第一种方法
        if(session.getAttribute("userName") == null){
            recommendBlog = blogService.selectRecommendBlog();
        }else{
            //获取登录用户ID
            String userId = session.getAttribute("userId").toString();
            //检查申请好友请求
            List<User> user = userService.selectQueryFriend(userId);
            mv.addObject("user",user);
            //获取非登陆人的博客信息
            recommendBlog = blogService.selectOtherBlog(userId);
            //获取登录人的博客信息
            List<Blog> blog = blogService.selectBlog(userId);
            mv.addObject("blog",blog);
            //获取登录人的好友
            List<User> friends = userService.showFriend(userId);
            mv.addObject("friends",friends);
        }
        mv.setViewName("blog");
        mv.addObject("recommendblog",recommendBlog);
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

    @RequestMapping(value = "/blog/new")
    public ModelAndView InsBlog(){
        mv.setViewName("/newBlog");
        return mv;
    }

    @RequestMapping(value="/donewBlog")
    public ModelAndView doRegist(Blog blog,HttpSession session){
        //获取登录人的id
        String userId = session.getAttribute("userId").toString();
        //设置博客所属人的ID
        blog.setUid(userId);
        //设置博客ID
        blog.setBid();
        //插入博客表
        blogService.insertBlog(blog);
        mv.setViewName("success");
        mv.addObject("msg","发布成功");
        mv.addObject("ie","/blog/show");
        return mv;
    }

    @RequestMapping(value = "/blog/edit")
    public ModelAndView ShowBlog(Blog blog,HttpSession session){//TODO 使用驼峰命名法
        mv.setViewName("editBlog");
        //获取博客的信息
        Blog blog1 = blogService.showBlog(blog.getBid());
        mv.addObject("blog",blog1);
        return mv;
    }

    @RequestMapping(value = "/doeditBlog")
    public ModelAndView EditBlog(Blog blog,int flag){
        mv.setViewName("success");
        /*flag=1表示修改成功，flag=2表示删除成功*/
        if(flag == 1){
            blog.setBid(blog.getBid());
            blogService.editBlog(blog);
            mv.addObject("msg","修改成功");
        }else if(flag == 2){
            blogService.deleteBlog(blog.getBid());
            mv.addObject("msg","删除成功");
        }
        mv.addObject("ie","/blog/show");
        return mv;
    }

    @RequestMapping(value = "/blog/OtherBlog")
    public ModelAndView ShowOtherBlog(String bid,HttpSession session){
        mv.setViewName("/otherBlog");
        //获取博客信息
        Blog blog = blogService.showBlog(bid);
        //显示博客内容
        mv.addObject("blog",blog);
        //获得博客所属人信息
        User fuser = userService.selectUser(blog.getUid());
        //显示博客所属人信息
        mv.addObject("user",fuser);

        //没有登录直接跳
        if(session.getAttribute("userId")!=null){
            //定义登陆人对象
            String userId = session.getAttribute("userId").toString();
            User user = userService.selectUser(userId);
            //设置博客所属人id
            user.setFid(blog.getUid());
            //判断是否已经是好友，如果是1则在页面上显示删好友，如果是0则显示加好友
            int cnt = userService.selectFriend(user);
            mv.addObject("flag",cnt);
            //将博客所属人id更改为登陆人id
            blog.setUid(userId);
        }
        Map map = new LinkedHashMap();
        //获取评论信息
        List<Blog> remark = blogService.selectComment(blog);
        for(Blog b:remark){
            User u = userService.selectUser(b.getUid());
            map.put(b,u);
        }
        //显示评论信息
        mv.addObject("map",map);
        return mv;
    }

    @RequestMapping("/friend/add")
    public ModelAndView doFriend(String fid,String bid,HttpSession session){
        mv.setViewName("success");
        User user = new User();
        //获取登录人ID
        String userId = session.getAttribute("userId").toString();
        //设置登录人id
        user.setId(userId);
        //设置博客所属人id
        user.setFid(fid);
        //添加好友
        userService.insertFriend(user);
        mv.addObject("msg","好友添加成功");
        mv.addObject("ie","/blog/OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping(value = "/friend/delete")
    public ModelAndView doDelFriend(String fid,String bid,HttpSession session){
        mv.setViewName("success");
        User user = new User();
        //获取登陆人id
        String userId = session.getAttribute("userId").toString();
        //设置要删除的朋友id
        user.setFid(fid);
        //设置登陆人id
        user.setId(userId);
        //删除好友
        userService.deleteFriend(user);
        mv.addObject("msg","删除好友成功");
        mv.addObject("ie","/blog/OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping("/comment/add")
    public ModelAndView doRemark(String comment,String bid,HttpSession session){
        mv.setViewName("success");
        //获取登陆人id
        String userId = session.getAttribute("userId").toString();
        Blog blog = new Blog();
        //设置博客id
        blog.setBid(bid);
        //设置登陆人id
        blog.setUid(userId);
        //设置评论内容
        blog.setText(comment);
        //设置评论ID
        blog.setCid();
        //插入评论表
        blogService.insertComment(blog);
        mv.addObject("msg","评论成功");
        mv.addObject("ie","/blog/OtherBlog?bid="+bid);
        return mv;
    }

    //TODO没搞懂一下子传来了三条记录
    @RequestMapping("/comment/delete")
    public ModelAndView delRemark(String cid,String bid){
        mv.setViewName("success");
        //调用删除评论 功能
        blogService.deleteComment(cid);
        mv.addObject("msg","评论删除成功");
        mv.addObject("ie","/blog/OtherBlog?bid="+bid);
        return mv;
    }

    @RequestMapping("/doexit")
    public ModelAndView doexit(HttpSession session){
        if(session != null){
            session.invalidate();
        }
        mv.setViewName("exituser");
        mv.addObject("ie","/blog/show");
        return mv;
    }

    @RequestMapping(value = "/queryFriend")
    @ResponseBody
    public void queryFriend(HttpSession session,Boolean rs){
        String userid = session.getAttribute("userId").toString();
        if(rs){
            userService.queryFriend(userid);
        }else{
            userService.deleteQueryFriend(userid);
        }
    }
}
