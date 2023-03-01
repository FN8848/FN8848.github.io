package com.hd.servlet;

import com.hd.model.User;
import com.hd.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改密码
 */
@WebServlet(name = "UserModifyPassWordServlet", value = "/UserModifyPassWordServlet")
public class UserModifyPassWordServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        session.invalidate();
        //用户id, 来自 user_center.jsp 167行左右
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");//用户输入的密码
        //更新密码
        userService.updateUserPassWord(password, id);
        response.sendRedirect("/LoginOutServlet");
    }
}
