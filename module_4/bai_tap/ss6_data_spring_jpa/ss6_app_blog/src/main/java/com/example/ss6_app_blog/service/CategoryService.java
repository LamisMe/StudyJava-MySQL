package com.example.ss6_app_blog.service;

import com.example.ss6_app_blog.model.Category;
import com.example.ss6_app_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean addCategory(Category category) {
        Category categoryEntity = categoryRepository.save(category);
        return categoryEntity != null;
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryEntity = categoryRepository.findById(category.getId()).get();
        categoryRepository.delete(categoryEntity);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }
}
