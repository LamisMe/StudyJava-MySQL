package com.example.luyen_tap_crud.controller;

import com.example.luyen_tap_crud.model.BaiHoc;
import com.example.luyen_tap_crud.model.BaiHocDto;
import com.example.luyen_tap_crud.service.BaiHocService;
import com.example.luyen_tap_crud.service.IBaiHocService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BaiHocServlet", value = "/bai-hoc")
public class
BaiHocServlet extends HttpServlet {
    private IBaiHocService baiHocService = new BaiHocService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "them":
                hienThiThem(request, response);
                break;
            case "capnhat":
                hienThiCapNhat(request, response);
                break;
            default:
                hienThiDanhSach(request, response);
                break;
        }

    }

    private void hienThiCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBaiHoc = Integer.parseInt(request.getParameter("maBaiHoc"));
        BaiHoc baiHoc = baiHocService.chiTietBaiHoc(maBaiHoc);
        request.setAttribute("baiHoc", baiHoc);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);
    }

    private void hienThiThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void hienThiDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BaiHocDto> baiHocDto = baiHocService.hienThiDanhSach();
        request.setAttribute("baiHocDto", baiHocDto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display.jsp");
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
            case "them":
                themMoiBaiHoc(request, response);
                break;
            case "xoa":
                xoaBaiHoc(request, response);
                break;
            case "capnhat":
                caoNhatBaiHoc(request, response);
                break;
        }
    }

    private void caoNhatBaiHoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maBaiHoc = Integer.parseInt(request.getParameter("maBaiHoc"));
        int maLoaiBaiHoc = Integer.parseInt(request.getParameter("maLoaiBaiHoc"));
        int doKho = Integer.parseInt(request.getParameter("doKho"));
        int module = Integer.parseInt(request.getParameter("module"));
        String link = request.getParameter("link");
        BaiHoc baiHoc = new BaiHoc(maBaiHoc,maLoaiBaiHoc, doKho, module, link);
        baiHocService.capNhat(baiHoc);
        request.setAttribute("baiHoc", baiHoc);
        request.setAttribute("thongBao","cap nhat thanh cong");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request,response);
    }

    private void xoaBaiHoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maBaiHoc = Integer.parseInt(request.getParameter("maBaiHoc"));
        baiHocService.xoa(maBaiHoc);
        request.setAttribute("thongBao", "Xoa thanh cong");
        response.sendRedirect("/bai-hoc");
    }

    private void themMoiBaiHoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maLoaiBaiHoc = Integer.parseInt(request.getParameter("maLoaiBaiHoc"));
        int doKho = Integer.parseInt(request.getParameter("doKho"));
        int module = Integer.parseInt(request.getParameter("module"));
        String link = request.getParameter("link");
        BaiHoc baiHoc = new BaiHoc(maLoaiBaiHoc, doKho, module, link);
        baiHocService.themMoi(baiHoc);
        request.setAttribute("thongBao", "Thêm mới thành công");
        request.setAttribute("baiHoc", baiHoc);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(request, response);
    }
}
