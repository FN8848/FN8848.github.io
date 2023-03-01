package com.hd.servlet;

import com.hd.model.Community;
import com.hd.model.Post;
import com.hd.service.CommunityService;
import com.hd.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 社区详情
 */
@WebServlet(name = "CommunityDetailServlet", value = "/CommunityDetailServlet")
public class CommunityDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //未登录状态
        if (request.getParameter("id") == null || "".equals(request.getParameter("username")) || request.getParameter("community_id") == null || "".equals(request.getParameter("community_name"))) {
            System.out.println("CommunityDetailServlet: 未登录无法进入社区详情");
            response.sendRedirect("login.jsp");
        } else {
            //已登录状态
            //获取从 community_list.jsp 传来的社区id和用户名
            int id = Integer.parseInt(request.getParameter("community_id"));//社区id
            String name = request.getParameter("community_name");//社区名
            int user_id = Integer.parseInt(request.getParameter("id"));//当前登录用户id
            String user_username = request.getParameter("username");//当前登录用户名
            System.out.println("CommunityDetailServlet:community_id=" + id + "\tcommunity_name=" + name + "\tid=" + user_id + "\tusername=" + user_username);
            //获取社区信息、帖子列表、评论
            Community community = new CommunityService().selectCommunityById(id);
            List<Post> postList = new PostService().selectPostListByCommunityId(id);
            //打印查看
            System.out.println("CommunityDetailServlet: 社区信息: " + community.toString() + "\n");
            System.out.println("CommunityDetailServlet: 帖子列表: " + postList + "\n");
            request.setAttribute("community", community);//社区信息
            request.setAttribute("postList", postList);//帖子列表
            request.setAttribute("user_username", user_username);//用户名
            request.getRequestDispatcher("community_detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
