package com.hd.servlet;

import com.hd.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 发表评论
 */
@WebServlet(name = "CommentAddServlet", value = "/CommentAddServlet")
public class CommentAddServlet extends HttpServlet {

    CommentService commentService = new CommentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        if ("".equals(request.getParameter("user_username"))) {
            System.out.println("CommentAddServlet:未登录无法评论");
            response.sendRedirect("login.jsp");
        } else {
            //接收post_detail.jsp评论对应帖子的 id , 内容 , 用户名
            String user_username = request.getParameter("user_username");
            String say = request.getParameter("say");
            int post_id = Integer.parseInt((request.getParameter("post_id")));
            System.out.println("CommentAddServlet 评论: " + "user_username=" + user_username + "\t评论内容=" + say + "\tid=" + post_id);

            //添加一条评论的方法
            commentService.insertComment(user_username, say, post_id);
            response.sendRedirect(request.getHeader("Referer"));//返回并刷新
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
