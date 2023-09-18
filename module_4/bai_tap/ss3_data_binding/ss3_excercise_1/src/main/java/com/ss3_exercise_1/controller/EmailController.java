package com.ss3_exercise_1.controller;

import com.ss3_exercise_1.model.Email;
import com.ss3_exercise_1.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @ModelAttribute("languages")
    public String[] getLanguageList(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{5,10,15,25,50,100};
    }
    @GetMapping("/now")
    public String showSettingNow(Model model){
        model.addAttribute("email",emailService.getEmail());
        return "setting-now";
    }

    @GetMapping("/setting")
    public String showFormSetting(Model model){
        model.addAttribute("email",emailService.getEmail());
        return "settings";
    }
    @PostMapping("/setting")
    public String save(@ModelAttribute Email email,
                       RedirectAttributes redirectAttributes){
        emailService.settingMail(email);
        redirectAttributes.addFlashAttribute("msg","Update successful");
        return "redirect:/setting";
    }
}
