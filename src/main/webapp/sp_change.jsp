<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="session" value="${pageContext.request.contextPath}" var="base"></c:set>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
    <script type="text/javascript" src="js/PIE_IE678.js"></script>
    <![endif]-->
    <link type="texts" rel="stylesheet" href="css/H-ui.css"/>
    <link type="texts" rel="stylesheet" href="css/H-ui.admin.css"/>
    <link type="texts" rel="stylesheet" href="font/font-awesome.min.css"/>

    <link type="text/css" rel="stylesheet" href="css/H-ui.css"/>
    <link type="text/css" rel="stylesheet" href="css/H-ui.admin.css"/>
    <link type="text/css" rel="stylesheet" href="font/font-awesome.min.css"/>
    <!--[if IE 7]>
    <link href="font/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
    <![endif]-->
    <title>修改密码</title>
</head>
<body class="cen">
<nav class="Hui-breadcrumb"><i class="icon-home"></i> 首页 <span class="c-gray en">&gt;</span> 修改密码 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav>
<div class="pd-20">
    <%--<form class="Huiform" id="loginform" action="${base}/teacher/updatePwd" method="post">--%>
    <%--<input type="text" name="studentId" id="studentId" value="" width="0" height="0" hidden="hidden">--%>

    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th colspan="2">修改密码</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th class="text-r" width="30%">旧密码：</th>
            <td><input name="oldpassword" id="oldpassword" class="input-text" type="password" autocomplete="off" placeholder="密码" tabindex="1" datatype="*6-16" nullmsg="请输入旧密码！" errormsg="4~16个字符，区分大小写！">
            </td>
        </tr>
        <tr>
            <th class="text-r">新密码：</th>
            <td><input name="newpassword" id="newpassword" class="input-text" type="password" autocomplete="off" placeholder="设置密码" tabindex="2" datatype="*6-16"  nullmsg="请输入您的新密码！" errormsg="4~16个字符，区分大小写！" >
            </td>
        </tr>
        <tr>
            <th class="text-r">再次输入新密码：</th>
            <td><input name="newpassword2" id="newpassword2" class="input-text" type="password" autocomplete="off" placeholder="确认新密码" tabindex="3" datatype="*" recheck="newpassword" nullmsg="请再输入一次新密码！" errormsg="您两次输入的新密码不一致！">
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <a onclick="sibmit()"  class="btn btn-success radius" id="student-password-save" name="student-password-save">确定</a>
            </td>
        </tr>
        </tbody>
    </table>
    <%--</form>--%>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="layer/layer.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript">
    // $(".Huiform").Validform();
    function sibmit(){
        var oldPassword=$('#oldpassword').val();
        var newPassword=$('#newpassword').val();
        var newPassword2=$('#newpassword2').val();
        var url = '${base}/student/updatePassword';
        var data = {
            studentId: ${currentStudent.studentId},
            oldpassword:$('#oldpassword').val(),
            newpassword:$('#newpassword').val()
        };
        if (oldPassword == "") {
            alert("旧密码不能为空")
        }
        else if (newPassword == "") {
            alert("新密码不能为空")
        }
        else if (newPassword2 == "") {
            alert("确认新密码不能为空")
        }
        else if (newPassword!=""&newPassword2!=""&newPassword != newPassword2) {
            alert("输入的两次密码不相同")
        }
        if (oldPassword!=""&newPassword!=""&newPassword2!=""&newPassword==newPassword2){
            //访问后台
            $.post(url, data, function(result) {
                if (result.code == 1) {
                    alert(result.msg);
                    window.location.href = '${base}/login.jsp';
                } else {
                    alert(result.msg);
                }
            }, 'json').always(function(){
                //关闭弹层
                /* layer.close(index);*/
            });
        }

    }


</script>

</body>
</html>