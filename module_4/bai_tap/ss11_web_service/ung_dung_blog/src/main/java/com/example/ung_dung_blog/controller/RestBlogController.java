package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.BlogEntity;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
//    @GetMapping("")
//    public ResponseEntity<List<BlogEntity>> showBlogListAll() {
//        List<BlogEntity> blogEntityList = blogService.getListBlog();
//        if (blogEntityList == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
//        }
//        return new ResponseEntity<>(blogEntityList, HttpStatus.OK);//200
//    }

    //    @GetMapping("")
//    public ResponseEntity<Page<BlogEntity>> showBlogList(@RequestParam(defaultValue = "0",required = false) int page) {
//        Pageable pageable = PageRequest.of(page,4);
//        Page<BlogEntity> blogEntityList = blogService.getListBlog(pageable);
//        if (blogEntityList == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
//        }
//        return new ResponseEntity<>(blogEntityList, HttpStatus.OK);//200
//    }
    @GetMapping("")
    public ResponseEntity<Page<BlogEntity>> showBlogListSearchByAuthor(@RequestParam(defaultValue = "", required = false) String authorSearch,
                                                                       @RequestParam(defaultValue = "0", required = false) int page
    ) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<BlogEntity> blogEntityList = blogService.searchByAuthor(pageable, authorSearch);
        if (blogEntityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogEntityList, HttpStatus.OK);//200
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> showBlogInCategory(@PathVariable Integer id) {
        BlogEntity blogEntity = blogService.findById(id);
        if (blogEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        return new ResponseEntity<>(blogEntity, HttpStatus.OK);//200
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<List<BlogEntity>> showBlogByCategoryId(@PathVariable int id) {
        List<BlogEntity> blogEntities = blogService.searchBlogByCategory(id);
        if (blogEntities == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        return new ResponseEntity<>(blogEntities, HttpStatus.OK);//200
    }

}