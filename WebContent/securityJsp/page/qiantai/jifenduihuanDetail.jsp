<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String availabelPoints = request.getParameter("availabelPoints") == null
			? ""
			: request.getParameter("availabelPoints");
	String consultId = request.getParameter("consultId") == null
			? ""
			: request.getParameter("consultId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分兑换详情页</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
input[type='text'] {
	text-align: center;
}
</style>
<script type="text/javascript">
	var submitForm1 = function() {
		if ($('#form1').form('validate')) {
			var url = "";
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(url, cxw.serializeObject($('#form1')), function(result) {
				if (result.success) {
					parent.$.messager.progress('close');
					$.messager.alert('提示', '操作成功!', 'info');
				} else {
					parent.$.messager.progress('close');
					$.messager.alert('提示', '操作失败!', 'info');
				}
			}, 'json');
		}
	}
	var submitForm2 = function() {
		if ($('#form2').form('validate')) {
			var url = "";
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(url, cxw.serializeObject($('#form2')), function(result) {
				if (result.success) {
					parent.$.messager.progress('close');
					$.messager.alert('提示', '操作成功!', 'info');
				} else {
					parent.$.messager.progress('close');
					$.messager.alert('提示', '操作失败!', 'info');
				}
			}, 'json');
		}
	}
	/* 初始化操作 */
	var init = function() {
		$('#handleSchoolCode1').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode1').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$("#btn_save1").click(function() {
			submitForm1();
		});
		$('#handleSchoolCode2').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode2').combobox('setValue',
									data[0].schoolCode);
						}
					}
				});
		$("#btn_save2").click(function() {
			submitForm2();
		});
	}
	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<div style="text-align: center;">
		<div>
			<span><%=availabelPoints%>&nbsp;(可用积分<%=availabelPoints%>)</span>
		</div>
		<form id="form1">
			<div>
				增加<input type="text" style="width: 50px;" name="realMoney" value="0">分,备注<input
					style="width: 200px;" type="text" name="remark"> <label
					for="handleSchoolCode">经办校区:</label><input id="handleSchoolCode1"
					class="easyui-combobox" name="handleSchoolCode"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				<button type="button" id="btn_save1">
					<img alt="保存" style="vertical-align: middle;"
						src="../../../style/image/save.gif"><span
						style="vertical-align: middle;">增加积分</span>
				</button>
			</div>
		</form>
		<form id="form2">
			<div>
				使用<input type="text" style="width: 50px;" name="realMoney" value="0">兑换<input
					id="" class="easyui-combobox" name="handleSchoolCode"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'',panelHeight:'auto',editable:false" />*<input
					type="text" style="width: 50px;" name="num" value="1">
			</div>
			<div>
				备注<input style="width: 200px;" type="text" name="remark"><label
					for="handleSchoolCode">经办校区:</label><input id="handleSchoolCode2"
					class="easyui-combobox" name="handleSchoolCode"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				<button type="button" id="btn_save2">
					<img alt="保存" style="vertical-align: middle;"
						src="../../../style/image/save.gif"><span
						style="vertical-align: middle;">办理兑换</span>
				</button>
			</div>
		</form>
	</div>
</body>
</html>