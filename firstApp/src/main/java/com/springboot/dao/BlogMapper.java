package com.springboot.dao;

import com.springboot.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    //查询
    List<Blog> SelBlog(int id);

    //查询别人的博客
    List<Blog> SelOtherBlog(int id);

    //写博客
    void InsBlog(Blog blog);

    //显示博客
    Blog ShowBlog(int bid);

    //修改博客
    void EditBlog(Blog blog);

    //插入评论
    void InsRemark(Blog blog);
}
