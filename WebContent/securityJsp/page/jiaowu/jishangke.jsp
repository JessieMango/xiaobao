<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记上课</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
a {
	text-decoration: none;
	color: #000;
}
</style>
<script type="text/javascript">
	var grid;

	var deleteFun = function(classCode) {
		$.post("deleteClass", {
			classCode : classCode
		}, function(result) {
			if (result.success) {
				grid.datagrid('load');
			} else {
				parent.$.messager.alert('提示', result.msg, 'error');
				grid.datagrid('load');
			}
		});
	}
	function init() {
		$('#schoolCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#schoolCode').combobox('setValue', data[0].schoolCode);
				}
			}
		});
		$('#courseTypeCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#courseTypeCode').combobox('setValue',
									data[0].courseTypeCode);
						}
					}
				});
		$('#teacherCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#teacherCode').combobox('setValue', data[0].userId);
				}
			}
		});
		$('#classRoomCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#classRoomCode').combobox('setValue',
									data[0].classRoomCode);
						}
					}
				});

		grid = $('#grid')
				.datagrid(
						{
							url : 'getClass',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							idField : 'classCode',
							singleSelect : true,
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [
									{
										field : 'nameM',
										title : '班级名称',
										width : "15%",
										align : 'center'

									},
									{
										field : 'teacherName',
										title : '教师',
										width : "6%",
										align : 'center'
									},
									{
										field : 'courseName',
										title : '课程',
										width : "15%",
										align : 'center'
									},
									{
										field : 'startDate',
										title : '开班',
										width : "7%",
										align : 'center',
										formatter : function(value, row) {
											if (row.dateUndetermined == 1) {
												return '待定';
											} else {
												return value;
											}
										}
									},
									{
										field : 'weekString',
										title : '时段',
										width : "18%",
										align : 'center'
									},
									{
										field : 'schoolName',
										title : '校区',
										width : "8%",
										align : 'center'
									},
									{
										field : 'classRoomName',
										title : '教室',
										width : "6%",
										align : 'center'
									},
									{
										field : 'tuition',
										title : '学费',
										width : "10%",
										align : 'center',
										formatter : function(value, row) {
											if (row.tuitionType == 1) {
												return value + '/按期';
											} else if (row.tuitionType == 2) {
												return value + '/按次';
											} else if (row.tuitionType == 3) {
												return value + '/按时间';
											}
										}
									},
									{
										title : '操作',
										field : 'edit',
										width : "14%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<button onclick=""><img src="../../../style/image/plus_1.png" alt="记上课" width="16" height="16" border="0" align="absbottom" /><span class="F_Red"><b>记上课</b></span></button>',
															row.classCode);
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
								parent.$.messager.progress('close');
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
					<div style="text-align: center;">
						<b><label for="nameM">班级名称&nbsp;</label></b><input type="text"
							name="nameM" class="easyui-validatebox" />&nbsp; <a
							href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form1')));">查询</a>
					</div>
				</form>
			</div>
			<form id="form2">
				<div style="margin-top: 20px; text-align: center;">
					<div style="display: inline-table; text-align: center;">
						<input id="schoolCode" class="easyui-combobox"
							style="width: 100px;" name="schoolCode"
							data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
						&nbsp; <input class="easyui-combobox" name="courseTypeCode"
							style="width: 200px;" id="courseTypeCode"
							data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />
						&nbsp; <input class="easyui-combobox" name="teacherCode"
							style="width: 100px;" id="teacherCode"
							data-options="valueField:'userId',textField:'username',url:'getUsersByRoleId?roleId=4&combo=true',panelHeight:'auto',editable:false" />
						&nbsp; <select name="tuitionType" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部模式</option>
							<option value="1">按期</option>
							<option value="2">按次</option>
							<option value="3">按时间</option>
						</select> &nbsp; <select name="week" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部时间</option>
							<option value="7">周日</option>
							<option value="6">周六</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
							<option value="3">周三</option>
							<option value="2">周二</option>
							<option value="1">周一</option>
						</select>
					</div>
					<div style="margin-top: 10px; text-align: inherit;">
						<select name="classState" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部状态</option>
							<option value="0">未开课</option>
							<option value="1">上课中</option>
							<option value="2">已结课</option>
						</select>&nbsp; <select name="year" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部年份</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
							<option value="2021">2021</option>
							<option value="2022">2022</option>
							<option value="2023">2023</option>
							<option value="2024">2024</option>
							<option value="2025">2025</option>
						</select> &nbsp; <select name="month" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部月份</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select> &nbsp; <input class="easyui-combobox" name="classRoomCode"
							style="width: 100px;" id="classRoomCode"
							data-options="valueField:'classRoomCode',textField:'classRoomName',url:'getClassRooms?type=1',panelHeight:'auto',editable:false" />
						&nbsp;<select name="order" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="1">开班排序</option>
							<option value="2">教师排序</option>
							<option value="3">教室排序</option>
							<option value="4">模式排序</option>
						</select> &nbsp;<a href="javascript:void(0);" style="width: 100px;"
							class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form2')));">查询</a>
					</div>
				</div>
			</form>
		</div>
		<table id="grid" data-options="border:false,fit:true"></table>
	</div>

</body>
</html>