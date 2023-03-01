package com.hd.servlet;

import com.hd.model.User;
import com.hd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 登录
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

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

        User userLogin = userService.login(number, password);

        if (userLogin == null) {
            System.out.println("账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            System.out.println("LoginServlet=登录成功");
            User user = userService.selectUser(number);
            System.out.println("LoginServlet:user=" + user.toString());
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("user_center.jsp").forward(request, response);
        }
    }
}
