<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String contextPath = request.getContextPath();
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材杂费详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitForm = function() {
		if ($('form').form('validate')) {
			var url = "";
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
	/* 初始化操作 */
	var init = function() {
		$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode2%>"}, function(result) {
			var length2 = result.length;
			$(result).each(function(index,data){
				var str = cxw.formatString('{0}￥<span><b>{1}</b></span><input type="text" name="num2"  onkeyup="CalcShouldPay(this,2,{2},{3},{4});" onblur="CheckNonNegativeNumber(this);"  style="width:50px;" value="0">&nbsp;&nbsp;<input type="hidden" id="two{5}" value="0"><input type="hidden" name="textBookFeeCode2" value="{6}">',data.nameM,data.price,data.price,index,length2,index,data.id);
				if((data.type == 1 || data.type == 2) && data.courseTypeCode != "qb"){
					$("#selfCourseFee").append(str);
				}else if(data.courseTypeCode == "qb"){
					$("#commonCourseFee").append(str);
				}
			});
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
		<div style="text-align: center;">
			<div>
				<span>本课程教材/杂费项</span>
			</div>
			<div>
				<span id="selfCourseFee"></span>
			</div>
			<div>
				<span>通用教材杂费选项</span>
			</div>
			<div>
				<span id="commonCourseFee"></span>
			</div>
			<div>
				<span>总计<span id="total"></span>元
				</span>
			</div>
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<div style="display: inline;">
				<select name="payTypeCode" id="payTypeCode">
					<option value="1">现金支付</option>
					<option value="2">刷卡支付</option>
					<option value="3">转账支付</option>
					<option value="4">支票支付</option>
					<option value="5">网络支付</option>
				</select>
			</div>

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
					style="vertical-align: middle;">保存</span>
			</button>
		</div>
	</form>
</body>
</html>