package com.example.gio_hang.controller;

import com.example.gio_hang.dto.CartDTO;
import com.example.gio_hang.dto.ProductDTO;
import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDTO initCartDTO(){
        return new CartDTO();
    }
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showProductPage(@RequestParam(defaultValue = "0",required = false) int page,
            Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Product> productPage = productService.findAll(pageable);
        model.addAttribute("productPage",productPage);
        return "product-list";
    }
    @GetMapping("create/{id}")
    public String createToCart(@PathVariable int id,
                               @SessionAttribute(value = "cart",required = false) CartDTO cartDTO){
        Product product =productService.findById(id);
        if(product!=null) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            cartDTO.createProduct(productDTO);
        }
        return "redirect:/cart";
    }
}
