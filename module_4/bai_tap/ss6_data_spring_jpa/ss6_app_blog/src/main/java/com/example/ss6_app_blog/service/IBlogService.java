package com.example.ss6_app_blog.service;

import com.example.ss6_app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Page<Blog> getAll(Pageable pageable);

    Page<Blog> findAllByNameOrAuthorOrTitle(Pageable pageable, Blog blog);

    boolean createBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Blog blog);

    Blog findById(int id);
    Page<Blog> findAllByBlog(Pageable pageable,int idCategory);
}
