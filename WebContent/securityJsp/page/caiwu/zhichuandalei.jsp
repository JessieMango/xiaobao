<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支出按大类</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var grid;
	function init() {
		$('#starttime').datebox({
			required : true,
			value : getPreOneMonths()
		});
		$('#endtime').datebox({
			required : true,
			value : getCurrentDate()
		});
	
		grid = $('#grid')
		.datagrid(
				{
					url : 'getZhiChuAnDaLei',
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
								title : '支出大类名称',
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
			<td>统计开始日期：</td>
			<td><input id="starttime" type="text" name="starttime" class="easyui-datebox" style="width: 200px;" required="required"></td>
			<td>统计截止日期：</td>
			<td><input id="endtime" type="text" name="endtime" class="easyui-datebox" style="width: 200px;" required="required"> </td>
			<td></td>
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