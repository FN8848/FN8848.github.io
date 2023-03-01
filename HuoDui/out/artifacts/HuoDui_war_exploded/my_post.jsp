<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子列表</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<div class="container">
    <%--标题栏--%>
    <jsp:include page="header.jsp">
        <jsp:param name="flag" value="1"/>
    </jsp:include>

    <c:forEach items="${postList}" var="post">
        <div class="row" style="height: 170px;background-color:#b7b5b5;">
            <div class="col-md-10">
                <div class="postList" style="margin-top: 10px;margin-bottom: 10px;background-color:#fff;">
                        <%--   点击进入帖子详情   --%>
                    <a href="<%=basePath%>/PostDetailServlet?id=${post.id}&user_id=${post.user_id}&username=${username}">
                        <div class="row">
                            <div class="col-md-10" style="height: 30px;font-size: 25px;line-height: 30px;margin: 5px;">
                                标题:${post.title}</div>
                            <div class="col-md-1">帖子id：${post.id}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-11" style="height: 100px;margin: 5px;">内容:${post.text}</div>
                        </div>
                    </a>
                </div>
            </div>
                <%--    删除帖子    --%>
            <div class="col-md-2 text-center" style="height: 150px;background-color:#b7b5b5;">
                <button onclick='location=("<%=basePath%>/PostDeleteServlet?post_id=${post.id}")' type="button"
                        class="btn-danger text-center"
                        style="width: 100%;line-height: 140px;margin-top: 10px;margin-bottom: 10px">删除
                </button>
            </div>
        </div>
    </c:forEach>

</div>


</body>
</html>
