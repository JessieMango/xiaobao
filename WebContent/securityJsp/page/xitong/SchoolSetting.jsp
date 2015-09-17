<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校区设置</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var editFun = function(schoolCode) {
		var dialog = parent.cxw.modalDialog({
			title : "设置校区",
			width : 500,
			height : 300,
			url : cxw.contextPath
					+ '/securityJsp/page/form/editSchoolForm.jsp?schoolCode='
					+ schoolCode,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}

	var deleteFun = function(schoolCode) {
		$.messager.confirm('确认', '你确定要删除这个账号吗?', function(r) {
			if (r) {
				$.post("deleteSchoolBySchoolCode", {
					schoolCode : schoolCode
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
											url : 'getAllSchools',
											pagePosition : 'bottom',
											pagination : true,
											striped : true,
											rownumbers : true,
											fitColumns : true,
											nowrap : false,
											idField : 'schoolCode',
											pageSize : 20,
											pageList : [ 10, 20, 30, 40, 50,
													100, 200, 300, 400, 500 ],
											columns : [ [
													{
														title : '类型',
														field : 'schoolType',
														width : "8%",
														align : 'center'
													},
													{
														title : '校区名',
														field : 'schoolName',
														width : "10%",
														align : 'center'
													},
													{
														title : '电话1',
														field : 'tel1',
														width : "15%",
														align : 'center'
													},
													{
														title : '电话2',
														field : 'tel2',
														width : "15%",
														align : 'center'
													},
													{
														title : '地址',
														field : 'address',
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
																			'<span onclick="editFun(\'{0}\')">{1}</span>',
																			row.schoolCode,
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
																			row.schoolCode);
														}
													} ] ]
										});

					});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">

		<table id="grid" style="margin-top: 10px;"
			data-options="border:false,fit:true"></table>
	</div>
</body>
</html>