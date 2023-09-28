package com.example.ung_dung_muon_sach.controller;


import com.example.ung_dung_muon_sach.dto.OrdersDetailDTO;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.OrdersDetail;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IOrderDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order-details")
public class OrderDetailController {
    @Autowired
    private IOrderDetailsService orderDetailsService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showOrderList(@RequestParam(defaultValue = "0", required = false) int page,
                                Model model) {
        List<Book> bookList = bookService.findAll();
        Pageable pageable = PageRequest.of(page, 4);
        Page<OrdersDetail> ordersDetails = orderDetailsService.getAll(pageable);
        model.addAttribute("ordersDetails", ordersDetails);
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping("/create/{id}")
    public String showFormCreateOrder(@PathVariable int id,
                                      Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("code", orderDetailsService.generateFiveNumberRandom());
        model.addAttribute("orderDTO", new OrdersDetailDTO());
        return "orders-detail";
    }

    @PostMapping("/create")
    public String createOrder(@Valid @ModelAttribute OrdersDetailDTO orderDTO,
                              @RequestParam int id,
                              BindingResult bindingResult) {
        Book book = bookService.findById(id);
        if (bindingResult.hasErrors()) {
            return "orders-detail";
        }
        OrdersDetail ordersDetail = new OrdersDetail();
        BeanUtils.copyProperties(orderDTO, ordersDetail);
        ordersDetail.setBook(book);
        orderDetailsService.addOrders(ordersDetail);
        return "redirect:/book";
    }
    @GetMapping("/give")
    public String showFormGiveBookBack() {
        return "give-book";
    }

    @PostMapping("/give")
    public String giveBookBack(@RequestParam String code) {
        orderDetailsService.giveBook(code);
        return "redirect:/order-details/give-success";
    }
    @GetMapping("/give-success")
    public String showFormGiveSuccess() {
        return "give-book-success";
    }
}
