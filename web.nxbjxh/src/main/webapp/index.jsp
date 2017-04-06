<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>宁夏保健学会学习平台</title>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">     
  	$(document).ready(function() {
  		window.location.href= "<%=basePath%>jsp/login.jsp";
	});
    </script>
  </head>
  <body>
  </body>
</html>
