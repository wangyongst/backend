<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-注册</title>
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
            <a class="navbar-brand" href="framework/home.do">宁夏保健学会学习平台</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="xuexi/update.do">修改个人信息</a></li>
                <li><a href="xuexi/home.do">在线学习</a></li>
                <li  class="active"><a href="xuexi/xuefen.do">我的学分 <span class="sr-only">(current)</span> </a></li>
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
            <div class="panel-heading">已获得学分课程</div>
            <div class="panel-body">
                <div class="col-md-12">
                    <table data-toggle="table" data-url="xuexi/get/xuefen.do" data-row-style="rowStyle">
                        <thead>
                        <tr>
                            <th data-field="name">课程名称</th>
                            <th data-field="begintime">开始时间</th>
                            <th data-field="endtime">结束时间</th>
                            <th data-field="year">年份</th>
                            <th data-field="score">学分</th>
                            <th data-field="stat">学习状态</th>
                            <th data-field="band">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">未获得学分课程 </div>
                <div class="panel-body">
                    <div class="col-md-12">
                        <table data-toggle="table" data-url="xuexi/get/xuexi.do" data-row-style="rowStyle">
                            <thead>
                            <tr>
                                <th data-field="name">课件名称</th>
                                <th data-field="begintime">开始时间</th>
                                <th data-field="endtime">结束时间</th>
                                <th data-field="yes">考试成绩</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div><!--/.col-->
    </div><!-- /.row -->
</div>
</body>

</html>
