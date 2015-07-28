<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String username = request.getParameter("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<title>用户Form</title>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<legend><%=username%></legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>状态</th>
					<td><select name="isEnabled"><option>启用</option>
							<option>禁用</option>
					</select></td>
				</tr>
				<tr>
					<th>级别</th>
					<td><input name="power" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>权限</th>
					<td><input name="permission" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>校区</th>
					<td><input name="scope" class="easyui-validatebox"
						type="radio" value="全部校区" checked="checked" /></td>
				</tr>
				<tr>
					<th>登录日期</th>
					<td><input name="check1" type="checkbox"
						class="easyui-validatebox" value="周一" />周一<input name="check2"
						type="checkbox" class="easyui-validatebox" value="周二" />周二<input
						name="check3" type="checkbox" class="easyui-validatebox"
						value="周三" />周三<input name="check4" type="checkbox"
						class="easyui-validatebox" value="周四" />周四<input name="check5"
						type="checkbox" class="easyui-validatebox" value="周五" />周五<input
						name="check6" type="checkbox" class="easyui-validatebox"
						value="周六" />周六<input name="check7" type="checkbox"
						class="easyui-validatebox" value="周日" />周日</td>
				</tr>
				<tr>
					<th>登录时限</th>
					<td><input name="loginStartTime" class="easyui-validatebox" />到<input
						name="loginEndTime" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><select name="gender"><option>男</option>
							<option>女</option>
					</select></td>
				</tr>
				<tr>
					<th>手机号</th>
					<td><input name="tel" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>磁卡</th>
					<td><input name="carCode" class="easyui-validatebox"
						data-options="required:true" />（绑定磁卡可实现员工磁卡考勤）</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>