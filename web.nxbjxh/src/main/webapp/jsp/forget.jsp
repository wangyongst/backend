<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-找回密码</title>
    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            $("#forget").click(function () {
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "framework/forget.do?",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#alertA"), "success","找回密码成功，请用你的密码是:"+result.data.password+",请妥善保管！");
                        }else{
                            showAlert($("#alertA"), "warning",result.message);
                        }
                    }
                });
            });

            $("#close").click(function () {
                window.close();
            })

        });

    </script>

</head>

<body>

<div class="row" id="alertA" hidden></div>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">宁夏保健学会学习平台找回密码</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请输入你注册的姓名">
                            <label>身份证号：</label>
                            <input class="form-control" type="text"  name="identity" placeholder="请输入你注册的身份证号">
                            <label>用户名：</label>
                            <input class="form-control" type="text" name="username" placeholder="请输入你注册的用户名">
                        </div>
                        <a id="forget" class="btn btn-primary">找回密码</a>
                        <a id="close" class="btn btn-primary">关闭</a>
                    </form>
                </div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->
</body>

</html>
