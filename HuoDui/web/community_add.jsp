<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/12
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
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
        <jsp:param name="flag" value="3"/>
    </jsp:include>

    <div class="row">
        <div class="container" style="background-color: #b4d5ee;margin-top: 100px;">
            <form action="<%=basePath%>/CommunityAddServlet?id=${user.id}" method="post" class="form-horizontal" role="form"
                  style="text-align: center;">
                <div class="form-group">
                    <h1>创建一个新的社区</h1>
                    <label for="name" class="control-label col-md-2">社区名</label>
                    <div class="col-md-9">
                        <input class="form-control" type="text" name="name" id="name" required
                               placeholder="请输入社区名">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="intro" class="control-label col-md-2">简介</label>
                    <div class="col-md-9">
                            <textarea style="height: 350px;" class="form-control" name="intro" id="intro" required
                                      placeholder="社区简介"></textarea>
                    </div>
                </div>
                <br>
                <div class="row">
                    <button class="btn btn-lg btn-info col-md-4 col-md-offset-4">创建</button>
                </div>
                <hr>
            </form>
        </div>
    </div>

</div>
</body>
</html>
