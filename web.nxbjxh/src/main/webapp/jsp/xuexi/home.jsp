<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-在线学习</title>


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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">点击展开菜单</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-text" href="framework/home.do"><h2>宁夏保健学会学习平台</h2></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="xuexi/update.do">修改个人信息 </a></li>
                <li class="active"><a href="xuexi/home.do">在线学习<span class="sr-only">(current)</span></a></li>
                <li><a href="xuexi/xuefen.do">我的学分 </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="framework/logout.do">退出学习平台</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
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
</body>

</html>
