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
<script type="text/javascript"
	src="<%=contextPath%>/jslib/jquery.SuperSlide.2.1.1.js"></script>
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
		jQuery(".slideBox").slide({
			mainCell : ".bd ul",
			effect : "left",
			autoPlay : true
		});
	});
</script>
<style type="text/css">
/* 本例子css */
.slideBox {
	overflow: hidden;
	position: relative;
	border: 0px solid #ddd;
}

.slideBox .bd {
	position: relative;
	height: 100%;
	z-index: 0;
}

.slideBox .bd ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px
}

.slideBox .bd li {
	zoom: 1;
	vertical-align: middle;
}

.slideBox .bd img {
	display: block;
	width: 100%;
	height: 100%
}

/* 下面是前/后按钮代码，如果不需要删除即可 */
.slideBox .prev, .slideBox .next {
	position: absolute;
	left: 3%;
	top: 50%;
	margin-top: -25px;
	display: block;
	width: 32px;
	height: 40px;
	background: url(<%=contextPath%>/style/image/slider-arrow.png) -110px
		5px no-repeat;
	filter: alpha(opacity = 50);
	opacity: 0.5;
}

.slideBox .next {
	left: auto;
	right: 3%;
	background-position: 8px 5px;
}

.slideBox .prev:hover, .slideBox .next:hover {
	filter: alpha(opacity = 100);
	opacity: 1;
}

.slideBox .prevStop {
	display: none;
}

.slideBox .nextStop {
	display: none;
}
</style>
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
					<div id="slideBox" class="slideBox">
						<div class="bd">
							<ul>
								<li><img alt="图片" src="<%=contextPath%>/style/image/AD.jpg"></li>
								<li><img alt="图片" src="<%=contextPath%>/style/image/AD.jpg"></li>
								<li><img alt="图片" src="<%=contextPath%>/style/image/AD.jpg">
								</li>
								<li><img alt="图片" src="<%=contextPath%>/style/image/AD.jpg"></li>
								<li><img alt="图片" src="<%=contextPath%>/style/image/AD.jpg">
								</li>
							</ul>
						</div>
						<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
						<a class="prev" href="javascript:void(0)"></a> <a class="next"
							href="javascript:void(0)"></a>
					</div>
				</div>
				<div class="morePlatform">
					<a href="" target="_blank"><img alt="二维码" class="item-image"
						src="<%=contextPath%>/style/image/qrcode.png"> </a> <a href=""
						target="_blank"><img alt="二维码" class="item-image"
						src="<%=contextPath%>/style/image/ios.png"> </a> <a href=""
						target="_blank"><img alt="二维码" class="item-image"
						src="<%=contextPath%>/style/image/ipad.png"> </a> <a href=""
						target="_blank"><img alt="二维码" class="item-image"
						src="<%=contextPath%>/style/image/morePlaterm.png"> </a>
				</div>
			</div>
		</div>
		<!-- 网站版权等等 -->
		<div class="ft-wrapper" style="width: 980px;">
			<p>
				<strong>玩转人人</strong> <a target="_blank"
					href="http://page.renren.com/register/regGuide/">公共主页</a> <a
					target="_blank" href="http://public.renren.com/">公众平台</a> <a
					target="_blank" href="http://support.renren.com/helpcenter">客服帮助</a>
				<a target="_blank" href="http://www.renren.com/siteinfo/privacy">隐私</a>
			</p>
			<p>
				<strong>商务合作</strong> <a target="_blank"
					href="http://page.renren.com/marketing/index">品牌营销</a> <a
					class="l-2" target="_blank"
					href="http://bolt.jebe.renren.com/introduce.htm">中小企业<br />自助广告
				</a> <a target="_blank" href="http://dev.renren.com/">开放平台</a>
			</p>
			<p>
				<strong>公司信息</strong> <a target="_blank"
					href="http://www.renren-inc.com/zh/product/renren.html">关于我们</a> <a
					target="_blank" href="http://page.renren.com/gongyi">人人公益</a> <a
					target="_blank" href="http://www.renren-inc.com/zh/hr/">招聘</a>
			</p>
			<p>
				<strong>友情链接</strong> <a target="_blank"
					href="http://www.jingwei.com/">经纬网</a> <a target="_blank"
					href="http://wan.renren.com/">人人游戏</a> <a target="_blank"
					href="http://fenqi.renren.com/">人人分期</a> <a target="_blank"
					href="http://quxue.renren.com/">人人趣学</a>
			</p>
			<p>
				<strong>人人移动客户端下载</strong> <a target="_blank"
					href="http://mobile.renren.com/showClient?v=platform_rr&psf=42064">iPhone/Android</a>
				<a target="_blank"
					href="http://mobile.renren.com/showClient?v=platform_hd&psf=42067">iPad客户端</a>
				<a target="_blank" href="http://mobile.renren.com">其他人人产品</a>
			</p>
			<p style="margi-left: -20px" class="copyright-info">
				<span>公司全称：北京千橡网景科技发展有限公司</span> <span>公司电话：010-84481818</span> <span><a
					href="mailto:admin@renren.com">公司邮箱：admin@renren.com</a></span> <span>公司地址：北京市朝阳区酒仙桥中路18号<br>国投创意信息产业园北楼1层
				</span> <span><a target="_blank" href="http://www.miibeian.gov.cn/">京ICP证090254号</a></span>
				<span>人人网&copy;2015</span> <span><a id="lawInfo" href="#nogo">法律声明</a></span>
			</p>
		</div>

	</div>
</body>
</html>