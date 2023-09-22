package com.example.ss6_app_blog.service;

import com.example.ss6_app_blog.model.Blog;
import com.example.ss6_app_blog.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> getAll();
    boolean addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    Category findById(int id);
}
