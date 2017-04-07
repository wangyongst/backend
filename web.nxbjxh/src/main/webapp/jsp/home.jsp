<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#update").click(function () {
                document.getElementById("right").src = "jsp/update.jsp";
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
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="framework/home.do"><span>宁夏保健学会学习平台</span></a>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li role="presentation" class="divider"></li>
        <li class="active"> <a id="update" class="btn btn-primary">修改个人信息</a></li>
        <li role="presentation" class="divider"></li>
        <li class="active"> <a id="xuexi" class="btn btn-primary">在线学习</a></li>
        <li role="presentation" class="divider"></li>
    </ul>
</div>

<iframe class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" src="menu/myhome.do" width="100%" frameborder="0" scrolling="no" id="right" onload="this.height=800"></iframe>
<!--/.main-->

</body>

</html>
