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
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script>

    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="/view/teacher/news/news_list.jsp">新闻查看</a></li>
        <li>新闻列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/news/teacher/search">
        <div class="form-group">
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <ul class="list-group">
        <c:forEach items="${info.list}" var="news">
            <li class="list-group-item">
                <span style="padding-left: 15px;">${news.newsType}</span>
                <a href="<%=path%>/news/teacher/getOne?newsId=${news.newsId}" class="list-group-item-heading" style="padding-left: 30px;">${news.newsName}</a>
                <span class="badge"><fmt:formatDate value="${news.updateTime}" pattern="yyyy-MM-dd HH:mm"/></span>
            </li>
        </c:forEach>
    </ul>
    <table class="table  table-condensed table-striped">
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/news/teacher/listAll?page=1">首页</a>
                    <a href="<%=path%>/news/teacher/listAll?page=${info.prePage}">上一页</a>
                </c:if>
                <c:if test="${info.pageNum==1}">
                    首页
                    上一页
                </c:if>
                <c:forEach items="${info.navigatepageNums}" var="num">
                    <c:if test="${num == info.pageNum}">
                        【${num}】
                    </c:if>
                    <c:if test="${num != info.pageNum}">
                        <a href="<%=path%>/news/teacher/listAll?page=${num}&key=${key}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/news/teacher/listAll?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/news/teacher/listAll?page=${info.pages}">末页</a>
                </c:if>
                <c:if test="${info.pageNum==info.pages}">
                    下一页
                    末页
                </c:if>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
