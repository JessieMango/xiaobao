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
											fitColumns : true,
											fit : true,
											nowrap : false,
											idField : 'userId',
											pageSize : 20,
											pageList : [ 10, 20, 30, 40, 50,
													100, 200, 300, 400, 500 ],
											columns : [ [
													{
														title : '姓名',
														field : 'username',
														width : "150",
														align : 'center',
														fixed : true
													},
													{
														title : '性别',
														field : 'gender',
														width : "80",
														align : 'center',
														fixed : true,
														formatter : function(
																value, row,
																index) {
															switch (value) {
															case '0':
																return '<img alt="男" style="vertical-align: middle;" src="../../../style/image/male.png">';
															case '1':
																return '<img alt="女" src="../../../style/image/female.png">';
															}
														}
													}, {
														title : '级别',
														field : 'power',
														width : "120",
														align : 'center',
														fixed : true
													}, {
														field : 'scope',
														title : '范围',
														width : "130",
														align : 'center',
														fixed : true
													}, {
														field : 'tel',
														title : '手机号',
														width : "130",
														align : 'center',
														fixed : true
													}, {
														title : '权限',
														field : 'permission',
														width : "500",
														align : 'center',
														fixed : true
													} ] ],
											onBeforeLoad : function(param) {
												parent.$.messager.progress({
													text : '数据加载中....'
												});
											},
											onSortColumn : function(sort, order) {
											},
											onLoadSuccess : function(data) {
												$('.iconImg').attr('src',
														cxw.pixel_0);
												parent.$.messager
														.progress('close');
											}
										});
					});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div style="width: 80%; margin: 0 auto;">
			<table id="grid" data-options="border:false"></table>
		</div>
	</div>
</body>
</html>