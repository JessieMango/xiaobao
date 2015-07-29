<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String version = "20150311";
%>
<!DOCTYPE html>
<html>
<head>
<title>登录超时</title>
<jsp:include page="../inc.jsp"></jsp:include>
<body>
	<script type="text/javascript" charset="utf-8">
		try {
			$.messager.alert('警告', '${msg}', 'info', function(r) {
				parent.location.replace(cxw.contextPath + '/index.jsp');
			});
			parent.$.messager.progress('close');
		} catch (e) {
		}
	</script>
</body>
</html>