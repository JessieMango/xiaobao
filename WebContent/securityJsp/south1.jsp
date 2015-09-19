<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String contextPath = request.getContextPath();
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
	String username, scope, power, time;
	if (StringUtils.isNotBlank(sessionInfo.getUser().getCarCode())) {
		username = "账户名:" + sessionInfo.getUser().getUsername()
				+ "&lt; 已绑定磁卡 &gt;";
	} else {
		username = "账户名:" + sessionInfo.getUser().getUsername()
				+ "&lt; 未绑定磁卡 &gt;";
	}
	scope = "权限范围:" + sessionInfo.getUser().getScope();
	power = "权限类型:" + sessionInfo.getUser().getPower();
	time = "登录时限:" + sessionInfo.getUser().getLoginStartTime() + "-"
			+ sessionInfo.getUser().getLoginEndTime();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body> 
	<div class="footer" style="background:#333">
		<div class="td">
			<a href="#" target="_blank" style="display: inline;"><img
				class="img" alt="版本" src="../style/image/v_pro.gif" /> </a>
		</div>
		<div class="td">
			<img alt="用户" src="../style/image/User.gif" class="img" /><span
				class="BlueFont" style="color:#fff"><%=username%></span>
		</div>
		<div class="td">
			<img alt="权限范围" src="../style/image/School.gif" class="img" /><span
				class="BlueFont" style="color:#fff"><%=scope%></span>
		</div>
		<div class="td">
			<img alt="权限类型" src="../style/image/key.gif" class="img" /><span
				class="BlueFont" style="color:#fff"><%=power%></span>
		</div>
		<div class="td">
			<img alt="登陆时限" src="../style/image/time.gif" class="img" /><span
				class="BlueFont" style="color:#fff"><%=time%></span>
		</div>
	</div>
</body>
</html>