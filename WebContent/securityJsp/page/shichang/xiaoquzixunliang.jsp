<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校区咨询量</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("getConsultStatistics", cxw.serializeObject($('form')), function(
				result) {
			if (!result.success) {
				$.messager.alert('提示', '统计失败!', 'info');
			}
		}, 'json');
	}
	else
		{
			$.messager.alert('提示', '请将信息填写完整!', 'info');		
		}
	}
	
	function init() {
		$('#starttime').datebox({
			required : true,
			value : getCurrentDate()
		});
		$('#endtime').datebox({
			required : true,
			value : getCurrentDate()
		});
		
		$('#xiaoqu').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#xiaoqu').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		
		$("#btn_save").click(function() {
			submitForm();
		});
		}

	$(function() {
		init();
	});
</script>
</head>

<body class="easyui-layout" data-options="fit:true,border:false">
<form method="post" class="form">
	<table>
		<tr>
			<td>统计时间：</td>
			<td><input id="starttime" type="text" name="starttime" class="easyui-datebox" style="width: 200px;" required="required"></td>
			<td>到</td>
			<td><input id="endtime" type="text" name="endtime" class="easyui-datebox" style="width: 200px;" required="required"> </td>
			<td></td>
			<td>校区：</td>
			<td>
			<input id="xiaoqu" name="xiaoqu"  class="easyui-combobox"  data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',required:true,editable:false,panelHeight:'auto',multiple:true"/>
			</td>
			<td></td>
			<td>
			<button type="button" id="btn_save">
				<img alt="保存" style="vertical-align: middle;"
					src="../../../style/image/save.gif"><span
					style="vertical-align: middle;">保存</span>
			</button>
			</td>
		</tr>
	</table>
</form>
	<div data-options="region:'center',fit:true,border:false">
		
	</div>


</body>
</html>