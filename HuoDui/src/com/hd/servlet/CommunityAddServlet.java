package com.hd.servlet;

import com.hd.service.CommunityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 创建一个社区
 */
@WebServlet(name = "CommunityAddServlet", value = "/CommunityAddServlet")
public class CommunityAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自 community_add.jsp 的用户id,社区名,社区简介
        String name = request.getParameter("name");
        String intro = request.getParameter("intro");
        int user_id = Integer.parseInt(request.getParameter("id"));
        boolean flag = new CommunityService().insertCommunity(name, intro, user_id);
        if (flag == true) {
            System.out.println("CommunityAddServlet:创建社区成功");
            response.sendRedirect("user_center.jsp");
        } else {
            System.out.println("CommunityAddServlet:创建社区失败");
            response.sendRedirect("user_center.jsp");
        }
    }
}
