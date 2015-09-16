<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String courseCode1 = request.getParameter("courseCode1") == null
			? ""
			: request.getParameter("courseCode1"); //课程名称
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
<title>转班详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.none {
	display: none;
}
</style>
<script type="text/javascript">
	/* 计算学费剩余 */
	var CalBanlance = function(target) {
		var times = parseFloat($("#realClassTimes").val());
		if(times><%=classTimes%>){
			$.messager.alert('提示', '已用课次不能超过总课次', 'info');
			$("#realClassTimes").val(0);
		}else{
			var price = parseFloat($("#price").val());
			var realTuition = parseFloat('<%=realTuition%>');
			var bmoney = realTuition - times * price;
			$("#balanceSpan").html(bmoney.toFixed(2));
		}
		CalMoney();
	}
	/* 计算转班应补或应退的金额 */
	var CalMoney = function(){
		var val = parseFloat(parseFloat($("#balanceSpan").html() - $("#tuition1").html()));
		if(val>=0){
			if($("#tui").hasClass("none")){
				$("#tui").removeClass("none");
			}	
			if(!$("#bu").hasClass("none")){
				$("#bu").addClass("none");
			}
			$("#moneyOfReturn").val(val);
		}else{
			if($("#bu").hasClass("none")){
				$("#bu").removeClass("none");
			}	
			if(!$("#tui").hasClass("none")){
				$("#tui").addClass("none");
			}
			$("#moneyOfLack").val(-val);
		}
	}
	var submitForm = function() {
		if ($('form').form('validate')) {
			var url = "zhuanBan";
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
	/* 收费模式改变时 */
	var changeType = function(order,target){
		if (order == 1) { //优惠金额改变
			$("#tuition1").html($("#tu1").val() - $(target).val());
		}
		if (order == 2) { //插班
			$("#tuition1").html($("#tu1").val() - $(target).val());
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
		$('#classCode1').combobox({
			url : 'getClassSByCourseCode?courseCode='+'<%=courseCode1%>',
			valueField : 'classCode',
			textField : 'nameM',
			panelHeight : 'auto',
			editable : false,
			onLoadSuccess : function(data) {
				if (data[0]) {
					$('#classCode1').combobox('setValue', data[0].classCode);
				}
			},
			onSelect : function(data) {
				if (data) {
					if (data.classCode != "qb") { //如果选中班级
						if ($("#otherSpan1").hasClass("none")) {
							$("#otherSpan1").removeClass("none")
						}
						if ($("#otherDiv1").hasClass("none")) {
							$("#otherDiv1").removeClass("none")
						}
						$("#tu1").val(data.tuition);
						$("#tuition1").html(data.tuition);
					} else {
						if (!$("#otherSpan1").hasClass("none")) {
							$("#otherSpan1").addClass("none")
						}
						if (!$("#otherDiv1").hasClass("none")) {
							$("#otherDiv1").addClass("none")
						}
					}
				}
			}
		});

		$("#discount1").numberbox({
			onChange : function(newValue, oldValue) {
				if (newValue == 0.0) {
					$("#tuition1").html($("#tu1").val());
				} else {
					$("#tuition1").html($("#tu1").val() * newValue / 10);
				}
				$('#realTuition1').val($("#tuition1").html());
				CalTotalMoney();
			}
		});
		$("#btn_save").click(function() {
			submitForm();
		});
	}
	$(document).ready(function() {
		init();
		$("#balanceSpan").html("<%=realTuition%>");
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
			</div>
			<div>
				<span>当前班级:</span><span><%=className%></span>|<span><%=courseName%></span>|<span>学费已收￥</span><span><%=realTuition%></span><strong>-</strong><span>已用</span><input
					type="text" value="0" onkeyup="CalBanlance(this);"
					id="realClassTimes" style="width: 50px;"
					onblur="CheckNonNegativeNumber(this);"><span>课次</span><strong>X</strong><span>￥</span><input
					type="text" value="<%=money%>" onkeyup="CalBanlance(this);"
					id="price" style="width: 50px;"
					onblur="CheckNonNegativeNumber(this);"><span>/次=学费剩余￥</span><span
					id="balanceSpan"></span>
			</div>
			<div style="margin-top: 20px;">
				<span>转到班级:</span><input type="text" id="classCode1"
					name="classCode1" style="width: 400px;" class="easyui-combobox" />
				<span id="otherSpan1" class="none"><select
					onchange="changeDiscountType(1,this);" name="discountType1"
					id="discountType1">
						<option value="1">原价</option>
						<option value="2">优惠</option>
						<option value="3">折扣</option>
						<option value="4">插班</option>
				</select><span id="span12" class="none"><input id="preferntial1"
						onkeyup="changeType(1,this);"
						onblur="CheckNonNegativeNumber(this);" name="preferntial1"
						style="width: 70px" value="0" />元</span><span id="span13" class="none"><input
						class="easyui-numberbox" style="width: 70px;" value="0"
						id="discount1" name="discount1"
						data-options="min:0,precision:1,max:9.9" />折</span><span id="span14"
					class="none">减免<input id="reduceMoney1" name="reduceMoney1"
						onkeyup="changeType(2,this);"
						onblur="CheckNonNegativeNumber(this);" style="width: 70px"
						value="0" />元<input type="hidden" id="tu1" />
				</span><span>=应收</span><span id="tuition1"><span> </span> </span></span>
			</div>
			<div id="otherDiv1" class="none" style="margin-top: 20px; text-align: center;">
				<span id="bu">转班应补<input type="text" style="width: 100px;"
					name="moneyOfLack" id="moneyOfLack">元 <select
					name="payTypeCode" id="payTypeCode">
						<option value="1">现金支付</option>
						<option value="2">刷卡支付</option>
						<option value="3">转账支付</option>
						<option value="4">支票支付</option>
						<option value="5">网络支付</option>
				</select><span>(使用余额<input type="text" style="width: 50px;"
						readonly="readonly" name="balance" id="balance">元)
				</span>
				</span>
				<span id="tui" class="none">
					转班应退<input type="text" name="moneyOfReturn" id="moneyOfReturn" style="width: 100px;">
					<span>(<input type="checkbox">不退款，转为余额)
				</span>
				</span>
			</div>
			<div style="text-align: center; margin-top: 20px;">
				转班备注:<input type="text" name="remark" style="width: 50%;">
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
		</div>
	</form>
	<div style="text-align: center; margin-top: 20px;">
		<button type="button" id="btn_save">
			<img alt="保存" style="vertical-align: middle;"
				src="../../../style/image/save.gif"><span
				style="vertical-align: middle;">办理转班</span>
		</button>
	</div>
</body>
</html>