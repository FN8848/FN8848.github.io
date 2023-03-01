package com.hd.servlet;

import com.hd.model.Baby;
import com.hd.service.BabyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 我的收藏
 */
@WebServlet(name = "MyBabyServlet", value = "/MyBabyServlet")
public class MyBabyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自user_center.jsp
        int user_id = Integer.parseInt(request.getParameter("id"));//用户id
        //获取用户的收藏列表
        List<Baby> babyList = new BabyService().selectBabyListByUserId(user_id);
        System.out.println("MyBabyServlet:我的收藏: " + babyList);
        request.setAttribute("babyList", babyList);
        request.getRequestDispatcher("my_baby.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
