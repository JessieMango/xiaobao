<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String level = request.getParameter("level");
	String levelName = request.getParameter("levelName");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitForm = function($dialog,$grid,$pjq){
		if($('form').form('validate')){
			var url = cxw.contextPath + '/securityJsp/page/form/addUserByRole';
			$.post(url, cxw.serializeObject($('form')), function(result) {
				if (result.success) {
					$grid.datagrid('load');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	}
	$(document).ready(function() {
		$.post("getPermissionByRoleId", {roleId :<%=level%>}, function(data) {
			$(data).each(function(index, role) {
				var description;
				if(role.description == null){
					description = '';
				} else {
					description = role.description;
				}
				if(role.isDefault == 1){
					$("#permission").append('<input type="checkbox" name="permission" value='+role.permission_id+' checked="checked"/>'+ role.permission + description);
				} else{
					$("#permission").append('<input type="checkbox" name="permission" value='+role.permission_id+' />'+ role.permission + description);
				}
			});
		});
		
	});
</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<table class="table" style="width: 100%;">
				<tr>
					<th>级别:</th>
					<td>&nbsp;<%=levelName%><input type="hidden" name="level" value="<%=level %>" /></td>
				</tr>
				<tr>
					<th>权限:</th>
					<td id="permission"></td>
				</tr>
				<tr>
					<th>校区:</th>
					<td><input type="radio" name="school" value="全部校区" checked="checked" />全部校区</td>
				</tr>
				<tr>
					<th>用户名:</th>
					<td><input class="easyui-validatebox" name="username"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>密码:</th>
					<td><input class="easyui-validatebox" name="pwd"
						value="123456" data-options="required:true"></td>
				</tr>
				<tr>
					<th>登录日期:</th>
					<td id="loginDate"><input type="checkbox" checked="checked"
						name="week" value="1" />周一 <input type="checkbox"
						checked="checked" name="week" value="2" />周二 <input
						type="checkbox" checked="checked" name="week" value="3" />周三 <input
						type="checkbox" checked="checked" name="week" value="4" />周四 <input
						type="checkbox" checked="checked" name="week" value="5" />周五 <input
						type="checkbox" checked="checked" name="week" value="6" />周六 <input
						type="checkbox" checked="checked" name="week" value="7" />周日</td>
				</tr>
				<tr>
					<th>登陆时限:</th>
					<td><input name="startTime" class="easyui-timespinner"
						style="width: 80px;" value="00:00" required="required"
						data-options="showSeconds:false">&nbsp;到&nbsp;<input
						name="endTime" class="easyui-timespinner" value="20:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false"></td>
				</tr>
				<tr>
					<th>性别:</th>
					<td><input type="radio" name="sex" value="male"
						checked="checked">男&nbsp; <input type="radio" name="sex"
						value="female">女</td>
				</tr>
				<tr>
					<th>手机号:</th>
					<td><input class="easyui-validatebox" name="tel"
						data-options="validType:'fixLength[11]'" /></td>
				</tr>
				<tr>
					<th>磁卡:</th>
					<td><input class="easyui-validatebox" name="carCode" />
						（绑定磁卡可实现员工磁卡考勤）</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>