<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支出按大类</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("getZhiChuAnDaLei", cxw.serializeObject($('form')),
				function(jsonData) {
					$("#container").highcharts({
						  title:{
						      text:  jsonData.title.text
						   },
							xAxis:{
						      categories:  jsonData.xAxis.categories
						   },
						   labels:{
						      items: jsonData.labels.items
						   },
						   series:jsonData.series,
						   center: jsonData.center,
						   size: jsonData.size,
						   showInLegend: jsonData.showInLegend
					});
				})
	}
};

	
	function init() {
		$('#starttime').datebox({
			required : true,
			value : getPreOneMonths()
		});
		$('#endtime').datebox({
			required : true,
			value : getCurrentDate()
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

<body>
<form method="post" class="form">
	<table>
		<tr>
			<td>统计开始日期：</td>
			<td><input id="starttime" type="text" name="starttime" class="easyui-datebox" style="width: 200px;" required="required"></td>
			<td>统计截止日期：</td>
			<td><input id="endtime" type="text" name="endtime" class="easyui-datebox" style="width: 200px;" required="required"> </td>
			<td></td>
			<td></td>
			
			<td>		
					 <a href="javascript:void(0);" id="btn_save"
						class="easyui-linkbutton"
						data-options="iconCls:'ext-icon-zoom',plain:true">查询</a>
			</td>
		</tr>
	</table>
	<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
</form>
</body>
</html>