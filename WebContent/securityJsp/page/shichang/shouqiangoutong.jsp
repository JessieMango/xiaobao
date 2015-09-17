<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>售前沟通</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
a {
	text-decoration: none;
	color: #000;
}
</style>
<script type="text/javascript">
	var grid;

	var deleteFun = function(id) {
		parent.$.messager.progress({
			text : '删除中....'
		});
		$.post("deleteCommunicationById", {
			id : id
		}, function(result) {
			if (result.success) {
				parent.$.messager.progress('close');
				grid.datagrid('load');
			} else {
				parent.$.messager.progress('close');
				parent.$.messager.alert('提示', result.msg, 'error');
				grid.datagrid('load');
			}
		});
	}

	/* 初始化页面 */
	function init() {
		$('#handlerCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handlerCode').combobox('setValue',
									data[0].handlerCode);
						}
					}
				});
		$('#handleSchoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$('#communicationType').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#communicationType').combobox('setValue',
									data[0].communicationType);
						}
					}
				});

		grid = $('#grid')
				.datagrid(
						{
							url : 'getCommunications',
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
										field : 'nameM',
										title : '姓名',
										width : "6%",
										align : 'center'

									},
									{
										field : 'otherTel',
										title : '手机号',
										width : "8%",
										align : 'center'
									},
									{
										field : 'communicationTypeName',
										title : '沟通类型',
										width : "7%",
										align : 'center'
									},
									{
										field : 'communicationContent',
										title : '沟通内容',
										width : "15%",
										align : 'center'
									},
									{
										field : 'communicationResult',
										title : '沟通结果',
										width : "15%",
										align : 'center'
									},
									{
										field : 'returnVisitDate',
										title : '回访日期',
										width : "8%",
										align : 'center'
									},
									{
										field : 'handleSchool',
										title : '经办学校',
										width : "7%",
										align : 'center'
									},
									{
										field : 'handler',
										title : '沟通人',
										width : "6%",
										align : 'center'
									},
									{
										field : 'communicationDate',
										title : '沟通日期',
										width : "8%",
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
															'<a href="../qiantai/addCommunication.jsp?commuId={0}&id={1}&type={2}">编辑</a>',
															row.id,
															row.consultId,
															"editg");
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
							onBeforeLoad : function(param) {
								var varify = cxw.checkStartTimeBeforeEndTime(
										'#startTime', '#endTime');
								if (!varify) {
									$.messager.alert('警告', '结束时间要大于开始时间',
											'warning');
								}
							}
						});

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div id="toolbar">
			<div>
				<form id="form1">
					<div style="text-align: center; margin-top: 10px">
						<b><label for="nameM">学员完整姓名</label></b><input type="text"
							name="nameM" class="easyui-validatebox" />&nbsp; <b><label
							for="telTail">学员电话尾号</label></b><input type="text" name="telTail"
							class="easyui-validatebox" />&nbsp; <a
							href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form1')));">查询</a>
					</div>
				</form>
			</div>
			<div>
				<form id="form2">
					<div style="margin-top: 10px;">
						<div style="margin-left: 15%;">
							<label>沟通日期</label> &nbsp;&nbsp;&nbsp;<input type="text"
								id="startTime" name="startTime" style="width: 100px;"
								class="easyui-datebox"
								data-options="required:true,value:'getPreOneMonths();'" />到<input
								style="width: 100px;" type="text" id="endTime" name="endTime"
								class="easyui-datebox"
								data-options="required:true,value:'getCurrentDate();'" />&nbsp;&nbsp;
							<input id="communicationType" class="easyui-combobox"
								style="width: 100px;" name="communicationType"
								data-options="valueField:'communicationType',textField:'communicationTypeName',url:'getCommunicationType?type=1&flag=select',panelHeight:'auto',editable:false" />
							<input id="handleSchoolCode" class="easyui-combobox"
								style="width: 100px;" name="handleSchoolCode"
								data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
							&nbsp; <input class="easyui-combobox" name="handlerCode"
								id="handlerCode" style="width: 100px;"
								data-options="valueField:'handlerCode',textField:'handler',url:'getHandler?type=1',panelHeight:'auto',editable:false" />
							&nbsp;<select name="order" class="easyui-combobox"
								data-options="required:true,editable:false,panelHeight:'auto'"
								style="width: 100px;">
								<option value="1">日期排序</option>
								<option value="2">方式排序</option>
								<option value="3">经办排序</option>
							</select> &nbsp; <a href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-zoom',plain:true"
								onclick="grid.datagrid('load',cxw.serializeObject($('#form2')));">查询</a>

						</div>
					</div>
				</form>
			</div>
		</div>
		<table id="grid" data-options="border:false,fit:true"></table>
	</div>

</body>
</html>