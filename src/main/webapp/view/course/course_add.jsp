<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript">
        $(function(){
            //获得学院信息
            $("#departmentId").append("<option selected='selected'>--请选择学院--</option>");
            $.post("/xuanke/department/listAll.do",{},function(data){
                for(var i=0;i<data.length;i++){
                    $("#departmentId").append("<option value="+data[i].departmentId+">"+data[i].departmentName+"</option>");
                }
            },"json");//指定返回类型为json
        });

        function showTeachers() {
            var departmentId = $("#departmentId").val();
            $("#teacherId").empty();
            $.ajax({
                method : "POST",
                url: "/xuanke/teacher/showTeachers?departmentId="+departmentId,
                dataType:"json",
                success: function (data) {
                    var teacherlist="<option selected='selected'>--请选择教师--</option>";
                    for(var i=0;i<data.length;i++){
                        teacherlist+=("<option value='" + data[i].teacherId + "'>" + data[i].teacherName + "</option>");
                    }
                    $("#teacherId").append(teacherlist)
                }
            });
        }
    </script>


</head>
<body>
<div style="padding:5px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">课程管理</a></li>
        <li>增加课程</li>
    </ul>
</div>

<form action="<%=path%>/course/add" mothod="post" class="form-horizontal">

    <!--开始 -->
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-3 control-label">课程名称</label>
                <div class="col-sm-9">
                    <input type="text" name="courseName" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">课程类型</label>
                <div class="col-sm-9">
                    <select name="courseType">
                        <option>通识选修课</option>
                        <option>专业选修课</option>
                        <option>公共选修课</option>
                        <option>必修课</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学院名称</label>
                <div class="col-sm-9">
                    <select class="dfinput" name="departmentId" id="departmentId" required="required" onchange="showTeachers()">
                </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">授课老师</label>
                <div class="col-sm-9">
                    <select class="dfinput" name="teacherId" id="teacherId" required="required">
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">学年</label>
                <div class="col-sm-9">
                    <select name="academicYear">
                        <option>2019-2020学年</option>
                        <option>2020-2021学年</option>
                        <option>2021-2022学年</option>
                        <option>2022-2023学年</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学期</label>
                <div class="col-sm-9">
                    <select name="semester">
                        <option>春季</option>
                        <option>秋季</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">上课时间</label>
                <div class="col-sm-9">
                    <input type="text" name="time" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">上课地点</label>
                <div class="col-sm-9">
                    <input type="text" name="place" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学时</label>
                <div class="col-sm-9">
                    <input type="text" name="creditHour" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">学分</label>
                <div class="col-sm-9">
                    <input type="text" name="credit" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">考试类型</label>
                <div class="col-sm-9">
                    <select name="examType">
                        <option>考试</option>
                        <option>考查</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">计划人数</label>
                <div class="col-sm-9">
                    <input type="text" name="planNumber" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">已选人数</label>
                <div class="col-sm-9">
                    <input type="text" name="selectedNumber" class="form-control input-sm" />
                </div>
            </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-2">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="course_list.jsp">返回上一级</a>
        </div>
    </div>
    </div>
</div>
</form>
</body>
</html>
