<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String courseCode1 = request.getParameter("courseCode1") == null
			? ""
			: request.getParameter("courseCode1");
	String courseCode2 = request.getParameter("courseCode2") == null
			? ""
			: request.getParameter("courseCode2");
	String courseCode3 = request.getParameter("courseCode3") == null
			? ""
			: request.getParameter("courseCode3");
	String courseTypeCode1 = request.getParameter("courseTypeCode1") == null
			? ""
			: request.getParameter("courseTypeCode1");
	String courseTypeCode2 = request.getParameter("courseTypeCode2") == null
			? ""
			: request.getParameter("courseTypeCode2");
	String courseTypeCode3 = request.getParameter("courseTypeCode3") == null
			? ""
			: request.getParameter("courseTypeCode3");
	String courseName1 = request.getParameter("courseName1") == null
			? ""
			: request.getParameter("courseName1");
	String courseName2 = request.getParameter("courseName2") == null
			? ""
			: request.getParameter("courseName2");
	String courseName3 = request.getParameter("courseName3") == null
			? ""
			: request.getParameter("courseName3");
	String id = request.getParameter("id") == null ? "" : request
			.getParameter("id");
	boolean flag = StringUtils.isNotBlank(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
input[type='text'] {
	text-align: center;
}

.labelUnit {
	margin-right: 20px;
}

.none {
	display: none;
}

.row{
	display: table-row;
}
</style>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var courseTypeCode = "";

	var getTextbookFee = function(type1, target, type2) {
		if(type1 == 1){
			var courseTypeCode = "<%=courseTypeCode1%>";
			if(type2 == 0){
				courseTypeCode = "qb";
			}
			$.post("getTextBookFeesByCourseType",{courseTypeCode : courseTypeCode,type : type2}, function(result) {
				if(type2 == 1){
					if($("#tf11").hasClass("none")){
						$("#tf11").removeClass("none");
					}
					if(!$("#tf12").hasClass("none")){
						$("#tf12").addClass("none");
					}
					if(!$("#tf13").hasClass("none")){
						$("#tf13").addClass("none");
					}
					$("#tf11").empty();
					$(result).each(function(index,data){
						$("#tf11").append(data.nameM + '￥<span><b>'+data.price+'</b></span><input type="text" name="num11" id="num11" onkeyup="CalcShouldPay(1);" onblur="CheckNonNegativeNumber(this);"  style="width:70px;" value="0" ">&nbsp;');
					});
				}
				if(type2 == 0){
					if($("#tf12").hasClass("none")){
						$("#tf12").removeClass("none");
					}
					if(!$("#tf11").hasClass("none")){
						$("#tf11").addClass("none");
					}
					if(!$("#tf13").hasClass("none")){
						$("#tf13").addClass("none");
					}
					$("#tf12").empty();
					$(result).each(function(index,data){
						$("#tf12").append(data.nameM + '￥<span><b>'+data.price+'</b></span><input type="text" name="num12" id="num12" class="easyui-numberbox" style="width:70px;" value="0" data-options="min:0,precision:0">&nbsp;');
					});
				}
				if(type2 == 2){
					if($("#tf13").hasClass("none")){
						$("#tf13").removeClass("none");
					}
					if(!$("#tf11").hasClass("none")){
						$("#tf11").addClass("none");
					}
					if(!$("#tf12").hasClass("none")){
						$("#tf12").addClass("none");
					}
					$("#tf13").empty();
					$(result).each(function(index,data){
						$("#tf13").append(data.nameM + '￥<span><b>'+data.price+'</b></span><input type="text" name="num13" id="num13" class="easyui-numberbox" style="width:70px;" value="0" data-options="min:0,precision:0">&nbsp;');
					});
				}
			});
		}
		if(type1 == 2){
			$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode2%>",type : 0}, function(result) {
	
			});
		}
		if(type1 == 2){
			$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode2%>",type : type2}, function(result) {
	
			});
		}
		
	}
	var init = function() {
		$("#preferntial1").numberbox(
				{
					onChange : function(newValue, oldValue) {
						$("#tuition1").html($("#tu1").val() - newValue);
						$('#realTuition1').numberbox('setValue',
								$("#tuition1").html());
						$("#money").html(
								$('#realTuition1').numberbox('getValue'));
						$("#points").html(
								$('#realTuition1').numberbox('getValue'));
					}
				});

		$("#realTuition1").numberbox(
				{
					onChange : function(newValue, oldValue) {
						va = newValue - $("#tuition1").html();
						if (va > 0) {
							if ($("#arrearage1").hasClass("none")) {
								$("#arrearage1").removeClass("none");
							}
							$("#arrearage1").empty();
							$("#arrearage1").append(
									"<span style='color:red;'>预存" + va
											+ "元</span>");
						}
						if (va < 0) {
							if ($("#arrearage1").hasClass("none")) {
								$("#arrearage1").removeClass("none");
							}
							$("#arrearage1").empty();
							$("#arrearage1").append(
									"<span style='color:red;'>欠费" + va
											+ "元</span>");
						}
						if (va == 0) {
							if (!$("#arrearage1").hasClass("none")) {
								$("#arrearage1").addClass("none");
							}
						}
						$("#money").html(
								$('#realTuition1').numberbox('getValue'));
						$("#points").html(
								$('#realTuition1').numberbox('getValue'));
					}
				});

		$("#discount1").numberbox(
				{
					onChange : function(newValue, oldValue) {
						if (newValue == 0.0) {
							$("#tuition1").html($("#tu1").val());
						} else {
							$("#tuition1").html(
									$("#tu1").val() * (newValue / 10));
						}
						$('#realTuition1').numberbox('setValue',
								$("#tuition1").html());
						$("#money").html(
								$('#realTuition1').numberbox('getValue'));
						$("#points").html(
								$('#realTuition1').numberbox('getValue'));
					}
				});
		$("#reduceMoney1").numberbox(
				{
					onChange : function(newValue, oldValue) {
						$("#tuition1").html($("#tu1").val() - newValue);
						$('#realTuition1').numberbox('setValue',
								$("#tuition1").html());
						$("#money").html(
								$('#realTuition1').numberbox('getValue'));
						$("#points").html(
								$('#realTuition1').numberbox('getValue'));
					}
				});

		if ("<%=courseCode1%>" == ""){
			$("#classDiv1").addClass("none");
		}else{
			$("#span1").html("<%=courseName1%>");
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
					if(data){
						if(data.classCode != "qb"){ //如果选中班级
							if($("#otherSpan1").hasClass("none")){
								$("#otherSpan1").removeClass("none")
							}
							if($("#otherDiv1").hasClass("none")){
								$("#otherDiv1").removeClass("none")
							}
							if($("#textbookFee1").hasClass("none")){
								$("#textbookFee1").removeClass("none")
							}
							$("#tu1").val(data.tuition);
							$("#tuition1").html(data.tuition);
							$('#realTuition1').numberbox('setValue', data.tuition);
							$("#money").html(data.tuition);
							$("#points").html(data.tuition);
						}else{
							if(!$("#otherSpan1").hasClass("none")){
								$("#otherSpan1").addClass("none")
							}
							if(!$("#otherDiv1").hasClass("none")){
								$("#otherDiv1").addClass("none")
							}
							if(!$("#textbookFee1").hasClass("none")){
								$("#textbookFee1").addClass("none")
							}
							$("#money").html("0");
							$("#points").html("0");
						}
					}
				}
			});
		}
		if("<%=courseCode2%>" == ""){
			$("#classDiv2").addClass("none");
		}else{
			$("#span2").html("<%=courseName2%>");
			$('#classCode2').combobox({
				url : 'getClassSByCourseCode?courseCode='+'<%=courseCode2%>',
				valueField : 'classCode',
				textField : 'nameM',
				panelHeight : 'auto',
				editable : false,
				onLoadSuccess : function(data) {
					if (data[0]) {
						$('#classCode2').combobox('setValue', data[0].classCode);
					}
				},
				onSelect : function(data) {
					if(data){
						if(data.classCode != "qb"){
							if($("#otherSpan2").hasClass("none")){
								$("#otherSpan2").removeClass("none")
							}
							if($("#otherDiv2").hasClass("none")){
								$("#otherDiv2").removeClass("none")
							}
							if($("#textbookFee2").hasClass("none")){
								$("#textbookFee2").removeClass("none")
							}
						}else{
							if(!$("#otherSpan2").hasClass("none")){
								$("#otherSpan2").addClass("none")
							}
							if(!$("#otherDiv2").hasClass("none")){
								$("#otherDiv2").addClass("none")
							}
							if(!$("#textbookFee2").hasClass("none")){
								$("#textbookFee2").addClass("none")
							}
						}
					}
				}
			});
		}
		if("<%=courseCode3%>" == "") {
			$("#classDiv3").addClass("none");
		}else{
			$("#span3").html("<%=courseName3%>");
			$('#classCode3').combobox({
				url : 'getClassSByCourseCode?courseCode='+'<%=courseCode3%>',
						valueField : 'classCode',
						textField : 'nameM',
						panelHeight : 'auto',
						editable : false,
						onLoadSuccess : function(data) {
							if (data[0]) {
								$('#classCode3').combobox('setValue',
										data[0].classCode);
							}
						},
						onSelect : function(data) {
							if(data){
								if(data.classCode != "qb"){
									if($("#otherSpan3").hasClass("none")){
										$("#otherSpan3").removeClass("none")
									}
									if($("#otherDiv3").hasClass("none")){
										$("#otherDiv3").removeClass("none")
									}
									if($("#textbookFee3").hasClass("none")){
										$("#textbookFee3").removeClass("none")
									}
								}else{
									if(!$("#otherSpan3").hasClass("none")){
										$("#otherSpan3").addClass("none")
									}
									if(!$("#otherDiv3").hasClass("none")){
										$("#otherDiv3").addClass("none")
									}
									if(!$("#textbookFee3").hasClass("none")){
										$("#textbookFee3").addClass("none")
									}
								}
							}
						}
					});
		}
		
		$("#btn_save").click(function(){
			
		});
	}
	$(document).ready(function() {
		init();
		if(<%=flag%>){
			$("input[type='text']").attr("readonly", "true");
			$.post("getConsultById", {id :"<%=id%>"}, function(result) {
				$('form').form('load', {
					"birthday" : result.birthday,
					"class_grade" : result.class_grade,
					"consultCourseCode" : result.consultCourseCode,
					"consultDate" : result.consultDate,
					"consultWayCode" : result.consultWayCode,
					"councilSchoolCode" : result.councilSchool,
					"carCode" : result.carCode,	
					"banlance" : result.banlance,
					"availabelPoints" : result.availabelPoints,
					"fatherTel" : result.fatherTel,
					"gender" : result.gender,
					"handleSchoolCode" : result.handleSchoolCode,
					"liveArea" : result.liveArea,
					"motherTel" : result.motherTel,
					"nameM" : result.nameM,
					"otherTel" : result.otherTel,
					"others" : result.others,
					"sellSourceCode" : result.sellSourceCode,
					"sellerCode" : result.sellerCode
				});
			});
		}
	});
</script>
</head>
<body>
	<form id="form1">
		<div style="display: table; margin: 20px auto;">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="nameM" class="labelUnit">学员姓名</label><input type="text"
						name="nameM" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="gender" class="labelUnit">学员性别</label><input
						id="gender" type="text" name="gender" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="birthday" class="labelUnit">学员生日</label><input
						type="text" name="birthday" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="carCode" class="labelUnit">磁卡卡号</label><input
						type="text" name="carCode" />
				</div>
			</div>
			<br />

			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="motherTel" class="labelUnit">母亲电话</label><input
						type="text" name="motherTel" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="fatherTel" class="labelUnit">父亲电话</label><input
						type="text" name="fatherTel" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="otherTel" class="labelUnit">其他电话</label><input
						type="text" name="otherTel" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="banlance" class="labelUnit">可用余额</label><input
						type="text" name="banlance" />
				</div>
			</div>
			<br />
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="councilSchool" class="labelUnit">公立学校</label><input
						type="text" name="councilSchool" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="class_grade" class="labelUnit">班级年级</label><input
						type="text" name="class_grade" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="liveArea" class="labelUnit">居住区域</label><input
						type="text" name="liveArea" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="availabelPoints" class="labelUnit">可用积分</label><input
						type="text" name="availabelPoints" />
				</div>
			</div>
			<br />
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="others" class="labelUnit">其他信息</label><input
						type="text" name="others" />
				</div>
			</div>
		</div>
	</form>
	<div id="classDiv1" style="text-align: center; margin-top: 30px;">
		<span id="span1"
			style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
			type="text" id="classCode1" name="classCode" style="width: 400px;"
			class="easyui-combobox" /><a
			href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
			target="_blank"><button>新建</button></a><span id="otherSpan1"
			class="none"><select onchange="changeDiscountType(1,this);"
			name="discountType1" id="discountType1">
				<option value="1">原价</option>
				<option value="2">优惠</option>
				<option value="3">折扣</option>
				<option value="4">插班</option>
		</select><span id="span12" class="none"><input class="easyui-numberbox"
				id="preferntial1" name="preferntial1"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元</span><span
			id="span13" class="none"><input class="easyui-numberbox"
				style="width: 70px;" value="0" id="discount1" name="discount1"
				data-options="min:0,precision:1,max:9.9" />折</span><span id="span14"
			class="none">减免<input class="easyui-numberbox"
				id="reduceMoney1" name="reduceMoney1"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元
		</span><span>=应收</span><span id="tuition1"></span><span>=实收</span><span><input
				style="width: 70px;" type="text" id="realTuition1"
				name="realTuition1" data-options="min:0,precision:2"
				class="easyui-numberbox" /> </span> </span>
		<div style="margin-top: 10px;" id="otherDiv1" class="none">
			<label for="tuitionRemark1">学费备注:</label><input type="text"
				style="width: 500px;" id="tuitionRemark1" /><input type="hidden"
				id="tu1" />
		</div>
		<div style="margin-top: 10px;" id="arrearage1"></div>
		<div id="textbookFee1" class="none" style="margin-top: 10px;">
			<div>
				<button
					style="padding: 5px; background-color: #0066CC; color: white;"
					onclick="getTextbookFee(1,'#textbookFee1',1);">教材项(本课程)</button>
				<span>/</span>
				<button
					style="padding: 5px; background-color: #5B8A5B; color: white;"
					onclick="getTextbookFee(1,'#textbookFee1',0);">教材项(所有课程)</button>
				<span>/</span>
				<button
					style="padding: 5px; background-color: #BD8E2F; color: white;"
					onclick="getTextbookFee(1,'#textbookFee1',2);">杂费项</button>
			</div>
			<div style="margin-top: 10px;">
				<span id="tf11" class="none"></span><span id="tf12" class="none"></span><span
					id="tf13" class="none"></span>
			</div>
			<div style="margin-top: 10px;">
				<span style="color: red;">教材杂费总计 <span>0</span> 元
				</span>
			</div>
		</div>
	</div>

	<div style="text-align: center; margin-top: 30px;" id="classDiv2">
		<span id="span2"
			style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
			type="text" id="classCode2" name="classCode2" style="width: 400px;"
			class="easyui-combobox" /><a
			href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
			target="_blank"><button>新建</button></a><span id="otherSpan2"
			class="none"><select onchange="changeDiscountType(2,this);"
			name="discountType2" id="discountType2">
				<option value="1">原价</option>
				<option value="2">优惠</option>
				<option value="3">折扣</option>
				<option value="4">插班</option>
		</select><span id="span22" class="none"><input class="easyui-numberbox"
				id="preferntial2" name="preferntial2"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元</span><span
			id="span23" class="none"><input class="easyui-numberbox"
				style="width: 70px;" value="0" id="discount2" name="discount2"
				data-options="min:0,precision:1,max:9.9" />折</span><span id="span24"
			class="none">减免<input class="easyui-numberbox"
				id="reduceMoney2" name="reduceMoney2"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元
		</span><span>=应收</span><span id="tuition1"></span><span>=实收</span><span><input
				style="width: 70px;" type="text" id="realTuition2"
				name="realTuition2" data-options="min:0,precision:2"
				class="easyui-numberbox" /> </span> </span>
		<div style="margin-top: 10px;" id="otherDiv2" class="none">
			<label for="tuitionRemark2">学费备注:</label><input type="text"
				style="width: 500px;" id="tuitionRemark2" />
		</div>
	</div>


	<div style="text-align: center; margin-top: 30px;" id="classDiv3">
		<span id="span3"
			style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
			type="text" id="classCode3" name="classCode3" style="width: 400px;"
			class="easyui-combobox" /><a
			href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
			target="_blank"><button>新建</button></a><span id="otherSpan3"
			class="none"><select onchange="changeDiscountType(3,this);"
			name="discountType3" id="discountType3">
				<option value="1">原价</option>
				<option value="2">优惠</option>
				<option value="3">折扣</option>
				<option value="4">插班</option>
		</select><span id="span32" class="none"><input class="easyui-numberbox"
				id="preferntial3" name="preferntial3"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元</span><span
			id="span33" class="none"><input class="easyui-numberbox"
				style="width: 70px;" value="0" id="discount3" name="discount3"
				data-options="min:0,precision:1,max:9.9" />折</span><span id="span34"
			class="none">减免<input class="easyui-numberbox"
				id="reduceMoney3" name="reduceMoney3"
				data-options="min:0,precision:2" style="width: 70px" value="0" />元
		</span><span>=应收</span><span id="tuition1"></span><span>=实收</span><span><input
				style="width: 70px;" type="text" id="realTuition3"
				name="realTuition3" data-options="min:0,precision:2"
				class="easyui-numberbox" /> </span> </span>
		<div style="margin-top: 10px;" id="otherDiv2" class="none">
			<label for="tuitionRemark2">学费备注:</label><input type="text"
				style="width: 500px;" id="tuitionRemark2" />
		</div>
	</div>
	<form id="form2">
		<div style="margin: 30px auto; display: table;">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					总计:<span id="money">0</span>元 <select name="payTypeCode"
						id="payTypeCode">
						<option value="1">现金支付</option>
						<option value="2">刷卡支付</option>
						<option value="3">转账支付</option>
						<option value="4">支票支付</option>
						<option value="5">网络支付</option>
					</select>=积分:0<span id="points"></span>
				</div>
				<div style="display: table-cell;">
					<label for="handleSchoolCode">|经办:</label><input
						id="handleSchoolCode" class="easyui-combobox"
						style="width: 100px;" name="handleSchoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				</div>&nbsp;&nbsp;
				<div style="display: table-cell;">
					<label for="sellSourceCode">销售来源:</label><input
						class="easyui-combobox" name="sellSourceCode" id="sellSourceCode"
						style="width: 100px;"
						data-options="valueField:'sellSourceCode',textField:'sellSource',url:'getSellSource',panelHeight:'auto'" />&nbsp;&nbsp;
				</div>
				<div style="display: table-cell;">
					<label for="sellerCode">销售员:</label><input class="easyui-combobox"
						id="sellerCode" name="sellerCode" style="width: 100px;"
						data-options="valueField:'sellerCode',textField:'seller',url:'getSeller',panelHeight:'auto' " />&nbsp;&nbsp;
				</div>
				<div style="display: table-cell;">
					<label for="enrollDate">报名日期:</label><input type="text"
						name="enrollDate" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
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