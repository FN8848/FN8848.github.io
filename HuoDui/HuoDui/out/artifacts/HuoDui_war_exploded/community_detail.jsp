<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/12
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>社区详情</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<style>
    .postList {
        margin-top: 10px;
        margin-bottom: 10px;
        background-color: #fff;
    }

    .postList:hover {
        background-color: #b4d5ee;
    }
</style>
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
    </div>
    <%--  社区信息  --%>
    <div class="row" style="background-color:#a0c5e8;">
        <div style="height: 50px;">
            <div class="col-md-4 text-center"><h4>社区id：${community.id}</h4></div>
            <div class="col-md-4 text-center"><h2>${community.name}</h2></div>
            <div class="col-md-4 text-center"><h4>社区创建者id：${community.user_id}</h4></div>
        </div>
        <div class="col-md-12" style="height: 100px;"><h3>社区简介：${community.intro}</h3></div>
    </div>
    <%--帖子列表--%>
    <div class="row">
        <c:forEach items="${postList}" var="post">
            <div style="height: 170px;background-color:#b7b5b5;">
                <div class="col-md-12">
                    <div class="postList">
                            <%--   点击进入帖子详情   --%>
                        <div onclick='location=("<%=basePath%>/PostDetailServlet?id=${post.id}&user_id=${post.user_id}&username=${username}&user_username=${user_username}")'>
                            <div class="row">
                                <div class="col-md-10"
                                     style="height: 30px;font-size: 25px;line-height: 30px;margin: 5px;">
                                    标题:${post.title}</div>
                                <div class="col-md-1">帖子id:${post.id}</div>
                            </div>
                            <div class="row">
                                <div class="col-md-12" style="height: 100px;margin: 5px;">内容:${post.text}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
