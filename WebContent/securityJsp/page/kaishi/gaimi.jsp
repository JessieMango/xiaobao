<%@page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../../inc.jsp"></jsp:include>
<title></title>
<style type="text/css">
label {
	margin-right: 20px;
}
</style>
<script type="text/javascript">
	var submitForm = function() {

		if ($('form').form('validate')) {

			$.post("alterPwd", cxw.serializeObject($('form')), function(data) {
				if (!data.success) {
					alert(data.msg);
				}
				if (data.success) {
					alert('更改密码成功');
					$.get("loginOut", function(data) {
						if (data.success == true) {
							parent.window.location
									.replace("../../../index.jsp");
						}
					});
				}
			}, 'json');
		}
	}
	function init() {
		$("#btn_Login").click(function() {
			submitForm();
		});
	}
	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<form>
			<div style="width: 400px; text-align: center; margin: auto;">
				<div style="margin-bottom: 20px; margin-top: 50px;">
					<label for="username">&nbsp;&nbsp;用户名</label><input name="username"
						readonly="readonly"
						value="<%=sessionInfo.getUser().getUsername()%>" />
				</div>
				<div style="margin-bottom: 20px;">
					<label for="password">&nbsp;&nbsp;原密码</label><input name="password"
						class="easyui-validatebox" data-options="required:true"
						type="password" />
				</div>
				<div style="margin-bottom: 20px;">
					<label for="pwd">&nbsp;&nbsp;新密码</label><input name="pwd" id="pwd"
						type="password" class="easyui-validatebox"
						data-options="required:true" />
				</div>
				<div style="margin-bottom: 20px;">
					<label for="rpwd">再输入一次</label><input name="rpwd" type="password"
						class="easyui-validatebox"
						data-options="required:true,validType:'eqPwd[\'#pwd\']'" />
				</div>
				<div style="text-align: center; margin-top: 20px;">
					<button type="button" id="btn_Login">
						<img alt="保存" style="vertical-align: middle;"
							src="../../../style/image/save.gif"><span
							style="vertical-align: middle;">保存</span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>