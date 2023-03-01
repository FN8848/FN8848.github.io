<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/05
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>发帖</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%--发帖--%>
<div style="background-color: #b4d5ee;margin-bottom: 1000px;">
    <form action="<%=basePath %>/PostAddServlet?id=${user.id}&username=${user.username}" method="post" class="form-horizontal" role="form"
          enctype="multipart/form-data"
          style="text-align: center;">
        <div class="form-group">
            <h1>发帖</h1>
            <label for="title" class="control-label col-md-2">标题</label>
            <div class="col-md-9">
                <input class="form-control" type="text" name="title" id="title" required>
            </div>
        </div>
        <div class="form-group">
            <label for="text" class="control-label col-md-2">内容</label>
            <div class="col-md-9">
                <textarea style="height: 300px;" class="form-control" type="text" name="text" id="text"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-5"><h4>选择发布社区</h4></div>
            <select name="community_id" class="col-sm-offset-5">
                <c:forEach items="${communityList}" var="community">
                    <option value="${community.id}">${community.name}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <div class="row">
            <button class="btn btn-info col-md-4 col-md-offset-4" type="submit">确定发帖</button>
        </div>
        <hr>
    </form>
</div>
</body>
</html>
