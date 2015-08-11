<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
a {
	text-decoration: none;
	color: #000;
}
</style>
<script type="text/javascript">
	var grid;
	var deleteFun = function(id) {
		$.post("deleteConsult", {
			id : id
		}, function(result) {
			if (result.success) {
				grid.datagrid('load');
			} else {
				parent.$.messager.alert('提示', result.msg, 'error');
				grid.datagrid('load');
			}
		});
	}
	
	var addFun = function(id){
		window.location.href = 'addCommunication.jsp?id='+id;
	}
	
	var showFun = function(id){
		window.location.href = 'showCommunication.jsp?id='+id;
	}
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
		$('#willDegreeCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#willDegreeCode').combobox('setValue',
									data[0].willDegreeCode);
						}
					}
				});
		$('#markCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#markCode').combobox('setValue', data[0].markCode);
				}
			}
		});
		$('#consultWayCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#consultWayCode').combobox('setValue',
									data[0].consultWayCode);
						}
					}
				});
		$('#sellSourceCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#sellSourceCode').combobox('setValue',
									data[0].sellSourceCode);
						}
					}
				});
		$('#handlerCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handlerCode').combobox('setValue',
									data[0].handlerCode);
						}
					}
				});
		$('#sellerCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#sellerCode').combobox('setValue', data[0].sellerCode);
				}
			}
		});
		$('#handleSchoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode').combobox('setValue',
									data[0].schoolCode);
						}
						grid.datagrid('load',cxw.serializeObject($('#form2')));
					}
				});

		grid = $('#grid')
				.datagrid(
						{
							url : 'getConsult',
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
										field : 'gender',
										title : '性别',
										width : "3%",
										formatter : function(value, row, index) {
											switch (value) {
											case '0':
												return '<img alt="男" style="vertical-align: middle;" src="../../../style/image/male.png">';
											case '1':
												return '<img alt="女" src="../../../style/image/female.png">';
											}
										}
									},
									{
										field : 'nameM',
										title : '姓名',
										width : "5%",
										align : 'center'

									},
									{
										field : 'birthday',
										title : '年龄',
										width : "5%",
										align : 'center',
										formatter : function(value, row) {
											return value + "岁";
										}
									},
									{
										field : 'otherTel',
										title : '手机号',
										width : "7%",
										align : 'center'
									},
									{
										field : 'willDegree',
										title : '意向',
										width : "4%",
										align : 'center'
									},
									{
										field : 'consultCourse',
										title : '课程',
										width : "8%",
										align : 'center'
									},
									{
										field : 'consultWay',
										title : '方式',
										width : "6%",
										align : 'center'
									},
									{
										field : 'sellSource',
										title : '来源',
										width : "8%",
										align : 'center'
									},
									{
										field : 'mark',
										title : '标记',
										width : "5%",
										align : 'center'
									},
									{
										field : 'seller',
										title : '销售员',
										width : "5%",
										align : 'center'
									},
									{
										field : 'notes',
										title : '沟通记录',
										width : "8%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<input value="+" type="reset" style="width:24px; margin-right:4px;" onclick="addFun(\'{0}\')" /><input type="button" value="查看" style="color:black; font-weight:bold; width:60px;" onclick="showFun(\'{1}\')" />',
															row.id, row.id);
										}
									},
									{
										field : 'state',
										title : '报名',
										width : "6%",
										align : 'center',
										formatter : function(value, row) {
											if (value == 0) {
												return cxw
														.formatString(
																'<input type="reset" value="办报名" style="color:black; font-weight:bold; width:60px;" onclick="editFun(\'{0}\')" />',
																row.id);
											} else {
												return '<img  alt="已报名"  style="vertical-align: middle;" src="../../../style/image/YES.gif" />';
											}
										}
									},
									{
										field : 'handleSchool',
										title : '经办学校',
										width : "6%",
										align : 'center'
									},
									{
										field : 'handler',
										title : '经办人',
										width : "6%",
										align : 'center'
									},
									{
										field : 'consultDate',
										title : '日期',
										width : "6%",
										align : 'center'
									},
									{
										title : '编辑',
										field : 'edit',
										width : "6%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<a href="xinzixun.jsp?id={0}">编辑</a>',
															row.id);
										}
									},
									{
										title : '删除',
										field : 'delete',
										width : "4%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
															row.id);
										}
									} ] ],
							onBeforeLoad : function(param) {
								var varify = cxw.checkStartTimeBeforeEndTime(
										'#startTime', '#endTime');
								if (varify) {
									parent.$.messager.progress({
										text : '数据加载中....'
									});
								} else {
									$.messager.alert('警告', '结束时间要大于开始时间',
											'warning');
								}
							},
							onSortColumn : function(sort, order) {
							},
							onLoadSuccess : function(data) {
								parent.$.messager.progress('close');
							}
						});
		
		var perDate = getPreThreeDate();
		$("#startTime").datebox("setValue",perDate);
	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div>
			<form id="form1">
				<div style="text-align: center;">
					<b><label for="nameM">学员完整姓名</label></b><input type="text"
						name="nameM" class="easyui-validatebox" />&nbsp; <b><label
						for="telTail">学员电话尾号</label></b><input type="text" name="telTail"
						class="easyui-validatebox" />&nbsp; <a href="javascript:void(0);"
						class="easyui-linkbutton"
						data-options="iconCls:'ext-icon-zoom',plain:true"
						onclick="grid.datagrid('load',cxw.serializeObject($('#form1')));">查询</a>
				</div>
			</form>
		</div>
		<div>
			<form id="form2">
				<div style="margin-top: 20px;">
					<div style="margin-left: 15%;">
						<input type="text" id="startTime" name="startTime"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />到<input
							style="width: 100px;" type="text" id="endTime" name="endTime"
							class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />&nbsp;&nbsp;
						<input style="width: 100px;" class="easyui-combobox"
							name="markCode" id="markCode"
							data-options="valueField:'markCode',textField:'mark',url:'getMark?type=1',panelHeight:'auto',editable:false" />
						&nbsp; <input class="easyui-combobox" name="consultWayCode"
							style="width: 100px;" id="consultWayCode"
							data-options="valueField:'consultWayCode',textField:'consultWay',url:'getConsultWay?type=1',panelHeight:'auto',editable:false" />
						&nbsp; <input id="handleSchoolCode" class="easyui-combobox"
							style="width: 100px;" name="handleSchoolCode"
							data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
						&nbsp; <select name="state" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部状态</option>
							<option value="1">已报名</option>
							<option value="0">未报名</option>
						</select> &nbsp;<select name="order" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="1">日期排序</option>
							<option value="2">方式排序</option>
							<option value="3">来源排序</option>
							<option value="4">课程排序</option>
							<option value="5">经办排序</option>
						</select> &nbsp; <a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form2')));">查询</a>

					</div>
					<div style="margin-left: 15%; margin-top: 10px;">
						<input class="easyui-combobox" name="consultCourseCode"
							style="width: 215px;" id="consultCourseCode"
							data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />&nbsp;&nbsp;
						<input id="willDegreeCode" class="easyui-combobox"
							name="willDegreeCode" style="width: 100px;"
							data-options="valueField:'willDegreeCode',textField:'willDegree',url:'getWillDegree?type=1',panelHeight:'auto',editable:false" />
						&nbsp;<input class="easyui-combobox" name="sellSourceCode"
							id="sellSourceCode" style="width: 100px;"
							data-options="valueField:'sellSourceCode',textField:'sellSource',url:'getSellSource?type=1',panelHeight:'auto',editable:false" />&nbsp;&nbsp;
						<input class="easyui-combobox" name="handlerCode" id="handlerCode"
							style="width: 100px;"
							data-options="valueField:'handlerCode',textField:'handler',url:'getHandler?type=1',panelHeight:'auto',editable:false" />
						&nbsp;&nbsp;<input class="easyui-combobox" id="sellerCode"
							name="sellerCode" style="width: 100px;"
							data-options="valueField:'sellerCode',textField:'seller',url:'getSeller?type=1',panelHeight:'auto',editable:false " />
					</div>
				</div>
			</form>
		</div>
		<div>
			<table id="grid" data-options="border:false"></table>
		</div>
	</div>

</body>
</html>