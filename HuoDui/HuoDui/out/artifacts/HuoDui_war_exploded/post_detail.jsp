<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/07
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子详情</title>
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
        <jsp:param name="flag" value="4"/>
    </jsp:include>

    <%-- 帖子内容 --%>
    <div class="row" style="background-color:#b4d5ee;padding: 15px;">
        <div class="col-md-12" id="post" style="background-color:#ffffff;margin-bottom: 30px;">
            <div class="my_post" style="margin-top: 10px;margin-bottom: 10px;background-color:#fff;">
                <h4>作者：${post.user_username}</h4>
                <div class="col-md-10" style="height: 30px;font-size: 25px;line-height: 30px;margin: 5px;">
                    标题：${post.title}</div>
                <div class="col-md-1">帖子id：${post.id}</div>
                <c:if test="${user.username!=null}">
                    <button onclick='location=("<%=basePath%>/BabyAddServlet?user_id=${user.id}&post_id=${post.id}&post_title=${post.title}")' >
                        收藏
                    </button>
                </c:if>
                <div class="col-md-12" style="margin: 5px;">内容:${post.text}</div>
            </div>
        </div>
        <%-- 评论区    用户名:评论内容--%>
        <div class="row" style="margin-left: 0;"><h4><b>评论区</b></h4></div>
        <c:forEach items="${commentList}" var="comment">
            <div class="row" style="padding: 15px;">
                <div class="col-md-12" style="">
                    <div>
                        <b>${comment.user_username}：</b>${comment.say}
                        <hr>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--  发表评论  --%>
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <form action="<%=basePath%>/CommentAddServlet?id=${post.id}&user_username=${user_username}"
                      method="post">
                    <input name="post_id" type="hidden" value="${post.id}">
                    <input name="user_username" type="hidden" value="${user_username}">
                    <input style="height: 50px;" class="col-md-9" type="text" name="say" placeholder="在此发表评论">
                    <input style="height: 50px;" class="col-md-3" type="submit" value="发布">
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function location(){
        alert("你点击了按钮哦");
    }
</script>

</body>

</html>
