package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getListBlog();

    Blog findById(int id);
    List<Blog> searchBlogByCategory(int categoryId);
}
