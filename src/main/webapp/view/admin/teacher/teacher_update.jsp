<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<html>
<head>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:5px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">教师管理</a></li>
        <li>修改教师</li>
    </ul>
</div>

<form action="<%=path%>/teacher/doUpdate" class="form-horizontal">
   
    <!--开始 -->
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-3 control-label">教师编号</label>
                <div class="col-sm-9">
                    <input type="text" name="teacherId" class="form-control input-sm" readonly="readonly" value="${teacher.teacherId}"/>
                </div>
            </div>
        	 <div class="form-group">
                <label class="col-sm-3 control-label">教师姓名</label>
                <div class="col-sm-9">
                    <input type="text" name="teacherName" class="form-control input-sm"  value="${teacher.teacherName}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">教师性别</label>
                <div class="col-sm-9">
                    <input type="text" name="teacherSex" class="form-control input-sm" value="${teacher.teacherSex}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">院系编号</label>
                <div class="col-sm-9">
                    <input type="text" name="departmentId" class="form-control input-sm" value="${teacher.departmentId}"/>
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-3 control-label">职称</label>
                <div class="col-sm-9">
                    <input type="text" name="title" class="form-control input-sm" value="${teacher.title}"/>
                </div>
            </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <input type="text" name="teacherPhone" class="form-control input-sm" value="${teacher.teacherPhone}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">教师地址</label>
                <div class="col-sm-9">
                    <input type="text" name="teacherAddress" class="form-control input-sm" value="${teacher.teacherAddress}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">教师密码</label>
                <div class="col-sm-9">
                    <input type="password" name="teacherPassword" class="form-control input-sm" value="${teacher.teacherPassword}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">管理员姓名</label>
                <div class="col-sm-9">
                    <input type="text" name="adminName" class="form-control input-sm" value="${teacher.adminName}"/>
                </div>
            </div>
        </div>
    </div>
     <!--结束 -->
      <div class="row">
        <div class="col-sm-3 col-sm-offset-2">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="<%=path%>/teacher/listAll">返回上一级</a>
        </div>
    </div>
   </form>
</body>
</html>
