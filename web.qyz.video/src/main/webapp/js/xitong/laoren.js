/**
 * Created by wangy on 2016-12-02.
 */


$(function () {
    makeModal($("#postLaorenModal"), "postLaoren", "1");
    makeModal($("#putLaorenModal"), "putLaoren", "2");
    makeModal($("#postJiashuModal"), "postJiashu", "3");

    makeModalColumns($("#postLaorenModal"), "laoren", "postLaoren", "请输入老人的");
    makeModalColumns($("#putLaorenModal"), "laoren", "putLaoren", "请输入老人的");
    makeModalColumns($("#postJiashuModal"), "jiashu", "postJiashu", "请输入老人家属的");

    makeAlert($("#postLaorenAlert"));
    makeAlert($("#putLaorenAlert"));
    makeAlert($("#postJiashuAlert"));
    makeAlert($("#mainAlert"));

    var type = 0;
    if (window.location.href.indexOf("2") != -1) {
        type = 2;
    } else if (window.location.href.indexOf("1") != -1) {
        type = 1;
    }

    $("#postLaorenSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/post/laoren.do?",
            data: $('#postLaorenForm').serialize() + "&type=" + type,
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postLaorenAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postLaorenModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postLaorenAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#putLaorenSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/put/laoren.do?_method=PUT",
            data: $('#putLaorenForm').serialize() + "&type=" + type,
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#putLaorenAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#putLaorenModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#putLaorenAlert"), "warning", result.message);
                }
            }
        });
    });

    $("#postJiashuSave").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/post/jiashu.do?",
            data: $('#postJiashuForm').serialize(),
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#postJiashuAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    $('#postJiashuModal').modal('toggle');
                    showAlert($("#mainAlert"), "success", result.message);
                    $("button[name='refresh']").click();
                } else {
                    showAlert($("#postJiashuAlert"), "warning", result.message);
                }
            }
        });
    });

    function showPostLaorenModal() {
        $('#postLaorenidInput').hide();
        $('#postLaorenidLabel').hide();
        $('#postLaorenModal').find("input[class=form-control]").val("");
        $('#postLaorenModal').find("input").prop("checked", false);
        $('#postLaorenModal').find('.modal-title').text('注册老人信息');
        $('#postLaorenModal').modal('toggle');
        $("#postLaorenAlert").hide();
    }

    function showPostJiashuModal(laoren) {
        $('#postJiashuidInput').hide();
        $('#postJiashuidLabel').hide();
        $('#postJiashuidLabel').find("input[class=form-control]").val("");
        $('#postJiashulaorenidInput').attr("readonly", "readonly");
        $('#postJiashulaorennameInput').attr("readonly", "readonly");
        $('#postJiashulaorenidInput').val(laoren.id);
        $('#postJiashulaorennameInput').val(laoren.name);
        $('#postJiashuModal').find('.modal-title').text('注册老人家属信息');
        $('#postJiashuModal').modal('toggle');
        $("#postJiashuAlert").hide();
    }


    function showPutLaorenModal(laoren) {
        for (var name in laoren) {
            $("#putLaoren" + name + "Input").val(laoren[name]);
            $("#putLaoren" + name + "Select").val(laoren[name]);
        }
        if (laoren.bingshi != null) {
            var bin = laoren.bingshi.split(",");
            for (var x in bin) {
                $("#putLaorenbingshiCheckbox input[name=bingshi]").each(function () { //遍历table里的全部checkbox
                    if ($(this).val() == bin[x]) { //如果被选中
                        $(this).prop("checked", true);
                    }
                });
            }
        }
        $('#putLaorenidInput').attr("readonly", "readonly");
        $('#putLaorenModal').find('.modal-title').text('修改老人信息');
        $('#putLaorenModal').modal('toggle');
        $("#putLaorenAlert").hide();
    }


    $("#zhuce").click(function () {
        showPostLaorenModal();
    });

    $("#jiashu").click(function () {
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
                    showPostJiashuModal(result.data);
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
            url: "xitong/get/laoren/" + select() + ".do",
            dataType: "json",
            error: function () {//请求失败时调用函数。
                showAlert($("#mainAlert"), "danger");
            },
            success: function (result) {
                if (result.status == 1) {
                    showPutLaorenModal(result.data);
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
            url: "xitong/delete/laoren/"+select()+".do?_method=DELETE",
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

    $("#toYMJ").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/put/laoren/" + select() + "/2.do?_method=PUT",
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
    $("#toOther").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/put/laoren/" + select() + "/0.do?_method=PUT",
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
    $("#toDSR").click(function () {
        $.ajax({
            type: "POST",
            cache: "false",
            url: "xitong/put/laoren/" + select() + "/1.do?_method=PUT",
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