<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<html>

	<head>
		<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" media="screen">
		<link href="<%=path%>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js" charset="UTF-8"></script>
		<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="<%=path%>/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	</head>

	<body>
		<div style="padding:5px; margin:0px;">
			<ul class="breadcrumb" style="  margin:0px; ">
				<li>
					<a href="student_list.jsp">学生管理</a>
				</li>
				<li>修改学生</li>
			</ul>
		</div>

		<form action="<%=path%>/student/update" class="form-horizontal">

			<!--开始 -->
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="col-sm-3 control-label">学生编号</label>
						<div class="col-sm-9">
							<input type="text" name="studentId" class="form-control input-sm" readonly="readonly" value="${student.studentId}"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">学生姓名</label>
						<div class="col-sm-9">
							<input type="text" name="studentName" class="form-control input-sm" value="${student.studentName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">学生性别</label>
						<div class="col-sm-9">
							<input type="text" name="studentSex" class="form-control input-sm"  value="${student.studentSex}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">院系编号</label>
						<div class="col-sm-9">
							<input type="text" name="departmentId" class="form-control input-sm" value="${student.departmentId}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">专业编号</label>
						<div class="col-sm-9">
							<input type="text" name="majorId" class="form-control input-sm" value="${student.majorId}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">班级编号</label>
						<div class="col-sm-9">
							<input type="text" name="classId" class="form-control input-sm" value="${student.classId}"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">学生密码</label>
						<div class="col-sm-9">
							<input type="password" name="studentPassword" class="form-control input-sm" value="${student.studentPassword}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">管理员姓名</label>
						<div class="col-sm-9">
							<input type="text" name="adminName" class="form-control input-sm" value="${student.adminName}"/>
						</div>
					</div>
				</div>
			</div>
			<!--结束 -->
			<div class="row">
				<div class="col-sm-3 col-sm-offset-2">
					<input type="submit" class="btn btn-success" value="提交" />
					<a class="btn btn-warning" href="<%=path%>/student/listAll">返回上一级</a>
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