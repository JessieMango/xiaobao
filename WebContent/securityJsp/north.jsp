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
	<div class="menu" style="background:#605ca8">
	<!-- 
		<div class="main_Menu">
			<ul id="mainMenu"></ul>
		</div>
		 -->
		 <div style="float:left;width:20%;">
		  <img src="<%=contextPath %>/style/images/logo.png" style="width:120px;margin-top:20px;margin-left:10px"/>
		 </div>
		 <div style="float:right;width:80%;text-align:right">
		 <div style="margin-top:10px"> 
		  <div style="display:inline;margin-right:10px;color:white;font-size:14px"> 
		  	<img src="<%=contextPath %>/style/images/tongxunlu.png"  style="vertical-align:top"/>
		  	<a href="#" style="text-decoration:none;color:white" >通讯录</a> 
		  </div>
		  <div style="display:inline;margin-right:10px;color:white;font-size:14px"> 
		  	<img src="<%=contextPath %>/style/images/xitongrizhi.png" style="vertical-align:top"/>
		  	<a href="#" style="text-decoration:none;color:white">系统日志</a> 
		  </div>
		   <div style="display:inline;margin-right:10px;color:white;font-size:14px"> 
		  	<img src="<%=contextPath %>/style/images/pwd.png" style="vertical-align:top"/>
		  	<a href="#" style="text-decoration:none;color:white">修改密码</a> 
		  </div>
		  <div style="display:inline;margin-right:10px;color:white;font-size:14px"> 
		  	<img src="<%=contextPath %>/style/images/tuichu.png" style="vertical-align:top"/>
		  	<a href="#" style="text-decoration:none;color:white">退出系统</a> 
		  	</div>
		 </div>
		 </div>
	</div>
</body>
</html>