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
    public List<Blog> selectBlog(String  userid){
        return blogMapper.selectBlog(userid);
    }

    //插入新博客
    @Override
    public void insertBlog(Blog blog){
        blogMapper.insertBlog(blog);
    }

    //显示博客
    @Override
    public Blog showBlog(String blogId){
        return blogMapper.showBlog(blogId);
    }

    //修改博客
    @Override
    public void editBlog(Blog blog){blogMapper.editBlog(blog);}

    //推荐别人的博客
    @Override
    public List<Blog> selectOtherBlog(String userId){return blogMapper.selectOtherBlog(userId);}

    //插入评论
    @Override
    public void insertComment(Blog blog){blogMapper.insertComment(blog);}//TODO 评论的常用英文是comment

    //查找评论
    @Override
    public List<Blog> selectComment(Blog blog) {return blogMapper.selectComment(blog);}

    //删除评论
    @Override
    public void deleteComment(String commentId){blogMapper.deleteComment(commentId);}

    //删除博客
    @Override
    public void deleteBlog(String blogId){blogMapper.deleteBlog(blogId);}

    //推荐博客
    @Override
    public List<Blog> selectRecommendBlog(){return blogMapper.selectRecommendBlog();}

    //查找博客ID
    @Override
    public String selectBlogId(String cid){return blogMapper.selectBlogId(cid);}
}
