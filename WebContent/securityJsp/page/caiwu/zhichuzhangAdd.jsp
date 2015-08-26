<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建支出帐</title>
<script type="text/javascript">
var submitForm = function($dialog,$grid,$pjq) {
	if ($('form').form('validate')) {		
		$.post("updateExpenseAccount", cxw.serializeObject($('form')), function(result) {
			if (result.success) {
				$grid.datagrid('load');
				$dialog.dialog('destroy');
			} else {
				$.messager.alert('提示', '修改失败!', 'info');
			}
		}, 'json');
	}
	else
		{
			$.messager.alert('提示', '请将信息填写完整!', 'info');		
		}
	}
/* 初始化页面 */
	function init() {
		$("#btn_save").click(function() {
			submitForm();
		});
		
		var permission;
		$.post("getExpenseAccountById", {id :"<%=id%>"}, function(rs) {
			$('form').form('load', {
				"dHandlerNameM" : rs.dHandlerNameM,
				"remarks" :rs.remarks,
				"moneyAmount" : rs.moneyAmount,
				"expenditureProjectID" : rs.expenditureProjectID,
				"expenditureNameM" : rs.expenditureNameM,
				"payDate" : rs.payDate
			});});}
	$(document).ready(function() {
	init();
	});
</script>
</head>
<body>
<form method="post" class="form">
	<div style="width: 70%;margin-left:auto;margin-right:auto;">
	<label>支出校区：</label> 
			<input class="easyui-combobox" name="schoolCode"
							id="schoolCode" style="width: 155px;"
							data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;
	</div>
</form>
</body>
</html>