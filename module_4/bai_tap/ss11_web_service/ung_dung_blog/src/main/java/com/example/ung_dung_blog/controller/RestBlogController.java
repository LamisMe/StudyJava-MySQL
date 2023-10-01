package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.BlogEntity;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<List<BlogEntity>> showListAllBlog() {
        List<BlogEntity> blogEntityList = blogService.getListBlog();
        if (blogEntityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogEntityList, HttpStatus.OK);//200
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> showBlogInCategory(@PathVariable int id) {
        BlogEntity blogEntity = blogService.findById(id);
        if (blogEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogEntity, HttpStatus.OK);//200
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<List<BlogEntity>> showBlogByCategoryId(@PathVariable int id) {
        List<BlogEntity> blogEntities = blogService.searchBlogByCategory(id);
        if (blogEntities == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogEntities, HttpStatus.OK);//200
    }

}
