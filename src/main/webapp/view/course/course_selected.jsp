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
        <%--if (!${msg}){--%>
        <%--    alert(${msg})--%>
        <%--}--%>
    </script>
<%--    <script type="text/javascript">--%>
<%--        var msg="${requestScope.msg}";--%>
<%--        if(msg=="OK"){--%>
<%--            alert('添加成功');--%>
<%--        }else if(msg=="ERR"){--%>
<%--            alert('添加失败');--%>
<%--        }--%>

<%--    </script>--%>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">课程管理</a></li>
        <li>课程列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/course/selected/listAll">
        <%--<div class="form-group">--%>
            <%--<input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字">--%>
        <%--</div>--%>
        <%--<input type="submit" class="btn btn-danger" value="查询"/>--%>
    </form>
</div>
<c:if test="${msg != ''}">
    <div>${msg}</div>
    <%
        session.removeAttribute("msg");
    %>
</c:if>

<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>选课编码</th>
            <th>课程名称</th>
            <th>学生名称</th>
            <th>学分</th>
            <th>绩点</th>
            <th>授课老师</th>
            <th>操作</th>
            <c:forEach items="${info.list}" var="selectedcourse">
        <tr>
            <td>${selectedcourse.selectedcourse.optionId}</td>
            <td>${selectedcourse.courseName}</td>
            <td>${selectedcourse.student.studentName}</td>
            <td>${selectedcourse.selectedcourse.score}</td>
            <td>${selectedcourse.selectedcourse.gpa}</td>
            <td>${selectedcourse.teacher.teacherName}</td>
            <td>
                <a href="<%=path%>/course/selected/Delete?courseId=${selectedcourse.courseId}" onclick="javascript:alert('已退课')">
                    <span>退选</span>
                </a>
            </td>
        </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/course/selected/listAll?page=1">首页</a>
                    <a href="<%=path%>/course/selected/listAll?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/course/selected/listAll?page=${num}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/course/selected/listAll?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/course/selected/listAll?page=${info.pages}">末页</a>
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