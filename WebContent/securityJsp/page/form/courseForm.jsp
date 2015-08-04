<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String courseCode = request.getParameter("courseCode");
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
			url = cxw.contextPath + '/securityJsp/page/form/updateCourse';
		} else {
			url = cxw.contextPath + '/securityJsp/page/form/addCourse';
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
			url : 'getCourseTypes',
			valueField : 'courseTypeCode',
			textField : 'courseTypeName',
			editable : false,
			panelHeight : "auto",
			required : true,
			onLoadSuccess : function(data) {
				if(data){
					$('#cc').combobox('setValue', data[0].courseTypeCode);
				}
			}
		});
		
		if("2" == "<%=type%>" ){
			$.post("getCourseById", {	courseCode :"<%=courseCode%>"}, function(result) {
				$('form').form('load', {
					"courseTypeCode" : result.courseTypeCode,
					"courseSeq" : result.courseSeq,
					"courseName" : result.courseName
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
					<th>所属课程类:</th>
					<td><select id="cc" name="courseTypeCode"
						class="easyui-combobox" style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>排序:</th>
					<td><input name="courseSeq" class="easyui-numberspinner"
						value="0" required="required" data-options="min:1,max:100"></td>
				</tr>
				<tr>
					<th>课程名:</th>
					<td><input class="easyui-validatebox" name="courseName"
						required="required" /><input name="courseCode" type="hidden"
						value="<%=courseCode%>" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>