package com.example.ss14_excercise_1.controller;

import com.example.ss14_excercise_1.service.GiaiPhuongTrinhBachai;
import com.example.ss14_excercise_1.service.IGiaiPhuongTrinhBacHai;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GiaiPhuongTrinhBacHaiServlet", value = "/giai-phuong-trinh-bac-hai")
public class GiaiPhuongTrinhBacHaiServlet extends HttpServlet {
    private IGiaiPhuongTrinhBacHai phuongTrinhBacHai = new GiaiPhuongTrinhBachai();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c = Integer.parseInt(request.getParameter("c"));
        List<Double> ketQua = phuongTrinhBacHai.giaiPhuongTrinhBacHai(a, b, c);
        if (ketQua.size() == 0) {
            request.setAttribute("ketQua", "Phương trình vô nghiệm");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } else if (ketQua.size() == 1) {
            request.setAttribute("ketQua", "Phương trình có 1 nghiệm duy nhất x1 = " + ketQua.get(0));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } else if (ketQua.size() == 2) {
            request.setAttribute("ketQua", "Phương trình có 2 nghiệm phân biệt là x1 = " + ketQua.get(0)
                    + " và x2 = " + ketQua.get(1));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
