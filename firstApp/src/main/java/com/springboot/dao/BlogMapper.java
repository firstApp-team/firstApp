package com.springboot.dao;

import com.springboot.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    //查询
    List<Blog> SelBlog(int id);

    //写博客
    void InsBlog(Blog blog);
}
