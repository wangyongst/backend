<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-找回密码</title>

    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            function forget() {
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "framework/forget.do?",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                        $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#alertA"), "success","找回密码成功，你的密码是:"+result.data.password+",请妥善保管！");
                            $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                        }else{
                            showAlert($("#alertA"), "warning",result.message);
                            $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                        }
                    }
                });
            }

            $("#forget").click(function () {
                forget();
            });

            $("#close").click(function () {
                window.close();
            });

            $("#authImage").click(function () {
                $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
            });

            $("#forgetPanel").keypress(function (event) {
                if (event.keyCode == 13) {
                    forget();
                }
            });

        });

    </script>

</head>

<body>


<div class="container-fluid">
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-primary" id="forgetPanel">
            <div class="panel-heading">宁夏保健学会学习平台找回密码</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请输入你注册的姓名" autofocus>
                            <label>身份证号：</label>
                            <input class="form-control" type="text"  name="identity" placeholder="请输入你注册的身份证号">
                            <label>验证码：</label>
                            <div class="row">
                                <div class="col-md-8"><input class="form-control" maxlength="8" placeholder="验证码,看不清可点击图片刷新" name="authcode" type="text"> </div>
                                <div class="col-md-4"><img src="/authImage.do" align="right" id="authImage" style="cursor:pointer;"></div>
                            </div>
                        </div>
                        <a id="forget" class="btn btn-primary">找回密码</a>
                        <a id="close" class="btn btn-primary">关闭</a>
                    </form>
                </div>
                <div class="row" id="alertA" hidden></div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->
</div>
</body>

</html>
