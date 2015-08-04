<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String expenditureCode = request.getParameter("expenditureCode");
	String type = request.getParameter("type");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitForm = function($dialog, $grid, $pjq) {
		var url ="";
		if("1" == "<%=type%>"){
			url = cxw.contextPath + '/securityJsp/page/form/updateExpenditure';
		} else {
			url = cxw.contextPath + '/securityJsp/page/form/addExpenditure';
		}
		if ($('form').form('validate')) {
			var url = url;
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
	
	$(document).ready(function(){
		if("1" == "<%=type%>" ){
			$.post("getExpenditure", {	id :"<%=expenditureCode%>"
			}, function(result) {
				$('form').form('load', {
					"expenditureSeq" : result.expenditureSeq,
					"expenditureName" : result.expenditureName
				});
			});
		}

	});
</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<table class="table" style="width: 100%;">
				<tr>
					<th>排序:</th>
					<td><input name="expenditureSeq" class="easyui-numberspinner"
						value="0" required="required" data-options="min:1,max:100"></td>
				</tr>
				<tr>
					<th>类名:</th>
					<td><input class="easyui-validatebox" name="expenditureName"
						required="required" /><input name="expenditureCode" type="hidden"
						value="<%=expenditureCode%>" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>