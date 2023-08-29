package com.example.ss11_manager_product.controller;

import com.example.ss11_manager_product.model.Product;
import com.example.ss11_manager_product.service.IProductService;
import com.example.ss11_manager_product.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showformcreateproduct":
                showFormCreateProduct(request, response);
                break;

            default:
                displayList(request, response);
        }
    }

    private void showFormCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        
    }
}

