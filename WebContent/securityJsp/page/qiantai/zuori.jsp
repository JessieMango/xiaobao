<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的昨日</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	function init() {
		$('#startTime').datebox({
			required : true,
			value : getCurrentDate()
		});

		grid = $('#grid').datagrid({
			url : 'getRunningwaterDaily',
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
				align : 'center'
			}, {
				field : 'feeState',
				title : '现金',
				width : "25%",
				align : 'center',
			}, {
				field : 'realMoney',
				title : '刷卡/支票/转账/网络',
				width : "25%",
				align : 'center'

			}, {
				field : 'remark',
				title : '总计',
				width : "24%",
				align : 'center'

			} ] ],
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onSortColumn : function(sort, order) {
			},
			onLoadSuccess : function(data) {
				parent.$.messager.progress('close');
			}
		});
	}

	$(function() {
		init();

	});
</script>
</head>
<body>
	<form>
		<div id="toolbar" style="text-align: center;">
			<label>时间:</label><input id="startTime" type="text" name="startTime"
				class="easyui-datebox" style="width: 200px;" required="required">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				data-options="iconCls:'ext-icon-zoom',plain:true"
				onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
		</div>
	</form>
	<table id="grid" data-options="border:false"></table>
</body>
</html>