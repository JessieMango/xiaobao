<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支出月对比</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var grid;
	function init() {
		grid = $('#grid').datagrid(
				{
					url : 'getZhiChuYueDuiBi',
					striped : true,
					pagination : true,
					rownumbers : true,
					nowrap : false,
					idField : 'userId',
					pageSize : 20,
					pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
							400, 500 ],
					columns : [ [
							{
								field : 'expenditurenameM',
								title : '月份',
								width : "33%",
								align : 'center'

							},
							{
								field : 'numberofaccounts',
								title : '条数',
								width : "33%",
								align : 'center'

							},
							
							{
								field : 'summoneyAmount',
								title : '总金额',
								width : "33%",
								align : 'center',
								
							}] ],
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
<form method="post" class="form">
	<table>
		<tr>
			<td>统计年度：</td>
			<td>
			<select name="statisticalYear" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 100px;">
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