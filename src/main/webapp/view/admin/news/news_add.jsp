<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/kindeditor.js" charset="UTF-8"></script>
    <!-- 富文本编辑器 -->
    <link rel="stylesheet" href="<%=path%>/kindeditor/themes/default/default.css"/>
    <script charset="UTF-8" src="<%=path%>/kindeditor/kindeditor-all.js"></script>
    <script charset="UTF-8" src="<%=path%>/kindeditor/lang/zh-CN.js"></script>
    <script type="text/javascript">
        //KindEditor脚本
        var editor;
        KindEditor.ready(function(K) {
            editor = K.create('#content', {
            });
        });
    </script>
</head>

<body>
<div style="padding:5px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>
            <a href="news_list.jsp">新闻管理</a>
        </li>
        <li>增加新闻</li>
    </ul>
</div>

<form action="<%=path%>/news/admin/add" class="form-horizontal">

    <!--开始 -->
    <div class="row">
        <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻标题</label>
                    <div class="col-sm-9">
                        <input type="text" name="newsName" class="form-control input-sm"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻类别</label>
                    <div class="col-sm-5">
                        <select class="form-control" name="newsType">
                            <option>活动信息</option>
                            <option>课程信息</option>
                            <option>学生工作</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻内容</label>
                    <div class="col-sm-3 control-label">
                        <textarea id="content" name="newsDetails" style="width:800px;height:400px;"></textarea>
                </div>
                </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-2">
            <input type="submit" class="btn btn-success" value="提交" />
            <a class="btn btn-warning" href="<%=path%>/news/admin/listAll">返回上一级</a>
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