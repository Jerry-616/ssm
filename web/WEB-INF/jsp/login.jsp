<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>登陆</title>

<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a><b>SSM</b></a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg"><b>会员登录</b></p>
			<form id="login1">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="用户名" required> <span
						class="fa fa-id-card form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="密码" required> <span
						class="fa fa-lock form-control-feedback"></span>
				</div>

				<div class="row">
					<div class="col-xs-9">
						<div class="checkbox icheck">
							<label><input type="checkbox" >记住自动登录</label>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/jump/jumpadminlogin" class="text-center">
								<span class="fa fa-key"></span><b>后台登录</b></a>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/jump/jumpregister" class="text-center"><b>没有账号请注册</b></a>
						</div>

					</div>
					<div class="col-xs-3">
						<button type="button" class="btn btn-primary btn-block btn-flat"
								onclick="userlogin()" title="登录">登录</button>
						<button type="reset" class="btn btn-primary btn-block btn-flat">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>>
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

		function userlogin(){
			$.ajax({
				type:"post",
				url: "${pageContext.request.contextPath}/user/login",
				data:$('#login1').serialize(),
				dataType:"json",
				success:function (response) {
					alert("登录成功");
					window.location.href="${pageContext.request.contextPath}/jump/jumpindex";
				},
				error:function (){
					alert("用户名或密码有误！");
				}
			});
		}
	</script>
</body>
</html>
