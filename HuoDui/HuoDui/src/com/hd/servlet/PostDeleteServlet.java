package com.hd.servlet;

import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 删除帖子 servlet
 */
@WebServlet("/PostDeleteServlet")
public class PostDeleteServlet extends HttpServlet {
    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("post_id"));
        System.out.println("PostDeleteServlet:删除帖子,id=" + id);
        postService.deletePostById(id);
        response.sendRedirect(request.getHeader("referer"));//返回并刷新
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
