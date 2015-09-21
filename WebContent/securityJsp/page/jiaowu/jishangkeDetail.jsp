<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String classCode = request.getParameter("classCode") == null ? ""
			: request.getParameter("classCode");
	String nameM = request.getParameter("nameM") == null ? "" : request
			.getParameter("nameM");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记上课详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
input {
	border: 1px solid #95b8e7;
	margin: 0;
	padding: 0 2px;
	vertical-align: middle;
	border-radius: 5px;
	height: 20px;
}

* {
	font-size: 12px;
}
</style>
</head>
<body>
	<div style="">
		<div style="width: 70%; margin: 0 auto;">
			<div class="easyui-panel" title="班级名称&nbsp;<%=nameM%>"></div>
		</div>
	</div>
</body>
</html>