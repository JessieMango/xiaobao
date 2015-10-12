<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
<style type="text/css">
body {
	margin-left: 1px;
	margin-top: 1px;
	margin-right: 1px;
	margin-bottom: 1px;
}
</style>
</head>
<body>
	<div style="margin: 20 auto;">
		<div
			style="width: 30%; float: left; height: 250px; display: inline-block; background: #FFF; margin-left: 10px; padding: 5px;">
			<h2>文档</h2>
			<hr>
		</div>
		<div
			style="width: 30%; height: 250px; display: inline-block; margin-left: 3%; background: #FFF; padding: 5px;">
			<h2>消息</h2>
			<hr>
		</div>
		<div
			style="width: 30%; float: right; height: 250px; display: inline-block; background: #FFF; margin-right: 10px; padding: 5px;">
			<h2>提醒</h2>
			<hr>
		</div>
	</div>
	<div style="margin: 20 auto; margin-top: 20px;">
		<div
			style="width: 45%; float: left; height: 200px; display: inline-block; background: #FFF; margin-left: 10px; padding: 5px;">
			<h2>在线用户</h2>
			<hr>
		</div>
		<div
			style="width: 45%; float: right; height: 200px; display: inline-block; background: #FFF; margin-left: 10px; padding: 5px;">
			<h2>今日总览</h2>
			<hr>
		</div>
	</div>
</body>
</html>