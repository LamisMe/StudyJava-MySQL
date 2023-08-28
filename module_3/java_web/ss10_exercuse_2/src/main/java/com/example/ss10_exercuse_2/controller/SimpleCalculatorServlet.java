package com.example.ss10_exercuse_2.controller;

import com.example.ss10_exercuse_2.service.SimpleCalculatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleCaculatorServlet", value = "/simple-calculator")
public class SimpleCalculatorServlet extends HttpServlet {
    private SimpleCalculatorService service = new SimpleCalculatorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Double first = Double.valueOf(request.getParameter("first"));
        String operator = request.getParameter("operator");
        Double second = Double.valueOf(request.getParameter("second"));
        String fail ;
        try {
            Double result = service.resultSimpleCalculator(first, second, operator);
            request.setAttribute("result", result);
            request.setAttribute("first", first);
            request.setAttribute("second", second);
            request.setAttribute("operator", operator);
        } catch (Exception e) {
            fail = e.getMessage();
            request.setAttribute("fail", fail);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }
}
