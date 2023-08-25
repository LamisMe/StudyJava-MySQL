package com.example.ss9_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "discountServlet", value = "/discount-servlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("product");
        Double price = Double.parseDouble(request.getParameter("price"));
        Double discount = Double.parseDouble(request.getParameter("discount"));
        Double result = price * discount * 0.01;
        request.setAttribute("result", result);
        request.setAttribute("description", description);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
