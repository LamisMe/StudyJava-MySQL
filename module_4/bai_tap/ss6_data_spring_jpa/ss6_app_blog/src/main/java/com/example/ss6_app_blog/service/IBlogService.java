package com.example.ss6_app_blog.service;

import com.example.ss6_app_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
    boolean createBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Blog blog);
    Blog findById(int id);
}
