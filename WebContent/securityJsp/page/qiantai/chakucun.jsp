<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查库存</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">

	/* 出入库 */
	var inOutWareHouse = function() {
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : "出入库",
			width : 500,
			height : 300,
			url : cxw.contextPath
					+ '/securityJsp/page/form/churukuForm.jsp',
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}
	/* 转库 */
	var transformWareHouse = function(){
		var dialog = parent.cxw.modalDialog({
			modal : true,
			title : "教材转库",
			width : 500,
			height : 300,
			url : cxw.contextPath
					+ '/securityJsp/page/form/jiaocaizhuankuForm.jsp',
			buttons : [ {
				text : '保存',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(
							dialog, grid, parent.$);
				}
			} ]
		});
	}
	/* 库存变动记录 */
	var changeRecord = function(){
		window.location.href = 'kucunbiandongjilu.jsp';
	}
	/* 初始化页面 */
	function init() {
		$('#courseTypeCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#courseTypeCode').combobox('setValue',
									data[0].courseTypeCode);
						}
					}
				});
		grid = $('#grid').datagrid({
			url : 'getKuCun',
			striped : true,
			pagination : true,
			rownumbers : true,
			nowrap : false,
			checkOnSelect : false,
			selectOnCheck : false,
			idField : 'nameM',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ {
				field : 'nameM',
				title : '教材名称',
				width : "25%",
				align : 'center'

			}, {
				field : 'num1',
				title : '仓库',
				width : "24%",
				align : 'center'
			}, {
				field : 'num2',
				title : '<%=sessionInfo.getUser().getSchool()%>',
				width : "24%",
				align : 'center'
			}, {
				field : 'total',
				title : '总计',
				width : "24%",
				align : 'center'
			} ] ]
		});

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<div style="text-align: center;">
		<button onclick="inOutWareHouse();">教材入库/出库</button>
		<button onclick="transformWareHouse();">教材转库</button>
		<button onclick="changeRecord();">库存变动记录</button>
	</div>
	<form>
		<div style="text-align: center; margin-top: 20px;">
			<label for="courseTypeCode">对应课程:</label>&nbsp;&nbsp;<input
				class="easyui-combobox" name="courseTypeCode"
				style="width: 215px;" id="courseTypeCode"
				data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=1',panelHeight:'auto',editable:false" />&nbsp;&nbsp;
			<a href="javascript:void(0);" class="easyui-linkbutton"
				data-options="iconCls:'ext-icon-zoom',plain:true"
				onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查库存</a>
		</div>
	</form>
	<div style="width: 65%; margin: 0 auto;">
		<table id="grid" data-options="border:false"></table>
	</div>
</body>
</html>