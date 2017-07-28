<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏远程继续医学教育平台-在线学习</title>
    <style type="text/css">
        table {
            border: 1px solid #cdced0;
            border-collapse: collapse;
            margin: 20px 0 0 20px;
            word-spacing: 6px;
        }

        td {
            border: 1px solid #cdced0;
            line-height: 35px;
        }

        th img {
            vertical-align: -3px;
        }

        th span {
            font-weight: bold;
            position: static;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#update").click(function () {
                window.location.href="<%=basePath%>xuexi/update.do";
            });
            $("#start").click(function () {
                window.location.href="<%=basePath%>xuexi/courses.do";
            });
        });

    </script>

</head>

<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <p class="navbar-text">
            <h2>宁夏远程继续医学教育平台</h2></p>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav nav-pills nav-stacked" id="bs-example-navbar-collapse-1">
            <li role="presentation" class="divider"></li>
            <li><a href="xuexi/update.do">修改个人信息 </a></li>
            <li role="presentation" class="divider"></li>
            <li class="active"><a href="xuexi/home.do">在线学习</a></li>
            <li role="presentation" class="divider"></li>
            <li><a href="xuexi/xuefen.do">我的学分 </a></li>
            <li role="presentation" class="divider"></li>
            <li><a href="framework/logout.do">退出学习平台</a></li>
            <li role="presentation" class="divider"></li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid xyz">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            提示信息
                        </div>
                        <div class="panel-body">
                            <p>
                            <h5 class="text-danger">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、每年远程继续教育的学习截止时间为当年的12月31日，请您在规定的时间内学习完成，逾期未学习完成的一律不发放学分证；
                                <br>
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、学习完毕后，请及时绑定学习卡，并申请证书。学习完毕但是没有申请证书的，不能发放学分证；
                                <br>
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、为了使您的学分证能够准确及时的发放，登陆学习时，请先核对您的注册信息（注意：进入个人学习界面，请特别注意核对单位）；
                                <br>
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、学习时，请根据继教条例、各市县卫生局的规定，并结合自身学习情况，合理选择学习课程；
                                <br>
                                <br>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5、如果您在学习时有任何问题，请拨打客服中心服务热线:400-6969-296/0931-2111188
                                <br>
                                <br>
                            </h5></p>
                            <table width="96%" border="0" cellspacing="0" cellpadding="0" align="center">
                                <tr>
                                    <td width="20%">姓名：</td>
                                    <td width="30%">${user.name}</td>
                                    <td>联系方式：</td>
                                    <td>${user.phone}</td>
                                </tr>
                                <tr>
                                    <td>身份证号：</td>
                                    <td>${user.identity}</td>
                                    <td>单位名称：</td>
                                    <td>${user.unit}</td>
                                </tr>
                                <tr>
                                    <td>科室：</td>
                                    <td>${user.department}</td>
                                    <td>性别：</td>
                                    <td>${user.sex}</td>
                                </tr>
                                <tr>
                                    <td>职称：</td>
                                    <td>${user.title}</td>
                                </tr>
                            </table>

                        </div>
                        <br>
                        <div class="col-md-10">
                        </div>
                        <div class="col-md-10">
                            <div class="col-md-3 col-md-offset-3"><a id="update" class="btn btn-primary">信息有误，点击修改</a></div>
                            <div class="col-md-4"><a id="start" class="btn btn-primary">信息正确，开始学习</a></div>
                        </div>
                    </div>
                </div><!--/.col-->
            </div><!-- /.row -->
        </div>
    </div>
</div>
</body>

</html>
