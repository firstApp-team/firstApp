package com.springboot.dao;

import com.springboot.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    //查询
    List<Blog> SelBlog(int userid);

    //查询别人的博客
    List<Blog> SelOtherBlog(int userid);

    //写博客
    void InsBlog(Blog blog);

    //显示博客
    Blog ShowBlog(int blogid);

    //修改博客
    void EditBlog(Blog blog);

    //插入评论
    void InsRemark(Blog blog);

    //查找评论
    List<Blog> SelRemark(Blog blog);

    //删除博客
    void DelBlog(int bid);

    //查找推荐博客
    List<Blog> SelrecommendBlog();

    //删除评论
    void Delremark(int rid);
}
