<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%--    <meta http-equiv="Content-Type" content="application/json; charset=utf-8" />--%>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
<%--    <script>--%>
<%--        $("#exportActivityAllBtn").click(function () {--%>
<%--            window.location.href="<%=path%>/teacher/export?courseId=${selectedCourse.courseId}";--%>
<%--        });--%>
<%--    </script>--%>
<%--    <script>--%>
<%--        //导出Excel形式--%>
<%--        function exportExcel(){--%>
<%--            window.location.href=rootPath + "<%=path%>/teacher/export?courseId=${selectedCourse.courseId}";--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<c:if test="${msg != ''}">
    <div>${msg}</div>
    <%
        session.removeAttribute("msg");
    %>
</c:if>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="<%=path%>/teacher/queryStudentInfoByKey">查询学生信息</a></li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/teacher/queryStudentInfoByKey">
        <div class="form-group">
            <label class="col-sm-3 control-label">课程代码：</label>
            <input type="text" name="courseId" class="form-control" id="courseId" placeholder="请输入关键字" value="${param.courseId}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">课程名称：</label>
            <input type="text" name="courseName" class="form-control" id="courseName" placeholder="请输入关键字" value="${param.courseName}">
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-danger" value="查询"/>
            <a href="<%=path%>/teacher/queryStudentInfoList?teacherId=${currentTeacher.teacherId}">
                <input type="button" class="btn btn-danger" value="清空条件" id="clearButton"  />
            </a>
        </div>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>课程号</th>
            <th>课程名称</th>
            <th>人数</th>
            <th>详情</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${info.list}" var="selectedCourse">
            <tr>
                    <%--            <td><input id="1" type="checkbox" value="2" name="allSelect"></td>--%>
                <td>${selectedCourse.courseId}</td>
                <td>${selectedCourse.courseName}</td>
                <td>${selectedCourse.selectedNumber}</td>
                <td>
                    <!--//  跳转到学生信息详情页面-->
                    <a href="<%=path%>/teacher/getStudentInfoDetails?courseId=${selectedCourse.courseId}&courseName=${selectedCourse.courseName}">
                        查看详情
                    </a>
                </td>
                <td>
                    <a href="<%=path%>/teacher/export?courseId=${selectedCourse.courseId}&courseName=${selectedCourse.courseName}">导出</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table class="table  table-condensed table-striped">
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/teacher/queryStudentInfoByKey?page=1">首页</a>
                    <a href="<%=path%>/teacher/queryStudentInfoByKeyy?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/teacher/queryStudentInfoByKey?page=${num}&key=${key}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/teacher/queryStudentInfoByKey?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/teacher/queryStudentInfoByKey?page=${info.pages}">末页</a>
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
