package com.hd.servlet;

import com.hd.service.BabyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 添加收藏
 */
@WebServlet(name = "BabyAddServlet", value = "/BabyAddServlet")
public class BabyAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自 post_detail.jsp 36行
        int user_id = Integer.parseInt(request.getParameter("user_id"));//用户id
        int post_id = Integer.parseInt(request.getParameter("post_id"));//帖子id
        String post_title = request.getParameter("post_title");//帖子标题

        new BabyService().insertBaby(user_id, post_id, post_title);

        response.sendRedirect(request.getHeader("Referer"));//返回并刷新
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
