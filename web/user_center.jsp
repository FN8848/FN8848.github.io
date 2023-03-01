<%--
  Created by IntelliJ IDEA.
  User: Win10ncvt
  Date: 2023/02/04
  Time: 18:49
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
<style>
    .no:hover {
        background-color: #b4d5ee;
        color: #1851b1;
    }

    #my {
        height: 200px;
        background-color: white;
        color: #2f6ac3;
        font-size: 25px;
        line-height: 200px;
        text-align: center;
    }

    #deleteUser:hover {
        background-color: #d99694;
        color: #fff;
    }
</style>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--header.jsp--%>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="flag" value="3"/>
    </jsp:include>

    <%--  登录失败或未登录  --%>
    <c:if test="${user==null}">
        <div class="row text-center"
             style="height: 200px;background-color:white;color: #2f6ac3;line-height: 200px;font-size: 25px;">
            <div class="no col-md-6" data-toggle="modal" data-target="#Register">注册</div>
            <div class="no col-md-6" onclick='location=("login.jsp")'>登录</div>
        </div>
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="Register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;X
                        </button>
                        <h4 class="modal-title" id="myModalLabel">欢迎加入火堆论坛!</h4>
                    </div>
                    <div class="modal-body">账号是数字,密码和昵称是字符串</div>
                    <form action="<%=basePath%>/RegisterServlet" method="post">
                        <div class="container row">
                            <div class="col-md-6">
                                <input type="number" class="form-control input-lg" placeholder="账号"
                                       name="number"
                                       required><br>
                                <input type="password" class="form-control input-lg" placeholder="密码"
                                       name="password"
                                       required><br>
                                <input type="text" class="form-control input-lg" placeholder="设置昵称"
                                       name="username"
                                       required><br>
                                <input type="submit" class="btn-primary btn-lg" value="立即注册">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <br>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </c:if>
    <%--  登陆成功  --%>
    <c:if test="${user!=null}">
        <div id="ok">
            <div class="row">
                <div class="col-md-10">
                    <h1>欢迎：${user.username}</h1>
                </div>
                <div class="col-md-2">
                    <a href="<%=basePath%>/LoginOutServlet"><h3>退出登录</h3></a>
                </div>
            </div>
            <div id="my">
                <div class="row">
                    <div class="col-md-4"
                         onclick='location=("<%=basePath%>/MyPostServlet?id=${user.id}&username=${user.username}")'>我的帖子
                    </div>
                    <div class="col-md-4"
                         onclick='location=("<%=basePath%>/MyBabyServlet?id=${user.id}&username=${user.username}")'>
                        我的收藏
                    </div>
                    <div class="col-md-4" onclick='location=("<%=basePath%>/community_add.jsp?id=${user.id}")'>
                        创建一个社区
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4"
                         onclick='location=("<%=basePath%>/MyCommunityServlet?id=${user.id}&username=${user.username}")'>
                        我创建的社区
                    </div>

                    <div class="no col-md-4" data-toggle="modal" data-target="#modifyUserName">修改用户名</div>
                    <!-- 修改用户名,模态框（Modal） -->
                    <div class="modal fade" id="modifyUserName" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;X
                                    </button>
                                    <h4 class="modal-title" id="username">修改用户名</h4>
                                </div>
                                <form action="<%=basePath%>/UserModifyUserNameServlet?id=${user.id}"
                                      method="post">
                                    <div class="container row">
                                        <div class="col-md-6">
                                            <input type="text" class="form-control input-lg"
                                                   placeholder="请输入新的用户名"
                                                   name="username"
                                                   required><br>
                                            <input type="hidden" name="number" value="${user.number}">
                                            <input type="hidden" name="password" value="${user.password}">
                                            <input type="submit" class="btn-primary btn-lg" value="确定">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                            </button>
                                            <br>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!-- /.modal-content -->
                    </div>
                    <!-- /.modal -->

                    <div class="no col-md-4" data-toggle="modal" data-target="#modifyPassWord">修改密码</div>
                    <!-- 修改密码,模态框（Modal） -->
                    <div class="modal fade" id="modifyPassWord" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;X
                                    </button>
                                    <h4 class="modal-title" id="password">修改密码</h4>
                                </div>
                                <form action="<%=basePath%>/UserModifyPassWordServlet?id=${user.id}"
                                      method="post">
                                    <div class="container row">
                                        <div class="col-md-6">
                                            <input type="password" class="form-control input-lg"
                                                   placeholder="请输入新密码"
                                                   name="password"
                                                   required><br>
                                            <input type="hidden" name="number" value="${user.number}">
                                            <input type="submit" class="btn-primary btn-lg" value="确定">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                            </button>
                                            <br>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!-- /.modal-content -->
                    </div>
                    <!-- /.modal -->
                </div>
            </div>
            <div onclick='location=("<%=basePath%>/UserDeleteServlet?id=${user.id}")' id="deleteUser"
                 class="row col-md-4 text-center"
                 style="color:red;height: 200px;line-height: 200px;font-size: 25px">删除账号
            </div>
        </div>
    </c:if>

</div>
</body>
<script>
</script>
</html>
