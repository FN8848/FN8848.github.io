package com.hd.servlet;

import com.hd.model.Images;
import com.hd.service.ImagesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 图片列表
 */
@WebServlet(name = "ImagesServlet", value = "/ImagesServlet")
public class ImagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List<Images> imagesList = new ImagesService().selectImagesList();
        request.setAttribute("imagesList", imagesList);
        request.getRequestDispatcher("images_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
