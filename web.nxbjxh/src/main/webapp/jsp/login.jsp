<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    session.setMaxInactiveInterval(-1);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <title>宁夏远程继续医学教育平台-登录</title>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {

            if($(window).height() < 780){
                $(".infos").removeClass(".infos").addClass("infos2");
            }

            function login() {
                $.ajax({
                    type: "POST",
                    cache: "false",
                    url: "framework/login.do?_method=PUT",
                    data: $('#userForm').serialize(),
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                        alert("程序异常，请联系管理员（电话：4006969296）处理，谢谢！");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href = "<%=basePath%>xuexi/home.do";
                        } else {
                            $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
                            alert(result.message);
                        }
                    }
                });
            };

            $("#login").click(function () {
                login();
            });

            document.onkeydown=function(event){
                e = event ? event :(window.event ? window.event : null);
                if(e.keyCode==13){
                    //执行的方法
                    login();
                }
            }

            $("#authImage").click(function () {
                $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
            });
        });

        function showBg() {
            var bh = $(document).height();
            var bw = $(document).width();
            $("#fullbg").css({
                height:bh,
                width:bw,
                display:"block"
            });
            $("#dialog").fadeIn(1000);
        }

        function closeBg() {
            $("#fullbg,#dialog").hide();
        }

        function reloadCode() {
            $("#authImage").attr("src", "<%=basePath%>authImage.do?time=" + new Date().getTime());
        }

    </script>

    <style type="text/css">
        *{ margin:0; padding:0;}
        body{ background:url(<%=basePath%>picture/loginBG.jpg) scroll center;}

        #fullbg{ background-color:Gray; left:0px; opacity:0.5; position:absolute; top:0px; z-index:3; filter:alpha(opacity=50); /* IE6 */ -moz-opacity:0.5; /* Mozilla */ -khtml-opacity:0.5; /* Safari */}
        #dialog{ background:#FFF; border:1px solid #888; display:none; height:500px; left:30%; margin:-50px 0 0 -50px; padding:12px; position:fixed !important; /* 浮动对话框 */ position:absolute; top:30%; width:700px; z-index:5;}
        #dialog p{margin:0 0 10px;}
        #dialog p.close {text-align:right;}
        #dialog p.close a,img{ border:0px; text-decoration:none; margin-right:5px;}

        #dialog  h2{ font: bold 20px '宋体'; color:red; text-align:center; padding-top:5px;line-height:2;}
        .content{ background:url(<%=basePath%>picture/loginLine.png) top center scroll no-repeat; max-width:1480px; overflow:hidden; margin:0 auto;}
        .infos{ width:1000px; height:400px; margin:0 auto; margin-top:13%; clear:both;}
        .infos2{ width:1000px; height:400px; margin:0 auto; margin-top:9%; clear:both;}
        .projectName img{ margin:0 0 15px 30px;}
        .infoBoard{ height:99%; background:url(<%=basePath%>picture/boardBG.jpg) center scroll; border:1px solid #FFF; border-radius:5px; overflow:hidden;}
        .bar{ width:650px; float:left;}
        .login{ width:340px; float:right;}
        .barTitle{ background:url(<%=basePath%>picture/barTitle.png) no-repeat left top scroll; height:51px; margin:30px 0 5px 0;}
        .barContent{ height:290px; width:90%; margin:0 auto; overflow:hidden; color:#FFF;}

        .barInput input{ vertical-align:-2px;}
        .loginTitle{ background:url(<%=basePath%>picture/logoTitle.png) no-repeat left top scroll; height:51px; margin:30px 0 15px 0;}
        .forms{ width:80%; margin:0 auto; font:14px "宋体"; color:#FFF; overflow:hidden; word-spacing:7px; line-height:42px; text-align:center; padding-top: 10px;}
        .forms input{ height:22px; border:1px solid #1c4e9d;}
        .forms div img{ text-align:left; border:1px solid #1c4e9d; margin-left:35px; vertical-align:-4px; margin-right:8px; margin-top:10px;}
        .forms a{ font:bold 14px "宋体"; color:#FFF;}
        .forms a:hover{ color:blue;}
        .buttonS{ word-spacing:3px; clear:both; overflow:hidden;}
        .buttonS a{ float:left; margin-left:15px; font:12px "宋体"; text-decoration:none; padding-top:12px; display:block; height:28px; width:95px; background:url(<%=basePath%>picture/logoinBtn2.png) scroll center no-repeat; text-align:center; border:0; margin-top:16px; cursor:pointer; color:#cf5300;}
        .buttonS a:hover{ background:url(<%=basePath%>picture/logoinBtn1.png) scroll center no-repeat; color:#666;}
        .forms p{ text-align:right; text-decoration:none; margin-top:8px;}
        .forms p a{text-decoration:underline; color:#000; font: bold 12px "宋体";}
        .forms p a:hover{text-decoration:underline; color:#00F;}
        .prompt{ margin:30px 10px 10px; background:#FFE9AD; border:#FAB823 1px solid; line-height:25px; padding-left:12px; color:#565656;}
    </style>

</head>

<body>
<!--通知暂时关闭  -->
<!-- jQuery 遮罩层 ->
<div id="fullbg"></div>
<!-- end jQuery 遮罩 ->

<!-- 弹出框->
<div id="dialog">

  <p class="close"><a href="javascript:void(null)" onclick="closeBg();"><img src="images/quit.jpg" width="13" height="13"  />关闭</a></p>
     <div style="background:url(images/line.jpg) repeat-x center; height:3px; margin-bottom:2px;"></div>
  <h2>温馨提示 </h2>

<br>
   <p>
  <p style="font-family:Simsun;font-size:medium;">
      各位学员：
  </p>
<br />
  <p class="MsoNormal" style="font-family:Simsun;font-size:medium;text-indent:32pt;">
      <span style="line-height:2;">2016年的远程继续医学教育项目学习已经全部结束，为方便大家巩固学习，系统仍向大家正常开放，可以正常观看视频，但无法申请学分。如有问题，欢迎来电咨询。</span><span></span>
  </p>
<br />
<span style="font-family:Simsun;font-size:16px;line-height:2;">咨询电话：4006969296&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0931-2111188</span>
</p>
<p>
  <span style="font-family:Simsun;font-size:16px;line-height:2;"><br />
</span>
</p>
<p style="text-align:right;">
  <span style="font-family:Simsun;font-size:16px;line-height:1.5;">宁夏远程继续医学教育网</span>
</p>
<p style="text-align:right;">
  <span style="font-family:Simsun;font-size:16px;line-height:1.5;">2017年1月1日</span>
</p>
<p>
  <br />
</p>
</div>
<!-- end 弹出框 -->


<form id="userForm">
    <div class="content">
        <div class="infos">
            <div class="projectName"><img src="<%=basePath%>picture/loginTitleNx.png" width="646" height="48" /></div>
            <div class="bar infoBoard">
                <div class="barTitle"></div>
                <div class="barContent">
                    <blockquote>
                        <p>
                            <span style="font-family:SimHei;color:#e53333;"><span style="font-size:18px;">&nbsp;</span><span style="font-family:SimHei;color:#e53333;font-size:18px;"><span style="line-height:24px;font-size:18px;"><span style="font-size:18px;">&nbsp;&nbsp; &nbsp; </span></span></span><span style="font-family:SimHei;color:#e53333;font-size:18px;"><span style="line-height:24px;"><span style="font-size:14px;"><span style="font-size:18px;"><span style="font-family:KaiTi_GB2312;"><span style="color:#000000;font-size:18px;">一、</span></span></span></span></span></span></span><span style="font-size:18px;line-height:2;font-family:KaiTi_GB2312;">基于系统安全方面的原因，建议使用ie8以上或者谷歌浏览器，否则会出现页面显示不完整，无法完成注册等问题。</span>
                        </p>
                    </blockquote>
                    <h2>
                        <span style="color:#FFFFFF;font-family:Simsun;font-size:medium;"><span><strong>&nbsp;</strong></span></span><span style="font-weight:normal;color:#FFFFFF;font-family:Simsun;font-size:medium;"><a href="<%=basePath%>jsp/forget.jsp" target="_blank"><u><span style="color:#E53333;"><strong>&nbsp;</strong></span></u></a></span><span style="font-weight:normal;font-size:medium;line-height:36px;"><a href="<%=basePath%>jsp/forget.jsp" target="_blank"><u><span style="color:#E53333;"><strong>找回密码</strong></span></u></a><u><span style="color:#E53333;"><strong>&nbsp;</strong></span></u></span><span style="color:#FFFFFF;font-family:Simsun;font-size:medium;font-weight:normal;line-height:1.5;"><strong>&nbsp;</strong></span>
                    </h2>
                    <h1>
                        <span style="font-family:SimHei;color:#e53333;font-size:18px;"></span>
                    </h1>
                </div>
            </div>

            <div class="login infoBoard">
                <div class="loginTitle"></div>

                <div class="forms">
                    登录名：<input placeholder="登录名是你注册身份证号" name="identity" type="text" size="30" autofocus/><br />
                    密  码：<input placeholder="你注册时填写的密码" name="password" type="password" size="30" /><br />
                    验证码：<input name="authcode" type="text" size="30" /><br />
                    <div>
                        <img id="authImage" src="<%=basePath%>authImage.do" width="104" height="22">
                        <a href="javascript:reloadCode();">换一张</a>
                    </div>
                    <div class="buttonS">
                        <a id="login"> 登 陆 </a>
                        <a id="register" href="<%=basePath%>framework/regist.do" target="_blank"> 注 册 </a>
                    </div>
                    <p><a id="forget" href="<%=basePath%>jsp/forget.jsp" target="_blank">找回密码</a></p><br/>

                </div>
            </div>
        </div>
    </div>
</form>
<div style="margin-top:100px;color:black;font-size:20px;text-align:center;">
    技术支持：甘肃七言志教育科技有限公司<br/><br/>
    客服电话：4006969296&nbsp;&nbsp;0931-2111188&nbsp;&nbsp;QQ：2715528741&nbsp;&nbsp;QQ群：68638150<br/><br/>
    备案信息：陇ICP备14000281号-3
</div>
</body>
</html>
