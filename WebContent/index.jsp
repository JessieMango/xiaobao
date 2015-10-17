<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>教育+ 教务管理系统 Educator</title>
<jsp:include page="inc.jsp"></jsp:include>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
	if (sessionInfo != null) {
%>
<script type="text/javascript">
	window.location.href = cxw.basePath + "/securityJsp/main.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	window.location.href = cxw.basePath + "/login.jsp";
</script>
<%
	}
%>
</head>
<body>

</body>
</html>