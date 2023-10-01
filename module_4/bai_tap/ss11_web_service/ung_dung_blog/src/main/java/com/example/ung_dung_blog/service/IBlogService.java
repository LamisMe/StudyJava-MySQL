package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.BlogEntity;

import java.util.List;

public interface IBlogService {
    List<BlogEntity> getListBlog();

    BlogEntity findById(int id);
    List<BlogEntity> searchBlogByCategory(int categoryId);
}
