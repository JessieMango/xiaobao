<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String userId = request.getParameter("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var resetPwd = function(userId) {
		alert(userId);
	}
</script>
</head>
<body>
	<div
		style="width: 60%; text-align: center; margin-top: 30px; margin-left: auto; margin-right: auto;">
		<div style="margin-bottom: 20px;">
			<span>用户名:</span>&nbsp;&nbsp;&nbsp;<span><%=username%></span>
		</div>
		<div style="margin-bottom: 20px;">
			<span>新密码:</span>&nbsp;&nbsp;&nbsp;<span>123456</span>
		</div>
		<div>
			<button id="resetButton">确认重置</button>
		</div>
	</div>
</body>
</html>