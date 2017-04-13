<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-注册</title>
    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            $("#updateUser").click(function () {
                if ($("input[name='password']").val() != $("input[name='password2']").val()) {
                    showAlert($("#alertA"), "warning", "你两次输入的密码不一致，请重新输入！");
                    return;
                }
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "xuexi/updateUser.do",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#alertA"), "success", "修改成功，你可以在本平台进行远程学习！");
                        } else {
                            showAlert($("#alertA"), "warning", result.message);
                        }
                    }
                });
            })

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
                <li class="active"><a href="xuexi/update.do">修改个人信息 <span class="sr-only">(current)</span></a></li>
                <li><a href="xuexi/home.do">在线学习</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="framework/logout.do">退出学习平台</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-primary">
            <div class="panel-heading">修改个人信息</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <input class="form-control" name="id" type="hidden" value="${user.id}">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请填写正确的中文名称(支持少数名族，不支持英文、拼音、数字)" value="${user.name}">
                            <label>性 别：</label>
                            <select id="sex" class="form-control" name="sex">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                            <label>身份证号：</label>
                            <input class="form-control" type="text" name="identity" placeholder="身份证号支持15位、18位两种，支持尾数为X" value="${user.identity}">
                            <label>联系电话：</label>
                            <input class="form-control" type="tel" name="phone" placeholder="手机号码为11位数字，座机号码为小于等于12位数字，区号后可带-" value="${user.phone}">
                            <label>用户名：</label>
                            <input class="form-control" type="text" name="username" placeholder="用户名仅支持字母、数字、下划线，长度为3到16个字符" value="${user.username}">
                            <label>密 码：</label>
                            <input class="form-control" type="password" name="password" placeholder="长度为6到22位" value="${user.password}">
                            <label>确认密码：</label>
                            <input class="form-control" type="password" name="password2" placeholder="输入一致的密码" value="${user.password}">
                            <label>单 位：</label>
                            <input class="form-control" name="unit" placeholder="请输入自己的单位中文名称(不支持英文、拼音、数字)" value="${user.unit}">
                            <label>科 室：</label>
                            <input class="form-control" name="department" placeholder="请输入自己的科室中文名称(不支持英文、拼音、数字)" value="${user.department}">
                            <label>职 称：</label>
                            <select id="title" class="form-control" name="title">
                                <c:forEach items="${titles}" var="title">
                                    <c:choose>
                                        <c:when test="${user.title == title.value}">
                                            <option selected="selected" value="${title.value}">${title.value}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${title.value}">${title.value}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <a id="updateUser" class="btn btn-primary">修改</a>
                    </form>
                    <div class="row" id="alertA" hidden></div>
                </div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->
</body>

</html>
