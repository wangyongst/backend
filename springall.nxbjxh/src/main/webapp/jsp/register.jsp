<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏远程继续医学教育平台-注册</title>

    <script type="text/javascript">
        $(function () {

            $("#shiselect").parent().hide();
            $("#quxianselect").parent().hide();

            $("#shengradio").prop("checked","true");
            $("#unitselect").parent().attr("class","col-md-12");

            makeModal($("#alertModal"), "alertB", "1");

            unit(1,1);

            function showAlertModal(message,type) {
                $('#alertModal').find('.modal-title').text('注册提示');
                $('#alertModal').attr("class","modal fade");
                $('#alertModal').children().attr("class","modal-dialog");
                $('#alertModal').find('.modal-body').text(message);
                if(type == 1){
                    $('#alertBSave').text("确定");
                    $('#alertBSave').show();
                    $('#alertBClose').hide();
                }else{
                    $('#alertBClose').show();
                    $('#alertBSave').hide();
                }

                $('#alertModal').modal('toggle');
            }

            $("#alertBSave").click(function () {
                window.location.href = "<%=basePath%>jsp/login.jsp";
            });

            $("#shiradio").click(function () {
                $("#shiselect").html("<option selected>——请选择市局——</option>");
                $("#quxianselect").html("<option selected>——请选择区县局——</option>");
                $("#unitselect").html("<option selected>——请选择单位——</option>");
                $("#quxianselect").parent().hide();
                $("#shiselect").parent().attr("class","col-md-6");
                $("#unitselect").parent().attr("class","col-md-6");
                $("#shiselect").parent().show();
                unit(1,5)
            });

            $("#shengradio").click(function () {
                $("#shiselect").html("<option selected>——请选择市局——</option>");
                $("#quxianselect").html("<option selected>——请选择区县局——</option>");
                $("#unitselect").html("<option selected>——请选择单位——</option>");
                $("#shiselect").parent().hide();
                $("#quxianselect").parent().hide();
                $("#unitselect").parent().attr("class","col-md-12");
                unit(1,1);
            });

            $("#quxianradio").click(function () {
                $("#shiselect").html("<option selected>——请选择市局——</option>");
                $("#quxianselect").html("<option selected>——请选择区县局——</option>");
                $("#unitselect").html("<option selected>——请选择单位——</option>");
                $("#shiselect").parent().attr("class","col-md-4");
                $("#quxianselect").parent().attr("class","col-md-4");
                $("#unitselect").parent().attr("class","col-md-4");
                $("#quxianselect").parent().show();
                $("#shiselect").parent().show();
                unit(1,5)
            });

            $("#shiselect").change(
                function () {
                    if ($("input[name='unittype']:checked").val()==2) {
                        unit($(this).children('option:selected').val(), 2);
                    }
                    if ($("input[name='unittype']:checked").val()==3) {
                        unit($(this).children('option:selected').val(), 6);
                    }
                }
            );

            $("#quxianselect").change(
                function () {
                    unit($(this).children('option:selected').val(), 3);
                }
            );

            $("#close").click(function () {
                window.close();
            });

            function unit(pid,type) {
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "framework/unit.do",
                    data: {pid:pid,type:type},
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlertModal("程序异常，请联系管理员（电话：4006969296）处理，谢谢！",0);
                    },
                    success: function (result) {
                        if (result.status == 1 || result.status == 7) {
                            if (result.message == "1" || result.message == "2" || result.message == "3") {
                                $.each(result.data, function (key, value) {
                                    $("#unitselect").append("<option value='" + value.name + "'>" + value.name + "</option>");
                                })
                            }else if(result.message == "5"){
                                $.each(result.data, function (key, value) {
                                    $("#shiselect").append("<option value='" + value.id + "'>" + value.name + "</option>");
                                })
                            }
                            else if(result.message == "6"){
                                $.each(result.data, function (key, value) {
                                    $("#quxianselect").append("<option value='" + value.id + "'>" + value.name + "</option>");
                                })
                            }
                        } else {
                            showAlertModal(result.message,0);
                        }
                    }
                });
            }

            function register() {
                if ($("input[name='password']").val() != $("input[name='password2']").val()) {
                    showAlertModal("你两次输入的密码不一致，请重新输入！",0);
                    $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                    return;
                }
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "framework/registUser.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                        showAlertModal("程序异常，请联系管理员（电话：4006969296）处理，谢谢！",0);
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                            showAlertModal("注册成功，请用你注册的账号及密码登录平台学习！",1);
                        } else {
                            $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                            showAlertModal(result.message,0);
                        }
                    }
                });
            }

            $("#register").click(function () {
                register();
            })

            $("#authImage").click(function () {
                $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
            });

            $("#registerPanel").keypress(function (event) {
                if (event.keyCode == 13) {
                    register();
                }
            });

        });

    </script>

</head>

<body>

<div class="container-fluid">
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-primary" id="registerPanel">
            <div class="panel-heading">宁夏远程继续医学教育平台--新用户注册</div>
            <div class="panel-body">
                <div class="col-md-8 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请填写正确的中文名称(支持少数名族，不支持英文、拼音、数字)" autofocus>
                            <label>性 别：</label>
                            <select class="form-control" name="sex">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                            <label>身份证号：</label>
                            <input class="form-control" type="text" name="identity" placeholder="身份证号支持15位、18位两种，支持尾数为X">
                            <label>联系电话：</label>
                            <input class="form-control" type="tel" name="phone" placeholder="手机号码为11位数字，座机号码为小于等于12位数字，区号后可带-">
                            <label>密 码：</label>
                            <input class="form-control" type="password" name="password" placeholder="长度为6到22位">
                            <label>确认密码：</label>
                            <input class="form-control" type="password" name="password2" placeholder="输入一致的密码">
                            <label>单位直属类别：</label>
                            <div class="row col-md-offset-0">
                                <div class="radio">
                                    <label class="col-md-4">
                                        <input id="shengradio" name="unittype" type="radio" value="1">省直属
                                    </label>
                                    <label class="col-md-4">
                                        <input id="shiradio" name="unittype" type="radio" value="2">市直属
                                    </label>
                                    <label class="col-md-4">
                                        <input id="quxianradio" name="unittype" type="radio" value="3">区/县直属
                                    </label>
                                </div>
                            </div>
                            <label>单 位：</label>
                            <div class="row">
                                     <label hidden>
                                        <select id="shiselect" class="form-control">
                                            <option value="" selected>——请选择市局——</option>
                                        </select>
                                    </label>
                                    <label hidden>
                                        <select id="quxianselect" class="form-control">
                                            <option value="" selected>——请选择区县局——</option>
                                        </select>
                                    </label>
                                    <label class=" col-md-12">
                                        <select id="unitselect" class="form-control" name="unit">
                                            <option value="" selected>——请选择单位——</option>
                                        </select>
                                    </label>
                            </div>
                            <label>科 室：</label>
                            <input class="form-control" name="department" placeholder="请输入自己的科室中文名称(不支持英文、拼音、数字)">
                            <label>职 称：</label>
                            <select id="title" class="form-control" name="title">
                                <option value="" selected>——请选择职称——</option>
                                <c:forEach items="${titles}" var="title">
                                    <option value="${title.value}">${title.value}</option>
                                </c:forEach>
                            </select>
                            <label>验证码：</label>
                            <div class="row">
                                <div class="col-md-8"><input class="form-control" maxlength="8" placeholder="验证码,看不清可点击图片刷新" name="authcode" type="text"></div>
                                <div class="col-md-4"><img src="<%=basePath%>authImage.do" align="right" id="authImage" style="cursor:pointer;"></div>
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

    <div id="alertModal"></div><!-- Modal -->
</div>
</body>

</html>
