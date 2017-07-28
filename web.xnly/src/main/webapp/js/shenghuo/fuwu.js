/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeModal($("#postFuwuModal"), "postFuwu", "1");
    makeModal($("#putFuwuModal"), "putFuwu", "2");

    makeModalColumns($("#postFuwuModal"), "fuwu", "postFuwu", "请输入老人的需求或服务记录");
    makeModalColumns($("#putFuwuModal"), "fuwu", "putFuwu", "请输入老人的需求或服务记录");

    makeAlert($("#postFuwuAlert"));
    makeAlert($("#putFuwuAlert"));

    makeAlert($("#mainAlert"));
    $("#postFuwuSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "shenghuo/post/fuwu.do?",
            data: $('#postFuwuForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postFuwuAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postFuwuModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postFuwuAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#putFuwuSave").click(function () {
            $.ajax({
                type: "POST",
                cache: "false",
                url: "shenghuo/put/fuwu.do?_method=PUT",
                data: $('#putFuwuForm').serialize(),
                dataType: "json",
                error: function () {//请求失败时调用函数。
                    showAlert($("#putFuwuAlert"), "danger");
                },
                success: function (result) {
                    if (result.status == 1) {
                        $('#putFuwuModal').modal('toggle');
                        showAlert($("#mainAlert"), "success", result.message);
                        $("button[name='refresh']").click();
                    } else {
                        showAlert($("#putFuwuAlert"), "warning", result.message);
                    }
                }
            });
        });

    function showPutFuwuModal(fuwu) {
        $('#putFuwuidInput').hide();
        $('#putFuwuidLabel').hide();
        for (var name in fuwu) {
            $("#putFuwu" + name + "Input").val(fuwu[name]);
        }
        $('#putFuwulaorenidInput').attr("readonly", "readonly");
        $('#putFuwulaorennameInput').attr("readonly", "readonly");
        $('#putFuwulaorenidInput').val(fuwu.laorenid);
        $('#putFuwulaorennameInput').val(fuwu.laorenname);
        $('#putFuwuModal').find('.modal-title').text('修改老人需求或服务记录');
        $('#putFuwuModal').modal('toggle');
    }

    function showPostFuwuModal(laoren) {
        $('#postFuwuidInput').hide();
        $('#postFuwuidLabel').hide();
        $('#postFuwuModal').find("input[class=form-control]").val("");
        $('#postFuwulaorenidInput').attr("readonly", "readonly");
        $('#postFuwulaorennameInput').attr("readonly", "readonly");
        $('#postFuwulaorenidInput').val(laoren.id);
        $('#postFuwulaorennameInput').val(laoren.name);
        $('#postFuwuModal').find('.modal-title').text('添加老人需求或服务记录');
        $('#postFuwuModal').modal('toggle');
    }

    $("#fuwu").click(function () {
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
                    showPostFuwuModal(result.data);
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
            url: "shenghuo/get/fuwu/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutFuwuModal(result.data);
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
            url: "shenghuo/delete/fuwu/" + select() + ".do?_method=DELETE",
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