<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-登录</title>
    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            $("#login").click(function () {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "framework/login.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href = "<%=basePath%>framework/home.do";
                        } else {
                            showAlert($("#alertA"), "warning", result.message);
                        }
                    }
                });
            })

            $("#register").click(function () {
               window.open("<%=basePath%>jsp/register.jsp");
            })

            $("#forget").click(function () {
                window.open("<%=basePath%>jsp/forget.jsp");
            })

        });

    </script>

</head>

<body>


<div class="row">
    <div class="col-md-8 col-md-offset-2">
<p><br><br><br><br></p>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->

<div class="row" id="alertA" hidden></div>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">宁夏保健学会学习平台</div>
            <div class="panel-body">
                <div class="col-md-5 col-md-offset-1">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            网站公告栏
                        </div>
                        <div class="panel-body">
                            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由于系统更新，所有学员的登录名请使用身份证号码，密码还是和去年的一样，忘记密码请使用“找回密码”功能，登录后首先请完善个人信息，确认无误后再开始学习，遇到各种问题请咨询4006969296
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基于系统安全方面的原因，建议使用ie8以上或者谷歌浏览器，否则会出现页面显示不完整，无法完成注册等问题。
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;升级请点击 </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">请输入您的用户名及密码！</div>
                        <div class="panel-body">
                            <form role="form" id="userForm">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="用户名" name="username" type="text" autofocus="true">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="密码" name="password" type="password" value="">
                                    </div>
                                    <a id="login" class="btn btn-primary">登录</a>
                                    <a id="register" class="btn btn-primary">注册</a>
                                    <a id="forget" class="btn btn-primary">找回密码</a>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div><!-- /.col-->
            </div>
        </div>


    </div><!--/.col-->


</div><!-- /.row -->
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <p>技术支持：甘肃七言志教育科技有限公司<br>客服电话：4006969296  0931-2111188 <br>QQ：2715528741<br>QQ群：68638150<br>备案信息：陇ICP备14000281号-1 <br></p>
    </div>
</div><!-- /.col-->
</div><!-- /.row -->
</body>

</html>
