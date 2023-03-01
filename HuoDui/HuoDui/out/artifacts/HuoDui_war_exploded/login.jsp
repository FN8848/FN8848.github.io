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
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="jQuery/jquery3.6.1.min.js"></script>
    <style>
        body {
            margin: 0;
            font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
        }

        .container {
            width: 100vw;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: url("https://starry-lixu.oss-cn-hangzhou.aliyuncs.com/202209141908599.jpg") fixed no-repeat;
            /*background-size: cover;*/
        }

        .login-form {
            width: 240px;
            height: 220px;
            display: flex;
            flex-direction: column;
            padding: 40px;
            text-align: center;
            position: relative;
            z-index: 100;
            background: inherit;
            border-radius: 18px;
            overflow: hidden; /* 隐藏多余的模糊效果*/
        }

        .login-form::before {
            content: "";
            width: calc(100% + 20px);
            height: calc(100% + 20px);
            position: absolute;
            top: -10px;
            left: -10px;
            overflow: hidden;
            background: inherit;
            box-shadow: inset 0 0 0 200px rgba(255, 255, 255, 0.25);
            filter: blur(6px);
            z-index: -1;
        }

        .login-form h2 {
            font-size: 18px;
            font-weight: 400;
            color: #3d5245;
        }

        .login-form input,
        .login-form button {
            margin: 6px 0;
            height: 36px;
            border: none;
            background-color: rgba(255, 255, 255, 0.3);
            border-radius: 4px;
            padding: 0 14px;
            color: #3d5245;
        }

        .login-form input::placeholder {
            color: #3d5245;
        }


        .login-form button:focus,
        .login-form input:focus {
            outline: 0;
        }

        .login-form button {
            margin-top: 24px;
            background-color: rgba(57, 88, 69, 0.4);
            color: white;
            position: relative;
            overflow: hidden;
            cursor: pointer;
            transition: 0.4s;
        }

        .login-form button:hover {
            background-color: rgba(12, 80, 38, 0.67);
        }
    </style>
</head>
<body>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--header.jsp--%>
<jsp:include page="header.jsp">
    <jsp:param name="flag" value="1"/>
</jsp:include>

<body>
<div class="container">
    <form action="/LoginServlet" class="login-form" method="post">
        <h2>登 录</h2>
        <input
                type="type"
                name="number"
                placeholder="账号"
                required="required"
        />
        <input
                type="password"
                name="password"
                placeholder="密码"
                required="required"
        />
        <input type="submit" value="登录">
        <div>没有账号？<a href="register.jsp">立即注册</a></div>
    </form>


</div>
</div>

</body>
</html>
