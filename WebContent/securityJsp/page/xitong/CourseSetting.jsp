<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程设置</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var addFun = function(target) {
		var title = "";
		var url = "";
		if ($(target).attr("id") == "addCourseType") {
			title = "添加课程类"
			url = cxw.contextPath + '/securityJsp/page/form/courseTypeForm.jsp';
		} else if ($(target).attr("id") == "addCourse") {
			title = "添加课程";
			url = cxw.contextPath + '/securityJsp/page/form/courseForm.jsp';
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
			title = "编辑课程类"
			url = cxw.contextPath
					+ '/securityJsp/page/form/courseTypeForm.jsp?courseTypeCode='
					+ code + '&type=' + type;
		} else if (type == "2") {
			title = "编辑课程";
			url = cxw.contextPath
					+ '/securityJsp/page/form/courseForm.jsp?courseCode='
					+ code + '&type=' + type;
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
			url = "deleteCourseType";
			title = "你确定要删除这个课程大类嘛?";
		} else if (type == "2") {
			url = "deleteCourse";
			title = "你确定要删除这个课程嘛?";
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
											url : 'getAllCourses',
											pagePosition : 'bottom',
											pagination : true,
											striped : true,
											rownumbers : true,
											fitColumns : true,
											nowrap : false,
											idField : 'courseCode',
											pageSize : 20,
											pageList : [ 10, 20, 30, 40, 50,
													100, 200, 300, 400, 500 ],
											columns : [ [
													{
														title : '课程大类',
														field : 'courseTypeName',
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
																			row.courseTypeCode,
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
																			row.courseTypeCode,
																			'1');
														}
													},
													{
														title : '课程',
														field : 'courseName',
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
																			row.courseCode,
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
																			row.courseCode,
																			'2');
														}
													} ] ],
											toolbar : '#toolbar',
											onLoadSuccess : function(data) {
												$(this).datagrid(
														"autoMergeCells",
														[ 'courseTypeName',
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
			<div
				style="text-align: center; margin-top: 10px; margin-bottom: 10px">
				<div id="addCourseType" onclick="addFun(this);" class="add">
					<img alt="添加课程大类" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">添加课程大类</span>
				</div>
				<div id="addCourse" onclick="addFun(this);" class="add">
					<img alt="添加课程" src="../../../style/image/plus.png"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">添加课程</span>
				</div>
			</div>
		</div>
		<div style="text-align: center;">
			<table id="grid" style="margin-top: 10px;"
				data-options="border:false"></table>
		</div>
	</div>
	<table id="grid" data-options="border:false,fit:true"></table>
</body>
</html>