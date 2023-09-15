package com.ss2_spices_sandwich.controller;

import com.ss2_spices_sandwich.service.ISpicesSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpicesSandwichController {
    @Autowired
    private ISpicesSandwichService spicesSandwichService;

    @GetMapping("/home")
    public String display() {
        return "home";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment" ,
                                     required = false,
                                     defaultValue = "Please choose a seasoning")
                                     String[] condiment,
                                     Model model) {
        String[] spices = spicesSandwichService.spices(condiment);
        model.addAttribute("spices", spices);
        return "home";
    }
}
