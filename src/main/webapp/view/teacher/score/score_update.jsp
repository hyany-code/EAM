<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="session" value="${pageContext.request.contextPath}" var="base"></c:set>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=path%>/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href=".<%=path%>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=path%>/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
</head>

<body>
<div style="padding:5px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>
            <a href="<%=path%>/view/teacher/score/score_list.jsp">学生成绩管理</a>
        </li>
        <li>修改成绩</li>
    </ul>
</div>

<form action="<%=path%>/teacher/updateScore" class="form-horizontal" method="post">
    <!--开始 -->
    <div class="row">
        <div class="col-sm-6">
            <input type="text" style="display:none" name="optionId" class="form-control input-sm" value="${optionId}" readonly="readonly"/>
            <div class="form-group">
                <label class="col-sm-3 control-label">课程代码</label>
                <div class="col-sm-9">
                    <input type="text" name="courseId" class="form-control input-sm" value="${selectedCourse.courseId}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">课程名称</label>
                <div class="col-sm-9">
                    <input type="text" name="courseName" class="form-control input-sm" value="${selectedCourse.courseName}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学生学号</label>
                <div class="col-sm-9">
                    <input type="text" name="studentId" class="form-control input-sm"  value="${selectedCourse.studentId}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学生姓名</label>
                <div class="col-sm-9">
                    <input type="text" name="studentName" class="form-control input-sm"  value="${selectedCourse.studentName}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学院</label>
                <div class="col-sm-9">
                    <input type="text" name="departmentName" class="form-control input-sm" value="${selectedCourse.departmentName}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">专业</label>
                <div class="col-sm-9">
                    <input type="text" name="majorName" class="form-control input-sm" value="${selectedCourse.majorName}" readonly="readonly"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">班级</label>
                <div class="col-sm-9">
                    <input type="text" name="className" class="form-control input-sm" value="${selectedCourse.className}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">成绩</label>
                <div class="col-sm-9">
                    <input type="text" name="score" class="form-control input-sm" value="${selectedCourse.score}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">绩点</label>
                <div class="col-sm-9">
                    <input type="text" name="gpa" class="form-control input-sm" value="${selectedCourse.gpa}" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学分</label>
                <div class="col-sm-9">
                    <input type="text" name="creditHour" class="form-control input-sm" value="${selectedCourse.creditHour}" readonly="readonly"/>
                </div>
            </div>

        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-2">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="<%=path%>/teacher/queryScoreList">返回上一级</a>
        </div>
    </div>
</form>

<script type="text/javascript">
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'yyyy-mm-dd'
    });
</script>
</body>

</html>