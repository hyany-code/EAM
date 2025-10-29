<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script type="text/javascript" src=".<%=path%>/js/alert.min.js"></script>
    <script>
        //    $('.alert').on('click', function () {
        //      $.alert('成功');
        //    });
        $(function(){
            $('.del').on('click', function () {
                $.confirm('确认要删除吗？', function (isConfirm) {
                    if (isConfirm) {
                        $.alert('确认');
                    } else {
                        $.alert('取消');
                    }
                });
            });

        });
    </script>
    <script>
        $(document).ready(function(){
            //获取后台数据的值(隐藏输入框的值)
            var key=$("#academicYear").val();
            //根据值让option选中
            $("#academicYearSelects option[value='"+key+"']").attr("selected","selected");
        })
        $(document).ready(function(){
            //获取后台数据的值(隐藏输入框的值)
            var key=$("#semester").val();
            //根据值让option选中
            $("#semesterSelects option[value='"+key+"']").attr("selected","selected");
        })
    </script>
    <script>
<%--    清空下拉列表值    --%>
        $("#clearButton").on("click", function() {
            var area = document.getElementById("academicYearSelects");
            area.innerHTML = "";
            for (var i = 0; i < area.childNodes.length; i++) {
                area.removeChild(area.options[0]);
                area.remove(0);
                area.options[0] = null;
            }
        })
    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">学生成绩</a></li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:5px 0px 5px 0px; padding:3px;">
    <form class="form-inline" action="<%=path%>/student/queryScoreByKey">
        <div class="form-group">
            <label class="col-sm-3 control-label">学年：</label>
            <div class="col-sm-5">
                <input type="hidden" id="academicYear" value="${param.academicYear}">
                <select   class="form-control" name="academicYear" id="academicYearSelects">
                    <option value="学年">全部</option>
                    <option value="2022-2023学年">2022-2023学年</option>
                    <option value="2021-2022学年">2021-2022学年</option>
                    <option value="2020-2021学年">2020-2021学年</option>
                    <option value="2019-2020学年">2019-2020学年</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">学期：</label>
            <div class="col-sm-5">
                <input type="hidden" id="semester" value="${param.semester}">
                <select   class="form-control" name="semester" id="semesterSelects">
                    <option value="学期">全部</option>
                    <option value="第1学期">第1学期</option>
                    <option value="第2学期">第2学期</option>
                </select>
            </div>
        </div>
        <div class="form-group">
        <input type="submit" class="btn btn-danger" value="查询"/>
        <a href="<%=path%>/student/queryScoreList?studentId=${currentStudent.studentId}">
            <input type="button" class="btn btn-danger" value="清空条件" id="clearButton"  />
        </a>
        </div>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>学年</th>
            <th>学期</th>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>学分</th>
            <th>考核方式</th>
            <th>成绩</th>
            <th>绩点</th>
            <th>开课学院</th>
            <th>课程类别</th>
            <th>教学班</th>
            <th>任课老师</th>
        </tr>

        <c:forEach items="${info.list}" var="selectedCourse">
        <tr>
        <%--            <td><input id="1" type="checkbox" value="2" name="allSelect"></td>--%>
            <th>${selectedCourse.academicYear}</th>
            <th>${selectedCourse.semester}</th>
            <td>${selectedCourse.courseId}</td>
            <td>${selectedCourse.courseName}</td>
            <th>${selectedCourse.credit}</th>
            <th>${selectedCourse.examType}</th>
            <td>${selectedCourse.score}</td>
            <td>${selectedCourse.gpa}</td>
            <th>${selectedCourse.departmentName}</th>  <!--  开课学院  -->
            <th>${selectedCourse.courseType}</th>
            <td>${selectedCourse.className}</td>
            <th>${selectedCourse.teacherName}</th>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
