package com.hd.servlet;

import com.hd.model.Post;
import com.hd.service.PostService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 发帖 servlet
 */
@WebServlet("/PostAddServlet")
public class PostAddServlet extends HttpServlet {
    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从post_add.jsp接收header.jsp传来的用户id和用户名到这里
        int user_id = Integer.parseInt(request.getParameter("id"));
        String user_username = request.getParameter("username");
        System.out.println("PostAddServlet:user_id=" + user_id + "\tuser_username=" + user_username);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //接收post_add.jsp的数据
        try {
            List<FileItem> list = upload.parseRequest(request);
            Post post = new Post();

            for (FileItem item : list) {
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "title":
                            post.setTitle(item.getString("utf-8"));
                            break;
                        case "text":
                            post.setText(item.getString("utf-8"));
                            break;
                        case "community_id":
                            post.setCommunity_id(Integer.parseInt(item.getString("utf-8")));
                            break;
                    }
                }
            }
            //把jsp页面的数据传到service方法
            postService.insertPost(user_id, user_username, post.getTitle(), post.getText(), post.getCommunity_id());
            //切换页面,到帖子列表servlet
            response.sendRedirect(request.getHeader("Referer"));//返回并刷新
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
