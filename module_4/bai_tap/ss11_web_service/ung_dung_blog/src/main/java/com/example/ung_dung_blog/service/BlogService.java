package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.BlogEntity;
import com.example.ung_dung_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogEntity> getListBlog() {
        return blogRepository.findAll();
    }

    @Override
    public BlogEntity findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<BlogEntity> searchBlogByCategory(int categoryId) {
        return blogRepository.searchBlogByCategory(categoryId);
    }
}
