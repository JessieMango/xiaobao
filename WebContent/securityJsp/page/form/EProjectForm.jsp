<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
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
		var url = "";
		if ("2" == "<%=type%>") {
			url = cxw.contextPath + '/securityJsp/page/form/updateExpenditureProject';
		} else {
			url = cxw.contextPath + '/securityJsp/page/form/addExpenditureProject';
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

	$(document).ready(function() {
		$('#cc').combobox({
			url : 'getAllExpenditures',
			valueField : 'expenditureCode',
			textField : 'expenditureName',
			editable : false,
			panelHeight : "auto",
			required : true,
			onLoadSuccess : function(data) {
				if(data){
					$('#cc').combobox('setValue', data[0].expenditureCode);
				}
			}
		});
		
		if("2" == "<%=type%>" ){
			$.post("getExpenditureProject", {	id :"<%=id%>"
			}, function(result) {
				$('form').form('load', {
					"expenditureProjectName" : result.expenditureProjectName,
					"expenditureProjectSeq" : result.expenditureProjectSeq,
					"expenditureCode" : result.expenditureCode
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
					<th>所属支出大类:</th>
					<td><select id="cc" name="expenditureCode"
						class="easyui-combobox" style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>排序:</th>
					<td><input name="expenditureProjectSeq" class="easyui-numberspinner"
						value="0" required="required" data-options="min:1,max:100"></td>
				</tr>
				<tr>
					<th>支出子项名称:</th>
					<td><input class="easyui-validatebox" name="expenditureProjectName"
						required="required" /><input name="id" type="hidden"
						value="<%=id%>" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>