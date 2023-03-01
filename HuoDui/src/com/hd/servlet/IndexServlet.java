package com.hd.servlet;

import com.hd.model.Community;
import com.hd.model.Post;
import com.hd.model.User;
import com.hd.service.CommunityService;
import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 首页
 * 包含社区列表和帖子列表
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

    PostService postService = new PostService();
    CommunityService communityService = new CommunityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //未登录,点击header.jsp
        if (request.getParameter("id") == null || request.getParameter("username") == null || "".equals(request.getParameter("id")) || "".equals(request.getParameter("username"))) {
            System.out.println("IndexServlet:未登录状态");

            List<Community> communityList = communityService.selectCommunityList();
            List<Post> postList = postService.selectPostList();

            System.out.println("IndexServlet(未登录):postList=" + postList.toString());
            System.out.println("IndexServlet(未登录):communityList=" + communityList.toString() + "\n");

            request.setAttribute("postList", postList);//帖子列表
            request.setAttribute("communityList", communityList);//评论列表
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //登录后点击header.jsp的首页传来的用户id,用户名
            int user_id = Integer.parseInt(request.getParameter("id"));

            String username = request.getParameter("username");
            System.out.println("IndexServlet:(已登录状态)id=" + user_id + "\t username=" + username);

            List<Community> communityList = communityService.selectCommunityList();
            List<Post> postList = postService.selectPostList();

            System.out.println("IndexServlet(已登录):postList=" + postList.toString());
            System.out.println("IndexServlet(已登录):communityList=" + communityList.toString() + "\n");

            request.setAttribute("user_id", user_id);//发帖时需要添加的参数user_id
            request.setAttribute("username", username);//评论时候显示用户名
            request.setAttribute("communityList", communityList);//社区列表
            request.setAttribute("postList", postList);//帖子列表
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
