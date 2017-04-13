<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <title>宁夏保健学会学习平台-在线学习</title>
    <script type="text/javascript">
        $(function () {
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
                                <img class="media-object" src="${currentCourse.picture}" alt="${currentCourse.name}">
                            </a>
                        </div>
                        <div class="col-md-8 media-body pull-left">
                            <h4 class="media-heading">${currentCourse.name}</h4>
                            ${currentCourse.introduce}
                        </div>
                    </div>
                </div>
                <c:forEach items="${lessons}" var="lesson">
                    <div class="media">
                        <div class="row">
                            <div class="col-md-1 col-md-offset-1 pull-left">
                                <a href="xuexi/lesson.do?id=${lesson.id}">
                                    <img class="media-object" src="${lesson.picture}" alt="${lesson.name}">
                                </a>
                            </div>
                            <div class="col-md-7 media-body pull-left">
                                <h4 class="media-heading"><a href="xuexi/lesson.do?id=${lesson.id}">${lesson.name}</a></h4>
                                <a href="xuexi/lesson.do?id=${lesson.id}">${lesson.introduce}.</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
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
    </div><!--/.col-->


</div><!-- /.row -->
</body>

</html>
