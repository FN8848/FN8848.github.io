<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎访问火堆论坛</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <style>
        *{


        }
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

        <%-- 发帖按钮 --%>
        <c:if test="${user.id!=null}">
            <div class="row">

                <div class="col-md-10"  style="line-height: 100px;font-size: 35px;background-color:#b4d5ee;">
                    <div style="margin-left: 260px;">欢迎进入火堆论坛</div>
                </div>
                <div class="col-md-2 send-hover" id="send"
                     style="background-color: #d0e9c6;height: 100px;display:flex;">
                    <div style="margin: auto;font-size: 35px;"><span>发帖</span></div>
                </div>
            </div>
            <%-- 发帖界面 --%>
            <div class="row">
                <div id="post_add" class="row" style="display: none">
                    <jsp:include page="post_add.jsp">
                        <jsp:param name="flag" value="1"/>
                    </jsp:include>
                </div>
            </div>
        </c:if>

        <div class="row">
            <%--社区列表--%>
            <div class="row col-md-2">
                <jsp:include page="community_list.jsp">
                    <jsp:param name="flag" value="3"/>
                </jsp:include>
            </div>
            <%--帖子列表--%>
            <div class="row col-md-10" style="margin-left: 45px;">
                <jsp:include page="post_list.jsp">
                    <jsp:param name="flag" value="4"/>
                </jsp:include>
            </div>
        </div>

    </div>
</div>
<img style="width: 220px;height: 100px;position: absolute;top: 0px;" src="logo/img.png">
</body>
<script>
    $('#send').click(function () {
        //如果当前是隐藏,点击就显示,反之隐藏
        if ($('#post_add').is(':hidden')) {
            $('#post_add').show();
            $('span').html('取消发帖');
        } else {
            $('#post_add').hide();
            $('span').html('发帖');
        }
    });
</script>
</html>
