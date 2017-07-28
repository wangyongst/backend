<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>

    <script type="text/javascript">

        $(function () {

            makeModal($("#kaishiModal"), "kaishi", "1");
            makeModal($("#bangzhuModal"), "bangzhu", "1");

            makeAlert($("#kaishiAlert"));
            $("#kaishiAlert").hide();

            $('#kaishiSave').text("开始");
            $('#bangzhuSave').text("知道了");

            $('#kaishiModal').find('.modal-title').text('各大视频网站VIP视频免费看，从这里开始！');
            $('#kaishiModal').find('.form-group').append("<label>视频地址(请先从视频网站复制浏览器器地址，粘贴在下面)</label>");
            $('#kaishiModal').find('.form-group').append("<input class='form-control' id='url' name='url' placeholder='如：http://www.iqiyi.com/v_19rra0fgdw.html?fc=8b62d5327a54411b#vfrm=19-9-0-1'>");
            $('#kaishiModal').find('.form-group').append("<label>观看线路(不同的线路视频质量不同，如不能观看或观看不佳，请切换线路)</label>");
            $('#kaishiModal').find('.form-group').append("<select class='form-control' id='platformid' name='platformid'></select >");
            $('#kaishiModal').find('.form-group').append("<label>观看密码(因资源紧张，需密码观看)</label>");
            $('#kaishiModal').find('.form-group').append("<input type='password' class='form-control' id='password' name='password' placeholder='请联系331527770@qq.com获取密码'>");

            $('#bangzhuModal').find('.modal-title').text('各大视频网站VIP视频免费看，从这里开始！');
            $('#bangzhuModal').find('.form-group').append("<label>1.为什么能免费看会员视频?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >本网站不是直接存储视频的网站，本网站只是通过技术手段共享各大网站的VIP会员,在本网站你可以免费去广告观看所有国内各大视频网站上的会员视频（包括电视剧、电影等），如你认为本网站对你非常有用，谢致信e-mail:331527770@qq.com!</text>");
            $('#bangzhuModal').find('.form-group').append("<label>2.怎么使用这个网站的免费看视频功能?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >在你登陆这个视频系统以后，你可以观看到一部免费播放的会员视频，这个视频是由系统推荐的。这时你可以点击“开始使用”按钮，填上对应的内容后点“开始”就可以切换成你想要看的视频！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>3.什么是视频地址?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >视频地址是指你在各大视频网站点开会员视频后你的浏览器显示的地址.以爱奇艺视频为例：当你在爱奇艺网站中点开会员视频6分钟免费观看时，你的浏览器地址栏会显示一串地址，比如像这样（http://www.iqiyi.com/v_19rr96agog.html?fc=8b62d5327a54411b#vfrm=19-9-0-1），你在爱奇艺上可以观看会员视频6分钟，6分钟以后你观看的视频就会停止。这个地址就是我们所说的视频地址！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>4.什么是观看线路?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >因各大视频网站也在通过技术手段打击本网站采用的会员共享技术，所以本网站建设了不同的网络观看线路供大家使用，观看线路会根据视频网站打击情况不定期调整！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>5.不同的观看线路有什么区别?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >不同的观看线路对不同的视频网站有不同的观看效果，比如线路一观看爱奇艺视频非常流畅，但在观看优酷视频时可能会卡顿，甚至完全不能播放！再比如昨天用线路一看爱奇艺很流畅，今天可能会看不了！这都是因为视频网站通过技术手段打击的结果！如果你选择的视频不能观看、清晰度太低或经常卡顿，那请你切换线路试试！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>6.怎么切换观看线路?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >点击“开始使用”按钮，重新选择观看线路即可，系统会自动切换观看线路，并从头开始播放视频，这种情况你可以拖动控制条快进到你想看的位置！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>7.为什么播放器要很久才会放出视频出来?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >受网络的影响，你在点击了“开始”按钮以后，系统会初始化加载视频及播放器，这个过种会在20秒钟左右，之后播放器会自动播放视频，请不要着急，耐心等几秒吧！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>8.为什么不能选择清晰度?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >本系统会根据你的网络情况，自动采用适合的清晰度播放视频！同时，视频清晰度也会受到不同观看线路的影响，如对清晰度不满意，切换观看线路试试吧！</text>");
            $('#bangzhuModal').find('.form-group').append("<label>9.怎么全屏观看?</label>");
            $('#bangzhuModal').find('.form-group').append("<text class='chat-body clearfix' >本系统采用HTML5播放技术，在不同的浏览器上会播放器操作起来会不一样，一般在视频右下角有全屏按钮，如果找不到你可以右键视频点全屏播放！</text>");
            $.ajax({
                type: "GET",
                cache: "true",
                url: "listPlatform.do",
                dataType: "json",
                success: function (result) {
                    if (result.status == 7) {
                        result.data.forEach(function (e) {
                            $("#platformid").append("<option value='" + e.id + "'>" + e.name + "</option>");
                        })
                    } else {
                        showAlert($("#kaishiAlert"), "warning", result.message);
                    }
                }
            });


            $("#kaishi").click(function () {
                $('#kaishiModal').modal('toggle');
            });

            $("#bangzhu").click(function () {
                $('#bangzhuModal').modal('toggle');
            });

            $("#bangzhuSave").click(function () {
                $('#bangzhuModal').modal('toggle');
            });

            $("#kaishiSave").click(function () {
                $.ajax({
                    type: "GET",
                    cache: "false",
                    url: "video/" + $("#platformid").val() + "/" + $("#password").val() + ".do",
                    data: {url: $("#url").val()},
                    dataType: "json",
                    error: function () {//请求失败时调用函数。
                        showAlert($("#kaishiAlert"), "danger");
                    },
                    success: function (result) {
                        if (result.status == 1) {
                            $('#kaishiModal').modal('toggle');
                            $("#videoIfame").prop("src", result.data);
                        } else {
                            showAlert($("#kaishiAlert"), "warning", result.message);
                        }
                    }
                });
            });
        });


        function iFrameHeight() {
            var ifm = document.getElementById("videoIfame");
            ifm.height = ifm.clientWidth / 16 * 9;
        }

    </script>
</head>

<body>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12">
                        <button type="button" class="btn btn-primary" id="kaishi">开始使用</button>
                        <button type="button" class="btn btn-primary" id="bangzhu">使用帮助</button>
                    </div>
                </div>
            </div>
        </div><!-- /.col-->
    </div>

    <div class="row">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12">
                        <iframe src="${homevideo}"
                                width="100%" frameborder="0" scrolling="no" onload="iFrameHeight()"
                                id="videoIfame"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.row -->

<div id="kaishiModal"></div>

<div id="bangzhuModal"></div>

</div><!--/.main-->
</body>
</html>
