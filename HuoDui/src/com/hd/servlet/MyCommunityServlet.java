package com.hd.servlet;

import com.hd.model.Community;
import com.hd.service.CommunityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 我创建的社区
 */
@WebServlet(name = "MyCommunityServlet", value = "/MyCommunityServlet")
public class MyCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //来自 user_center.jsp 的用户id
        int user_id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        List<Community> communityList = new CommunityService().selectCommunityByUserId(user_id);
        //打印查看
        System.out.println("MyCommunityServlet:user_id=" + user_id + "\tusername=" + username);
        System.out.println("MyCommunityServlet:communityList=" + communityList);
        //点开我的社区需要使用的参数
        request.setAttribute("id", user_id);
        request.setAttribute("username", username);
        request.setAttribute("communityList", communityList);
        request.getRequestDispatcher("my_community.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
