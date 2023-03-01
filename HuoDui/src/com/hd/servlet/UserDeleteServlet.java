package com.hd.servlet;

import com.hd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 删除用户
 */
@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //用户id, 来自 user_center.jsp 188行左右
        int id = Integer.parseInt(request.getParameter("id"));
        new UserService().deleteUser(id);
        response.sendRedirect("/LoginOutServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
