package com.hd.servlet;

import com.hd.model.Post;
import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 我的收藏详情
 */
@WebServlet(name = "MyBabyDetailServlet", value = "/MyBabyDetailServlet")
public class MyBabyDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自 my_baby.jsp 的 post_id
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        //根据帖子id查询帖子接收数据并传给 PostDetailServlet
        Post post = new PostService().selectPostById(post_id);
        System.out.println(post.toString());
        request.setAttribute("id", post_id);//帖子id
        request.setAttribute("user_id", post.getUser_id());//发帖人的id
        request.setAttribute("username", post.getUser_username());//发帖人username
        request.getRequestDispatcher("/PostDetailServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
