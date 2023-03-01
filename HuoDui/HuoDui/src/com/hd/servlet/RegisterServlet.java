package com.hd.servlet;

import com.hd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 注册
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int number = Integer.parseInt(request.getParameter("number"));
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        new UserService().register(number, password, username);
        request.setAttribute("username", username);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
