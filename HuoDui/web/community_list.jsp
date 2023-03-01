<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/10
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>社区列表</title>
    <script type="text/javascript" src="js/jquery3.6.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<style>
    #community {
        margin: 0;
        padding: 0;
        width: 230px;
        height: 170px;
        background-color: #3acdb5;
        display: flex;
        color: #fff;
    }

    #community:hover {
        background-color: #1589f6;
    }
</style>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--社区列表--%>
<c:forEach items="${communityList}" var="community">
    <div id="community" onclick='location=("<%=basePath%>/CommunityDetailServlet?community_id=${community.id}&community_name=${community.name}&id=${user.id}&username=${user.username}")'>
        <div style="margin: auto;"><b>${community.name}</b></div>
    </div>
</c:forEach>
</body>
</html>
