package com.hd.servlet;

import com.hd.model.Images;
import com.hd.service.ImagesService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 上传图片
 */
@WebServlet(name = "ImagesAddServlet", value = "/ImagesAddServlet")
public class ImagesAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");  //处理中文问题
        upload.setSizeMax(1024 * 1024);   //限制文件大小

        try {
            List<FileItem> fileItems = upload.parseRequest(request);  //解码请求 得到所有表单元素
            Images images = new Images();
            for (FileItem fileItem : fileItems) {
                //文件如果不空就继续执行
                if (fileItem.getInputStream().available() <= 0) continue;
                //文件名
                String fileName = fileItem.getName();
                fileName = fileName.substring(fileName.lastIndexOf("."));//截取.后面的字符串,例如.jpg
                fileName = "/" + new Date().getTime() + fileName;//文件完整路径
                String path = this.getServletContext().getRealPath("/images") + fileName;
                System.out.println(path);

                InputStream in = fileItem.getInputStream();
                FileOutputStream out = new FileOutputStream(path);

                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer);
                }

                in.close();
                out.close();
                fileItem.delete();
                if (fileItem.getFieldName().equals("imagesUrl")) {
                    images.setImagesUrl("/images" + fileName);
                }
            }
            new ImagesService().insertImages(images.getImagesUrl());
            request.getRequestDispatcher("/ImagesServlet").forward(request, response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
