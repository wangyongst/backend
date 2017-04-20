<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-绑定学习卡</title>

    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            function bangding() {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "xuexi/bangding.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href="<%=basePath%>xuexi/xuefen.do"
                        } else {
                            showAlert($("#alertA"), "warning", result.message);
                        }
                    }
                });
            }

            $("#bangding").click(function () {
               bangding();
            });

            $("#bangdingPanel").keypress(function (event) {
                if (event.keyCode == 13) {
                    forget();
                }
            });

        });

    </script>

</head>

<body>

<nav class="navbar navbar-default">
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
                <li ><a href="xuexi/update.do">修改个人信息 </a></li>
                <li><a href="xuexi/home.do">在线学习</a></li>
                <li class="active"><a href="xuexi/xuefen.do">学分记录 <span class="sr-only">(current)</span></a></li>
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
        <div class="panel panel-primary" id="bangdingPanel">
            <div class="panel-heading">你还没有绑定学习卡，请先绑定学习卡</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <label>学习卡号：</label>
                            <input class="form-control" type="text" name="number" placeholder="请填写你购买的学习卡号" autofocus>
                        </div>
                        <a id="bangding" class="btn btn-primary">绑定学习卡</a>
                    </form>
                    <div class="row" id="alertA" hidden></div>
                </div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->
</div>
</body>

</html>
