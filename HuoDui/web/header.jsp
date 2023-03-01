<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>火堆论坛</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<style>
    .col-md-4:hover {
        background-color: #b4d5ee;
        color: #1851b1;
    }

    #header-color {
        background-color: #2f6ac3;
        color: white;
        height: 50px;
        line-height: 50px;
        text-align: center;
    }
</style>
<body>
<div class="row" id="header-color">
    <div class="col-md-4"
         onclick="location.href=('<%=basePath%>/IndexServlet?id=${user.id}&username=${user.username}')">首页
    </div>
    <div class="col-md-4" onclick='location.href=("#")'>热门</div>
    <div class="col-md-4"
         onclick='location.href=("<%=basePath%>/user_center.jsp?id=${user.id}&username=${user.username}")'>个人中心
    </div>
</div>
</body>
</html>
