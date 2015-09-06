<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String consultId = request.getParameter("consultId") == null
			? ""
			: request.getParameter("consultId"); //咨询表ID
	String className = request.getParameter("className") == null
			? ""
			: request.getParameter("className"); //班级名称
	String courseName = request.getParameter("courseName") == null
			? ""
			: request.getParameter("courseName"); //课程名称
	String classTimes = request.getParameter("classTimes"); //规定上课次数
	String studentClass_id = request.getParameter("studentClass_id") == null
			? ""
			: request.getParameter("studentClass_id"); //报名表ID
	String realShouldTuition = request
			.getParameter("realShouldTuition") == null ? "0" : request
			.getParameter("realShouldTuition"); //实际应收学费
	String realTuition = request.getParameter("realTuition") == null
			? "0"
			: request.getParameter("realTuition"); //实交学费
	String money = "";
	if (classTimes == null || classTimes == "") {
		money = "0";
	} else {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		money = df.format((Float.parseFloat(realShouldTuition) / Float
				.parseFloat(classTimes))) + "";
	}
	if (Float.parseFloat(realTuition) >= Float
			.parseFloat(realShouldTuition)) {
		realTuition = realShouldTuition;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>听课详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var CalBanlance = function(target) {
		var times = parseFloat($("#realClassTimes").val());
		var price = parseFloat($("#price").val());
		var realTuition = parseFloat('<%=realTuition%>');
		console.info("times:" + times + ";price:" + price + ";realTuition:"
				+ realTuition);
		var bmoney = realTuition - times * price;
		$("#balanceSpan").html(bmoney.toFixed(2));
		$("#balance").val(bmoney.toFixed(2));
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
	});
</script>
</head>
<body>
	<form>
		<div>
			<div>
				<span>办理停课</span> <input type="hidden" name="studentClass_id"
					value="<%=studentClass_id%>">
				<!-- 停课转余额;预存余额 -->
				<input type="hidden" name="operateCode" value="7"> <input
					type="hidden" name="consultId" value="<%=consultId%>">
				<!-- 学费转余额 -->
				<input type="hidden" name="payWayCode" value="6">
			</div>
			<div>
				<span>当前班级:</span><span><%=className%></span>|<span><%=courseName%></span><span>学费已收￥</span><span><%=realTuition%></span><strong>-</strong><span>已用</span><input
					type="text" value="0" onkeyup="CalBanlance(this);"
					id="realClassTimes" style="width: 50px;"
					onblur="CheckNonNegativeNumber(this);"><span>课次</span><strong>X</strong><span>￥</span><input
					type="text" value="<%=money%>" onkeyup="CalBanlance(this);"
					id="price" style="width: 50px;"
					onblur="CheckNonNegativeNumber(this);"><span>/次=学费剩余￥</span><span
					id="balanceSpan"></span>
			</div>
			<div style="text-align: center;">
				<span>学费剩余</span><input type="text" readonly="readonly" id="balance"
					name="balance"><span>元(转为余额)</span>
			</div>
			<div style="text-align: center;">
				<label for="stopClassReason">停课原因</label><input type="text"
					name="stopClassReason" style="width: 400px;">
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
			</div>
			<div style="text-align: center; margin-top: 20px;">
				<button type="button" id="btn_save">
					<img alt="办理停课" style="vertical-align: middle;"
						src="../../../style/image/save.gif"><span
						style="vertical-align: middle;">办理停课</span>
				</button>
			</div>
		</div>
	</form>
</body>
</html>