<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材杂费</title>
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
	var changeClassFun = function(consultId, lackMoney) {
		window.location.href = "jiaocaizafeiDetail.jsp?consultId=" + consultId
				+ "&lackMoney=" + lackMoney;
	}
	var init = function() {
		grid = $('#grid')
				.datagrid(
						{
							url : 'getOldStudentAgainEnrolls',
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
										width : "4.5%",
										align : 'center'
									},
									{
										field : 'liveArea',
										title : '居住区域',
										width : "4.5%",
										align : 'center'
									},
									{
										field : 'className',
										title : '班级',
										width : "7%",
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
										align : 'center',
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
										width : "3%",
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
									},
									{
										field : 'sellSource',
										title : '来源',
										width : "3%",
										align : 'center'
									},
									{
										field : 'seller',
										title : '销售员',
										width : "4%",
										align : 'center'
									},
									{
										field : 'handleSchool',
										title : '经办学校',
										width : "5%",
										align : 'center'
									},
									{
										field : 'handler',
										title : '经办人',
										width : "4%",
										align : 'center'
									},
									{
										field : 'enrollDate',
										title : '日期',
										width : "6%",
										align : 'center'
									},
									{
										title : '办理',
										field : 'edit',
										width : "7%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<input type="button" value="￥教材杂费" style="color:black; font-weight:bold; width:90px;" onclick="changeClassFun(\'{0}\',\'{1}\')" />',
															row.consultId,
															-row.lackMoney);
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
<body>
	<div>
		<form>
			<div style="text-align: center;">
				<b><label for="nameM">学员完整姓名</label></b><input type="text"
					name="nameM" class="easyui-validatebox" />&nbsp; <b><label
					for="telTail">学员电话尾号</label></b><input type="text" name="telTail"
					class="easyui-validatebox" />&nbsp; <a href="javascript:void(0);"
					class="easyui-linkbutton"
					data-options="iconCls:'ext-icon-zoom',plain:true"
					onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
			</div>
		</form>
	</div>
	<div>
		<table id="grid" data-options="border:true"></table>
	</div>
</body>
</html>