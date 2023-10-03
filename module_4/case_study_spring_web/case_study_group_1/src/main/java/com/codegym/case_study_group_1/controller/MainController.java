package com.codegym.case_study_group_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class MainController {
    @GetMapping("")
    public String home() {
        return "home";
    }
}
