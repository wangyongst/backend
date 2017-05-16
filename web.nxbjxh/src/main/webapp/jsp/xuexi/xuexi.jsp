<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script src="jwplayer/jwplayer.js"></script>
    <script src="jwplayer/jwplayer.loader.swf"></script>
    <!--这是KEY-->
    <script>jwplayer.key = "K1FkbLwx4yev30aJnbBUge9Yz8CQ25BWxo5a9Q==";</script>
    <title>宁夏保健学会学习平台-在线学习</title>
    <script type="text/javascript">

        $(function () {

            $("#isover").val(0);

            makeModal($("#jiangyiModal"), "jiangyi", "1");

            makeModal($("#testModal"), "test", "2");

            makeModal($("#bandModal"), "band", "3");

            makeAlert($("#testAlert"));

            makeAlert($("#bandAlert"));

            $("#jiangyi").click(function () {
                $('#jiangyiModal').find('.modal-title').text('课程讲义');
                $('#jiangyiModal').attr("class","modal fade bs-example-modal-lg");
                $('#jiangyiModal').children().attr("class","modal-dialog modal-lg");
                $('#jiangyiModal').find('.modal-body').children().remove();
                $('#jiangyiModal').find('.modal-body').append('<embed src="${currentLesson.pdf}" width="100%" height="600px"> </embed> ');
                $('#jiangyiSave').remove();
                $('#jiangyiModal').modal('toggle');
            });

            function makeTest(value) {
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "xuexi/get/test.do",
                    data: {id:"${currentLesson.id}",test:value.id},
                    sync:false,
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#testAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 7) {
                            $.each(result.data, function (i, val) {
                                if (value.multi == 0) {
                                    $("#idtest" + value.id).append("<label class='col-md-3'><input type='radio' name='yes+"+value.id+"' value='" + val.id + "'>" + val.name + "</label>");
                                } else {
                                    $("#idtest" + value.id).append("<label class='col-md-3'><input type='checkbox' name='yes+"+value.id+"' value='" + val.id + "'>" + val.name + "</label>");
                                }
                            });
                        } else if (result.status == 1) {
                            if (value.multi == 0) {
                                $("#idtest" + value.id).append("<label class='col-md-3'><input type='radio' name='yes+"+value.id+"' value='" + result.data.id + "'>" + result.data.name + "</label>");
                            } else {
                                $("#idtest" + value.id).append("<label class='col-md-3'><input type='checkbox' name='yes+"+value.id+"' value='" + result.data.id + "'>" + result.data.name + "</label>");
                            }
                        } else {
                            showAlert($("#testAlert"), "warning", result.message);
                        }
                    }
                });
            }

            function test() {
                $('#testForm').empty();
                $('#testSave').text('交卷');
                $("#testAlert").hide();
                $('#testSave').show();
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "xuexi/get/test.do",
                    data: {id:"${currentLesson.id}",test:0},
                    sync:false,
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#testAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 7) {
                            $.each(result.data, function (key, value) {
                                if(value.multi == 0){
                                    $('#testForm').append("<div class='form-group'><label>" + value.ord + "." + value.name + "</label><div class='radio' id='idtest"+value.id+"'></div></div>");
                                }else{
                                    $('#testForm').append("<div class='form-group'><label>" + value.ord + "." + value.name + "</label><div class='checkbox' id='idtest"+value.id+"'></div></div>");
                                }
                                makeTest(value);
                            });
                        }else if(result.status == 1 ){
                            if(result.data.multi == 0){
                                $('#testForm').append("<div class='form-group'><label>" + result.data.ord + "." + result.data.name + "</label><div class='radio' id='idtest"+result.data.id+"'></div></div>");
                            }else{
                                $('#testForm').append("<div class='form-group'><label>" + result.data.ord + "." + result.data.name + "</label><div class='checkbox' id='idtest"+result.data.id+"'></div></div>");
                            }
                            makeTest(result.data);
                        } else {
                            showAlert($("#testAlert"), "warning", result.message);
                        }
                    }
                });
            }

            $("#test").click(function () {
                $('#testModal').find('.modal-title').text('在线考试');
                $('#testModal').attr("class","modal fade bs-example-modal-lg");
                $('#testModal').children().attr("class","modal-dialog modal-lg");
                if($("#isover").val() != 1){
                    $('#testSave').hide();
                    $("#testAlert").hide();
                    $('#testForm').empty();
                    $('#testForm').append("请先观看完视频课程再进行考试！");
                    $('#testModal').modal('toggle');
                    return;
                }
                test();
                $('#testModal').modal('toggle');
            });

            $("#testSave").click(function () {
                if($("#testSave").text() == "重新考试"){
                    test();
                    return;
                }
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "xuexi/post/test.do",
                    data: {id:"${currentLesson.id}",yes:$('#testForm').serialize().replace(/yes%2B/g,"").replace(/&/g,",")},
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#testAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            showAlert($("#testAlert"), "success", result.message);
                        }else if(result.status == 9){
                            $('#testForm').empty();
                            $('#testForm').append(result.message);
                            $.each(result.data, function (i, value) {
                                $('#testForm').append("<br><br>"+value.ord+"."+value.name);
                                $('#testSave').text("重新考试");
                                $("#testAlert").hide();
                            });
                        }else if(result.status == 10){
                            $('#testModal').modal('toggle');
                            $('#bandModal').find('.modal-title').text('申请学分');
                            $('#bandModal').attr("class","modal fade bs-example-modal-lg");
                            $('#bandModal').children().attr("class","modal-dialog modal-lg");
                            $('#bandForm').append("恭喜你已经完成本课程所有课件学习，你已经获得本课程学分，你可以绑定你的学习卡领取学分证书！<br>");
                            $('#bandForm').append("请输入你的学习卡和密码，并点击申请学习！<br><br>");
                            $('#bandForm').append("<label>学习卡号：</label><input class='form-control' type='text' name='number' placeholder='请填写你购买的学习卡卡号' autofocus>");
                            $('#bandForm').append("<label>学习卡密码：</label><input class='form-control' type='password' name='password' placeholder='请填写你购买的学习卡密码'>")
                            $('#bandSave').text('申请学分');
                            $("#bandAlert").hide();
                            $('#bandSave').show();
                            $('#bandModal').modal('toggle');
                        }
                        else {
                            showAlert($("#testAlert"), "warning", result.message);
                        }
                    }
                });
            });

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
            <a class="navbar-brand" href="framework/home.do">宁夏保健学会学习平台</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="xuexi/update.do">修改个人信息 </a></li>
                <li class="active"><a href="xuexi/home.do">在线学习<span class="sr-only">(current)</span></a></li>
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
        <div class="panel panel-primary" id="xuexiPanel">
            <div class="panel-heading">在线学习--${currentLesson.name}</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-7 media">
                        <div id='myplayer' class="col-md-12"></div>
                        <script type='text/javascript'>
                            jwplayer('myplayer').setup({
                                file: '${currentLesson.url}',
                                width: '100%',
                                height: '480',
                                autostart:true,
                                image: '${currentLesson.picture}',
                                events : {
                                    onComplete : function () {
                                       $("#isover").val(1);
                                    }
                                }
                            });
                        </script>
                    </div>
                    <div class="col-md-5 panel panel-success">
                        <div class="panel-heading">课件介绍</div>
                        <div class="panel-body">
                            <span>主讲人:</span>${currentLesson.teacher}
                            <br>
                            <br>
                            <span>课件介绍:</span>${currentLesson.introduce}
                        </div>
                    </div>
                    <div class="row">
                        <input id="isover" value="0" hidden>
                    <div class="btn-group col-md-1 col-md-offset-0" role="group">
                        <button id="jiangyi" type="button" class="btn btn-success">课程讲义</button>
                    </div>
                    <div class="btn-group col-md-1 col-md-offset-0" role="group">
                        <button id="test" type="button" class="btn btn-success">在线考试</button>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!--/.col-->
</div><!-- /.row -->
</div>
<div id="jiangyiModal"></div><!-- Modal -->
<div id="testModal"></div><!-- Modal -->
<div id="bandModal"></div><!-- Modal -->
</body>

</html>
