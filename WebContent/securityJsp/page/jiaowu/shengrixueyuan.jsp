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
		grid = $('#grid')
				.datagrid(
						{
							url : 'GetShengRiXueYuan',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							idField : '',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [
									{
							         	field : 'username',
										title : '姓名',
										width : "5%",
										align : 'center'

									},
									{
										field : 'gender',
										title : '性别',
										width : "3%",
										formatter : function(value, row, index) {
											switch (value) {
											case '0':
												return '<img alt="男" style="vertical-align: middle;" src="../../../style/image/male.png">';
											case '1':
												return '<img alt="女" src="../../../style/image/female.png">';
											}
										}
									},
									
									{
										field : 'personnelstatus',
										title : '状态',
										width : "5%",
										align : 'center',
										
									},
									{
										field : 'education',
										title : '学历',
										width : "7%",
										align : 'center'
									},
									{
										field : 'laborRelations',
										title : '关系',
										width : "4%",
										align : 'center'
									}
									] ],
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

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
			<form method="post" class="form">
			<table>
		<tr>
			<td>统计年度：</td>
			<td>
			<select name="StudentMonth" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 100px;">
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
			</td>
			<td></td>
			<td>		
				<a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
			</td>
		</tr>
	</table>
			</form>
		<div>
		
			<table id="grid" data-options="border:false"></table>
		</div>
</body>
</html>