<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号管理</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var resetPassword = function(userId, username) {
		$('#dd').dialog(
				{
					title : '重置密码',
					width : 400,
					height : 200,
					closed : false,
					cache : false,
					href : cxw.contextPath
							+ '/securityJsp/form/resetPassword.jsp?username='
							+ username + '&userId=' + userId,
					modal : true
				});
	}
	var editFun = function(userId, username) {
		var dialog = parent.cxw.modalDialog({
			title : username,
			url : cxw.contextPath + '/securityJsp/form/userForm.jsp?userId='
					+ userId + '&username=' + username,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}
	var deleteFun = function(userId) {
		alert(userId);
	}
	$(document)
			.ready(
					function() {
						grid = $('#grid')
								.datagrid(
										{
											url : 'getAllUsers',
											pagePosition : 'bottom',
											pagination : true,
											striped : true,
											rownumbers : true,
											idField : 'userId',
											pageSize : 20,
											pageList : [ 10, 20, 30, 40, 50,
													100, 200, 300, 400, 500 ],
											columns : [
													[
															{
																title : '账户名',
																colspan : 2,
															},
															{
																field : 'scope',
																title : '范围',
																width : "6%",
																align : 'center',
																rowspan : 2
															},
															{
																title : '权限',
																colspan : 2
															},
															{
																field : 'isEnabled',
																title : '状态',
																width : "6%",
																align : 'center',
																rowspan : 2,
																formatter : function(
																		value,
																		row,
																		index) {
																	switch (value) {
																	case '0':
																		return '禁用';
																	case '1':
																		return '启用';
																	}
																}
															},
															{
																field : 'tel',
																title : '手机号',
																width : "8%",
																align : 'center',
																rowspan : 2
															},
															{
																field : 'loginDate',
																title : '登录日期',
																width : "10%",
																align : 'center',
																rowspan : 2
															},
															{
																title : '登录时限',
																colspan : 2
															},
															{
																field : 'carCode',
																title : '磁卡',
																width : "10%",
																align : 'center',
																rowspan : 2
															},
															{
																field : 'action',
																title : '操作',
																colspan : 3,
																align : 'center'
															} ],
													[
															{
																title : '性别',
																field : 'gender',
																width : "4%",
																align : 'center',
																formatter : function(
																		value,
																		row,
																		index) {
																	switch (value) {
																	case '0':
																		return '<img alt="男" style="vertical-align: middle;" src="../../../style/image/male.png">';
																	case '1':
																		return '<img alt="女" src="../../../style/image/female.png">';
																	}
																}
															},
															{
																title : '姓名',
																field : 'username',
																width : "6%",
																align : 'center'
															},
															{
																title : '级别',
																field : 'power',
																width : "6%",
																align : 'center'
															},
															{
																title : '权限',
																field : 'permission',
																width : "12%",
																align : 'center'
															},
															{
																title : '开始时间',
																field : 'loginStartTime',
																width : "7%",
																align : 'center'
															},
															{
																title : '结束时间',
																field : 'loginEndTime',
																width : "7%",
																align : 'center'
															},
															{
																title : '修改密码',
																field : 'alter',
																width : "8%",
																align : 'center',
																formatter : function(
																		value,
																		row) {
																	return cxw
																			.formatString(
																					'<span onclick="resetPassword(\'{0}\',\'{1}\')">{2}</span>',
																					row.userId,
																					row.username,
																					'修改密码');
																}
															},
															{
																title : '编辑',
																field : 'edit',
																width : "4%",
																align : 'center',
																formatter : function(
																		value,
																		row) {
																	return cxw
																			.formatString(
																					'<span onclick="editFun(\'{0}\',\'{1}\')">{2}</span>',
																					row.userId,
																					row.username,
																					'编辑');
																}
															},
															{
																title : '删除',
																field : 'delete',
																width : "4%",
																align : 'center',
																formatter : function(
																		value,
																		row) {
																	return cxw
																			.formatString(
																					'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
																					row.userId);
																}
															} ] ],
											onBeforeLoad : function(param) {
												parent.$.messager.progress({
													text : '数据加载中....'
												});
											},
											onSortColumn : function(sort, order) {
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
		<div id="chart"></div>
		<div style="padding: 20px; padding: 10px; text-align: center;">
			<div id="permission1" class="addpermission">
				<img alt="最高权限" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">最高权限</span>
			</div>
			<div id="permission2" class="addpermission">
				<img alt="财务权限" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">财务权限</span>
			</div>
			<div id="permission3" class="addpermission">
				<img alt="人事权限" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">人事权限</span>
			</div>
			<div id="permission4" class="addpermission">
				<img alt="教务权限" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">教务权限</span>
			</div>
			<div id="permission5" class="addpermission">
				<img alt="教师权限" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">教师权限</span>
			</div>
			<div id="permission6" class="addpermission">
				<img alt="多校主管" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">多校主管</span>
			</div>
			<div id="permission7" class="addpermission">
				<img alt="单校主管" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">单管主管</span>
			</div>
			<div id="permission8" class="addpermission">
				<img alt="校区前台" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">校区前台</span>
			</div>
			<div id="permission9" class="addpermission">
				<img alt="市场主管" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">市场主管</span>
			</div>
			<div id="permission10" class="addpermission">
				<img alt="销售员" src="../../../style/image/plus.png"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">销售员</span>
			</div>
		</div>

		<table id="grid" style="margin-top: 10px;" data-options="border:false"></table>

		<div id="dd"></div>
	</div>
</body>
</html>
