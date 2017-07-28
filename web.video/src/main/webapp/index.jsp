<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>爱品优购VIP会员视频观看系统</title>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            window.location.href = "<%=basePath%>home.do";
        });
    </script>
</head>
<body>
</body>
</html>
