package com.example.ss6_app_blog.controller;

import com.example.ss6_app_blog.model.Blog;
import com.example.ss6_app_blog.model.Category;
import com.example.ss6_app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showCategoryList(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "home-category";
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "create-category";
    }
    @PostMapping("create")
    public String createCategory(@ModelAttribute Category category,
                             RedirectAttributes redirectAttributes){
        boolean addCategory = categoryService.addCategory(category);
        if(addCategory){
            redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        }else {
            redirectAttributes.addFlashAttribute("msg","Thêm mới thất bại");
        }
        return "home-category";
    }
    @PostMapping("delete")
    public String deleteCategory(@ModelAttribute Category category,
                             RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(category);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:home";
    }
    @GetMapping("update/{id}")
    public String showFormUpdateCategory(@PathVariable int id,
                                        Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "update-category";
    }

    @PostMapping("update")
    public String updateCategory(@ModelAttribute Category category,
                                RedirectAttributes redirectAttributes) {
        categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:";
    }
    @GetMapping("detail")
    public String detailCategory(Model model, @RequestParam int id) {
        model.addAttribute("category", categoryService.findById(id));
        return "redirect:/blog/"+id;
    }
}
