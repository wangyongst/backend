<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>爱品优购VIP会员视频观看系统-登录</title>
    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            $("#login").click(function () {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "login.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href = "<%=basePath%>home.do";
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

<div class="row" id="alertA" hidden></div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">欢迎登录本系统，请输入您的用户名及密码！</div>
            <div class="panel-body">
                <form role="form" id="userForm">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名" name="username" type="text" autofocus="true">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">记住我
                            </label>
                        </div>
                        <a id="login" class="btn btn-primary">登录</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->
</body>

</html>
