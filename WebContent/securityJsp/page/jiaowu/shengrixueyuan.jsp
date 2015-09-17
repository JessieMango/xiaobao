<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生日学员</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	/* 初始化页面 */
	function init() {
		grid = $('#grid').datagrid({
			url : 'GetShengRiXueYuan',
			striped : true,
			pagination : true,
			rownumbers : true,
			nowrap : false,
			idField : '',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ {
				field : 'nameM',
				title : '姓名',
				width : "10%",
				align : 'center'

			}, {
				field : 'birthday',
				title : '生日',
				width : "12%",
				align : 'center',
				formatter : function(value, row) {
					return value + "岁生日";
				}
			}, {
				field : 'age',
				title : '年龄',
				width : "15%",
				align : 'center',

			}, {
				field : 'motherTel',
				title : '母亲电话',
				width : "15%",
				align : 'center'
			}, {
				field : 'fatherTel',
				title : '父亲电话',
				width : "15%",
				align : 'center'
			}, {
				field : 'otherTel',
				title : '其他电话',
				width : "15%",
				align : 'center'
			}, {
				field : 'councilSchool',
				title : '其他学校',
				width : "16%",
				align : 'center'
			} ] ],
			toolbar:'#toolbar'
		});
	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div id="toolbar">
	<form method="post" class="form">
		<div style="text-align:center;margin-top:10px;margin-bottom:10px">
			统计年度：<select name="StudentMonth" class="easyui-combobox"
					data-options="required:true,editable:false,panelHeight:'auto'"
					style="width: 100px;">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'ext-icon-zoom',plain:true"
					onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
		</div>

	</form>
	</div>
	<div>

		<table id="grid" data-options="border:false"></table>
	</div>
</body>
</html>