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
			$
					.post(
							"getXiaoQuZiXunLiang",
							cxw.serializeObject($('form')),
							function(jsonData) {

								var datas = "[ {name : jsonData.series.data[0].name,data : [ jsonData.series.data[0].y ]}, {name : jsonData.series.data[1].name,data : [ jsonData.series.data[1].y ]	} ]";
								var data1 = eval("(" + datas + ")");
								$("#container").highcharts({
									title : {
										text : jsonData.title.text
									},

									series : [ {
										type : 'pie',
										name : jsonData.series.name,
										data : jsonData.series.data
									} ]

								});
								$("#container1").highcharts({
									title : {
										text : jsonData.title.text
									},
									chart : {
										type : 'column'
									},
									series : data1
								});
							}, 'json');
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

		$('#xiaoqu').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#xiaoqu').combobox('setValue', data[0].schoolCode);
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

<body>
	<form method="post" class="form">
		<table>
			<tr>
				<td>统计时间：</td>
				<td><input id="starttime" type="text" name="starttime"
					class="easyui-datebox" style="width: 200px;" required="required"></td>
				<td>到</td>
				<td><input id="endtime" type="text" name="endtime"
					class="easyui-datebox" style="width: 200px;" required="required">
				</td>
				<td></td>
				<td>校区：</td>
				<td><input id="xiaoqu" name="xiaoqu" class="easyui-combobox"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',required:true,editable:false,panelHeight:'auto',multiple:true" />
				</td>
				<td></td>
				<td><a href="javascript:void(0);" id="btn_save"
					class="easyui-linkbutton"
					data-options="iconCls:'ext-icon-zoom',plain:true">查询</a></td>
			</tr>
		</table>

		<div id="container"
			style="width: 550px; height: 400px; margin: 0 auto"></div>
		<div id="container1"
			style="width: 550px; height: 400px; margin: 0 auto"></div>
	</form>
</body>
</html>