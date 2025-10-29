<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
//    String teacherId = session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>个人信息</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <style type="text/css">
        .ui-jqgrid tr.jqgrow td {
            white-space: normal;
            vertical-align: top;
        }
    </style>
</head>
<body>
<div style="width: 100%;" id="bodyContainer">
    <div class="container container-func sl_all_bg" id="yhgnPage">
        <div id="innerContainer">
            <!-- 放置页面显示内容 -->
            <form id="ajaxForm" name="ajaxForm" method="post" class="form-horizontal ">

                <div class="panel " style="margin-bottom:0px;">
                    <div class="panel-heading"  style="padding: 0px;">
                        <div class="row" style="margin-bottom: 0px;">
                            <div class="col-md-4 col-sm-6">
                                <div class="form-group sl_bmsz_tb1_h1">
                                    <label class="col-sm-4 control-label">学号：</label>
                                    <div class="col-sm-8">
                                        <p class="form-control-static">${currentStudent.studentId}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="form-group sl_bmsz_tb1_h1">
                                    <label class="col-sm-4 control-label">姓名：</label>
                                    <div class="col-sm-8">
                                        <p class="form-control-static">${currentStudent.studentName}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body" style="padding: 10px 0px 0px; ">

                        <div id="func_fields"><div class="row ">
                            <!--Tab 导航栏 -->
                            <div class="col-md-12 col-sm-12">
                                <ul class='nav nav-tabs' role='tablist' id='tab_xsxxgl' style="margin-bottom: 10px;padding-left:15px;">
                                    <li class="active" >
                                        <a href="#content_xsxxgl_xsjbxx" data-flszid="xsxxgl_xsjbxx" role='tab' data-toggle='tab'> 基本信息 </a>
                                    </li>
                                </ul>
                                <!-- Tab 内容面板 -->
                                <div class="tab-content ">
                                    <div id="content_xsxxgl_xsjbxx"  class="tab-pane fade in active"  >
                                        <div class="row">
                                            <div class="col-md-8 col-sm-8">
                                                <div class="row">
                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="form-group" >
                                                            <label class="col-sm-4 control-label">
                                                                学号：
                                                            </label>
                                                            <div class="col-sm-8" id="col_xh">
                                                                <p class="form-control-static">${currentStudent.studentId}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="form-group" >
                                                            <label class="col-sm-4 control-label">
                                                                姓名：
                                                            </label>
                                                            <div class="col-sm-8" id="col_xm">

                                                                <p class="form-control-static">${currentStudent.studentName}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="form-group" >
                                                            <label class="col-sm-4 control-label">
                                                                院系名称：
                                                            </label>
                                                            <div class="col-sm-8" id="col_xmpy">
                                                                <p class="form-control-static" >
                                                                    ${student[0].departmentName}
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="form-group" >
                                                            <label class="col-sm-4 control-label">
                                                                专业名称：
                                                            </label>
                                                            <div class="col-sm-8" id="col_xbm">
                                                                <p class="form-control-static" name="majorName">
                                                                    ${student[0].majorName}
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6 col-sm-6">
                                                        <div class="form-group" >
                                                            <label class="col-sm-4 control-label">
                                                                班级名称：
                                                            </label>
                                                            <div class="col-sm-8" id="col_xbma">
                                                                <p class="form-control-static" >
                                                                    ${student[0].className}
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>