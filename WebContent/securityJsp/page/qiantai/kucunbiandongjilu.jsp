<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存变动记录</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.tr {
	display: table-row;
}

.th {
	display: table-cell;
}

a {
	text-decoration: none;
	color: #000;
}
</style>
<script type="text/javascript">
	/* 编辑库存变动记录 */
	var editFun = function(id){
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : "出入库",
			width : 500,
			height : 300,
			url : cxw.contextPath
					+ '/securityJsp/page/form/churukuForm.jsp?id='+id,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}
	var submit = function() {
		if ($('form').form('validate')) {
			grid.datagrid('load', cxw.serializeObject($('form')));
		}
	}
	/* 初始化页面 */
	function init() {
		$('#textbookFee_id').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#textbookFee_id').combobox('setValue', data[0].id);
				}
			}
		});
		grid = $('#grid')
				.datagrid(
						{
							url : 'getKuCunBianDongJiLu',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							checkOnSelect : false,
							selectOnCheck : false,
							idField : 'id',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [
									{
										field : 'location',
										title : '仓库',
										width : "10%",
										align : 'center',
										formatter : function(value, row) {
											switch (value) {
											case '1':
												return '仓库';
											case '2':
												return '<%=sessionInfo.getUser().getSchool()%>';
											}
										}
									},
									{
										field : 'textbookFee_id',
										title : '教材',
										width : "10%",
										align : 'center'
									},
									{
										field : 'operate',
										title : '交易类型',
										width : "10%",
										align : 'center',
										formatter : function(value, row) {
											switch (value) {
											case '1':
												return '入库';
											case '2':
												return '出库';
											}
										}
									},
									{
										field : 'number',
										title : '数量',
										width : "10%",
										align : 'center',
										formatter : function(value, row) {
											if(row.operate == 1){
												return value;
											}else{
												return -value;
											}
										}
									},
									{
										field : 'operateDate',
										title : '日期',
										width : "10%",
										align : 'center'
									},
									{
										field : 'handler',
										title : '经办人',
										width : "10%",
										align : 'center'
									},
									{
										field : 'remark',
										title : '备注',
										width : "15%",
										align : 'center'
									},
									{
										title : '编辑',
										field : 'edit',
										width : "6%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<button onclick="editFun(\'{0}\');">编辑</button>',
															row.id);
										}
									},
									{
										title : '删除',
										field : 'delete',
										width : "4%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
															row.id);
										}
									} ] ],
							toolbar : '#toolbar',
						});

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<div id="toolbar" style="text-align: center; margin: 20px auto;">
		<form>
			<div class="tr">
				<div class="th">
					<select name="location" class="easyui-combobox"
						data-options="required:true,editable:false,panelHeight:'auto'"
						style="width: 100px;">
						<option value="qb">全部</option>
						<option value="1">库房</option>
						<option value="2"><%=sessionInfo.getUser().getSchool()%></option>
					</select>
				</div>
				<div class="th">
					<input type="text" class="easyui-combobox" name="textbookFee_id"
						style="width: 100px;" id="textbookFee_id"
						data-options="valueField:'id',textField:'nameM',url:'getKuCun',panelHeight:'auto',editable:false" />
				</div>
				<div class="th">
					<input style="width: 100px;" type="text" name="startTime"
						class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
				<div class="th">
					<input style="width: 100px;" type="text" name="endTime"
						class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
				<div class="th">
					<a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'ext-icon-zoom',plain:true"
						onclick="submit();">查询</a>
				</div>
			</div>
		</form>
	</div>
	<table id="grid" data-options="border:false"></table>
</body>
</html>