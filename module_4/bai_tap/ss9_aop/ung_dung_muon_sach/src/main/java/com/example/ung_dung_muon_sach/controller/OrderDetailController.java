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
                              @RequestParam String code,
                              BindingResult bindingResult) {
        Book book = bookService.findById(id);
        if (bindingResult.hasErrors()) {
            return "orders-detail";
        }
        if (book.getQuantity() == 0){
            return "old-quantity";
        }
        OrdersDetail ordersDetail = new OrdersDetail();
        BeanUtils.copyProperties(orderDTO, ordersDetail);
        ordersDetail.setBook(book);
        ordersDetail.setBookLoanCode(code);
        bookService.updateQuantityBorrowBook(book);
        orderDetailsService.addOrders(ordersDetail);
        return "redirect:/order-details/borrow-success/"+code;
    }

    @GetMapping("/give")
    public String showFormGiveBookBack() {
        return "give-book";
    }

    @PostMapping("/give")
    public String giveBookBack(@RequestParam String code) {
        OrdersDetail ordersDetail = orderDetailsService.findByLoadCode(code);
        if (ordersDetail != null) {
            orderDetailsService.giveBook(code);
            Book book = bookService.findById(ordersDetail.getBook().getId());
            bookService.updateQuantityGiveBook(book);
            bookService.addBook(book);
            return "redirect:/order-details/give-success";
        }
        return "redirect:/order-details/give-fail";
    }

    @GetMapping("/give-success")
    public String showFormGiveSuccess() {
        return "give-book-success";
    }

    @GetMapping("/give-fail")
    public String showFormGiveBookFail() {
        return "give-fail";
    }
    @GetMapping("/borrow-success/{code}")
    public String showFormBorrowSuccess(@PathVariable String code,
                                        Model model) {
        OrdersDetail ordersDetail = orderDetailsService.findByLoadCode(code);
        model.addAttribute("ordersDetail",ordersDetail);
        return "borrow-success";
    }
}
