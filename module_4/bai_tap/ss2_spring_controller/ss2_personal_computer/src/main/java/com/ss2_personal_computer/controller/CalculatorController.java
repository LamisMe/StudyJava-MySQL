package com.ss2_personal_computer.controller;

import com.ss2_personal_computer.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/home-calculator")
    public String home() {
        return "home-calculator";
    }

    @GetMapping("/total")
    public String total(@RequestParam(value = "first-number", required = false) int firstNum,
                        @RequestParam(value = "second-number", required = false) int secondNum,
                        @RequestParam(value = "allowable", required = false) String allowable,
                        Model model) {
        double result = calculatorService.total(firstNum, secondNum, allowable);
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        if (secondNum != 0) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("msg", "Cannot divide by 0");
        }
        return "home-calculator";
    }
}
