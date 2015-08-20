<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流水按校区</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("getLiuShuiAnXiaoQu", cxw.serializeObject($('form')), function(
				jsonData) {	
			var ColumnResult="[";
			for(var i=0;i<jsonData.series.data.length;i++)
				{
					ColumnResult+=",{name:jsonData.series.data["+i+"].name, data:[jsonData.series.data["+i+"].y]}"
				}
			
			ColumnResult=ColumnResult.replace(",","");
			ColumnResult+="]";
			var datas = eval("("+ColumnResult+")")

			
			$("#container").highcharts({
				   title : {
                       text : jsonData.title.text
                   },
                   series:[{
                	   type:'pie',
                	   name:jsonData.series.name,
                	   data:jsonData.series.data
                   }]
                   }
			);
			$("#container1").highcharts({
				   title : {
                    text : jsonData.title.text
                },
                chart:{
                	type:'column'
                	},
                series:datas
                });
		}, 'json');
	}}
	
	function init() {
		$('#starttime').datebox({
			required : true,
			value : getCurrentDate()
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
			<td>统计时间：</td>
			<td><input id="starttime" type="text" name="starttime" class="easyui-datebox" style="width: 200px;" required="required"></td>
			<td>到</td>
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
		<div id="container1" style="width: 550px; height: 400px; margin: 0 auto"></div>
</form>
</body>
</html>