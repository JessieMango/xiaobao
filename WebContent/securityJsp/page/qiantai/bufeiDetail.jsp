<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String consultId = request.getParameter("consultId") == null ? ""
			: request.getParameter("consultId");
	String lackMoney = request.getParameter("lackMoney") == null ? ""
			: request.getParameter("lackMoney");
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
</head>
<body>
	<div style="display: table; margin-left: 20px;">
		<div style="display: table-row;">
			<span class="spanLeft">欠费金额&nbsp;</span><span><b><%=lackMoney%></b>元</span>
		</div>
		<br>
		<div style="display: table-row;">
			<span class="spanLeft">补费金额&nbsp;</span><select name="payTypeCode"
				id="payTypeCode">
				<option value="1">现金支付</option>
				<option value="2">刷卡支付</option>
				<option value="3">转账支付</option>
				<option value="4">支票支付</option>
				<option value="5">网络支付</option>
			</select><input type="number" id="" style="width: 70px;"><span>元+使用余额</span><input
				type="number" id="" style="width: 70px;"><span>元(可用<span
				id=""></span>元)=<span id="total"></span>元
			</span>
		</div>
		<br>
		<div style="display: table-row;">
			<span class="spanLeft">备注&nbsp;</span><input type="text"
				style="width: 500px;">
		</div>
	</div>
	<div style="text-align: center; margin-top: 20px;">
		<div style="display: inline;">
			<label for="handleSchoolCode">校区:</label><input id="handleSchoolCode"
				class="easyui-combobox" name="handleSchoolCode"
				data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
		</div>
		<div style="display: inline;">
			<label for="consultDate">咨询日期</label><input type="text"
				name="consultDate" class="easyui-datebox"
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
</body>
</html>