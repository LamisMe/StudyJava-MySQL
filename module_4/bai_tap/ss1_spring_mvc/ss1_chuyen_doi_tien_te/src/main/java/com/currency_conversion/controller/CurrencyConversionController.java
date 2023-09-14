package com.currency_conversion.controller;

import com.currency_conversion.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService currencyConversion;
    @GetMapping("/display")
    public String display(){
       return "/result";
    }
    @GetMapping("/exchange")
    public String exchange(@RequestParam int amountOfMoney, Model model) {
           double convert = currencyConversion.convertUSDToVND(amountOfMoney);
           model.addAttribute("convert",convert + " VND");
        return "/result";
    }
}
