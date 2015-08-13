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
	var submitForm = function($dialog, $gridBook,$gridFee, $pjq) {
		var url ="";
		if("edit" == "<%=type%>"){
			url = cxw.contextPath + '/securityJsp/page/form/updateTextBookFee';
		} else {
			url = cxw.contextPath + '/securityJsp/page/form/addTextBookFee';
		}
		if ($('form').form('validate')) {
			var url = url;
			$.post(url, cxw.serializeObject($('form')), function(result) {
				if (result.success) {
					$gridBook.datagrid('load');
					$gridFee.datagrid('load');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	}
	
	$(document).ready(function(){
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
		
		$('#type').combobox({
			url : 'getDTextBookFeesType',
			valueField : 'type',
			textField : 'dnameM',
			editable : false,
			panelHeight : "auto",
			required : true,
			onLoadSuccess : function(data) {
				if(data){
					$('#type').combobox('setValue', data[0].type);
				}
			}
		});
		
		if("edit" == "<%=type%>" ){
			$.post("getTextBookFee", {	id :"<%=id%>"
			}, function(result) {
				$('form').form('load', {
					"courseTypeCode" : result.courseTypeCode,
					"type" : result.type,
					"seq" : result.seq,
					"nameM" : result.nameM,
					"points" : result.points,
					"price" : result.price
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
					<th>对应课程:</th>
					<td><select id="cc" name="courseTypeCode"
						class="easyui-combobox" style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>类型:</th>
					<td><select id="type" name="type" class="easyui-combobox"
						style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>排序:</th>
					<td><input name="seq" class="easyui-numberspinner" value="0"
						required="required" data-options="min:1,max:100"></td>
				</tr>
				<tr>
					<th>教材杂费名称:</th>
					<td><input class="easyui-validatebox" name="nameM"
						required="required" /><input name="id" type="hidden"
						value="<%=id%>" /></td>
				</tr>
				<tr>
					<th>价格:</th>
					<td>￥<input class="easyui-numberbox" name="price"  data-options="min:0,value:0" style="width: 70px;"
						required="required" /></td>
				</tr>
				<tr>
					<th>需要积分:</th>
					<td><input class="easyui-numberbox"  data-options="min:0,value:0"  name="points" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>