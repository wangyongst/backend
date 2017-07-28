/**
 * Created by wangy on 2016-12-02.
 */
$(function () {

    makeModal($("#postCaijiModal"), "postCaiji", "1");
    makeModal($("#putCaijiModal"), "putCaiji", "2");

    makeModalColumns($("#postCaijiModal"), "caiji", "postCaiji", "请输入采集的老人");
    makeModalColumns($("#putCaijiModal"), "caiji", "putCaiji", "请输入采集老的人");

    makeAlert($("#postCaijiAlert"));
    makeAlert($("#putCaijiAlert"));
    makeAlert($("#mainAlert"));

    $("#postCaijiSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "jiankang/post/caiji.do?",
            data: $('#postCaijiForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postCaijiAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postCaijiModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postCaijiAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#putCaijiSave").click(
        function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "jiankang/put/caiji.do?_method=PUT",
                data: $('#putCaijiForm').serialize(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#putCaijiAlert"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#putCaijiModal').modal('toggle');
                        showAlert($("#mainAlert"), "success", result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#putCaijiAlert"), "warning", result.message);
                    }
                }
            });
        });

    function showPutCaijiModal(caiji) {       
        $('#putCaijiidInput').hide();
        $('#putCaijiidLabel').hide();
        for (var name in caiji) {
            $("#putCaiji" + name + "Input").val(caiji[name]);
        }
        $('#putCaijilaorenidInput').attr("readonly", "readonly");
        $('#putCaijilaorennameInput').attr("readonly", "readonly");
        $('#putCaijiidInput').val(caiji.id);
        $('#putCaijilaorenidInput').val(caiji.laorenid);
        $('#putCaijilaorennameInput').val(caiji.laorenname);
        $('#putCaijiModal').find('.modal-title').text('修改老人健康数据');
        $('#putCaijiModal').modal('toggle');
    }

    function showPostCaijiModal(laoren) {
        $('#postCaijiidInput').hide();
        $('#postCaijiidLabel').hide();
        $('#postCaijiModal').find("input[class=form-control]").val("");
        $('#postCaijilaorenidInput').attr("readonly", "readonly");
        $('#postCaijilaorennameInput').attr("readonly", "readonly");
        $('#postCaijilaorenidInput').val(laoren.id);
        $('#postCaijilaorennameInput').val(laoren.name);
        $('#postCaijiModal').find('.modal-title').text('采集老人健康数据');
        $('#postCaijiModal').modal('toggle');
    }


    $("#caiji").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "xitong/get/laoren/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPostCaijiModal(result.data);
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#chakan").click(
        function () {
            $.ajax({
                type: "GET",
                cache: "false",
                url: "xitong/get/laoren/" + select() + ".do",
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#mainAlert"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        window.location.href = "menu/jiankang/caiji/3/" + result.data.id + ".do";
                    } else {
                        showAlert($("#mainAlert"), "warning", result.message);
                    }
                }
            });
        });

    $("#xiugai").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "jiankang/get/caiji/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutCaijiModal(result.data);
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#shanchu").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "jiankang/delete/caiji/" + select() + ".do?_method=DELETE",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#mainAlert"), "warning", result.message);
                }
            }
        });
    });
});