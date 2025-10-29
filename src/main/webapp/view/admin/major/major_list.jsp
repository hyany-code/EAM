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
    <script src="<%=path%>path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script>
//    $('.alert').on('click', function () {
//      $.alert('成功');
//    });
function delMajor(majorId) {

    $.confirm('确认要删除吗？', function (isConfirm) {
        if (isConfirm) {
            window.location.href = "<%=path%>/major/doDelete?majorId=" + majorId;
        } else {
            $.alert('取消');
        }
    });
}
      
    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">专业管理</a></li>
        <li>专业列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/major/search">
        <div class="form-group">
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        <a class="btn btn-success" href="<%=path%>/view/admin/major/major_add.jsp">增加</a>
        <a href="#">
            <span class="glyphicon glyphicon-trash del" aria-hidden="true">批量删除</span>
        </a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th><input id="all" type="checkbox" value="all" name="allSelect">全选/取消</th>
            <th>专业编号</th>
            <th>专业名称</th>
            <th>管理员姓名</th>
            <th>院系编号</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${info.list}" var="major">
        <tr>
            <td><input id="3" type="checkbox" value="1" name="allSelect"></td>
            <td>${major.majorId}</td>
            <td>${major.majorName}</td>
            <td>${major.adminName}</td>
            <td>${major.departmentId}</td>
            <td>
                <a href="<%=path%>/major/getOne?majorId=${major.majorId}">
                	  <span class="glyphicon glyphicon-edit" aria-hidden="true">修改</span>
                </a>
                <a href="<%=path%>/major/doDelete?majorId=${major.majorId}">
                	<span class="glyphicon glyphicon-trash del" aria-hidden="true">删除</span>
                </a>
            </td>
        </tr>
        </c:forEach>
            <tr align="center">
                <td colspan="5">
                    <c:if test="${info.pageNum!=1}">
                        <a href="<%=path%>/major/listAll?page=1">首页</a>
                        <a href="<%=path%>/major/listAll?page=${info.prePage}">上一页</a>
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
                            <a href="<%=path%>/major/listAll?page=${num}">${num}</a>
                        </c:if>
                    </c:forEach>
                    <a href="<%=path%>/major/listAll?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/major/listAll?page=${info.pages}">末页</a>
                </td>
            </tr>

    </table>
</div>
</body>
</html>
