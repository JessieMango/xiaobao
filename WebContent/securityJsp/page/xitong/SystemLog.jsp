<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录日志</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
/* 系统登录日志中的controller都在controller下的SystemLogController来进行后台逻辑的处理 */
<script type="text/javascript">
	function init() {
		$('#cc').datebox({
			required : true,
			value : getCurrentDate()
		});
		$('#cb').combobox(
				{
					url : 'readOperateType',
					valueField : 'operateType',
					textField : 'operateName',
					editable : false,
					panelHeight : "auto",
					required : true,
					onLoadSuccess : function(data) {
						if (data) {
							$('#cb').combobox('setValue', data[0].operateType);
							grid.datagrid('load', cxw
									.serializeObject($('#searchForm')));
						}
					}
				});

		grid = $('#grid').datagrid({
			url : 'readLog',
			striped : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,
			nowrap : false,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [

			{
				field : 'operateTime',
				title : '时间',
				width : "24%",
				align : 'center'
			}, {
				field : 'username',
				title : '用户',
				width : "24%",
				align : 'center',
			}, {
				field : 'operateName',
				title : '操作名称',
				width : "24%",
				align : 'center'

			}, {
				field : 'message',
				title : 'IP',
				width : "24%",
				align : 'center'

			} ] ],
			toolbar : '#toolbar'
		});
	}

	$(function() {
		init();

	});
</script>
</head>

<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar" style="display: none;">
		<table style="width: 100%">
			<tr>
				<td>
					<form id="searchForm">
						<table style="text-align: center; margin: auto">
							<tr>
								<td>登录时间：</td>
								<td><input id="cc" type="text" name="cc"
									class="easyui-datebox" style="width: 200px;"
									required="required"></td>
								<td>登录类型：</td>
								<td><select id="cb" name="cb" style="width: 200px;"
									class="easyui-combobox"></select></td>
								<td><a href="javascript:void(0);" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom',plain:true"
									onclick="grid.datagrid('load',cxw.serializeObject($('#searchForm')));">查询</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>

	<table id="grid" data-options="border:false,fit:true"></table>


</body>
</html>