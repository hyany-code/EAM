<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script charset="UTF-8">
    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">课程管理</a></li>
        <li>课程列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/course/teached/listAll">
        <%--<div class="form-group">--%>
        <%--<input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字">--%>
        <%--</div>--%>
        <%--<input type="submit" class="btn btn-danger" value="查询"/>--%>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>课程编码</th>
            <th>课程名称</th>
            <th>课程类型</th>
            <th>教师名称</th>
            <th>学年</th>
            <th>学期</th>
            <th>上课时间</th>
            <th>上课地点</th>
            <th>学时</th>
            <th>学分</th>
            <th>考试类型</th>
            <th>计划人数</th>
            <th>已选人数</th>
            <c:forEach items="${info.list}" var="teachedcourse">
        <tr>
        <td>${teachedcourse.courseId}</td>
        <td>${teachedcourse.courseName}</td>
        <td>${teachedcourse.courseType}</td>
        <td>${teachedcourse.teacher.teacherName}</td>
        <td>${teachedcourse.academicYear}</td>
        <td>${teachedcourse.semester}</td>
        <td>${teachedcourse.time}</td>
        <td>${teachedcourse.place}</td>
        <td>${teachedcourse.creditHour}</td>
        <td>${teachedcourse.credit}</td>
        <td>${teachedcourse.examType}</td>
        <td>${teachedcourse.planNumber}</td>
        <td>${teachedcourse.selectedNumber}</td>
        </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/course/teached/listAll?page=1">首页</a>
                    <a href="<%=path%>/course/teached/listAll?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/course/teached/listAll?page=${num}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/course/teached/listAll?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/course/teached/listAll?page=${info.pages}">末页</a>
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