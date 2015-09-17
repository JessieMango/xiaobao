<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>正式停职员工档案</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">

	var editFun = function(userId) {
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : '编辑',
			width : 660,
			height : 400,
			url : cxw.contextPath
			+ '/securityJsp/page/renshi/editstaffInformation.jsp?userId='
					+ userId,
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
				$.post("deletezhengshitingzhi", {
					userId: userId
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
	var grid;
	/* 初始化页面 */
	function init() {
		
		$('#staffTag').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#staffTag').combobox('setValue',
									data[0].id);
						}
					}
				});
		
		$('#laborRelations').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#laborRelations').combobox('setValue',
									data[0].id);
						}
					}
				});
		$('#socialsecurityStatus').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#socialsecurityStatus').combobox('setValue',
									data[0].id);
						}
					}
				});	

		grid = $('#grid')
				.datagrid(
						{
							url : 'Getzhengshitingzhi',
							striped : true,
							pagination : true,
							rownumbers : true,
							nowrap : false,
							idField : 'userId',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							columns : [ [
									{
										field : 'username',
										title : '姓名',
										width : "20%",
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
										field : 'dpersonnelStatusnameM',
										title : '状态',
										width : "5%",
										align : 'center',
										
									},
									{
										field : 'education',
										title : '学历',
										width : "7%",
										align : 'center'
									},
									{
										field : 'dlaborRelationsnameM',
										title : '关系',
										width : "4%",
										align : 'center'
									},
									{
										field : 'contractState',
										title : '合同',
										width : "8%",
										align : 'center',
										formatter : function(value, row) {
											if (value == 0) {
												return '<img  alt="未签"  style="vertical-align: middle;" src="../../../style/image/signmakeup.gif" />';
											} else {
												return '<img  alt="已签"  style="vertical-align: middle;" src="../../../style/image/signin.gif" />';
											}
										}
									},
									{
										field : 'socialsecurityStatus',
										title : '社保',
										width : "6%",
										align : 'center',
										formatter : function(value, row) {
											if (value == 0) {
												return '<img  alt="未签"  style="vertical-align: middle;" src="../../../style/image/signmakeup.gif" />';
											} else {
												return '<img  alt="已签"  style="vertical-align: middle;" src="../../../style/image/signin.gif" />';
											}
										}
									},
									{
										field : 'contractStartDate',
										title : '转正已过',
										width : "8%",
										align : 'center'
									},
									{
										field : 'contractEndtDate',
										title : '剩余',
										width : "8%",
										align : 'center'
									},
									{
										field : 'confirmationdate',
										title : '转正日期',
										width : "8%",
										align : 'center'
									},
									{
										title : '编辑',
										field : 'edit',
										width : "8%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<input type="reset" value="编辑" style="color:black; font-weight:bold; width:60px;"  onclick="editFun(\'{0}\')" />',
															row.userId);
										}
									},
									{
										title : '删除',
										field : 'delete',
										width : "8%",
										align : 'center',
										formatter : function(value, row) {
											return cxw
													.formatString(
															'<img  alt="删除" onclick="deleteFun(\'{0}\')" style="vertical-align: middle;" src="../../../style/image/delete.png" />',
															row.userId );
										}
									} ] ],toolbar:'#toolbar',
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
		<div id='toolbar'>
			<form id="form1">
				<div style="margin-top: 10px;margin-bottom:10px">
					<div style="margin-left: 15%;">
					&nbsp;&nbsp;<select name="contractState" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
									<option value="qb">全部合同状态</option>
									<option value="0">未签</option>
									<option value="1">已签</option>	
							</select>&nbsp;
					<input class="easyui-combobox" name="socialsecurityStatus"
							id="socialsecurityStatus" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getsocialsecurityStatus?type=1',required:true,panelHeight:'auto',editable:false" />
					&nbsp;
					
					&nbsp;
					<input class="easyui-combobox" name="laborRelations"
							id="laborRelations" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getlaborRelations?type=1',required:true,panelHeight:'auto',editable:false" />&nbsp;&nbsp;
							
					
					&nbsp;<input class="easyui-combobox" name="staffTag"
							id="staffTag" style="width: 100px;"
							data-options="valueField:'id',textField:'cardCode',url:'getStaffTag?type=1',panelHeight:'auto',editable:false" />&nbsp;&nbsp;
				
					&nbsp;<select name="remark" class="easyui-combobox"
							data-options="required:true,editable:false,panelHeight:'auto'"
							style="width: 100px;">
							<option value="1">员工姓名排序</option>
							<option value="2">员工工龄排序</option>
							<option value="3">员工状态排序</option>
							<option value="4">合同起日排序</option>
							<option value="5">合同止日排序</option>
							<option value="6">转正日期排序</option>
						</select> &nbsp; 
						
						<a href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'ext-icon-zoom',plain:true"
							onclick="grid.datagrid('load',cxw.serializeObject($('#form1')));">查询</a>

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