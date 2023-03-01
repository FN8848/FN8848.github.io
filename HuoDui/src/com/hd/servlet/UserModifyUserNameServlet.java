package com.hd.servlet;

import com.hd.model.User;
import com.hd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改用户名
 */
@WebServlet(name = "UserModifyUserNameServlet", value = "/UserModifyUserNameServlet")
public class UserModifyUserNameServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //用户id, 来自 user_center.jsp 130行左右
        int id = Integer.parseInt(request.getParameter("id"));
        int number = Integer.parseInt(request.getParameter("number"));//账号
        String password = request.getParameter("password");//密码
        String username = request.getParameter("username");//用户输入的名
        //更新用户名
        userService.updateUserName(username, id);
        //传数据、跳转、重新登陆
        request.setAttribute("number",number);
        request.setAttribute("password",password);
        request.getRequestDispatcher("/LoginServlet").forward(request, response);
    }
}
