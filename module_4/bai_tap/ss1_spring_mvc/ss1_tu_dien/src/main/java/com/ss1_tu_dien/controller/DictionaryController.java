package com.ss1_tu_dien.controller;

import com.ss1_tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String dictionary(){
        return "/display";
    }

    @PostMapping ("/message")
    public String dictionaryShow(@RequestParam String vocabulary, Model model){
        String result = dictionaryService.result(vocabulary);
        if(result == null){
            model.addAttribute("message","Từ này không có trong từ điển bạn nhé hehe");
        }else {
            model.addAttribute("result","Từ trên có nghĩa là:  " + result);
        }
        return "/display";
    }
}
