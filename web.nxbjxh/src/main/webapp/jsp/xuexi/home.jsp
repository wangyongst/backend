<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
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
                    <div class="row">
                        <div class="col-md-1 pull-left">
                            <a>
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-8 media-body pull-left">
                            <h4 class="media-heading">警戒素与人体免疫相关研究</h4>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                            fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                    </div>
                </div>
                <div class="media">
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1 pull-left">
                            <a href="#">
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-7 media-body pull-left">
                            <h4 class="media-heading"><a href="#">警戒素与人体免疫相关研究</a></h4>
                            <a href="#">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                            fringilla. Donec lacinia congue felis in faucibus.</a>
                        </div>
                    </div>
                </div>
                <div class="media">
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1 pull-left">
                            <a href="#">
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-7 media-body pull-left">
                            <h4 class="media-heading"><a>警戒素与人体免疫相关研究</a></h4>
                            <a>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                                fringilla. Donec lacinia congue felis in faucibus.</a>
                        </div>
                    </div>
                </div>
                <div class="media">
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1 pull-left">
                            <a href="#">
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-7 media-body pull-left">
                            <h4 class="media-heading"><a>警戒素与人体免疫相关研究</a></h4>
                            <a>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                                fringilla. Donec lacinia congue felis in faucibus.</a>
                        </div>
                    </div>
                </div>
                <div class="media">
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1 pull-left">
                            <a href="#">
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-7 media-body pull-left">
                            <h4 class="media-heading"><a>警戒素与人体免疫相关研究</a></h4>
                            <a>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                                fringilla. Donec lacinia congue felis in faucibus.</a>
                        </div>
                    </div>
                </div>
                <div class="media">
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1 pull-left">
                            <a href="#">
                                <img class="media-object" src="picture/default.png" alt="警戒素与人体免疫相关研究">
                            </a>
                        </div>
                        <div class="col-md-7 media-body pull-left">
                            <h4 class="media-heading"><a>警戒素与人体免疫相关研究</a></h4>
                            <a>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate
                                fringilla. Donec lacinia congue felis in faucibus.</a>
                        </div>
                    </div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href=".">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">4</a></li>
                            <li><a href="">5</a></li>
                            <li>
                                <a href="" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div><!--/.col-->


</div><!-- /.row -->
</body>

</html>
