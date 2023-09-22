package com.example.ss6_app_blog.controller;

import com.example.ss6_app_blog.model.Blog;
import com.example.ss6_app_blog.model.Category;
import com.example.ss6_app_blog.service.IBlogService;
import com.example.ss6_app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/{categoryId}")
    public String showBlogList(@PageableDefault(value = 0,size = 2) Pageable pageable,
                               Model model,
                               @PathVariable int categoryId){
        Page<Blog> pageBlog = blogService.findAllByBlog(pageable,categoryId);
        Category category = categoryService.findById(categoryId);
        model.addAttribute("pageBlog",pageBlog);
        model.addAttribute("category",category);
        return "home-blog";
    }
    @GetMapping("create")
    public String showFormCreateBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "create-blog";
    }
    @PostMapping("create")
    public String createBlog(@ModelAttribute Blog blog,
                             RedirectAttributes redirectAttributes){
        boolean blogCreate = blogService.createBlog(blog);
        if(blogCreate){
            redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        }else {
            redirectAttributes.addFlashAttribute("msg","Thêm mới thất bại");
        }
        return "redirect:create";
    }
    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute Blog blog,
                             RedirectAttributes redirectAttributes){
        blogService.deleteBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:home-blog";
    }

    @GetMapping("detail")
    public String detailProduct(Model model, @RequestParam int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail-blog";
    }
    @GetMapping("update/{id}")
    public String showFormUpdateProduct(@PathVariable int id,
                                        Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "update-blog";
    }

    @PostMapping("update")
    public String updateProduct(@ModelAttribute Blog blog,
                                RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:";
    }

}
