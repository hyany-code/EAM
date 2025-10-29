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
    <script>
        //导出Excel形式
        function exportExcel(){
            window.location.href=rootPath + "<%=path%>/teacher/export?courseId=${selectedCourse.courseId}";
        }
    </script>
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
        <li><a href="<%=path%>/teacher/getStudentInfoDetails">详细信息</a></li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/teacher/getStudentInfoDetails?courseId=${param.courseId}">
        <input type="text" style="display:none" name="courseId" class="form-control input-sm" value="${param.courseId}" readonly="readonly"/>
        <div class="form-group">
            <label class="col-sm-3 control-label">所属学院：</label>
            <input type="text" name="departmentName" class="form-control" id="departmentName" placeholder="请输入关键字" value="${param.departmentName}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">专业名称：</label>
            <input type="text" name="majorName" class="form-control" id="majorName" placeholder="请输入关键字" value="${param.majorName}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">班级名称：</label>
            <input type="text" name="className" class="form-control" id="className" placeholder="请输入关键字" value="${param.className}">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-danger" value="查询"/>
            <a href="<%=path%>/teacher/getStudentInfoDetails?courseId=${param.courseId}">
                <input type="button" class="btn btn-danger" value="清空条件" id="clearButton"  />
            </a>
        </div>
        <div class="form-group">›
            <a class="btn btn-warning" href="<%=path%>/teacher/queryStudentInfoByKey">返回上一级</a>
        </div>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>课程号</th>
            <th>课程名称</th>
            <th>所属学院</th>
            <th>专业</th>
            <th>班级</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${info.list}" var="selectedCourse">
            <tr>
                <td>${selectedCourse.courseId}</td>
                <td>${selectedCourse.courseName}</td>
                <td>${selectedCourse.departmentName}</td>
                <td>${selectedCourse.majorName}</td>
                <td>${selectedCourse.className}</td>
                <td>
                    <a href="<%=path%>/teacher/exportClassInfo?courseId=${selectedCourse.courseId}&courseName=${selectedCourse.courseName}&className=${selectedCourse.className}">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true">导出</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table class="table  table-condensed table-striped">
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/teacher/getStudentInfoDetails?page=1">首页</a>
                    <a href="<%=path%>/teacher/getStudentInfoDetails?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/teacher/getStudentInfoDetails?page=${num}&key=${key}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/teacher/getStudentInfoDetails?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/teacher/getStudentInfoDetails?page=${info.pages}">末页</a>
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
