<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台报名量</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("getQianTaiBaoMingLiang", cxw.serializeObject($('form')), function(
				jsonData) {	
			for(var i=0;i<jsonData.length;i++)
			{
				$("#container").highcharts({
					   title : {
		                   text : jsonData[i].title.text
		               },
		               series:[{
		            	   type:'pie',
		            	   name:jsonData[i].series.name,
		            	   data:jsonData[i].series.data
		               }]
		               });
			}
	})}};
	
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
			<td>经办人报名统计：</td>
			<td><input id="starttime" type="text" name="starttime" class="easyui-datebox" style="width: 200px;" required="required"></td>
			<td>到</td>
			<td><input id="endtime" type="text" name="endtime" class="easyui-datebox" style="width: 200px;" required="required"> </td>
			<td></td>
			<td>
			<select name="studentType" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
									<option value="1">新生</option>
									<option value="3">老生</option>
									<option value="2">插班</option>	
			</select>
			</td>
			
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