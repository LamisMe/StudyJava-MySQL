package com.example.quan_ly_nong_trai_heo.controller;

import com.example.quan_ly_nong_trai_heo.dto.PigDto;
import com.example.quan_ly_nong_trai_heo.model.Location;
import com.example.quan_ly_nong_trai_heo.model.Pig;
import com.example.quan_ly_nong_trai_heo.service.ILocationService;
import com.example.quan_ly_nong_trai_heo.service.IPigService;
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
import java.util.List;

@Controller
@RequestMapping("/pigs")
public class PigController {
    @Autowired
    private IPigService pigService;
    @Autowired
    private ILocationService locationService;
    @GetMapping("")
    public String showAllPigPage(@RequestParam(defaultValue = "0",required = false) int page,
                                 @RequestParam(defaultValue = "",required = false) String locationName,
                                 @RequestParam(required = false) boolean status,
                                 @RequestParam(defaultValue = "",required = false) String pigId,
                                 Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Pig> pigPage = pigService.findAllPig(pageable,locationName,status,pigId);
        List<Location> locationList = locationService.findAll();
        model.addAttribute("pigPage",pigPage);
        model.addAttribute("locationName",locationName);
        model.addAttribute("pigId",pigId);
        model.addAttribute("status",status);
        model.addAttribute("locationList",locationList);
        return "index";
    }
    @PostMapping("delete")
    public String deletePig(@RequestParam int id){
        pigService.deletePig(id);
        return "redirect:/pigs";
    }
    @GetMapping("detail")
    public String showDetail(Model model,
                             @RequestParam int id){
        Pig pig = pigService.findById(id);
        model.addAttribute("pig",pig);
        return "details";
    }
    @GetMapping("update")
    public String showFormUpdateSong(@RequestParam int id,
                                     Model model) {
        Pig pig = pigService.findById(id);
        model.addAttribute("pigDto", pig);
        return "update";
    }

    @PostMapping("update")
    public String updateCategory(@Valid @ModelAttribute PigDto pigDto,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult bindingResult) {
        new PigDto().validate(pigDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Pig pig = new Pig();
        BeanUtils.copyProperties(pigDto, pig);
        pigService.updatePig(pig);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/pigs";
    }
    @GetMapping("/create")
    public String showFormCreateSong(Model model) {
        List<Location> locationList = locationService.findAll();
        model.addAttribute("pigDto", new PigDto());
        model.addAttribute("locationList", locationList);
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute PigDto pigDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new PigDto().validate(pigDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Pig pig = new Pig();
        BeanUtils.copyProperties(pigDto, pig);
        pigService.createPig(pig);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/pigs";
    }
}
