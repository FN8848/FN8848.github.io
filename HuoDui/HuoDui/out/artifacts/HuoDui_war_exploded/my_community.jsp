<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的社区</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>

    <style>
        .col-md-6:hover {
            background-color: #3acdb5;
        }
    </style>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--header.jsp--%>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="flag" value="1"/>
    </jsp:include>

    <div class="row">
        <c:forEach items="${communityList}" var="community">
            <%--我创建的社区列表--%>
            <div class="col-md-6" style="margin-top: 30px;">
                <div style="padding: 20px;background-color: #337ab7;"
                     onclick='location=("<%=basePath%>/CommunityDetailServlet?id=${user.id}&username=${username}&community_id=${community.id}&community_name=${community.name}")'>
                    <div style="width: 100%;height: 350px;background-color:#b4d5ee;font-size: 30px;line-height: 350px;"
                         class="text-center">
                            ${community.name}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
