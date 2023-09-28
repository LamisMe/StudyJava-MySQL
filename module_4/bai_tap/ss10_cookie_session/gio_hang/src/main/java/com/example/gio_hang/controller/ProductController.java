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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    @GetMapping("minus/{id}")
    public String minus(@PathVariable int id,
                        @SessionAttribute(value = "cart",required = false) CartDTO cartDTO){
        Product product = productService.findById(id);
        if(product != null){
            ProductDTO productDto = new ProductDTO();
            BeanUtils.copyProperties(product,productDto);
            cartDTO.downProductQuantity(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("productDto", new ProductDTO());
        return "create-product";
    }

    @PostMapping("/create")
    public String saveInfo(@Valid @ModelAttribute ProductDTO productDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
//        new ProductDTO().validate(productDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "create-product";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.createProduct(product);
        redirectAttributes.addFlashAttribute("mess", "Created Success!!");
        return "redirect:/shop";
    }

}
