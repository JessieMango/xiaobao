<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校区总计</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	function init() {
		$('#startTime').datebox({
			required : true,
			value : getCurrentDate()
		});

		grid = $('#grid').datagrid({
			url : 'getRunningwaterDaily?pageCode=school',
			striped : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			nowrap : false,
			idField : 'typeCode',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ {
				field : 'typeCode',
				title : '',
				width : "24%",
				align : 'center',
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return "学费";
					case '2':
						return "教材杂费";
					case '3':
						return "合计";
					}
				}
			}, {
				field : 'feeState',
				title : '现金',
				width : "25%",
				align : 'center',
				formatter : function(value, row, index) {
					if (value == null) {
						return 0;
					} else {
						return value;
					}
				}
			}, {
				field : 'realMoney',
				title : '刷卡/支票/转账/网络',
				width : "25%",
				align : 'center',
				formatter : function(value, row, index) {
					if (value == null) {
						return 0;
					} else {
						return value;
					}
				}

			}, {
				field : 'remark',
				title : '总计',
				width : "24%",
				align : 'center',
				formatter : function(value, row, index) {
					if (value == null) {
						return 0;
					} else {
						return value;
					}
				}

			} ] ],
			toolbar : '#toolbar'
		});
	}

	$(function() {
		init();

	});
</script>
</head>
<body style="margin: 0px; padding: 0px">
	<div id="toolbar">
		<form>
			<div style="text-align: center; margin-top: 10px; margin-bottom: 0px">
				<label>时间:</label><input id="startTime" type="text" name="startTime"
					class="easyui-datebox" style="width: 200px;" required="required">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'ext-icon-zoom',plain:true"
					onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
			</div>
		</form>
	</div>
	<table id="grid" data-options="border:false"></table>
</body>
</html>