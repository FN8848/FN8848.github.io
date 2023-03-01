package com.hd.servlet;

import com.hd.model.Post;
import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 我发布的帖子
 */
@WebServlet(name = "MyPostServlet", value = "/MyPostServlet")
public class MyPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收来自 user_center.jsp 的参数: 用户id
        int user_id = Integer.parseInt(request.getParameter("id"));
        System.out.println("MyPostServlet:用户id=" + user_id);

        List<Post> postList = new PostService().selectPostListByUserId(user_id);
        System.out.println("MyPostServlet:我的帖子:\n" + postList);

        request.setAttribute("postList", postList);
        request.getRequestDispatcher("my_post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
