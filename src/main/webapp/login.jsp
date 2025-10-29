<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="session" value="${pageContext.request.contextPath}" var="base"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<%=path%>/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/ace-rtl.min.css"/>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/alert.min.js"></script>
    <script type="text/javascript">
        if (top.location != self.location){
            top.location = self.location;
        }
    </script>

    <%--<meta name="author" content="DeathGhost" />--%>
    <style>
        body{height:100%;background: lightsteelblue;overflow:hidden;}
        canvas{z-index:-1;position:absolute;}
    </style>
<%--    <script src="<%=path%>/Scripts/jquery.js"></script>--%>
<%--    <script src="<%=path%>/Scripts/verificationnumbers.js"></script>--%>
<%--    <script src="<%=path%>/Scripts/particleground.js"></script>--%>
<%--    <script>--%>
<%--        // $(document).ready(function() {--%>
<%--            //验证码--%>
<%--            // createCode();--%>
<%--            //测试提交，对接程序删除即可--%>
<%--            /*$(".submit_btn").click(function(){--%>
<%--                if ( document.getElementsByName("role")[0].checked){--%>
<%--                    location.href="student-index.jsp";--%>
<%--                };--%>
<%--                if(document.getElementsByName("role")[1].checked){--%>
<%--                    location.href="teacherIndex.jsp";--%>
<%--                }--%>
<%--                if(document.getElementsByName("role")[2].checked){--%>
<%--                          location.href="adminIndex.jsp";--%>
<%--                }--%>
<%--                });*/--%>
<%--        });--%>
<%--    </script>--%>
</head>
<body class="login-layout" >
<div class="main-container" background="/img/bg1.JPG">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <span class="red">XX大学</span>
                            <span class="white">在线选课系统</span>
                        </h1>
                    </div>
                    <div class="space-6"></div>
                    <div class="position-relative">
                        <div id="login-box"
                             class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee orange"></i> 请输入您的账号和密码
                                    </h4>
                                    <div class="space-6"></div>
                                    <form action="index_admin.jsp" method="post" onsubmit="return check()">
                                        <fieldset>
                                            <label class="block clearfix"> <span
                                                    class="block input-icon input-icon-right">
                                                <input id="Id" name="loginAccount" type="text" class="form-control"
                                                       placeholder="请输入账号"/>
                                                <i class="icon-user"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                            <span class="block input-icon input-icon-right">
                                                <input id="password" name="password" type="password" class="form-control"
                                                       placeholder="请输入密码"/>
                                                <i class="icon-lock"></i>
                                            </span>
<%--                                                <p>--%>
<%--                                                    <label for="email">邮箱：</label>--%>
<%--                                                    <input class="form-control" id="email" placeholder="请输入邮箱" name="email" oninput="checkinput('email')">--%>
<%--                                                <div id="email-tips"></div><div style="display: none"><input value="false" id="email-check"></div>--%>
<%--                                                </p>--%>
<%--                                                <p>--%>
<%--                                                    <label for="captcha">验证码：</label>--%>
<%--                                                    <input class="form-control" id="captcha" placeholder="请输入验证码" name="captcha" oninput="checkinput('captcha')">--%>
<%--                                                <div id="captcha-tips"></div><div style="display: none"><input value="false" id="captcha-check"></div>--%>
<%--                                                <input class="btn btn-info" type="button" value="获取验证码" id="get-captcha">--%>
<%--                                                </p>--%>
                                                <form>
                                                    <input type="radio" name="role"  class="radio1" value="1" id="student" >学生
                                                    <input type="radio" name="role"  class="radio2" value="2" id="teacher">教师
                                                    <input type="radio" name="role"  class="radio3" value="3" id="admin">管理员
                                                </form>
<%--                                                    <button onclick="sendMail();">发送邮件验证</button>--%>
                                                <div class="clearfix">
                                                    <input type="button" id="btn" value="登陆" class="submit_btn"/>
                                                </div>
                                                <div class="space-4"></div>
                                            </label>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(document).ready(function(){
        //点击登陆按钮
        $('#btn').click(function(){
            var Id = $('#Id').val();
            var password = $('#password').val();
            if (!Id) {
                alert('学号或工号不能为空');
                return;
            }
            if (!password) {
                alert('密码不能为空');
                return;
            }
            // if (validate()!=true){
            //     alert("验证码不正确");
            //     return;
            // }


            var role = $('input[name="role"]:checked').val();
            if(role == 1){      //  学生
                var url = '${base}/student/login';
                var data = {
                    studentId: $('#Id').val(),
                    studentPassword: $('#password').val(),
                    teaRole:role,
                };

                //访问后台
                $.post(url, data, function(result) {
                    if (result.code == 3) {
                        window.sessionStorage["currentStudent"] = result.student  //  存入session
                        window.location.href = '${base}/index_student.jsp?studentId='+result.student.studentId;
                    } else {
                        alert("学生："+result.msg);
                    }
                }, 'json').always(function(){
                });
            }//  end of student
            else if(role == 2) {    //  老师
                var url = '${base}/teacher/login';
                var data = {
                    teacherId: $('#Id').val(),
                    teacherPassword: $('#password').val(),
                    teaRole: role,
                };
                //访问后台
                $.post(url, data, function(result){
                    if (result.code == 3) {
                        window.sessionStorage["currentTeacher"] = result.teacher    //  存入session
                        location.href = '${base}/index_teacher.jsp?teacherId='+result.teacher.teacherId;

                    } else {
                        alert("老师："+result.msg);
                    }
                }, 'json').always(function(){
                });
            }//end of teacher

            else if(role==3){   //管理员
                var url = '${base}/admin/login';
                var data = {
                    adminId: $('#Id').val(),
                    adminPassword: $('#password').val(),
                    teaRole: role,
                };

                //访问后台
                $.post(url, data, function(result) {
                    if (result.code == 3) {
                        window.sessionStorage["currentAdmin"] = result.admin    //  存入session
                        window.location.href = '${base}/index_admin.jsp?adminId='+result.admin.adminId;
                    } else {
                        alert("管理员："+result.msg);
                    }
                }, 'json').always(function(){
                });
            }//end of admin

        });
    });
</script>

<Script>
    // $(function () {
    //         $("#get-captcha").click(function () {
    //         if ($("#email").val() == "") {
    //             alert("邮箱不能为空");
    //             $("#email").focus();
    //             return false;
    //         } else if ($("#email").val().indexOf('@') == '-1' || $("#email").val().indexOf('.com') == '-1') {
    //             alert("请检查邮箱格式是否正确")
    //         } else {
    //             $.ajax({
    //                 url: 'teacher/checkEmail',
    //                 datatype: "json",
    //                 type: "post",
    //                 data: {
    //                     teacherId:$('#Id').val(),
    //                     email: $("#email").val()
    //                 },
    //                 success: function (res) {
    //                     if (res == true) {
    //                         $("#get-captcha").attr("disabled", true);
    //                         $("#get-captcha").val("发送中...");
    //                         $.ajax({
    //                             url: 'email/send',
    //                             datatype: "json",
    //                             type: "post",
    //                             data: {
    //                                 email: $("#email").val()
    //                             },
    //                             success: function (res) {
    //                                 if (res) {
    //                                     alert("验证码发送成功")
    //                                     var count = 60;
    //                                     var countdown = setInterval(CountDown, 1000);
    //
    //                                     function CountDown() {
    //                                         $("#get-captcha").attr("disabled", true);
    //                                         $("#get-captcha").val(count + "s");
    //                                         if (count == 0) {
    //                                             $("#get-captcha").val("重新获取验证码").removeAttr("disabled");
    //                                             clearInterval(countdown);
    //                                             $.ajax({
    //                                                 url: "teacher/deleteCaptcha",
    //                                                 datatype: "json",
    //                                                 type: "post",
    //                                                 success: function () {
    //                                                     alert("获取验证码失效，请重新获取")
    //                                                 }
    //                                             })
    //                                         }
    //                                         count--;
    //                                     }
    //                                 }
    //                             }, error: function () {
    //                                 alert("获取验证码失败")
    //                                 $("#get-captcha").val("重新获取验证码").removeAttr("disabled");
    //                             }
    //                         })
    //                     } else {
    //                         alert("该邮箱不能获取验证码")
    //                     }
    //
    //                 }
    //             })
    //         }
    //     });
    // })
    // $("#btn").click(function () {
    //     $.ajax({
    //     url:"teacher/checkCaptcha",
    //     data:{
    //         captcha:$("#captcha").val()
    //     },
    //     dataType:"json",
    //     type:"post",
    //     success:function (res) {
    //         if(res==false){
    //             alert("验证码不正确");
    //             return false;
    //         }else{
    //             alert("登录成功")
    //             $("form").submit();
    //         }
    //     }
    // })
    // });
</Script>

</body>
</html>
