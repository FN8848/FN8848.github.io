<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>登录</title>
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
  <div class="row">
    <c:if test="${username!=null}">
      <div class="row">
        <div class="col-md-12"><h4>${username}&nbsp;注册成功！请登录</h4></div>
      </div>
    </c:if>
    <div class="container" style="background-color: #b4d5ee;margin-top: 100px;">
      <form action="<%=basePath %>/LoginServlet" method="post" class="form-horizontal" role="form"
            style="text-align: center;">
        <div class="form-group">
          <h1>登录</h1>
          <label for="number" class="control-label col-md-2">账号</label>
          <div class="col-md-9">
            <input class="form-control" type="number" name="number" id="number" required
                   placeholder="请输入账号">
          </div>
        </div>
        <br>
        <div class="form-group">
          <label for="password" class="control-label col-md-2">密码</label>
          <div class="col-md-9">
            <input class="form-control" type="password" name="password" id="password" required
                   placeholder="请输入密码">
          </div>
        </div>
        <br>
        <div class="row">
          <button class="btn btn-info col-md-4 col-md-offset-4">登录</button>
        </div>
        <hr>
      </form>
    </div>
  </div>
</div>
</body>
</html>
