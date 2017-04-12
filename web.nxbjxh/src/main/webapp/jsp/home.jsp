<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#update").click(function () {
                $("#update").parent().attr("class","active");
                $("#xuexi").parent().attr("class","")
                getRight("jsp/update.jsp");
            });

            $("#logout").click(function () {
                window.location.href="<%=basePath%>framework/logout.do"
            });

            $("#xuexi").click(function () {
                $("#xuexi").parent().attr("class","active");
                $("#update").parent().attr("class","")
                getRight("xuexi/home.do");
            });
        });

        function reinitIframe() {
            var iframe = document.getElementById("right");
            try {
                var bHeight = iframe.contentWindow.document.body.scrollHeight;
                var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                var height = Math.max(bHeight, dHeight);
                iframe.height = height;
            } catch (ex) {
            }
        }

        window.setInterval("reinitIframe()", 200);

        function getRight(url) {
            document.getElementById("right").src = url;
        }


    </script>

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">点击展开菜单</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="framework/home.do"><span>宁夏保健学会学习平台</span></a>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-md-2 sidebar">
    <ul class="nav menu">
        <li role="presentation" class="divider"></li>
        <li><a id="update"><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;修改个人信息</a></li>

        <li class="active"><a id="xuexi"><span class="glyphicon glyphicon-folder-open" ></span>&nbsp;&nbsp;在线学习</a></li>
        <li role="presentation" class="divider"></li>
        <li><a id="logout"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出学习平台</a></li>
        <li role="presentation" class="divider"></li>
    </ul>
</div>

<div class="embed-responsive embed-responsive-4by3">
    <iframe class="col-md-9 col-md-offset-2 embed-responsive-item" src="${right}" id="right"></iframe>
</div>
<!--/.main-->

</body>

</html>
