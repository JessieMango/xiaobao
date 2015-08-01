<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String schoolCode = request.getParameter("schoolCode");
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
					+ '/securityJsp/page/form/updateSchoolBySchoolCode';
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
		$.post("getSchoolById", {	schoolCode :"<%=schoolCode%>"}, function(result) {
			$('form').form('load', {
				"schoolName" : result.schoolName,
				"seq" : result.seq,
				"schoolTypeCode" : result.schoolTypeCode,
				"tel1" : result.tel1,
				"tel2" : result.tel2,
				"address" : result.address
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
					<th>校区名:</th>
					<td><input name="schoolName" class="easyui-validatebox" /><input name="schoolCode" type="hidden" value="<%=schoolCode%>" /></td>
				</tr>
				<tr>
					<th>排序:</th>
					<td><input name="seq" class="easyui-numberspinner"
						required="required" data-options="min:1,max:100"></td>
				</tr>
				<tr>
					<th>类型:</th>
					<td><select name="schoolTypeCode" class="easyui-combobox"
						data-options="required:true,editable:false,valueField:'schoolTypeCode',textField:'schoolType',url:'getSchoolType',panelHeight:'auto'"
						style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>电话1:</th>
					<td><input name="tel1" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>电话2:</th>
					<td><input name="tel2" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>地址:</th>
					<td><input name="address" class="easyui-validatebox"
						style="width: 300px;" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>