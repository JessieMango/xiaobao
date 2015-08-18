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
		$.post("getXiaoQuZiXunLiang", cxw.serializeObject($('form')), function(
				jsonData) {	
			
			$("#container").highcharts({
				   title : {
                       text : jsonData.title.text
                   },
                 
                   series:[{
                	   type:'pie',
                	   name:jsonData.series.name,
                	   data:[{
                	   name:jsonData.series.data[0].name,
                	   y:jsonData.series.data[0].y
                	  },
                	  {
                   	   name:jsonData.series.data[1].name,
                   	   y:jsonData.series.data[1].y,
	                   sliced: true,
	                   selected: true
                   	  }]
                   }]
                   /* ,
                   plotOptions:{
                	   pie:{
                		   allowPointSelect:jsonData.plotOptions.pie.allowPointSelect,
                		   cursor:jsonData.plotOptions.pie.cursor,
                		   dataLabels:jsonData.plotOptions.pie.dataLabels 
							allowPointSelect: true,
							cursor: 'pointer',
							dataLabels: {
								enabled: true,
								format: '<b>{point.name}%</b>: {point.percentage:.1f} %'
							}
                  		 }
					}, 
                   chart : {
               	   plotBackgroundColor :jsonData.chart.plotBackgroundColor,
                	   plotBorderWidth :jsonData.chart.plotBorderWidth,
                	   plotShadow:jsonData.chart.plotShadow 
                	   plotBackgroundColor: null,
            	       plotBorderWidth: null,
            	       plotShadow: false
                   }, 
                   tooltip:{
                	    pointFormat:jsonData.tooltip.pointFormat 
                	   pointFormat: '{jsonData.series.name}: <b>{point.percentage:.1f}%</b>'
                   }*/
                   
                   }
			);
			$("#container1").highcharts({
				   title : {
                    text : jsonData.title.text
                },
                chart:{
                	type:'column'
                	},
                series:[{
	             	   name:jsonData.series.data[0].name,
	             	   data:[jsonData.series.data[0].y]
             	  },
             	  {
                	   name:jsonData.series.data[1].name,
                	   data:[jsonData.series.data[1].y]
                	}]
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
	
		<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
			<div id="container1" style="width: 550px; height: 400px; margin: 0 auto"></div>
</form>
	


</body>
</html>