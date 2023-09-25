package com.example.ss8_validate_thong_tin_bai_hat.controller;

import com.example.ss8_validate_thong_tin_bai_hat.model.Song;
import com.example.ss8_validate_thong_tin_bai_hat.model.SongDto;
import com.example.ss8_validate_thong_tin_bai_hat.service.ISongService;
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
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showSongPage(@RequestParam(defaultValue = "0", required = false) int page,
                               Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Song> songPage = songService.getAll(pageable);
        model.addAttribute("songPage", songPage);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreateSong(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.createSong(song);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("update/{id}")
    public String showFormUpdateSong(@PathVariable int id,
                                     Model model) {
        Song song = songService.findById(id);
        model.addAttribute("songDto", song);
        return "update";
    }

    @PostMapping("update")
    public String updateCategory(@Valid @ModelAttribute SongDto songDto,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.createSong(song);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/song";
    }

}
