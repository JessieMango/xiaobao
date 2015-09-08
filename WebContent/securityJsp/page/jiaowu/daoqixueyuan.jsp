<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>到期学员</title>
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
		grid = $('#grid')
				.datagrid(
						{
							url : 'getOldStudentAgainEnrolls?pageCode=daoqi',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							idField : 'consultId',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [
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
										width : "3%",
										align : 'center'

									},
									{
										field : 'birthday',
										title : '年龄',
										width : "3%",
										align : 'center',
										formatter : function(value, row) {
											return value + "岁";
										}
									},
									{
										field : 'otherTel',
										title : '手机号',
										width : "6%",
										align : 'center'
									},
									{
										field : 'councilSchool',
										title : '公立学校',
										width : "5%",
										align : 'center'
									},
									{
										field : 'liveArea',
										title : '居住区域',
										width : "5%",
										align : 'center'
									},
									{
										field : 'className',
										title : '班级',
										width : "9%",
										align : 'center'
									},
									{
										field : 'courseName',
										title : '课程',
										width : "7%",
										align : 'center'
									},
									{
										field : 'teacherName',
										title : '老师',
										width : "4%",
										align : 'center'
									},
									{
										field : 'realTuition',
										title : '实收学费',
										width : "5%",
										align : 'center',
										formatter : function(value, row, index) {
											return '￥' + value;
										}
									},
									{
										field : 'discountType',
										title : '',
										width : "2%",
										formatter : function(value, row, index) {
											switch (value) {
											case '1':
												return cxw
														.formatString(
																'<img alt="原价" onclick="alert(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/Tuition_Org.gif">',
																"原价,无折扣");
											case '2':
												return cxw
														.formatString(
																'<img alt="优惠" onclick="alert(\'优惠{0}元\')" src="../../../style/image/Tuition_discountMoney.gif">',
																row.preferentialPrice);
											case '3':
												return cxw
														.formatString(
																'<img alt="打折" onclick="alert(\'{0}折\')" style="vertical-align: middle;" src="../../../style/image/Tuition_discountRate.gif">',
																row.discount);
											case '4':
												return cxw
														.formatString(
																'<img alt="插班" onclick="alert(\'优惠{0}元\')" src="../../../style/image/Tuition_Insert.gif">',
																row.reduceMoney);
											}
										}
									},
									{
										field : 'lackMoney',
										title : '欠费',
										width : "3%",
										align : 'center',
										formatter : function(value, row, index) {
											if (value < 0) {
												return cxw
														.formatString(
																'<img alt="欠费" onclick="alert(\'欠费{0}元\')" style="vertical-align: middle;" src="../../../style/image/Tuition_lack.gif">',
																value);
											} else {
												return cxw
														.formatString(
																'<img alt="缴清"  style="vertical-align: middle;" src="../../../style/image/Tuition_full.gif">',
																value);
											}
										}
									},
									{
										field : 'textBook',
										title : '教材',
										width : "4%",
										align : 'center',
										formatter : function(value, row, index) {
											return '￥' + value;
										}
									},
									{
										field : 'fee',
										title : '杂费',
										width : "4%",
										align : 'center',
										formatter : function(value, row, index) {
											return '￥' + value;
										}
									},
									{
										field : 'availabelPoints',
										title : '积分',
										width : "5%",
										align : 'center',
										formatter : function(value, row, index) {
											return cxw
													.formatString('<img alt="积分" style="vertical-align: middle;" src="../../../style/image/member-s.gif">'
															+ value);
										}

									},
									{
										field : 'studentState',
										title : '状态',
										width : "4%",
										align : 'center'
									},
									{
										field : 'studentType',
										title : '类型',
										width : "3%",
										align : 'center',
										formatter : function(value, row, index) {
											switch (value) {
											case '1':
												return '新生';
											case '2':
												return '老生';
											}
										}
									}, {
										field : 'sellSource',
										title : '来源',
										width : "4%",
										align : 'center'
									}, {
										field : 'seller',
										title : '销售员',
										width : "4%",
										align : 'center'
									}, {
										field : 'handleSchool',
										title : '经办学校',
										width : "5%",
										align : 'center'
									}, {
										field : 'handler',
										title : '经办人',
										width : "4%",
										align : 'center'
									}, {
										field : 'enrollDate',
										title : '日期',
										width : "6%",
										align : 'center'
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
<body>
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
			<div
				style="margin-top: 20px; display: table; margin: 0 auto; padding: 5px;">
				<div style="display: table-row;">
					<div style="display: table-cell; text-align: center;">
						<span>报名日期</span>
					</div>
					<div style="display: table-cell;">
						<input id="handleSchoolCode" class="easyui-combobox"
							style="width: 150px;" name="handleSchoolCode"
							data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
					</div>
					<div style="display: table-cell;">
						<input type="text" style="width: 100px;" class="easyui-combobox"
							data-options="valueField:'userId',textField:'username',url:'getUsersByRoleId?roleId=4&combo=1',panelHeight:'auto',editable:false"
							id="teacherCode" name="teacherCode" class="easyui-combobox" />
					</div>
					<div style="display: table-cell;">
						<select name="discountType" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部学费</option>
							<option value="1">按期原价</option>
							<option value="2">按期优惠</option>
							<option value="3">按期折扣</option>
							<option value="4">按期插班</option>
						</select>
					</div>
					<div style="display: table-cell;">
						<select name="studentState" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部状态</option>
							<option value="1">正常</option>
							<option value="2">转出</option>
							<option value="3">停课</option>
							<option value="4">退费</option>
						</select>
					</div>
					<div style="display: table-cell;">
						<input class="easyui-combobox" id="sellerCode" name="sellerCode"
							style="width: 100px;"
							data-options="valueField:'sellerCode',textField:'seller',url:'getSeller?type=1',panelHeight:'auto',editable:false " />
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
						<input class="easyui-combobox" name="courseTypeCode"
							style="width: 150px;" id="courseTypeCode"
							data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />
					</div>
					<div style="display: table-cell;">
						<select name="studentType" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="qb">全部类型</option>
							<option value="1">新生</option>
							<option value="2">老生</option>
						</select>
					</div>
					<div style="display: table-cell;">
						<input class="easyui-combobox" name="sellSourceCode"
							id="sellSourceCode" style="width: 100px;"
							data-options="valueField:'sellSourceCode',textField:'sellSource',url:'getSellSource?type=1',panelHeight:'auto',editable:false" />
					</div>
					<div style="display: table-cell;">
						<input class="easyui-combobox" name="handlerCode" id="handlerCode"
							style="width: 100px;"
							data-options="valueField:'handlerCode',textField:'handler',url:'getHandler?type=1',panelHeight:'auto',editable:false" />
					</div>
					<div style="display: table-cell;">
						<select name="order" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="1">日期排序</option>
							<option value="2">状态排序</option>
							<option value="3">来源排序</option>
							<option value="4">姓名排序</option>
							<option value="5">年龄排序</option>
							<option value="6">课程排序</option>
							<option value="7">经办排序</option>
						</select>
					</div>
				</div>
			</div>
		</form>
	</div>
	<table id="grid" data-options="border:true,fit:true"></table>
</body>
</html>