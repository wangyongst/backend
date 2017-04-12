<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-注册</title>
    <script type="text/javascript">
        $(function () {

            makeAlert($("#alertA"));

            $.ajax({
                type: "GET",
                cache: "false",
                url: "framework/get/param.do",
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#alertA"), "danger");
                },
                success: function (result) {
                    if (result.status == 1 || result.status == 7) {
                        $.each(result.data.forEach(function(value,index,arr) {
                            if(value.name == "title"){
                                $("#title").append("<option value='"+value.value+"'>"+value.value+"</option>");
                            }
                        }));
                    } else {
                        showAlert($("#alertA"), "warning", result.message);
                    }
                }
            });

            $("#close").click(function () {
                window.close();
            });

            $("#register").click(function () {
                if($("input[name='password']").val() != $("input[name='password2']").val()){
                    showAlert($("#alertA"), "warning", "你两次输入的密码不一致，请重新输入！");
                    return;
                }
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "framework/regist.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                        $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#alertA"), "success","注册成功，请用你注册的账号及密码登录系统学习！");
                            $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                            //window.location.href = "<%=basePath%>framework/home.do";
                        } else {
                            showAlert($("#alertA"), "warning", result.message);
                            $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                        }
                    }
                });
            })

            $("#authImage").click(function () {
                $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
            })

        });

    </script>

</head>

<body>

<div class="row" id="alertA" hidden></div>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">宁夏保健学会学习平台新用户注册</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请填写正确的中文名称(支持少数名族，不支持英文、拼音、数字)">
                            <label>性 别：</label>
                            <select class="form-control" name="sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                            </select>
                            <label>身份证号：</label>
                            <input class="form-control" type="text"  name="identity" placeholder="身份证号支持15位、18位两种，支持尾数为X">
                            <label>联系电话：</label>
                            <input class="form-control" type="tel"  name="phone" placeholder="手机号码为11位数字，座机号码为小于等于12位数字，区号后可带-">
                            <label>用户名：</label>
                            <input class="form-control" type="text" name="username" placeholder="用户名仅支持字母、数字、下划线，长度为3到16个字符">
                            <label>密 码：</label>
                            <input class="form-control" type="password"  name="password" placeholder="长度为6到22位">
                            <label>确认密码：</label>
                            <input class="form-control" type="password"  name="password2" placeholder="输入一致的密码">
                            <label>单 位：</label>
                            <input class="form-control" name="unit" placeholder="请输入自己的单位中文名称(不支持英文、拼音、数字)">
                            <label>科 室：</label>
                            <input class="form-control" name="department" placeholder="请输入自己的科室中文名称(不支持英文、拼音、数字)">
                            <label>职 称：</label>
                            <select id="title" class="form-control" name="title">
                            </select>
                            <label>验证码：</label>
                            <div class="row">
                                <div class="col-md-8"><input class="form-control" maxlength="8" placeholder="验证码,看不清可点击图片刷新" name="authcode" type="text"> </div>
                                <div class="col-md-4"><img src="/authImage.do" align="right" id="authImage" style="cursor:pointer;"></div>
                            </div>
                        </div>
                        <a id="register" class="btn btn-primary">注册</a>
                        <a id="close" class="btn btn-primary">关闭</a>
                    </form>
                </div>
            </div>
        </div>


    </div><!--/.col-->


</div><!-- /.row -->
</body>

</html>
