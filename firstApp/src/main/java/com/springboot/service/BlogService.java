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
    public List<Blog> SelBlog(int id){
        return blogMapper.SelBlog(id);
    }

    //插入新博客
    @Override
    public void InsBlog(Blog blog){
        blogMapper.InsBlog(blog);
    }

    //显示博客
    @Override
    public Blog ShowBlog(int bid){
        return blogMapper.ShowBlog(bid);
    }

    //修改博客
    @Override
    public void EditBlog(Blog blog){blogMapper.EditBlog(blog);}

    //推荐别人的博客
    @Override
    public List<Blog> SelOtherBlog(int id){return blogMapper.SelOtherBlog(id);}

    //插入评论
    @Override
    public void InsRemark(Blog blog){blogMapper.InsRemark(blog);}

    //查找评论
    @Override
    public List<Blog> SelRemark(int bid) {return blogMapper.SelRemark(bid);}

    //删除博客
    @Override
    public void DelBlog(int bid){blogMapper.DelBlog(bid);}
}
