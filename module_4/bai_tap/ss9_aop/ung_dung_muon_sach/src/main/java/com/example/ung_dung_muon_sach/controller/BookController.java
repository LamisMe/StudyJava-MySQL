package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.dto.BookDTO;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.service.IBookService;
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
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public String showBookList(@RequestParam(defaultValue = "0",required = false )int page,
                               @RequestParam(defaultValue = "",required = false) String searchName,
                               Model model){
        Pageable pageable = PageRequest.of(page,4);
        Page<Book> bookPage = bookService.getAll(pageable,searchName);
        model.addAttribute("bookPage",bookPage);
        return "book-list";
    }
    @GetMapping("/create")
    public String showFormCreateBook(Model model) {
        model.addAttribute("bookDTO", new BookDTO());
        return "create-book";
    }

    @PostMapping("/create")
    public String createBook(@Valid @ModelAttribute BookDTO bookDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new BookDTO().validate(bookDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create-book";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/book";
    }
    @GetMapping("detail/{id}")
    public String showDetailBook(@PathVariable int id,
                                 Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "detail-book";
    }
}
