package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<BlogEntity> getListBlog();
    Page<BlogEntity> getListBlog(Pageable pageable);
    Page<BlogEntity> searchByAuthor(Pageable pageable,String authorSearch);

    BlogEntity findById(Integer id);
    List<BlogEntity> searchBlogByCategory(int categoryId);
}
