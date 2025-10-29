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
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script>
//    $('.alert').on('click', function () {
//      $.alert('成功');
//    });
   function delDepartment(departmentId) {

       $.confirm('确认要删除吗？', function (isConfirm) {
           if (isConfirm) {
               window.location.href = "<%=path%>/department/doDelete?departmentId=" + departmentId;
           } else {
               $.alert('取消');
           }
       });
   }
     	


<%--//全选(全不选)--%>
<%--function selectAll(){--%>
    <%--//如果选择全选按钮--%>
    <%--if ($("#allSelect").is(":checked")) {--%>
        <%--$(":checkbox").prop("checked", true);//所有选择框都选中--%>
    <%--} else {  //如果没有选择全选按钮--%>
        <%--$(":checkbox").prop("checked", false); //全部不选中--%>
    <%--}--%>
<%--}--%>
<%--//批量删除--%>
<%--$("#deleteButton").on("click", function() {--%>
    <%--//判断至少写了一项--%>
    <%--var checkedNum = $("input[name='checkbox']:checked").length;--%>
    <%--if (checkedNum == 0) {--%>
        <%--alert("请至少选择一项!");--%>
        <%--return false;--%>
    <%--}--%>
    <%--//创建数组,存储选择的id--%>
    <%--var checkedList = new Array();--%>
    <%--$("input[name='checkbox']:checked").each(function () {--%>
        <%--//把当前选中的复选框的id存入数组中--%>
        <%--checkedList.push($(this).val());--%>
    <%--});--%>

    <%--//提示删除--%>
    <%--var flag=confirm("确认要删除这"+checkedList.length+"条数据吗?")--%>
    <%--if(flag){--%>
        <%--//传参,后端继续进行删除操作,传到后端的是一个String数组--%>
        <%--window.location.href="<%=path%>/department/batchDeletes"+checkedList;--%>
    <%--}--%>

<%--})--%>
// //单个删除
// function delByID(id){
//     window.location.href="http://localhost:8080/delByID?id="+id
// }
    </script>

      

</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">学院管理</a></li>
        <li>学院列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/department/search">
        <div class="form-group">
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        <a class="btn btn-success" href="<%=path%>/view/admin/department/department_add.jsp">增加</a>
        <a href="<%=path%>/department/getOne?departmentId=${department.departmentId}">
            <span class="glyphicon glyphicon-trash del" aria-hidden="true">批量删除</span>
        </a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
        	<th>学院编号</th>
            <th>学院名称</th>
            <th>联系人名称</th>
            <th>管理员姓名</th>
            <th>操作</th>
            <th><input id="all" type="checkbox" value="all" name="allSelect">全选/取消</th>
        </tr>
        <c:forEach items="${info.list}" var="department">
        <tr>
            <td>${department.departmentId}</td>
            <td>${department.departmentName}</td>
            <td>${department.teacherName}</td>
            <td>${department.adminName}</td>
            <td><input id="1" type="checkbox" value="1" name="allSelect"></td>
            <td>
                <a href="<%=path%>/department/getOne?departmentId=${department.departmentId}">
                	  <span class="glyphicon glyphicon-edit" aria-hidden="true">修改</span>
                </a>
                <a href="javascript:delDepartment(${department.departmentId})">
                	<span class="glyphicon glyphicon-trash del" aria-hidden="true">删除</span>
                </a>
            </td>
        </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/department/listAll?page=1">首页</a>
                    <a href="<%=path%>/department/listAll?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/department/listAll?page=${num}">${num}</a>
                    </c:if>
                </c:forEach>

                <a href="<%=path%>/department/listAll?page=${info.nextPage}">下一页</a>
                <a href="<%=path%>/department/listAll?page=${info.pages}">末页</a>

            </td>
        </tr>
    </table>
</div>
</body>
</html>
