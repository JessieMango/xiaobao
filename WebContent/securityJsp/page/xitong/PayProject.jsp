<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;

	var addFun = function(target) {
		var title = "";
		var url = "";
		if ($(target).attr("id") == "addEP") {
			title = "添加支出大类"
			url = cxw.contextPath
					+ '/securityJsp/page/form/ExpenditureForm.jsp';
		} else if ($(target).attr("id") == "addE") {
			title = "添加支出子项";
			url = cxw.contextPath + '/securityJsp/page/form/EProjectForm.jsp';
		}
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 400,
			height : 200,
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

	var editFun = function(code, type) {
		var title = "";
		var url = "";
		if (type == "1") {
			title = "编辑支出大类"
			url = cxw.contextPath
					+ '/securityJsp/page/form/ExpenditureForm.jsp?expenditureCode='
					+ code + '&type=' + type;
		} else if (type == "2") {
			title = "编辑支出子项";
			url = cxw.contextPath
					+ '/securityJsp/page/form/EProjectForm.jsp?id=' + code
					+ '&type=' + type;
		}
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 400,
			height : 200,
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
		var url = "";
		var title = "";
		if (type == "1") {
			url = "deleteExpenditure";
			title = "你确定要删除这个大类嘛?";
		} else if (type == "2") {
			url = "deleteExpenditureProject";
			title = "你确定要删除这个支出项目嘛?";
		}
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

	$(document)
			.ready(
					function() {

						grid = $('#grid')
								.datagrid(
										{
											url : 'getAllExpenditureProjects',
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
														title : '支出大类',
														field : 'expenditureName',
														width : "30%",
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
													},
													{
														title : '支出项目',
														field : 'expenditureProjectName',
														width : "30%",
														align : 'center'
													},
													{
														title : '编辑',
														field : 'edit2',
														width : "10%",
														align : 'center',
														formatter : function(
																value, row) {
															return cxw
																	.formatString(
																			'<span onclick="editFun(\'{0}\',\'{1}\')">{2}</span>',
																			row.id,
																			'2',
																			'编辑');
														}
													},
													{
														title : '删除',
														field : 'delete2',
														width : "8%",
														align : 'center',
														formatter : function(
																value, row) {
															return cxw
																	.formatString(
																			'<img  alt="删除" onclick="deleteFun(\'{0}\',\'{1}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
																			row.id,
																			'2');
														}
													} ] ],toolbar : '#toolbar',
											onBeforeLoad : function(param) {
												parent.$.messager.progress({
													text : '数据加载中....'
												});
											},
											onLoadSuccess : function(data) {
												parent.$.messager
														.progress('close');
												$(this).datagrid(
														"autoMergeCells",
														[ 'expenditureName',
																'edit',
																'delete' ]);
											}
										});

					});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div id="toolbar">
		<div style="text-align: center;margin-top:10px;margin-bottom:10px">
			<div id="addEP" onclick="addFun(this);" class="add">
				<img alt="添加大类" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">添加大类</span>
			</div>
			<div id="addE" onclick="addFun(this);" class="add">
				<img alt="添加项目" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">添加项目</span>
			</div>
		</div>
		</div>
		<div style="text-align: center;">
			<table id="grid" style="margin-top: 10px;"
				data-options="border:false"></table>
		</div>
	</div>
	<table id="grid" data-options="border:false"></table>
</body>
</html>