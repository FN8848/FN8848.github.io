<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的收藏</title>
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
    <%--header.jsp--%>
    <jsp:include page="header.jsp">
        <jsp:param name="flag" value="1"/>
    </jsp:include>
    <%-- 收藏列表 --%>
    <c:forEach items="${babyList}" var="baby">
        <div class="row" style="background-color:#b4d5ee;padding: 15px;">
            <div class="col-md-12" style="background-color:#ffffff;margin-bottom: 30px;">
                <div style="margin-top: 10px;margin-bottom: 10px;background-color:#fff;">
                        <%-- 点击进入帖子详情,但是去新的servlet,然后转发给PostDetailServlet --%>
                    <div class="col-md-10"
                         onclick='location=("<%=basePath%>/MyBabyDetailServlet?post_id=${baby.post_id}")'
                         style="height: 30px;font-size: 25px;line-height: 30px;margin: 5px;">
                        标题：${baby.post_title}</div>
                    <button style="background-color: #e33d30;color:#fff;"
                            onclick='location=("<%=basePath%>/BabyDeleteServlet?id=${baby.id}")'>
                        取消收藏
                    </button>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
