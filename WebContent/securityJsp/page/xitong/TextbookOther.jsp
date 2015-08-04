<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材杂项</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var gridBook;
	var gridFee;

	var addFun = function(target) {
		var title = "添加教材杂项";
		var url = cxw.contextPath
				+ '/securityJsp/page/form/TextBookFeeForm.jsp';
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 400,
			height : 300,
			url : url,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, gridBook, gridFee, parent.$);
				}
			} ]
		});

	}

	var editFun = function(id) {
		title = "编辑课程杂费"
		url = cxw.contextPath
				+ '/securityJsp/page/form/TextBookFeeForm.jsp?id=' + id
				+ '&type=edit';
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : title,
			width : 400,
			height : 300,
			url : url,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, gridBook, gridFee, parent.$);
				}
			} ]
		});
	}

	var deleteFun = function(id) {
		url = "deleteTextBookFee";
		title = "你确定要删除嘛?";
		$.messager.confirm('确认', title, function(r) {
			if (r) {
				$.post(url, {
					id : id
				}, function(data) {
					if (!data.success) {
						parent.$.messager.alert('提示', data.msg, 'error');
						gridBook.datagrid('load');
						gridFee.datagrid('load');
					} else {
						gridFee.datagrid('load');
						gridBook.datagrid('load');
					}
				});
			}
		});
	}

	$(document)
			.ready(
					function() {
						gridBook = $('#gridBook')
								.datagrid(
										{
											url : 'getAllTextBookFees?type=1',
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
														title : '教材名称',
														field : 'nameM',
														width : "20%",
														align : 'center'
													},
													{
														title : '对应课程',
														field : 'courseTypeName',
														width : "20%",
														align : 'center'
													},
													{
														title : '价格',
														field : 'price',
														width : "10%",
														align : 'center',
														formatter : function(
																value, row) {
															return '￥'+value;
														}
													},
													{
														title : '兑换',
														field : 'points',
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
																			'<span onclick="editFun(\'{0}\')">{1}</span>',
																			row.id,
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
																			'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
																			row.id);
														}
													} ] ],
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

						gridFee = $('#gridFee')
								.datagrid(
										{
											url : 'getAllTextBookFees?type=2',
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
														title : '杂费名称',
														field : 'nameM',
														width : "20%",
														align : 'center'
													},
													{
														title : '对应课程',
														field : 'courseTypeName',
														width : "20%",
														align : 'center'
													},
													{
														title : '价格',
														field : 'price',
														width : "10%",
														align : 'center',
														formatter : function(
																value, row) {
															return '￥'+value;
														}
													},
													{
														title : '兑换',
														field : 'points',
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
																			'<span onclick="editFun(\'{0}\')">{1}</span>',
																			row.id,
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
																			'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
																			row.id);
														}
													} ] ],
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

					});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">

	<div data-options="region:'center',fit:true,border:false">
		<div
			style="width: 45%; float: left; margin-left: 20px; text-align: center; margin-top: 20px;">
			<div id="addTextBook" onclick="addFun(this);" class="add">
				<img alt="添加教材项" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">添加教材项</span>
			</div>
			<div style="margin-top: 20px;">
				<table id="gridBook" data-options="border:false"></table>
			</div>

		</div>
		<div
			style="width: 45%; float: right; margin-right: 20px; text-align: center; margin-top: 20px;">
			<div id="addFee" onclick="addFun(this);" class="add">
				<img alt="添加杂费项" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">添加杂费项</span>
			</div>
			<div style="margin-top: 20px;">
				<table id="gridFee" data-options="border:false"></table>
			</div>
		</div>
	</div>
</body>
</html>