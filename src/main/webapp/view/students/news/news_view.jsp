<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script>

    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="news_list.jsp">新闻查看</a></li>
        <li>新闻详情</li>
    </ul>
</div>
<div class="container" style="min-height:600px !important;">
    <div class="row alert alert-info">
        <h3 class="text-center">${news.newsName}</h3>
        <h5 class="text-center news_title1">
            <span>发布人:${news.adminName}</span>
            <span>发布时间:<fmt:formatDate value="${news.updateTime}" pattern="yyyy-MM-dd HH:mm"/></span>
        </h5>
    </div>

    <div class="news_con" style="padding:15px; padding-top:0px;">
    <p style="margin-top: 0px;margin-bottom: 0px;padding: 0px;front-size:40px;
    white-space:normal;text-indent:43px;line-height: 37px;background: white;">
        ${news.newsDetails}
    </p>
    </div>
</div>
</body>
</html>
