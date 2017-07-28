/**
 * Created by wangy on 2016-12-02.
 */
$(function () {

    makeModal($("#putJiashuModal"), "putJiashu", "1");

    makeModalColumns($("#putJiashuModal"), "jiashu", "putJiashu", "请输入老人家属的");

    makeAlert($("#putJiashuAlert"));
    makeAlert($("#mainAlert"));

    $("#putJiashuSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/put/jiashu.do?_method=PUT",
            data: $('#putJiashuForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#putJiashuAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#putJiashuModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#putJiashuAlert"), "warning", result.message);
                }
            }
        });
    });


    function showPutJiashuModal(jiashu) {
        for (var name in jiashu) {
            $("#putJiashu" + name + "Input").val(jiashu[name]);
            $("#putJiashu" + name + "Select").val(jiashu[name]);
        }
        $('#putJiashuidInput').attr("readonly", "readonly");
        $('#putJiashulaorenidInput').attr("readonly", "readonly");
        $('#putJiashulaorennameInput').attr("readonly", "readonly");
        $('#putJiashuModal').find('.modal-title').text('修改老人家属信息');
        $('#putJiashuModal').modal('toggle');
        $("#putJiashuAlert").hide();
    }


    $("#xiugai").click(function () {
        $.ajax({
            type: "GET",
            cache: "false",
            url: "xitong/get/jiashu/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutJiashuModal(result.data);
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
            url: "xitong/delete/jiashu/" + select() + ".do?_method=DELETE",
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