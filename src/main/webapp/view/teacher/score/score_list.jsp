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
        //    $('.alert').on('click', function () {
        //      $.alert('成功');
        //    });
        // $(function(){
        //     $('.del').on('click', function () {
        //         $.confirm('确认要删除吗？', function (isConfirm) {
        //             if (isConfirm) {
        //                 $.alert('确认');
        //             } else {
        //                 $.alert('取消');
        //             }
        //         });
        //     });
        // });
        function delScore(optionId){
            $.confirm('确认要删除吗？',function (isConfirm) {
                if (isConfirm) {
                    window.location.href="<%=path%>/teacher/deleteScore?optionId="+optionId;
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
        <li><a href="#">学生成绩</a></li>
        <li>查询学生成绩</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/teacher/queryScoreByKey">
        <div class="form-group">
            <label class="col-sm-3 control-label">课程代码：</label>
            <input type="text" name="courseId" class="form-control" id="courseId" placeholder="请输入关键字" value="${param.courseId}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">课程名称：</label>
            <input type="text" name="courseName" class="form-control" id="courseName" placeholder="请输入关键字" value="${param.courseName}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">学生学号：</label>
            <input type="text" name="studentId" class="form-control" id="studentId" placeholder="请输入关键字" value="${param.studentId}">
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">学生姓名：</label>
            <input type="text" name="studentName" class="form-control" id="studentName" placeholder="请输入关键字" value="${param.studentName}">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-danger" value="查询"/>
            <a href="<%=path%>/teacher/queryScoreList?teacherId=${currentTeacher.teacherId}">
                <input type="button" class="btn btn-danger" value="清空条件" id="clearButton"  />
            </a>
            <a href="#">
                <input type="button" value="批量删除" id="deleteButton">
            </a>
        </div>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <table class="table  table-condensed table-striped">
        <tr>
            <th><input type="checkbox" id="SelectAll" onclick="selectAll();" /> 全选/取消</th>
            <th>课程号</th>
            <th>课程名称</th>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>学院</th>
            <th>专业</th>
            <th>班级</th>
            <th>成绩</th>
            <th>绩点</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${info.list}" var="selectedCourse">
        <tr>
<%--            <td><input id="1" type="checkbox" value="2" name="allSelect"></td>--%>
            <td align="center"><input type="checkbox" name="optionId" value="${selectedCourse.optionId}"></td>
            <td>${selectedCourse.courseId}</td>
            <td>${selectedCourse.courseName}</td>
            <td>${selectedCourse.studentId}</td>
            <td>${selectedCourse.studentName}</td>
            <td>${selectedCourse.departmentName}</td>
            <td>${selectedCourse.majorName}</td>
            <td>${selectedCourse.className}</td>
            <td>${selectedCourse.score}</td>
            <td>${selectedCourse.gpa}</td>

            <td>
                <a href="<%=path%>/teacher/getOneScore?optionId=${selectedCourse.optionId}">
                    <span class="glyphicon glyphicon-edit" aria-hidden="true">修改</span>
                </a>
                <a href="javascript:delScore(${selectedCourse.optionId})">
                    <span class="glyphicon glyphicon-trash del" aria-hidden="true">删除</span>
                </a>
    </td>
        </tr>
    </c:forEach>
    </table>
    <table class="table  table-condensed table-striped">
        <tr align="center">
            <td colspan="5">
                <c:if test="${info.pageNum!=1}">
                    <a href="<%=path%>/teacher/queryScoreByKey?page=1">首页</a>
                    <a href="<%=path%>/teacher/queryScoreByKey?page=${info.prePage}">上一页</a>
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
                        <a href="<%=path%>/teacher/queryScoreByKey?page=${num}&key=${key}">${num}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${info.pageNum!=info.pages}">
                    <a href="<%=path%>/teacher/queryScoreByKey?page=${info.nextPage}">下一页</a>
                    <a href="<%=path%>/teacher/queryScoreByKey?page=${info.pages}">末页</a>
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
        var checkedNum = $("input[name='optionId']:checked").length;
        if (checkedNum == 0) {
            alert("请至少选择一项!");
            return false;
        }
        //创建数组,存储选择的id
        var checkedList = new Array();
        $("input[name='optionId']:checked").each(function () {
            //把当前选中的复选框的id存入数组中
            checkedList.push($(this).val());
        });

        //提示删除
        var flag=confirm("确认要删除这"+checkedList.length+"条数据吗?")
        if(flag){
            //传参,后端继续进行删除操作,传到后端的是一个String数组
            window.location.href="<%=path%>/teacher/batchDeletesScore?ids="+checkedList;
        }

    })
    //单个删除
    function delByID(id){
        window.location.href="http://localhost:8080/delByID?id="+id
    }

</script>
</html>
