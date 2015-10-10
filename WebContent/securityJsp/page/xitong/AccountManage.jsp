<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var resetPassword = function(userId, username) {
		$.messager.alert('重置密码', '新密码:123', 'info', function(r) {
			$.post("resetPwd", {
				id : userId
			}, function(data) {
				if (data.success == true) {
					$.messager.show({
						title : '重置密码',
						msg : '重置密码成功',
						timeout : 3000,
						showType : 'slide'
					});
				} else {
					$.messager.show({
						title : '重置密码',
						msg : '重置密码失败',
						timeout : 3000,
						showType : 'slide'
					});
				}
			});
		});
	}
	var editFun = function(userId, username, roleId) {
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : username,
			width : 660,
			height : 400,
			url : cxw.contextPath
					+ '/securityJsp/page/form/editUserForm.jsp?userId='
					+ userId + '&roleId=' + roleId,
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}

	var deleteFun = function(userId) {
		$.messager.confirm('确认', '你确定要删除这个账号吗?', function(r) {
			if (r) {
				$.post("deleteUser", {
					id : userId
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

	var addFun = function(target) {
		var level, levelName;
		var id = $(target).attr('id');
		if (id == 'permission1') {
			level = 0;
			levelName = '最高';
		} else if (id == 'permission2') {
			level = 1;
			levelName = '财务';
		} else if (id == 'permission3') {
			level = 2;
			levelName = '人事';
		} else if (id == 'permission4') {
			level = 3;
			levelName = '财务';
		} else if (id == 'permission5') {
			level = 4;
			levelName = '教师';
		} else if (id == 'permission6') {
			level = 5;
			levelName = '多校主管';
		} else if (id == 'permission7') {
			level = 6;
			levelName = '主管';
		} else if (id == 'permission8') {
			level = 7;
			levelName = '前台';
		} else if (id == 'permission9') {
			level = 8;
			levelName = '市场';
		} else if (id == 'permission10') {
			level = 9;
			levelName = '销售';
		}
		var dialog = parent.cxw.modalDialog({
			title : '账号权限',
			width : 660,
			height : 400,
			url : cxw.contextPath
					+ '/securityJsp/page/form/addUserForm.jsp?level=' + level
					+ '&levelName=' + levelName,
			buttons : [ {
				text : '添加',
				left : true,
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}
	$(document)
			.ready(
					function() {
						grid = $('#grid')
								.datagrid(
										{
											url : 'getAllUsers',
											striped : true,
											singleSelect : true,
											pagination : true,
											rownumbers : true,
											nowrap : false,
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
																					'<span onclick="editFun(\'{0}\',\'{1}\',\'{2}\')">{3}</span>',
																					row.userId,
																					row.username,
																					row.roleId,
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
											toolbar : '#toolbar'
										});
					});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">

		<div id="chart"></div>
		<div id="toolbar">
			<div style="padding: 20px; padding: 10px; text-align: center;">
				<div id="permission1" onclick="addFun(this);" class="add">
					<img alt="最高权限" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">最高权限</span>
				</div>
				<div id="permission2" onclick="addFun(this);" class="add">
					<img alt="财务权限" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">财务权限</span>
				</div>
				<div id="permission3" onclick="addFun(this);" class="add">
					<img alt="人事权限" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">人事权限</span>
				</div>
				<div id="permission4" onclick="addFun(this);" class="add">
					<img alt="教务权限" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">教务权限</span>
				</div>
				<div id="permission5" onclick="addFun(this);" class="add">
					<img alt="教师权限" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">教师权限</span>
				</div>
				<div id="permission6" onclick="addFun(this);" class="add">
					<img alt="多校主管" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">多校主管</span>
				</div>
				<div id="permission7" onclick="addFun(this);" class="add">
					<img alt="单校主管" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">单校主管</span>
				</div>
				<div id="permission8" onclick="addFun(this);" class="add">
					<img alt="校区前台" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">前台咨询</span>
				</div>
				<div id="permission9" onclick="addFun(this);" class="add">
					<img alt="市场主管" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">市场主管</span>
				</div>
				<div id="permission10" onclick="addFun(this);" class="add">
					<img alt="销售员" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">销售员</span>
				</div>
			</div>
		</div>
		<table id="grid" data-options="border:false,fit:true"></table>

	</div>
</body>
</html>
