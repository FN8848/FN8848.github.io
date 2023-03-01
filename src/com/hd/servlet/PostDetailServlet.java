package com.hd.servlet;

import com.hd.model.Comment;
import com.hd.model.Post;
import com.hd.service.CommentService;
import com.hd.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帖子详情
 */
@WebServlet(name = "PostDetailServlet", urlPatterns = "/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
    PostService postService = new PostService();
    CommentService commentService = new CommentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从首页点进来的
        if (request.getParameter("user_username") == null) {
            //从收藏点进来的, MyBabyDetailServlet 转发的数据
            if (request.getAttribute("id") != null) {
                int id = (int) request.getAttribute("id");//帖子id
                int user_id = (int) request.getAttribute("user_id");//发帖人id
                String user_username = (String) request.getAttribute("username");//发帖人username

                Post post = postService.selectPostById(id);
                System.out.println("PostDetailServlet:帖子内容: " + post.toString() + "\n");

                //根据 帖子的id 查找评论列表
                List<Comment> commentList = commentService.selectCommentListByPostId(id);
                System.out.println("PostDetailServlet:评论列表: " + commentList);
                request.setAttribute("post", post);
                request.setAttribute("user_id", user_id);//已登录用户id
                request.setAttribute("user_username", user_username);//已登录用户名
                request.setAttribute("commentList", commentList);
                request.getRequestDispatcher("post_detail.jsp").forward(request, response);
            } else {
                //获取从 post_list.jsp 页面传过来的帖子id,用户id,用户名
                int id = Integer.parseInt(request.getParameter("id").trim());
                int user_id = Integer.parseInt(request.getParameter("user_id").trim());
                String user_username = request.getParameter("username").trim();

                Post post = postService.selectPostById(id);
                System.out.println("PostDetailServlet:帖子内容: " + post.toString() + "\n");

                //根据 帖子的id 查找评论列表
                List<Comment> commentList = commentService.selectCommentListByPostId(id);
                System.out.println("PostDetailServlet:评论列表: " + commentList);
                request.setAttribute("post", post);
                request.setAttribute("user_id", user_id);//已登录用户id
                request.setAttribute("user_username", user_username);//已登录用户名
                request.setAttribute("commentList", commentList);
                request.getRequestDispatcher("post_detail.jsp").forward(request, response);
            }
        } else {
            //从社区里点进来的
            //获取从 post_list.jsp 页面传过来的帖子id,用户id,用户名
            int id = Integer.parseInt(request.getParameter("id").trim());
            int user_id = Integer.parseInt(request.getParameter("user_id").trim());
            String user_username = request.getParameter("user_username").trim();

            Post post = postService.selectPostById(id);
            System.out.println("PostDetailServlet:帖子内容: " + post.toString() + "\n");

            //根据 帖子的id 查找评论列表
            List<Comment> commentList = commentService.selectCommentListByPostId(id);
            System.out.println("PostDetailServlet:评论列表: " + commentList);
            request.setAttribute("post", post);
            request.setAttribute("user_id", user_id);//已登录用户id
            request.setAttribute("user_username", user_username);//已登录用户名
            request.setAttribute("commentList", commentList);
            request.getRequestDispatcher("post_detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
