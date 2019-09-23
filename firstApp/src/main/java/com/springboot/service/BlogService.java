package com.springboot.service;

import com.springboot.dao.BlogMapper;
import com.springboot.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements BlogMapper{
    @Autowired
    BlogMapper blogMapper;

    //查找博客
    @Override
    public List<Blog> SelBlog(int userid){
        return blogMapper.SelBlog(userid);
    }

    //插入新博客
    @Override
    public void InsBlog(Blog blog){
        blogMapper.InsBlog(blog);
    }

    //显示博客
    @Override
    public Blog ShowBlog(int blogid){
        return blogMapper.ShowBlog(blogid);
    }

    //修改博客
    @Override
    public void EditBlog(Blog blog){blogMapper.EditBlog(blog);}

    //推荐别人的博客
    @Override
    public List<Blog> SelOtherBlog(int userid){return blogMapper.SelOtherBlog(userid);}

    //插入评论
    @Override
    public void InsRemark(Blog blog){blogMapper.InsRemark(blog);}//TODO 评论的常用英文是comment

    //查找评论
    @Override
    public List<Blog> SelRemark(Blog blog) {return blogMapper.SelRemark(blog);}

    //删除博客
    @Override
    public void DelBlog(int blogid){blogMapper.DelBlog(blogid);}

    //推荐博客
    @Override
    public List<Blog> SelrecommendBlog(){return blogMapper.SelrecommendBlog();}

    //删除评论
    @Override
    public void Delremark(int rid){blogMapper.Delremark(rid);}
}
