<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支出帐编辑</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
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
		$('#schoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#schoolCode').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$('#expenditureCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#expenditureCode').combobox('setValue',
									data[0].id);
						}
					},
					onSelect : function(data) {
						var url = 'getAllExpenditureProject?type='
								+ data.id;
						$('#expenditureProjectCode').combobox('reload', url);
					}
				});

		$('#expenditureProjectCode').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#expenditureProjectCode').combobox('setValue', data[0].id);
				}
				if (data[0] == undefined) {
					$('#expenditureProjectCode').combobox('setValue', '');
				}
			}
		});
		var permission;
		$.post("getExpenseAccountById", {id :"<%=id%>"}, function(rs) {
			$('form').form('load', {
				"schoolCode" : rs.schoolCode,
				"payDate" :rs.payDate,
				"expenditureProjectCode" : rs.expenditureProjectCode,
				"expenditureCode" : rs.expenditureCode,
				"moneyAmount" : rs.moneyAmount,
				"dHandlerNameM" : rs.dHandlerNameM,
				"remarks":rs.remarks
			});});}
	$(document).ready(function() {
	init();
	});
</script>
</head>
<body>
<form method="post" class="form">
<table>
	<tr>
		<td><label>支出校区：</label> </td>
		<td></td>
		<td><input class="easyui-combobox" name="schoolCode"	id="schoolCode" style="width: 155px;" 
	data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',required:true,panelHeight:'auto',editable:false" /></td>
	</tr>
<tr></tr>
	<tr>
		<td><label>支出日期：</label></td>
		<td></td>
		<td>
	<input type="text" id="payDate" name="payDate"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" /></td>
	</tr>
<tr></tr>
	<tr>
		<td><label>支出类别：</label></td>
		<td><input class="easyui-combobox" name="expenditureCode"	id="expenditureCode" style="width: 155px;" 
	data-options="valueField:'id',textField:'nameM',url:'getAllExpenditure?type=2',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;</td>
		<td> <input class="easyui-combobox" name="expenditureProjectCode"	id="expenditureProjectCode" style="width: 155px;" 
	data-options="valueField:'id',textField:'nameM',required:true,panelHeight:'auto',editable:false" /></td>
	</tr>
<tr></tr>
	<tr>
		<td><label>支出金额：</label></td>
		<td></td>
		<td><input type="text" name="moneyAmount" id="moneyAmount" class="easyui-numberbox" data-options="min:0,precision:2"/></td>
	</tr>
<tr></tr>
	<tr>
		<td><label>备注：</label></td>
		<td></td>
		<td><input type="text" name="remarks" id="remarks" class="easyui-validatebox" /></td>
	</tr>
<tr></tr>
	<tr>
		<td><label>经办人：</label></td>
		<td></td>
		<td><input type="text" name="dHandlerNameM" id="dHandlerNameM" class="easyui-validatebox" /></td>
	</tr>
</table>
</form>
</body>
</html>