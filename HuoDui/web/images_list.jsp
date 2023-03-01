<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/14
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图片分享</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <style>
        .send-hover:hover {
            color: #337ab7;
        }
    </style>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<div class="container">

    <div class="row">
        <%--标题栏--%>
        <div class="row">
            <jsp:include page="header.jsp">
                <jsp:param name="flag" value="1"/>
            </jsp:include>
        </div>

        <%-- 图片列表 --%>
        <div class="row">
            <c:forEach items="${imagesList}" var="images">
                <img src="${images.imagesUrl}" style="margin-top: 30px;" class="col-md-6" height="500px">
            </c:forEach>
        </div>

        <%-- 上传图片按钮 --%>
        <c:if test="${user.id!=null}">
            <button type="button" id="images" class="btn-lg btn-primary col-lg-2 col-sm-offset-10"
                    style="margin-top: 50px;margin-bottom: 100px;height: 100px;">
                上传图片
            </button>
            <div id="file_img" style="background-color: #b4d5ee;display: none">
                <form action="<%=basePath%>/ImagesAddServlet" method="post"
                      class="form-horizontal" role="form"
                      enctype="multipart/form-data"
                      style="text-align: center;">

                    <div class="form-group">
                        <label for="input_file" class="col-sm-1 control-label">单张图片</label>
                        <div class="col-sm-6" style="font-size: 20px;">
                            <input type="file" name="imagesUrl" id="input_file" required="required">
                        </div>
                    </div>
                    <br>
                    <button class="btn btn-info col-md-4 col-md-offset-4" type="submit">确定上传</button>
                    <hr>
                </form>
            </div>
        </c:if>
    </div>
</div>
</body>
<script>
    $('#images').click(function () {
        //如果当前是隐藏,点击就显示,反之隐藏
        if ($('#file_img').is(':hidden')) {
            $('#file_img').show();
            $('#images').html('取消');
        } else {
            $('#file_img').hide();
            $('#images').html('上传图片');
        }
    });
</script>
</html>
