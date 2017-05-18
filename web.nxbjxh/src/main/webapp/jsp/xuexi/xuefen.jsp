<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-注册</title>
    <script type="text/javascript">
        $(function () {
            makeModal($("#bandModal"), "band", "1");

            makeAlert($("#bandAlert"));

            $("#bandSave").click(function () {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "xuexi/post/band.do",
                    data: $('#bandForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#bandAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#bandAlert"), "success", result.message);
                        }
                        else {
                            showAlert($("#bandAlert"), "warning", result.message);
                        }
                    }
                });
            });

            $("#bandClose").click(function () {
                window.location.reload();
            });

        });

        function show(course) {
            $('#bandModal').find('.modal-title').text('申请学分');
            $('#bandModal').attr("class", "modal fade bs-example-modal-lg");
            $('#bandModal').children().attr("class", "modal-dialog modal-lg");
            $('#bandForm').empty();
            $('#bandForm').append("恭喜你已经完成本课程所有课件学习，你已经获得本课程学分，你可以绑定你的学习卡领取学分证书！<br>");
            $('#bandForm').append("请输入你的学习卡和密码，并点击申请学习！<br><br>");
            $('#bandForm').append("<input type='text' name='course' value='" + course + "' hidden>")
            $('#bandForm').append("<label>学习卡号：</label><input class='form-control' type='text' name='number' placeholder='请填写你购买的学习卡卡号' autofocus>");
            $('#bandForm').append("<label>学习卡密码：</label><input class='form-control' type='password' name='password' placeholder='请填写你购买的学习卡密码'>")
            $('#bandSave').text('申请学分');
            $("#bandAlert").hide();
            $('#bandSave').show();
            $('#bandModal').modal('toggle');
        };

        function makeXuexi(id) {
            //alert(id);
            $('#xuexiTable').bootstrapTable(
                "refresh",
                {
                    url:"xuexi/get/xuexi.do?course="+id,
                }
            );
            $('#myModal').modal('toggle');
        }

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
            <a class="navbar-text" href="framework/home.do"><h2>宁夏保健学会学习平台</h2></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="xuexi/update.do">修改个人信息</a></li>
                <li><a href="xuexi/home.do">在线学习</a></li>
                <li class="active"><a href="xuexi/xuefen.do">我的学分 <span class="sr-only">(current)</span> </a></li>
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
                                <th data-field="xuefen">学习状态</th>
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

        </div><!--/.col-->
    </div><!-- /.row -->
</div>

<div id="bandModal"></div><!-- Modal -->

<div class="modal fade" id="myModal" tabindex="3" role="dialog" aria-labelledby="ModalLabelEditByYong">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-primary">
                    <div class="panel-heading">课程学习记录</div>
                    <div class="panel-body">
                        <table data-toggle="table" data-url="" data-row-style="rowStyle" id="xuexiTable">
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
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>

</html>
