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
<link href="<%=contextPath%>/style/login.css" style="text/css"
	rel="stylesheet" />
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
	<div class="total">
		<div class="header">
			<div class="logo">
				<img alt="logo" src="<%=contextPath%>/style/images/logo.gif">
			</div>
			<div class="navBar">
				<div class="menu">
					<a href="" target="_blank" class="st-btn">学生团体入口</a>
				</div>
				<div class="menu">
					<a href="" title="注册">注册</a>
				</div>
				<div class="menu">
					<a href="" title="给我们提意见">反馈意见</a>
				</div>
			</div>
		</div>
		<div class="mm">
			<div class="mm-left">
				<div class="login">
					<div class="pic">
						<img alt="头像" src="<%=contextPath%>/style/image/person.jpg">
					</div>
					<form method="post" class="login-form">
						<dl>
							<dd>
								<input type="text" name="loginname" id="loginname" tabindex="1"
									autofocus="autofocus" placeholder="邮箱/手机号/用户名"
									required="required" class="input-text" />
							</dd>
						</dl>
						<dl>
							<dd>
								<input type="password" name="password" id="password"
									required="required" tabindex="2" class="input-text"
									placeholder="请输入密码" />
							</dd>
						</dl>
						<dl>
							<dd>
								<span id="msg"></span>
							</dd>
						</dl>
						<dl>
							<dd>
								<label title="为了确保您的信息安全，请不要在网吧或者公共机房勾选此项！" for="autoLogin"
									class="labelCheckbox"><input type="checkbox"
									name="autoLogin" id="autoLogin" value="true" tabindex="3" />下次自动登录</label>
							</dd>
							<dd>
								<span class="getpassword" id="getpassword"><a href=""
									tabindex="4">忘记密码?</a></span>
							</dd>
						</dl>
						<dl>
							<dd>
								<input type="button" id="login" class="login-btn" value="登录"
									tabindex="4" />
							</dd>
						</dl>
						<dl>
							<dd>
								<input type="button" onclick="window.location=''" id="regnow"
									class="regbutton" value="注册" tabindex="5" />
							</dd>
						</dl>
					</form>
				</div>
				<div class="login-corp">
					<div class="login-word">
						<div class="login-word-left">其他账号登录:</div>
						<div class="login-word-right">
							<a title="移动" class="login-item yidong"
								href="https://open.mmarket.com:443/omee-aus/services/oauth/authorize?responseType=code&scope=getUserInfo&clientId=300007884008&redirectUri=http%3A%2F%2Fwww.renren.com%2Fbind%2Fcnmobile%2FloginCallBack&clientState=9"
								id="login_cnmobile"> 移动</a> <a title="天翼"
								class="login-item tianyi" id="login_tianyi"
								href="https://oauth.api.189.cn/emp/oauth2/authorize?app_id=296961050000000294&response_type=code&redirect_uri=http://www.renren.com/bind/ty/tyLoginCallBack">天翼</a>
							<a title="360" class="login-item lo360" id="login_360"
								href="https://openapi.360.cn/oauth2/authorize?client_id=5ddda4458747126a583c5d58716bab4c&response_type=code&redirect_uri=http://www.renren.com/bind/tsz/tszLoginCallBack&scope=basic&display=default">360</a>
							<a title="百度" class="login-item baidu"
								href="https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=foRRWjPq8In3SIhmKQw1Pep3&redirect_uri=http%3A%2F%2Fwww.renren.com%2Fbind%2Fbaidu%2FbaiduLoginCallBack"
								id="login_baidu">百度</a>
						</div>
					</div>
				</div>
			</div>
			<div class="mm-right">
				<div class="mm-right-up">
					<img alt="图片" src="<%=contextPath%>/style/image/big.jpg">
				</div>
				<div class="mm-right-down">
					<div class="item">
						<a href="" target="_blank"><img alt="二维码" class="item-image"
							src="<%=contextPath%>/style/image/qrcode.jpg"> </a>
					</div>
					<div class="item">
						<a href="" target="_blank"><img alt="手机" class="item-image"
							src="<%=contextPath%>/style/image/phone.jpg"></a>
					</div>
					<div class="item">
						<a href="" target="_blank"><img alt="平板" class="item-image"
							src="<%=contextPath%>/style/image/pad.jpg"></a>
					</div>
					<div class="item">
						<a href="" target="_blank"><img alt="其他" class="item-image"
							src="<%=contextPath%>/style/image/other.jpg"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>