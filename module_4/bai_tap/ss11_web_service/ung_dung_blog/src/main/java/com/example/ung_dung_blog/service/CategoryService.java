package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.CategoryEntity;
import com.example.ung_dung_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> getCategoryList() {
        return categoryRepository.findAll();
    }
}
