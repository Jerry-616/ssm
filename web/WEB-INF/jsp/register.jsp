<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>注册</title>

    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a><b>SSM</b></a>
    </div>
    <div class="register-box-body">
        <p class="register-box-msg"><b>注册新用户</b></p>
        <form id="register1">
            <div class="form-group has-feedback" >
                <input type="text" name="userid" id="id" class="form-control"
                       placeholder="用户ID" onblur="registerAjax()" required> <span id="userInfo"
                    class="fa fa-id-card form-control-feedback"><demo:star/></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control"
                       placeholder="用户名" required> <span
                    class="fa fa-envelope form-control-feedback"><demo:star/></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control"
                       placeholder="密码" required> <span
                    class="fa fa-lock form-control-feedback"><demo:star/></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="sex" class="form-control"
                       placeholder="性别" required> <span
                    class="fa fa-intersex form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="adress" class="form-control"
                       placeholder="地址" required> <span
                    class="fa fa-home form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="phone" class="form-control"
                       placeholder="电话" required> <span
                    class="fa fa-phone form-control-feedback"><demo:star/></span>
            </div>

            <div class="row">
                <div class="col-xs-9">
                    <a href="${pageContext.request.contextPath}/user/jumplogin" class="text-center"><b>已有账号，马上登录</b></a>
                </div>
                <div class="col-xs-3">
                    <button type="button" class="btn btn-primary btn-block btn-flat"
                            onclick="userregister()" title="注册">注册</button>
                    <button type="reset" class="btn btn-primary btn-block btn-flat">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>

<script type="text/javascript">
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

    function userregister(){
        $.ajax({
            type:"post",
            url: "${pageContext.request.contextPath}/user/register",
            data:$('#register1').serialize(),
            dataType:"json",
            success:function (response) {
                alert("注册成功");
                window.location.href="${pageContext.request.contextPath}/user/jumplogin";
            },
            error:function (){
                alert("出现错误！");
            }
        });
    }

    function registerAjax(){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/user/a1",
            data:$('#userid').val(),
            dataType:"json",
            success:function (response) {
                alert("ID可以被注册");
                },
            error:function (){
                alert("ID已被注册");
            }
        });
    }
</script>
</body>
</html>
