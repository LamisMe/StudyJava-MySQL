package com.manager_products.controller;

import com.manager_products.model.Product;
import com.manager_products.service.IProductService;
import com.manager_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("home")
    public String homeProduct(Model model) {
        model.addAttribute("productList", productService.getALl());
        return "list";
    }

    @GetMapping("create")
    public String formCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("create")
    public String saveCreateProduct(@ModelAttribute Product product,
                                    RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:create";
    }

    @GetMapping("detail")
    public String detailProduct(Model model, @RequestParam int id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("update/{id}")
    public String formUpdateProduct(@PathVariable int id,
                                    Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("update")
    public String updateProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/product/update/"+product.getId();
    }

    @PostMapping("delete")
    public String deleteProduct(@RequestParam int id,
                                RedirectAttributes redirectAttributes) {
        Product product = productService.getById(id);
        productService.remove(product);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:home";
    }
    @PostMapping("searchName")
    public String searchByName(@RequestParam String name,
                               Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products",products);
        return "search-name";
    }
}
