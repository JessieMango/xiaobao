<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支出帐</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var addFun = function(id) {
		var title = "增加支出记录";
		var url = cxw.contextPath
		+ '/securityJsp/page/caiwu/zhichuzhangAdd.jsp?id='+id;
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 500,
			height : 600,
			url : url,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});

	}
	
	var editFun = function(id, type) {
		var title = "编辑支出记录"
		var url = cxw.contextPath
					+ '/securityJsp/page/caiwu/zhichuzhangEdit.jsp?id='
					+ id;
		
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 400,
			height : 400,
			url : url,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}

	var deleteFun = function(code, type) {
		var url = "deleteExpenseAccount";
		var title =  "你确定要删除这个大类嘛?";
		
		$.messager.confirm('确认', title, function(r) {
			if (r) {
				$.post(url, {
					code : code
				}, function(data) {
					if (!data.success) {
						parent.$.messager.alert('提示', data.msg, 'error');
						grid.datagrid('load');
					} else {
						grid.datagrid('load');
					}
				});
			}
		});
	}
	function init() {
		$('#schoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#schoolCode').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$('#schoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#schoolCode').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		
		$('#dHandlerNameM').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#dHandlerNameM').combobox('setValue',
									data[0].handlerCode);
						}
					}
				});
		$('#expenditureCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#expenditureCode').combobox('setValue',
									data[0].id);
						}
					},
					onSelect : function(data) {
						var url = 'getAllExpenditureProject?type='
								+ data.id;
						$('#expenditureProjectCode').combobox('reload', url);
					}
				});

		$('#expenditureProjectCode').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#expenditureProjectCode').combobox('setValue', data[0].id);
				}
				if (data[0] == undefined) {
					$('#expenditureProjectCode').combobox('setValue', '');
				}
			}
		});
		grid = $('#grid')
		.datagrid(
				{
					url : 'getExpenseAccount',
					pagePosition : 'bottom',
					pagination : true,
					striped : true,
					rownumbers : true,
					fitColumns : true,
					nowrap : false,
					idField : 'id',
					pageSize : 20,
					pageList : [ 10, 20, 30, 40, 50,
							100, 200, 300, 400, 500 ],
					columns : [ [
							{
								title : '日期',
								field : 'payDate',
								width : "10%",
								align : 'center'
							},
							{
								title : '校区',
								field : 'schoolName',
								width : "10%",
								align : 'center'
							},
							{
								title : '支出大类',
								field : 'expenditureNameM',
								width : "10%",
								align : 'center'
							},
							{
								title : '支出项目',
								field : 'expenditureProjectID',
								width : "10%",
								align : 'center'
							},
							{
								title : '金额',
								field : 'moneyAmount',
								width : "10%",
								align : 'center'
							},
							{
								title : '备注',
								field : 'remarks',
								width : "10%",
								align : 'center'
							},
							{
								title : '经办人',
								field : 'dHandlerNameM',
								width : "10%",
								align : 'center'
							},
							{
								title : '编辑',
								field : 'edit',
								width : "10%",
								align : 'center',
								formatter : function(
										value, row) {
									return cxw
											.formatString(
													'<span onclick="editFun(\'{0}\',\'{1}\')">{2}</span>',
													row.expenditureCode,
													'1',
													'编辑');
								}
							},
							{
								title : '删除',
								field : 'delete',
								width : "8%",
								align : 'center',
								formatter : function(
										value, row) {
									return cxw
											.formatString(
													'<img  alt="删除" onclick="deleteFun(\'{0}\',\'{1}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
													row.expenditureCode,
													'1');
								}
							}
							 ] ],
					onBeforeLoad : function(param) {
						parent.$.messager.progress({
							text : '数据加载中....'
						});
					},
					onLoadSuccess : function(data) {
						parent.$.messager
								.progress('close');
					}
				});

	}
	$(document)
			.ready(	function() {
				init();
					});
	</script>
</head>
<body>
<div data-options="region:'center',fit:true,border:false">
	<div id="addE" onclick="addFun(this);" class="add">
		<img alt="记录支出" src="../../../style/image/plus.png"
			style="vertical-align: middle;"> <span
			style="vertical-align: middle;">添加项目</span>
	</div>
		<div>
			<form id="form2">
				<div style="margin-top: 20px;">
					<div style="margin-left: 15%;">
						<input type="text" id="startTime" name="startTime"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,value:'getPreOneMonths();'" />到<input
							style="width: 100px;" type="text" id="endTime" name="endTime"
							class="easyui-datebox" data-options="required:true,value:'getCurrentDate();'" />&nbsp;&nbsp;
						<label>支出校区:</label>&nbsp;<input style="width: 100px;" class="easyui-combobox"
							name="schoolCode" id="schoolCode"
							data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false"/>
						&nbsp; <label>支出大类:</label>&nbsp;<input class="easyui-combobox" name="expenditureCode"
							style="width: 100px;" id="expenditureCode"
							data-options="valueField:'id',textField:'nameM',url:'getAllExpenditure?type=1',panelHeight:'auto',editable:false"/>
						&nbsp; <label>支出项目:</label>&nbsp;<input id="expenditureProjectCode" class="easyui-combobox"
							style="width: 100px;" name="expenditureProjectCode"
							data-options="valueField:'id',textField:'nameM',url:'',panelHeight:'auto',editable:false"/>
						&nbsp; <label>经办人：</label>&nbsp;<input name="dHandlerNameM" id="dHandlerNameM" class="easyui-combobox" 
							data-options="valueField:'handlerCode',textField:'handler',url:'getHandler?type=1',panelHeight:'auto',editable:false"/>
							&nbsp;<label>备注：</label>&nbsp;<input type="text" id="remarks" name="remarks" />
							 &nbsp; <a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form2')));">查询</a>
					</div>
				</div>
			</form>
		</div>
		</div>
	<div>
		<table id="grid" data-options="border:false"></table>
	</div>
</body>
</html>