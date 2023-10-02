package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.BlogEntity;
import com.example.ung_dung_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Page<BlogEntity> getListBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<BlogEntity> searchByAuthor(Pageable pageable, String authorSearch) {
        return blogRepository.searchByAuthor(pageable, "%"+authorSearch+"%");
    }

    @Transactional

    @Override
    public BlogEntity findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<BlogEntity> searchBlogByCategory(int categoryId) {
        return blogRepository.searchBlogByCategory(categoryId);
    }
}
