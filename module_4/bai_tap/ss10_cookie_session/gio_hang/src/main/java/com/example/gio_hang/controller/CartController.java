package com.example.gio_hang.controller;

import com.example.gio_hang.dto.CartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String showCart(@SessionAttribute(value = "cart",required = false) CartDTO cartDTO,
                           Model model){
        model.addAttribute("cart", cartDTO);
        return "cart-list";
    }
}
