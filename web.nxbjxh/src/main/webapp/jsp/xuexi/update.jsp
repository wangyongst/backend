<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-注册</title>
    <script type="text/javascript">
        $(function () {

            makeModal($("#alertModal"), "alertB", "1");

            function showAlertModal(message,type) {
                $('#alertModal').find('.modal-title').text('用户更新资料提示');
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

            var myunittype = "${mynuittype}";

            $("input[name='unittype'][value='"+ myunittype +"']").prop("checked",true);

            if(myunittype == 1){
                $("#shiselect").parent().hide();
                $("#quxianselect").parent().hide();
            }else if(myunittype == 2){
                $("#quxianselect").parent().hide();
            }

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

            $("#updateUser").click(function () {
                if ($("input[name='password']").val() != $("input[name='password2']").val()) {
                    showAlertModal("你两次输入的密码不一致，请重新输入！",0);
                    return;
                }
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "xuexi/updateUser.do",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlertModal("程序异常，请联系管理员（电话：4006969296）处理，谢谢！",0);
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlertModal("修改成功，你可以在本平台进行远程学习！",0);
                        } else {
                            showAlertModal(result.message,0);
                        }
                    }
                });
            })

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
            <p class="navbar-text"><h2>宁夏保健学会学习平台</h2></p>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="xuexi/update.do">修改个人信息 <span class="sr-only">(current)</span></a></li>
                <li><a href="xuexi/home.do">在线学习</a></li>
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
            <div class="panel-heading">修改个人信息</div>
            <div class="panel-body">
                <div class="col-md-6 col-md-offset-1">
                    <form role="form" id="userForm">
                        <div class="form-group">
                            <input class="form-control" name="id" type="hidden" value="${user.id}">
                            <label>姓名：</label>
                            <input class="form-control" type="text" name="name" placeholder="请填写正确的中文名称(支持少数名族，不支持英文、拼音、数字)" value="${user.name}" autofocus>
                            <label>性 别：</label>
                            <select id="sex" class="form-control" name="sex">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                            <label>身份证号：</label>
                            <input class="form-control" type="text" name="identity" placeholder="身份证号支持15位、18位两种，支持尾数为X" value="${user.identity}">
                            <label>联系电话：</label>
                            <input class="form-control" type="tel" name="phone" placeholder="手机号码为11位数字，座机号码为小于等于12位数字，区号后可带-" value="${user.phone}">
                            <label>密 码：</label>
                            <input class="form-control" type="password" name="password" placeholder="长度为6到22位" value="${user.password}">
                            <label>确认密码：</label>
                            <input class="form-control" type="password" name="password2" placeholder="输入一致的密码" value="${user.password}">
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
                                <label>
                                    <select id="shiselect" class="form-control">
                                        <c:forEach items="${myshis}" var="myshis">
                                            <c:choose>
                                                <c:when test="${myshis.id == myshi}">
                                                    <option selected="selected" value="${myshis.id}">${myshis.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${myshis.id}">${myshis.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </label>
                                <label>
                                    <select id="quxianselect" class="form-control">
                                        <c:forEach items="${myquxians}" var="myquxians">
                                            <c:choose>
                                                <c:when test="${myquxians.id == myquxian}">
                                                    <option selected="selected" value="${myquxians.id}">${myquxians.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${myquxians.id}">${myquxians.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </label>
                                <label>
                                    <select id="unitselect" class="form-control" name="unit">
                                        <c:forEach items="${myunits}" var="myunits">
                                            <c:choose>
                                                <c:when test="${myunits.id == myunit}">
                                                    <option selected="selected" value="${myunits.name}">${myunits.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${myunits.name}">${myunits.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
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
                </div>
            </div>
        </div>
    </div><!--/.col-->
</div><!-- /.row -->
    <div id="alertModal"></div><!-- Modal -->
</div>
</body>

</html>
