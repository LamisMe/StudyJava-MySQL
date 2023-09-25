package com.example.validate_form_dang_ky.controller;

import com.example.validate_form_dang_ky.dto.UserDto;
import com.example.validate_form_dang_ky.model.User;
import com.example.validate_form_dang_ky.sevice.IUserService;
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
@RequestMapping("/user")
public class FormController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String showUserList(@RequestParam(defaultValue = "0",required = false) int page,
                               Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<User> userPage = userService.findAll(pageable);
        model.addAttribute("userPage",userPage);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreateUser(Model model){
        model.addAttribute("userDto",new UserDto());
        return "index";
    }
    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:result";
    }
    @GetMapping("/result")
    public String showResult(){
        return "result";
    }
}
