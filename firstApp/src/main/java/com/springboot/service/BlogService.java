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

    @Override
    public List<Blog> SelBlog(int id){
        return blogMapper.SelBlog(id);
    }

    @Override
    public void InsBlog(Blog blog){
        blogMapper.InsBlog(blog);
    }

    @Override
    public Blog ShowBlog(int bid){
        return blogMapper.ShowBlog(bid);
    }

    @Override
    public void EditBlog(Blog blog){blogMapper.EditBlog(blog);}

    @Override
    public List<Blog> SelOtherBlog(int id){return blogMapper.SelOtherBlog(id);}
}
