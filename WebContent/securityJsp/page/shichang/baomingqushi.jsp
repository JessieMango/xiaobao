<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报名来源趋势</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("getBaoMingLaiYuanQuShi", cxw.serializeObject($('form')), function(
				/* 市场中的controller都在controller下的MarketStatisticsController来进行后台逻辑的处理 */
				jsonData) {	
			$("#container").highcharts({
				   title : {
                       text : jsonData.title.text
                   },
                   xAxis:{
           		      categories: ['一月', '二月', '三月', '四月', '五月', '六月',
           		         '七月', '八月', '九月', '十月', '十一月', '十二月']
                		   },
           		   yAxis:{
           				      title: {
           				         text: '报名量'
           				      },
           				      plotLines: [{
           				         value: 0,
           				         width: 1,
           				         color: '#808080'
           				      }]
           				   },
                   series:jsonData.diagramseries
                   });
	})}};
	
	function init() {
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
	<div style="text-align:center">
		统计年度：<select name="statisticalYear" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 100px;">
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
			</select>
			<a href="javascript:void(0);" id="btn_save" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom',plain:true">查询</a>
	</div>
		<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
		
</form>
</body>
</html>