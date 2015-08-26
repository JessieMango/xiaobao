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
	<label>支出校区：</label> <input class="easyui-combobox" name="schoolCode"	id="schoolCode" style="width: 155px;" 
	data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;
	<br/><label>支出日期：</label>
	<input type="text" id="payDate" name="payDate"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />
	<br/>
	<label>支出类别：</label>
	 <input class="easyui-combobox" name="expenditureCode"	id="expenditureCode" style="width: 155px;" 
	data-options="valueField:'',textField:'',url:'',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;
	 <input class="easyui-combobox" name="expenditureProjectCode"	id="expenditureProjectCode" style="width: 155px;" 
	data-options="valueField:'',textField:'',url:'',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;
	<br/>
	<label>支出金额：</label>
	<input type="text" class="easyui-numberbox" value="100" data-options="min:0,precision:2"/>
	<br/>
	<label>备注：</label>
	<br/>
	<label>经办人：</label>
</form>
</body>
</html>