<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/07
  Time: 15:59
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
<c:forEach items="${postList}" var="post">
    <div style="height: 170px;background-color:#b7b5b5;">
        <div class="col-md-12">
            <div class="postList">
                    <%--   点击进入帖子详情   --%>
                <div onclick='location=("<%=basePath%>/PostDetailServlet?id=${post.id}&user_id=${post.user_id}&username=${username}")'>
                    <div class="row">
                        <div class="col-md-10" style="height: 30px;font-size: 25px;line-height: 30px;margin: 5px;">
                            标题:${post.title}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" style="height: 100px;margin: 5px;">内容:${post.text}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
<script>
    <%--    &lt;%&ndash;    删除帖子    &ndash;%&gt;--%>

    <%--    function postDelete(post_id) {--%>
    <%--        $.ajax({--%>
    <%--            url: "/PostDeleteServlet",--%>
    <%--            type: "get",--%>
    <%--            data: {"post_id": post_id},--%>
    <%--            success: {}--%>
    <%--        })--%>
    <%--    }--%>

    <%--    &lt;%&ndash; 点击进入帖子详情 &ndash;%&gt;--%>

    <%--    function postDetail(post_id) {--%>
    <%--        $.ajax({--%>
    <%--            url: "/PostDetailServlet",--%>
    <%--            type: "get",--%>
    <%--            data: {"post_id": post_id},--%>
    <%--            success: function (data) {--%>
    <%--                window.location.href = "/PostDetailServlet"--%>
    <%--            }--%>
    <%--        })--%>
    <%--    }--%>
</script>
</html>
