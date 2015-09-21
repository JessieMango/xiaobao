<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师课时</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
a {
	text-decoration: none;
	color: #000;
}

input[type='text'] {
	text-align: center;
}
</style>
<script type="text/javascript">
	var grid;
	
	/* 初始化页面 */
	function init() {
		$('#consultCourseCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#consultCourseCode').combobox('setValue',
									data[0].courseTypeCode);
						}
					}
				});
		
		$('#courseTypeCode1').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#courseTypeCode1').combobox('setValue',
									data[0].courseTypeCode);
						}
					},
					onSelect : function(data) {
						var url = 'getAllCourses?courseTypeCode='
								+ data.courseTypeCode;
						$('#courseCode1').combobox('reload', url);
					}
				});

		$('#courseCode1').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#courseCode1').combobox('setValue', data[0].courseCode);
				}
				if (data[0] == undefined) {
					$('#courseCode1').combobox('setValue', '');
				}
			}
		});
		
		grid = $('#grid')
				.datagrid(
						{
							url : '',
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
										field : '',
										checkbox : true,
										width : "5%",
										align : 'center'

									},
									{
										field : 'nameM',
										title : '姓名',
										width : "5%",
										align : 'center'

									} ] ],
							toolbar : '#toolbar',
							onBeforeLoad : function(param) {
								var varify = cxw.checkStartTimeBeforeEndTime(
										'#startTime', '#endTime');
								if (!varify)  {
									$.messager.alert('警告', '结束时间要大于开始时间',
											'warning');
								}
							},
							onSortColumn : function(sort, order) {
							},
							onLoadSuccess : function(data) {
							}
						});

		var perDate = firstOfMouthDate();
		
		$("#startTime").datebox("setValue", perDate);
		
	}

	$(document).ready(function() {
		init();		
		grid.datagrid('load',cxw.serializeObject($('#form')));
		
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">

		<div id="toolbar" style="display: none;">
			<form id="form">
				<div style="margin-top: 10px; margin-bottom: 5px">
					<div style="margin-left: 15%;">
						<input type="text" id="startTime" name="startTime"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />到<input
							style="width: 100px;" type="text" id="endTime" name="endTime"
							class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />&nbsp;&nbsp;
						
						

					</div>
					<div style="margin-left: 15%; margin-top: 10px;">
					
					
						<input class="easyui-combobox" name="consultCourseCode"
							style="width: 215px;" id="consultCourseCode"
							data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />&nbsp;&nbsp;
							
						&nbsp;<input id="courseCode1"	data-options="required:true,valueField:'courseCode',textField:'courseName',url:'getAllCourses?courseTypeCode=qb',panelHeight:'auto',editable:false"
						class="easyui-combobox" style="width: 220px;" name="courseCode1" />
						
						<input id="willDegreeCode" class="easyui-combobox"
							name="willDegreeCode" style="width: 100px;"
							data-options="valueField:'willDegreeCode',textField:'willDegree',url:'getWillDegree?type=1',panelHeight:'auto',editable:false" />
						&nbsp;&nbsp;<input class="easyui-combobox" id="sellerCode"
							name="sellerCode" style="width: 100px;"
							data-options="valueField:'sellerCode',textField:'seller',url:'getSeller?type=1',panelHeight:'auto',editable:false " />
					&nbsp; <a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							
							
							onclick="grid.datagrid('load',cxw.serializeObject($('#form')));">查询</a>
					</div>
				</div>
			</form>
		</div>
		<table id="grid" data-options="border:false,fit:true"></table>
	</div>
</body>
</html>