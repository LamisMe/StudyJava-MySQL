package com.example.ss6_app_blog.controller;

import com.example.ss6_app_blog.model.Blog;
import com.example.ss6_app_blog.model.Category;
import com.example.ss6_app_blog.service.IBlogService;
import com.example.ss6_app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String showBlogList(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "", required = false) String searchName,
                               Model model,
                               @PathVariable int categoryId) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Blog> pageBlog = blogService.findAllByBlog(pageable,categoryId, searchName);
        Category category = categoryService.findById(categoryId);
        model.addAttribute("pageBlog", pageBlog);
        model.addAttribute("category", category);
        return "home-blog";
    }

    @GetMapping("create")
    public String showFormCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create-blog";
    }

    @PostMapping("create")
    public String createBlog(@ModelAttribute Blog blog,
                             RedirectAttributes redirectAttributes) {
        boolean blogCreate = blogService.createBlog(blog);
        if (blogCreate) {
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thất bại");
        }
        return "redirect:create";
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute Blog blog,
                             @RequestParam int categoryId,
                             Model model,
                             @RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "", required = false) String searchName) {
        Category category = categoryService.findById(categoryId);
        blogService.deleteBlog(blog);
        Pageable pageable = PageRequest.of(page, 4);
        Page<Blog> pageBlog = blogService.findAllByName(pageable, searchName);
        model.addAttribute("pageBlog", pageBlog);
        model.addAttribute("category", category);
        return "redirect:/blog/"+categoryId;
    }

    @GetMapping("detail")
    public String showDetailBlog(Model model, @RequestParam int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail-blog";
    }

    @GetMapping("update/{id}")
    public String showFormUpdateBlog(@PathVariable int id,
                                        Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "update-blog";
    }

    @PostMapping("update")
    public String updateBlog(@ModelAttribute Blog blog,
                                RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:";
    }

}
