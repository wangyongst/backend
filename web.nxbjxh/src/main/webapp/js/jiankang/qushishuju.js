/**
 * Created by wangy on 2016-12-02.
 */
$(function () {
    makeAlert($("#mainAlert"));

    function getIndex(column) {
        var col = $('table tr:first').find("th").length;
        for (var i = 0; i < col; i++) {
            if ($('table tr:first').find("th").eq(i).text().indexOf(column) != -1) {
                return i;
            }
        }
    }

    function getValues(column) {
        var values = [];
        $("input[name=toolbar1]").each(function () {
            if ($(this).prop('checked')) {
                var index = $("table input:checkbox").index(this);
                values.push($("table").find("tr").eq(index).find("td").eq(getIndex(column)).text() + "");
            }
        });
        return values;
    }

    function myLineChart(mychartid, mylineChartData) {
        document.getElementById(mychartid)
        var chart1 = document.getElementById(mychartid).getContext("2d");
        window.myLine = new Chart(chart1).Line(mylineChartData, {
            responsive: true
        });
    }

    function create2LineChartData(labels, datas1, datas2) {
        var mylineChartData = {
            labels: labels,
            datasets: [
                {
                    fillColor: "rgba(48, 164, 255,0.2)",
                    strokeColor: "rgba(48, 164, 255,1)",
                    pointColor: "rgba(48, 164, 255,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(48, 164, 255,1)",
                    data: datas1
                },
                {
                    fillColor: "rgba(48, 164, 255, 0.2)",
                    strokeColor: "rgba(48, 164, 255, 1)",
                    pointColor: "rgba(48, 164, 255, 1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(48, 164, 255, 1)",
                    data: datas2
                }
            ]
        };
        return mylineChartData;
    }

    function create1LineChartData(labels, datas) {
        var mylineChartData = {
            labels: labels,
            datasets: [
                {
                    fillColor: "rgba(48, 164, 255,0.2)",
                    strokeColor: "rgba(48, 164, 255,1)",
                    pointColor: "rgba(48, 164, 255,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(48, 164, 255,1)",
                    data: datas
                }
            ]
        };
        return mylineChartData;
    }

    function isSelect() {
        if (select() == "") {
            showAlert($("#mainAlert"), "warning", "请选择两条以上记录，以形成健康趋势图！");
        }
    }

    $("#xueya").click(
        function () {
            isSelect();
            $("#linechartitle").text("血压趋势图");
            myLineChart("line-chart", create2LineChartData(getValues("测量时间"), getValues("高压"), getValues("低压")));
        });

    $("#xueyang").click(
        function () {
            isSelect();
            $("#linechartitle").text("血氧趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("血氧")));
        });

    $("#tizhaong").click(
        function () {
            isSelect();
            $("#linechartitle").text("体重趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("体重")));
        });

    $("#xuetang").click(
        function () {
            isSelect();
            $("#linechartitle").text("血糖趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("血糖")));
        });

    $("#maibo").click(
        function () {
            isSelect();
            $("#linechartitle").text("脉博趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("脉博")));
        });

    $("#shenggao").click(
        function () {
            isSelect();
            $("#linechartitle").text("身高趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("身高")));
        });

    $("#bmi").click(
        function () {
            isSelect();
            $("#linechartitle").text("BMI趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("BMI")));
        });

    $("#huxi").click(
        function () {
            isSelect();
            $("#linechartitle").text("呼吸趋势图");
            myLineChart("line-chart", create1LineChartData(getValues("测量时间"), getValues("呼吸")));
        });
});