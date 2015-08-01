<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String roleId = request.getParameter("roleId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = cxw.contextPath
					+ '/securityJsp/page/form/editUserByUserId';
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
		var permission;
		$.post("getPermissionByRoleId", {roleId :"<%=roleId%>"}, function(data) {
			$(data).each(function(index, role) {
				var description;
				if(role.description == null){
					description = '';
				} else {
					description = role.description;
				}
				$("#permission").append('<input type="checkbox" name="permission" class="per" value='+role.permission_id+' />'+ role.permission + description);
			});
			
			$.post("getUserByUserId", {userId :"<%=userId%>"}, function(result) {
				permission = result.permission;
				var loginDate = result.loginDate;
				if(loginDate.indexOf("1") != -1){
					$("#check1").attr("checked","checked");
				} 
				if(loginDate.indexOf("2") != -1){
					$("#check2").attr("checked","checked");
				} 
				if(loginDate.indexOf("3") != -1){
					$("#check3").attr("checked","checked");
				} 
				if(loginDate.indexOf("4") != -1){
					$("#check4").attr("checked","checked");
				} 
				if(loginDate.indexOf("5") != -1){
					$("#check5").attr("checked","checked");
				} 
				if(loginDate.indexOf("6") != -1){
					$("#check6").attr("checked","checked");
				} 
				if(loginDate.indexOf("7") != -1){
					$("#check7").attr("checked","checked");
				}			
				
				$('form').form('load', {
					'power' : result.power,
					'loginStartTime' : result.loginStartTime,
					'loginEndTime' : result.loginEndTime,
					'tel' : result.tel,
					'carCode' : result.carCode,
					'isEnabled' : result.isEnabled,
					'gender' : result.gender
				});
				
				$(".per").each(function(index,dom){
					if(permission.indexOf($(dom).val()) != -1){
						$(dom).attr("checked","checked");
					}
				});
				
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
					<th>状态</th>
					<td>
					<select name="isEnabled" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select></td>
				</tr>
				<tr>
					<th>级别</th>
					<td><input name="power" class="easyui-validatebox"  readonly="readonly"/> <input type="hidden" name="userId" value="<%=userId %>" /></td>
				</tr>
				<tr>
					<th>权限</th>
					<td id="permission"></td>
				</tr>
				<tr>
					<th>校区</th>
					<td><input name="scope" class="easyui-validatebox" value="全部校区"
						type="radio" checked="checked" />全部校区</td>
				</tr>
				<tr>
					<th>登录日期</th>
					<td><input name="week" id="check1" type="checkbox"  value="1" />周一
						<input name="week" id="check2" type="checkbox"  value="2" />周二
						<input name="week" id="check3" type="checkbox"  value="3" />周三
						<input name="week" id="check4" type="checkbox"  value="4" />周四
						<input name="week" id="check5" type="checkbox"  value="5" />周五
						<input name="week" id="check6" type="checkbox"  value="6" />周六
						<input name="week" id="check7" type="checkbox"  value="7" />周日
					</td>
				</tr>
				<tr>
					<th>登录时限</th>
					<td><input name="loginStartTime" class="easyui-validatebox" />到<input
						name="loginEndTime" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><select name="gender" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">男</option>
						<option value="1">女</option>
					</select></td>
				</tr>
				<tr>
					<th>手机号</th>
					<td><input name="tel" class="easyui-validatebox" data-options="validType:'fixLength[11]'" /></td>
				</tr>
				<tr>
					<th>磁卡</th>
					<td><input name="carCode" class="easyui-validatebox" />（绑定磁卡可实现员工磁卡考勤）</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>