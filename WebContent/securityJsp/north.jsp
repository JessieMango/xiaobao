<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title> 
<style type="text/css">
.dvimg{
	 vertical-align:middle
}
</style>
</head>
<body>
	<div class="menu">
	<!-- 
		<div class="main_Menu">
			<ul id="mainMenu"></ul>
		</div>
		 -->
		 <div style="float:left;width:20%;">
		  <img src="<%=contextPath %>/style/images/logo.gif" style="width:120px;margin-top:20px;margin-left:10px"/>
		 </div>
		 <div style="float:right;width:80%;text-align:right">
		 <div style="margin-top:10px"> 
		  <div style="display:inline;margin-right:10px;color:white"> 
		  	<img src="<%=contextPath %>/style/image/ICON/kaishi/zhuomian.png" />
		  	<a href="#" style="text-decoration:none;color:white">通讯录</a> 
		  </div>
		  <div style="display:inline;margin-right:10px;color:white"> 
		  	<img src="<%=contextPath %>/style/images/04.png" class="dvimg"/>
		  	<a href="#" style="text-decoration:none;color:white">系统日志</a> 
		  </div>
		   <div style="display:inline;margin-right:10px;color:white"> 
		  	<img src="<%=contextPath %>/style/images/04.png" class="dvimg"/>
		  	<a href="#" style="text-decoration:none;color:white">修改密码</a> 
		  </div>
		  <div style="display:inline;margin-right:10px;color:white"> 
		  	<img src="<%=contextPath %>/style/images/04.png" class="dvimg"/>
		  	<a href="#" style="text-decoration:none;color:white">退出系统</a> 
		  	</div>
		 </div>
		 </div>
	</div>
</body>
</html>