package com.example.demo_send_mail.controller;

import com.example.demo_send_mail.repository.ISendEmail;
import com.example.demo_send_mail.service.ISendEmailService;
import com.example.demo_send_mail.service.SendMailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "SendMailServlet", value = "/send-mail")
public class SendMailServlet extends HttpServlet {
    private SendMailService sendEmail = new SendMailService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "hienthiform":
                hienThiForm(request, response);
                break;
        }
    }

    private void hienThiForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        request.setAttribute("email", email);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gui-mail.jsp");
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
            case "guimail":
                guiMail(request, response);
                break;
        }
    }

    private void guiMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        Map<String, String> err = new LinkedHashMap<>();
        StringBuilder html = new StringBuilder();
        html.append("Cảm ơn bạn đã đồng hành cùng Nuối Em.\n" +
                "Nhập mã xác minh để hoàn tất cập nhật địa chỉ email: "
        );
        html.append("<strong style='color: red'>"+sendEmail.codeRandom()+"</strong>");
        html.append(" là mã nhận dạng. Xin lưu ý rằng mã này chỉ có hiệu lực trong 5 phút.");
        String mess = "";
        mess = html.toString();
        if (sendEmail.email(email) == null) {
            err.put("err", "email không đúng");
            request.setAttribute("err", err);
        }
        sendEmail.send(email, "[NUOI EM PASSWORD]-Update e-mail address", mess, "nhom2.c0523g1@gmail.com", "tkasvmbxqvktqiet");
        response.sendRedirect("/gui-mail.jsp");
    }
}
