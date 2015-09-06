<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兑换记录</title>
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
	var query2 = function() {
		if ($('#form2').form('validate')) {
			grid.datagrid('load', cxw.serializeObject($('#form2')));
		}
	}
	var deleteFun = function(id) {
		$.post("deleteFinancialRunnningAccount", {
			id : id,
			type : 1
		}, function(result) {
			if (result.success) {
				grid.datagrid('load');
			} else {
				parent.$.messager.alert('提示', result.msg, 'error');
				grid.datagrid('load');
			}
		});
	}
	var init = function() {
		$('#handleSchoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$('#operateCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#operateCode').combobox('setValue', data[0].id);
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
		$('#typeCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#typeCode').combobox('setValue', 3);
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
		$('#payWayCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#payWayCode').combobox('setValue', data[0].id);
				}
			}
		});
		grid = $('#grid')
				.datagrid(
						{
							url : 'getFinancialRunnningAccount',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							idField : 'id',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [

									{
										field : 'id',
										title : '交易号',
										width : "4%",
										align : 'center'

									},
									{
										field : 'operate',
										title : '操作',
										width : "6%",
										align : 'center'
									},
									{
										field : 'className',
										title : '科目',
										width : "10%",
										align : 'center'
									},
									{
										field : 'realMoney',
										title : '实付',
										width : "5%",
										align : 'center',
										formatter : function(value, row) {
											return "<span>￥</span>" + value;
										}

									},
									{
										field : 'payWay',
										title : '支付方式',
										width : "7%",
										align : 'center'
									},
									{
										field : 'balance',
										title : '余额',
										width : "6%",
										align : 'center',
										formatter : function(value, row) {
											return "￥" + value;
										}
									},
									{
										field : 'feeState',
										title : '到款',
										width : "4%",
										align : 'center',
										formatter : function(value, row) {
											if (value == 1) {
												return '<img  alt="已收款"  style="vertical-align: middle;" src="../../../style/image/YES.gif" />';
											} else {
												return '<img  alt="未收款"  style="vertical-align: middle;" src="../../../style/image/signmakeup.png" />';
											}
										}
									},
									{
										field : 'remark',
										title : '备注',
										width : "15%",
										align : 'center'
									},
									{
										field : 'gender',
										title : '性别',
										width : "4%",
										align : 'center',
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
										field : 'studentName',
										title : '学生姓名',
										width : "7%",
										align : 'center'
									},
									{
										field : 'handleSchool',
										title : '经办学校',
										width : "8%",
										align : 'center'
									},
									{
										field : 'handler',
										title : '经办人',
										width : "6%",
										align : 'center'
									},
									{
										field : 'operateDate',
										title : '日期',
										width : "7%",
										align : 'center'
									},
									{
										title : '编辑',
										field : 'edit',
										width : "5%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<a href="">编辑</a>',
															row.id);
										}
									},
									{
										title : '删除',
										field : 'delete',
										width : "5%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/trash.png" />',
															row.id);
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
		$("#startTime").datebox("setValue", firstOfMouthDate());
	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',fit:true"
		style="overflow: hidden; border: 0;">
		<div>
			<form id="form1">
				<div style="text-align: center;">
					<b><label for="studentName">学员完整姓名</label></b><input type="text"
						name="studentName" class="easyui-validatebox" />&nbsp; <b><label
						for="id">交易号</label></b><input type="text" name="id"
						class="easyui-validatebox" />&nbsp; <a href="javascript:void(0);"
						class="easyui-linkbutton"
						data-options="iconCls:'ext-icon-zoom',plain:true"
						onclick="grid.datagrid('load',cxw.serializeObject($('#form1')));">查询</a>
				</div>
			</form>
		</div>
		<div>
			<form id="form2">
				<div
					style="margin-top: 20px; display: table; margin: 0 auto; padding: 5px;">
					<div style="display: table-row;">
						<div style="display: table-cell; text-align: center;">
							<span>日期</span>
						</div>
						<div style="display: table-cell;">
							<input type="text" style="width: 100px;" class="easyui-combobox"
								data-options="valueField:'id',textField:'nameM',url:'getTypeCode?type=1',panelHeight:'auto',editable:false"
								id="typeCode" name="typeCode" class="easyui-combobox" />
						</div>
						<div style="display: table-cell;">
							<input id="operateCode" class="easyui-combobox"
								style="width: 150px;" name="operateCode"
								data-options="valueField:'id',textField:'nameM',url:'getOperateCode?type=1',panelHeight:'auto',editable:false" />
						</div>
						<div style="display: table-cell;">
							<select name="schoolCode" class="easyui-combobox"
								data-options="required:true,editable:false,panelHeight:'auto'"
								style="width: 100px;">
								<option value="1">按收费校区</option>
								<option value="2">按上课校区</option>
							</select>
						</div>
						<div style="display: table-cell;">
							<input class="easyui-combobox" name="handlerCode"
								id="handlerCode" style="width: 100px;"
								data-options="valueField:'handlerCode',textField:'handler',url:'getHandler?type=1',panelHeight:'auto',editable:false" />
						</div>
						<div style="display: table-cell;">
							<select name="order" class="easyui-combobox"
								data-options="required:true,editable:false,panelHeight:'auto'"
								style="width: 100px;">
								<option value="1">日期排序</option>
								<option value="2">经办排序</option>
							</select>
						</div>
						<div style="display: table-cell;">
							<a href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-zoom',plain:true"
								onclick="query2();">查询</a>
						</div>
					</div>
					<div style="display: table-row;">

						<div style="display: table-cell;">
							<input type="text" id="startTime" name="startTime"
								style="width: 100px;" class="easyui-datebox"
								data-options="required:true,value:'getCurrentDate();'" />到<input
								style="width: 100px;" type="text" id="endTime" name="endTime"
								class="easyui-datebox"
								data-options="required:true,value:'getCurrentDate();'" />
						</div>
						<div style="display: table-cell;">
							<input class="easyui-combobox" id="payWayCode" name="payWayCode"
								style="width: 100px;"
								data-options="valueField:'id',textField:'nameM',url:'getPayWayCode?type=1',panelHeight:'auto',editable:false " />
						</div>
						<div style="display: table-cell;">
							<input class="easyui-combobox" name="courseTypeCode"
								style="width: 150px;" id="courseTypeCode"
								data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />
						</div>
						<div style="display: table-cell;">
							<input id="handleSchoolCode" class="easyui-combobox"
								style="width: 100px;" name="handleSchoolCode"
								data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
						</div>
						<div style="display: table-cell;">
							<select name="feeState" class="easyui-combobox"
								data-options="required:true,editable:false,panelHeight:'auto'"
								style="width: 100px;">
								<option value="qb">全部状态</option>
								<option value="0">未到款</option>
								<option value="1">已到款</option>
							</select>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div>
			<table id="grid" data-options="border:true"></table>
		</div>
	</div>
</body>
</html>