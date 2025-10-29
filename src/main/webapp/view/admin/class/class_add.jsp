<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>

</head>
<body>
<div style="padding:5px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">班级管理</a></li>
        <li>增加班级</li>
    </ul>
</div>

<form action="<%=path%>/classes/add" class="form-horizontal">
   
    <!--开始 -->
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-3 control-label">班级名称</label>
                <div class="col-sm-9">
                    <input type="text" name="className" class="form-control input-sm" />
                </div>
            </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">院系编号</label>
                <div class="col-sm-9">
                    <input type="text" name="majorId" class="form-control input-sm" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">管理员名称</label>
                <div class="col-sm-9">
                    <input type="text" name="adminName" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
     <!--结束 -->
      <div class="row">
        <div class="col-sm-3 col-sm-offset-2">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="<%=path%>/classes/listAll">返回上一级</a>
        </div>
    </div>
   </form>
</body>
</html>
