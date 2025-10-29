<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script>
        function delNews(newsId){
            $.confirm('确认要删除吗？',function (isConfirm) {
                if (isConfirm) {
                    window.location.href="<%=path%>/news/admin/delete?newsId="+newsId;
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
        <li><a href="#">新闻管理</a></li>
        <li>新闻列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/news/admin/search">
        <div class="form-group">
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入关键字" value="${key}">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        <a class="btn btn-success" href="<%=path%>/view/admin/news/news_add.jsp">增加</a>
        <input type="button" id="deleteButton" value="批量删除">
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <table class="table  table-condensed table-striped">
        <tr>
            <th><input type="checkbox" id="SelectAll" onclick="selectAll();" /> 全选/取消</th>
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>新闻类别</th>
            <th>发布人</th>
            <th>发布日期</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${info.list}" var="news">
            <tr>
                <td align="center"><input type="checkbox" name="newsId" value="${news.newsId}"></td>
                <td>${news.newsId}</td>
                <td>${news.newsName}</td>
                <td>${news.newsType}</td>
                <td>${news.adminName}</td>
                <td><fmt:formatDate value="${news.updateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td>
                    <a href="<%=path%>/news/admin/getOne?newsId=${news.newsId}">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true">修改</span>
                    </a>
                    <a href="javascript:delNews(${news.newsId})">
                        <span class="glyphicon glyphicon-trash del" aria-hidden="true">删除</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="8">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/news/admin/listAll?page=1">首页</a>
                    <a href="<%=path%>/news/admin/listAll?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/news/admin/listAll?page=${num}&key=${key}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/news/admin/listAll?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/news/admin/listAll?page=${info.pages}">末页</a>
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
<script>
        //全选(全不选)
        function selectAll(){
        //如果选择全选按钮
        if ($("#SelectAll").is(":checked")) {
        $(":checkbox").prop("checked", true);//所有选择框都选中
        } else {  //如果没有选择全选按钮
        $(":checkbox").prop("checked", false); //全部不选中
        }
        }

        //批量删除
        $("#deleteButton").on("click", function() {
        //判断至少写了一项
        var checkedNum = $("input[name='newsId']:checked").length;
        if (checkedNum == 0) {
        alert("请至少选择一项!");
        return false;
        }
        //创建数组,存储选择的id
        var checkedList = new Array();
        $("input[name='newsId']:checked").each(function () {
        //把当前选中的复选框的id存入数组中
        checkedList.push($(this).val());
        });

        //提示删除
        var flag=confirm("确认要删除这"+checkedList.length+"条数据吗?")
        if(flag){
        //传参,后端继续进行删除操作,传到后端的是一个String数组
        window.location.href="<%=path%>/news/admin/batchDeletes?ids="+checkedList;
        }
        })
</script>
</html>
