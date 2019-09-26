package com.springboot.dao;

import com.springboot.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    //查询博客
    List<Blog> selectBlog(String userId);

    //查询别人的博客
    List<Blog> selectOtherBlog(String userId);

    //写博客
    void insertBlog(Blog blog);

    //显示博客
    Blog showBlog(String blogId);

    //修改博客
    void editBlog(Blog blog);

    //插入评论
    void insertComment(Blog blog);

    //查找评论
    List<Blog> selectComment(Blog blog);

    //删除博客
    void deleteBlog(String blogId);

    //查找推荐博客
    List<Blog> selectRecommendBlog();

    //删除评论
    void deleteComment(String commentId);

    //查找博客ID
    String selectBlogId(String cid);
}
