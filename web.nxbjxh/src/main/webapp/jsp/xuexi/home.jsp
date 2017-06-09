<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏远程继续医学教育平台-在线学习</title>


    <script type="text/javascript">
        $(function () {
        });

    </script>

</head>

<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <p class="navbar-text">
            <h2>宁夏远程继续医学教育平台</h2></p>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav nav-pills nav-stacked" id="bs-example-navbar-collapse-1">
            <li role="presentation" class="divider"></li>
            <li><a href="xuexi/update.do">修改个人信息 </a></li>
            <li role="presentation" class="divider"></li>
            <li class="active"><a href="xuexi/home.do">在线学习</a></li>
            <li role="presentation" class="divider"></li>
            <li><a href="xuexi/xuefen.do">我的学分 </a></li>
            <li role="presentation" class="divider"></li>
            <li><a href="framework/logout.do">退出学习平台</a></li>
            <li role="presentation" class="divider"></li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid xyz">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">在线学习</div>
                        <div class="panel-body">
                            <ul class="media-list">
                                <li class="media">

                                </li>
                                <c:forEach items="${courses}" var="course">
                                    <li class="media">
                                        <div class="col-md-1 col-md-offset-1 media-left">
                                            <a href="xuexi/course.do?id=${course.id}">
                                                <img class="media-object img-thumbnail" src="${course.picture}" alt="${course.name}" style="width: 81px;height: 81px">
                                            </a>
                                        </div>
                                        <div class="media-body media-left">
                                            <h4 class="media-heading"><a href="xuexi/course.do?id=${course.id}">${course.name}</a></h4>
                                            <span class="col-md-11 text-success">课件简介：${course.introduce}</span>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div><!--/.col-->
            </div><!-- /.row -->
        </div>
    </div>
</div>
</body>

</html>
