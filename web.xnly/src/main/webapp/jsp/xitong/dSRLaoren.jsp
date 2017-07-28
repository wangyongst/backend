<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/jsp/base.jsp" %>
    <script src="js/xitong/laoren.js"></script>
</head>

<body style="padding-top:0px">

<div class="row">
    <ol class="breadcrumb">
        <li><a href="${home}"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active">${title}</li>
    </ol>
</div><!--/.row-->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">${tableName}</div>
            <div class="panel-body">

                <div id="mainAlert" hidden></div>

                <button type="button" class="btn btn-primary" id="zhuce">注册老人信息</button>
                <button type="button" class="btn btn-primary" id="xiugai">修改老人信息</button>
                <button type="button" class="btn btn-primary" id="shanchu">删除老人信息</button>
                <button type="button" class="btn btn-primary" id="jiashu">添加老人家属</button>
                <button type="button" class="btn btn-primary" id="toYMJ">移入饮马街老人组</button>
                <button type="button" class="btn btn-primary" id="toOther">移入普通老人组</button>

                <table data-toggle="table" data-url="xitong/list/laorens.do?type=1" data-show-refresh="true"
                       data-show-toggle="true" data-show-columns="true" data-search="true"
                       data-select-item-name="toolbar1" data-pagination="true" data-sort-name="id"
                       data-sort-order="desc">
                    <thead>
                    <tr>
                        <th data-field="state" data-checkbox="true"></th>
                        <c:forEach var="item" items="${tableColumns}">
                            <th data-field="${item.columnname}" data-sortable="true">${item.chinese}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>

    </div>

</div><!--/.row-->

<!-- Modal -->
<div id="postLaorenModal"></div><!-- Modal -->
<div id="putLaorenModal"></div><!-- Modal -->
<div id="postJiashuModal"></div><!-- Modal -->

</body>

</html>
