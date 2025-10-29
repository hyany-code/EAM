<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style=" margin:0px;" >
        <li ><a href="#">首页</a></li>
        <li>工作台</li>
    </ul>
</div>

<div class="row " style="padding:1px; margin-top:5px;"  >
    <div class="col-sm-8">
        <div class="panel panel-default" >
            <div class="panel-heading" style=" padding:3px;height:30px;"  >
                <span class="glyphicon glyphicon-refresh"></span>新闻中心
            </div>
            <div class="panel-body">
                <img src="img/01.jpg" width="100%" />
            </div>
        </div>
    </div>




    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading"  style=" padding:3px;height:30px;"  >
                <span class="glyphicon glyphicon-refresh"></span>公告
            </div>
            <div class="panel-body">公告</div>
        </div>
    </div>
</div>



</body>
</html>
