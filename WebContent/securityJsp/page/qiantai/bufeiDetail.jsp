<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String id = request.getParameter("id") == null ? "" : request
			.getParameter("id"); //报名表ID
	String consultId = request.getParameter("consultId") == null
			? ""
			: request.getParameter("consultId"); //咨询表ID
	String lackMoney = request.getParameter("lackMoney") == null
			? ""
			: request.getParameter("lackMoney"); //欠费金额
	String banlance = request.getParameter("banlance") == null
			? ""
			: request.getParameter("banlance"); //可用余额
	String realShouldTuition = request
			.getParameter("realShouldTuition") == null ? "" : request
			.getParameter("realShouldTuition"); //实际应付学费
	String realTuition = request.getParameter("realTuition") == null
			? ""
			: request.getParameter("realTuition"); //实际已付学费

	if (Float.parseFloat(banlance) < 0) {
		banlance = "0";
	}
	String contextPath = request.getContextPath();
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>补费详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.spanLeft {
	width: 100px;
	display: inline-block;
	text-align: right;
}
</style>
<script type="text/javascript">
	var lackMoney = '<%=lackMoney%>';
	var banlance = '<%=banlance%>';
	var CalTotal = function() {
		var total = parseFloat($("#balance").val())
				+ parseFloat($("#realMoney").val());
		$("#total").html(total);
	}
	var changeMoney = function(target, type) {
		var value = parseFloat($(target).val());
		if (type == 1) { //实付金额发生变化
			if (value > lackMoney) {
				$.messager.alert('提示', '"补费金额" 不能大于 "欠费金额"' + lackMoney + '元',
						'info');
				$(target).val(lackMoney);
			}
			if (value < 0) {
				$.messager.alert('提示', '支付金额不能小于0!', 'info');
				$(target).val(lackMoney);
			}
		}
		if (type == 2) { //余额发生变化
			if (value < 0) {
				$.messager.alert('提示', '使用的余额不能是负数', 'info');
				$(target).val(banlance);
			}
			if (banlance < value) {
				$.messager.alert('提示', '使用余额最多为' + banlance, 'info');
				$(target).val(banlance);
			}
		}
		CalTotal(); //算总金额
	}
	var submitForm = function() {
		if ($('form').form('validate')) {
			var url = "addFinancialRunnningAccount";
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(url, cxw.serializeObject($('form')), function(result) {
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
	/* 初始化 */
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
		$("#btn_save").click(function() {
			submitForm();
		});
	}
	$(document).ready(function() {
		init();
		CalTotal(); //算总金额
	});
</script>
</head>
<body>
	<form>
		<div style="display: table; margin-left: 20px;">
			<div style="display: table-row;">
				<span class="spanLeft">欠费金额&nbsp;</span><span><b><%=lackMoney%></b>元</span><input
					type="hidden" name="realShouldTuition"
					value="<%=realShouldTuition%>"><input type="hidden"
					name="studentClass_id" value="<%=id%>"><input type="hidden"
					name="operateCode" value="8"> <input type="hidden"
					name="consultId" value="<%=consultId%>"><input type="hidden"
					name="realTuition" value="<%=realTuition%>">
			</div>
			<br>
			<div style="display: table-row;">
				<span class="spanLeft">补费金额&nbsp;</span><select name="payWayCode"
					id="payWayCode">
					<option value="1">现金支付</option>
					<option value="2">刷卡支付</option>
					<option value="3">转账支付</option>
					<option value="4">支票支付</option>
					<option value="5">网络支付</option>
				</select><input type="text" id="realMoney" name="realMoney"
					onkeyup="changeMoney(this,1);" value="<%=lackMoney%>"
					onblur="CheckNonNumber(this);" style="width: 70px;"><span>元+使用余额</span><input
					type="text" id="balance" name="balance" style="width: 70px;"
					onblur="CheckNonNumber(this);" value="<%=banlance%>"
					onkeyup="changeMoney(this,2);"><span>元(可用<span><%=banlance%></span>元)=<span
					id="total"></span>元
				</span>
			</div>
			<br>
			<div style="display: table-row;">
				<span class="spanLeft">备注&nbsp;</span><input type="text"
					name="remark" style="width: 500px;">
			</div>
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<div style="display: inline;">
				<label for="handleSchoolCode">校区:</label><input
					id="handleSchoolCode" class="easyui-combobox"
					name="handleSchoolCode"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
			</div>
			<div style="display: inline;">
				<label for="operateDate">日期</label><input type="text"
					name="operateDate" class="easyui-datebox"
					data-options="required:true,value:'getCurrentDate();'" />
			</div>
			<div style="display: inline; margin-top: 20px;">
				<label for="handleSchoolCode">经办:</label><span><%=sessionInfo.getUser().getUsername()%></span>
			</div>
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<button type="button" id="btn_save">
				<img alt="保存" style="vertical-align: middle;"
					src="../../../style/image/save.gif"><span
					style="vertical-align: middle;">办理付费</span>
			</button>
		</div>
	</form>
</body>
</html>