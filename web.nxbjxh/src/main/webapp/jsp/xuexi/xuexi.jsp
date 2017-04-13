<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script src="jwplayer/jwplayer.js"></script>
    <script src="jwplayer/jwplayer.loader.swf"></script>
    <!--这是KEY-->
    <script>jwplayer.key="K1FkbLwx4yev30aJnbBUge9Yz8CQ25BWxo5a9Q==";</script>
    <title>宁夏保健学会学习平台-在线学习</title>
    <script type="text/javascript">

        $(function () {

            makeAlert($("#alertA"));

            $("#login").click(function () {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "framework/login.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#alertA"), "danger");
                        $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href = "<%=basePath%>framework/home.do";
                        } else {
                            showAlert($("#alertA"), "warning", result.message);
                            $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
                        }
                    }
                });
            })

            $("#register").click(function () {
               window.open("<%=basePath%>jsp/register.jsp");
            })

            $("#forget").click(function () {
                window.open("<%=basePath%>jsp/forget.jsp");
            })

            $("#authImage").click(function () {
                $("#authImage").attr("src","<%=basePath%>authImage.do?time="+new Date().getTime());
            })

        });

    </script>

</head>

<body>

<div class="row">
    <div class="col-md-8 col-md-offset-1">
        <div class="panel panel-primary">
            <div class="panel-heading">在线学习</div>
            <div class="panel-body">
                <div class="media">
                    <div id='myplayer'></div>
                    <script type='text/javascript'>
                        jwplayer('myplayer').setup({
                            file: 'http://localhost:81/1.mp4',
                            width: '640',
                            height: '480'});
                    </script>
                </div>
            </div>
        </div>


    </div><!--/.col-->


</div><!-- /.row -->
</body>

</html>
