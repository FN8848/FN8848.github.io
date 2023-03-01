package com.hd.servlet;

import com.hd.model.Post;
import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子列表
 */
@WebServlet("/PostListServlet")
class PostListServlet extends HttpServlet {
    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取帖子列表
        List<Post> postList = postService.selectPostList();
        //发送到帖子列表jsp
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("post_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
