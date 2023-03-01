package com.hd.servlet;

import com.hd.service.BabyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 删除收藏
 */
@WebServlet(name = "BabyDeleteServlet", value = "/BabyDeleteServlet")
public class BabyDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自 my_baby.jsp 的收藏id
        int id = Integer.parseInt(request.getParameter("id"));
        new BabyService().deleteBabyById(id);

        response.sendRedirect(request.getHeader("referer"));//返回并刷新
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
