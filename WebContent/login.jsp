<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

a {
	color: white;
	text-decoration: none;
}

a:hover {
	cursor: pointer;
	text-decoration: none;
}

body {
	height: 100%;
	background: url('style/images/loginBg.jpg') no-repeat;
}

.main {
	min-width: 100%;
}

.top_right {
	margin-top: 30px;
	margin-right: 50px;
	text-align: right;
	height: 30px;
}

.login {
	width: 353px;
	height: 494px;
	margin: auto;
	background: url('style/images/login_box_bg.png') no-repeat;
}

.inputradius {
	border: 1px solid #dedede;
	-moz-border-radius: 5px; /* Gecko browsers */
	-webkit-border-radius: 5px; /* Webkit browsers */
	border-radius: 5px; /* W3C syntax */
}
</style>
<script type="text/javascript"
	src="<%=contextPath%>/jslib/jquery-1.9.1.js"></script>
<script src="<%=contextPath%>/jslib/cxwExtJquery.js"
	type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
	var submit = function() {
		if ($("#loginname").val() == "" || $("#password").val() == "") {
			alert("用户名密码不能为空");
		} else {
			$.post("securityJsp/login", cxw.serializeObject($('form')),
					function(result) {
						if (result.success) {
							window.location.replace("securityJsp/main.jsp")
						} else {
							$("#msg").html(result.msg);
						}
					}, 'json');
		}
	}

	$(document).ready(function() {
		$("#login").click(function() {
			submit();
		});

		$("html").keypress(function(e) {
			var e = e || event;
			keycode = e.which || e.keyCode;
			if (keycode == 13) {
				submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="main">
		<!-- top 学生登录入口  注册 反馈意见 -->
		<div class="top_right">
			<a>学生登录入口</a>&nbsp;&nbsp;&nbsp;<a href="http://www.baidu.com">家长登录入口</a>&nbsp;&nbsp;&nbsp;<a>联系我们</a>
		</div>
		<!-- 登录区域 -->
		<div style="text-align: center; margin-top: 5%">
			<div class="login">
				<form method="post">
					<div style="text-align: center; padding-top: 50px">
						<img src="style/images/logo.gif" border="0" />
					</div>
					<div style="margin-top: 10px">
						<img src="style/images/login_home.png" border="0" />
					</div>
					<div style="margin-top: 10px">
						<img src="style/images/login_username.png" border="0"
							style="vertical-align: middle" /> &nbsp;<input
							style="width: 200px; height: 28px;" name="loginname"
							id="loginname" class="inputradius" />
					</div>
					<div style="margin-top: 10px">
						<img src="style/images/login_pwd.png" border="0"
							style="vertical-align: middle" /> &nbsp;<input type="password"
							style="width: 200px; height: 28px;" class="inputradius"
							name="password" id="password" />
					</div>
					<div style="margin-top: 15px; color: red">
						<span id="msg"></span>
					</div>
					<div style="margin-top: 15px">
						<div style="display: inline; margin-right: 38px; color: #737373">
							<input type="checkbox" name="autoLogin" id="autoLogin"
								value="true" />下次启动登录
						</div>
						<div style="display: inline;">
							<a style="color: #737373">忘记密码?</a>
						</div>
					</div>
					<!-- 登录 注册 -->
					<div style="margin-top: 20px">
						<img src="style/images/login_submit.png" border="0"
							style="margin-right: 50px" id="login" /> <img
							src="style/images/login_reg.png" border="0" id="regnow" />
					</div>
					<!-- 其他登录方式 -->
					<div style="margin-top: 50px">
						其他登录&nbsp; <img src="style/images/01.png" border="0" />&nbsp; <img
							src="style/images/02.png" border="0" />&nbsp; <img
							src="style/images/03.png" border="0" />&nbsp; <img
							src="style/images/04.png" border="0" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>