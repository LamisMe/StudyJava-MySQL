package com.ss2_spices_sandwich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpicesSandwichController {
    @Autowired

    @GetMapping("/home")
    public String display() {
        return "home";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment")
                                     String condiment,
                                     Model model) {
        model.addAttribute("condiment", condiment);
        return "home";
    }
}
