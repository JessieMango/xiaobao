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

.row {
	display: table-row;
}
</style>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var courseTypeCode = "";
	var getTextbookFee = function(type1, type2) {
		if (type1 == 1) {
			if (type2 == 1) {
				if ($("#tf11").hasClass("none")) {
					$("#tf11").removeClass("none");
				}
				if (!$("#tf12").hasClass("none")) {
					$("#tf12").addClass("none");
				}
				if (!$("#tf13").hasClass("none")) {
					$("#tf13").addClass("none");
				}
			}
			if (type2 == 0) {
				if ($("#tf12").hasClass("none")) {
					$("#tf12").removeClass("none");
				}
				if (!$("#tf11").hasClass("none")) {
					$("#tf11").addClass("none");
				}
				if (!$("#tf13").hasClass("none")) {
					$("#tf13").addClass("none");
				}
			}
			if (type2 == 2) {
				if ($("#tf13").hasClass("none")) {
					$("#tf13").removeClass("none");
				}
				if (!$("#tf11").hasClass("none")) {
					$("#tf11").addClass("none");
				}
				if (!$("#tf12").hasClass("none")) {
					$("#tf12").addClass("none");
				}
			}
		}
		if (type1 == 2) {
			if (type2 == 1) {
				if ($("#tf21").hasClass("none")) {
					$("#tf21").removeClass("none");
				}
				if (!$("#tf22").hasClass("none")) {
					$("#tf22").addClass("none");
				}
				if (!$("#tf23").hasClass("none")) {
					$("#tf23").addClass("none");
				}
			}
			if (type2 == 0) {
				if ($("#tf22").hasClass("none")) {
					$("#tf22").removeClass("none");
				}
				if (!$("#tf21").hasClass("none")) {
					$("#tf21").addClass("none");
				}
				if (!$("#tf23").hasClass("none")) {
					$("#tf23").addClass("none");
				}
			}
			if (type2 == 2) {
				if ($("#tf23").hasClass("none")) {
					$("#tf23").removeClass("none");
				}
				if (!$("#tf21").hasClass("none")) {
					$("#tf21").addClass("none");
				}
				if (!$("#tf22").hasClass("none")) {
					$("#tf22").addClass("none");
				}
			}
		}
		if (type1 == 3) {
			if (type2 == 1) {
				if ($("#tf31").hasClass("none")) {
					$("#tf31").removeClass("none");
				}
				if (!$("#tf32").hasClass("none")) {
					$("#tf32").addClass("none");
				}
				if (!$("#tf33").hasClass("none")) {
					$("#tf33").addClass("none");
				}
			}
			if (type2 == 0) {
				if ($("#tf32").hasClass("none")) {
					$("#tf32").removeClass("none");
				}
				if (!$("#tf31").hasClass("none")) {
					$("#tf31").addClass("none");
				}
				if (!$("#tf33").hasClass("none")) {
					$("#tf33").addClass("none");
				}
			}
			if (type2 == 2) {
				if ($("#tf33").hasClass("none")) {
					$("#tf33").removeClass("none");
				}
				if (!$("#tf31").hasClass("none")) {
					$("#tf31").addClass("none");
				}
				if (!$("#tf32").hasClass("none")) {
					$("#tf32").addClass("none");
				}
			}
		}
		return false;
	}
	/* 提交表单 */
	var submitForm = function() {
		var nQb = 0;
		var nClass = 0;
		if("<%=courseCode1%>" != ""){
			nClass += 1;
		}
		if("<%=courseCode2%>" != ""){
			nClass += 1;
		}
		if("<%=courseCode3%>" != ""){
			nClass += 1;
		}
		if($("#classCode1").combobox('getValue')=="qb"){
			nQb += 1;
		}
		if($("#classCode2").combobox('getValue')=="qb"){
			nQb += 1;
		}
		if($("#classCode3").combobox('getValue')=="qb"){
			nQb += 1;
		}
		if ((cxw.trim($("#motherTel").val()) == ""
			&& cxw.trim($("#fatherTel").val()) == ""
			&& cxw.trim($("#otherTel").val()) == "") || nQb == nClass) {
			$.messager.alert('提示', '必须至少填入一个电话!<br>必须至少选择一个班级!', 'info');
		} else if ($('form').form('validate')) {
			if ($("#councilSchoolCode").combobox('getValue') == undefined
					&& cxw.trim($("#councilSchoolCode").combobox('getText')) != "") {
				$("#councilSchoolCode").combobox('setValue',
						$("#councilSchoolCode").combobox('getText'));
			}
			if ($("#sellSourceCode").combobox('getValue') == undefined
					&& cxw.trim($("#sellSourceCode").combobox('getText')) != "") {
				$("#sellSourceCode").combobox('setValue',
						$("#sellSourceCode").combobox('getText'));
			}
			if ($("#sellerCode").combobox('getValue') == undefined
					&& cxw.trim($("#sellerCode").combobox('getText')) != "") {
				$("#sellerCode").combobox('setValue',
						$("#sellerCode").combobox('getText'));
			}
			parent.$.messager.progress({
				text : '保存中....'
			});
			var url="";
			url = "addStudentClassNo";
			$.post(url, cxw.serializeObject($('form')), function(
					result) {
				if (result.success) {
					parent.$.messager.progress('close');
					$.messager.alert('提示', '报名成功!', 'info');
				} else {
					$.messager.alert('提示', result.msg, 'info');
					parent.$.messager.progress('close');
				}
			}, 'json');
		}
		
	}
	
	var init = function() {

		$("#discount1").numberbox(
				{
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
		$("#discount2").numberbox(
				{
					onChange : function(newValue, oldValue) {
						if (newValue == 0.0) {
							$("#tuition2").html($("#tu2").val());
						} else {
							$("#tuition2").html($("#tu2").val() * newValue / 10);
						}
						$('#realTuition2').val($("#tuition2").html());
						CalTotalMoney();
					}
				});
		$("#discount3").numberbox(
				{
					onChange : function(newValue, oldValue) {
						if (newValue == 0.0) {
							$("#tuition3").html($("#tu3").val());
						} else {
							$("#tuition3").html($("#tu3").val() * newValue / 10);
						}
						$('#realTuition3').val($("#tuition3").html());
						CalTotalMoney();
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
							$('#realTuition1').val(data.tuition);
							CalTotalMoney();
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
							if(!$("#arrearage1").hasClass("none")){
								$("#arrearage1").addClass("none")
							}
							$("#arrearage1").empty();
							CalTotalMoney();
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
							$("#tu2").val(data.tuition);
							$("#tuition2").html(data.tuition);
							$('#realTuition2').val(data.tuition);
							CalTotalMoney();
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
							if(!$("#arrearage2").hasClass("none")){
								$("#arrearage3").addClass("none")
							}
							$("#arrearage2").empty();
							CalTotalMoney();
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
									$("#tu3").val(data.tuition);
									$("#tuition3").html(data.tuition);
									$('#realTuition3').val(data.tuition);
									CalTotalMoney();
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
									if(!$("#arrearage3").hasClass("none")){
										$("#arrearage3").addClass("none")
									}
									$("#arrearage3").empty();
									CalTotalMoney();
								}
							}
						}
					});
		}
		
		$("#btn_save").click(function(){
			submitForm();
		});
		$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode1%>"}, function(result) {
			var length1 = result.length;
			$(result).each(function(index,data){
				var str = cxw.formatString('{0}￥<span><b>{1}</b></span><input type="text" name="num1"  onkeyup="CalcShouldPay(this,1,{2},{3},{4});" onblur="CheckNonNegativeNumber(this);"  style="width:50px;" value="0">&nbsp;&nbsp;<input type="hidden" id="one{5}" value="0"><input type="hidden" name="textBookFeeCode1" value="{6}">',data.nameM,data.price,data.price,index,length1,index,data.id);
				if(data.type == 1 && data.courseTypeCode != "qb"){
					$("#tf11").append(str);
				}else if(data.type == 2){
					$("#tf13").append(str);
				}else if(data.courseTypeCode == "qb"){
					$("#tf12").append(str);
				}
			});
		});
		
		$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode2%>"}, function(result) {
			var length2 = result.length;
			$(result).each(function(index,data){
				var str = cxw.formatString('{0}￥<span><b>{1}</b></span><input type="text" name="num2"  onkeyup="CalcShouldPay(this,2,{2},{3},{4});" onblur="CheckNonNegativeNumber(this);"  style="width:50px;" value="0">&nbsp;&nbsp;<input type="hidden" id="two{5}" value="0"><input type="hidden" name="textBookFeeCode2" value="{6}">',data.nameM,data.price,data.price,index,length2,index,data.id);
				if(data.type == 1 && data.courseTypeCode != "qb"){
					$("#tf21").append(str);
				}else if(data.type == 2){
					$("#tf23").append(str);
				}else if(data.courseTypeCode == "qb"){
					$("#tf22").append(str);
				}
			});
		});
		
		$.post("getTextBookFeesByCourseType",{courseTypeCode : "<%=courseTypeCode3%>"},function(result) {
							var length3 = result.length;
							$(result)
									.each(
											function(index, data) {
												var str = cxw
														.formatString(
																'{0}￥<span><b>{1}</b></span><input type="text" name="num3"  onkeyup="CalcShouldPay(this,3,{2},{3},{4});" onblur="CheckNonNegativeNumber(this);"  style="width:50px;" value="0">&nbsp;&nbsp;<input type="hidden" id="three{5}" value="0"><input type="hidden" name="textBookFeeCode3" value="{6}">',
																data.nameM,
																data.price,
																data.price,
																index, length3,
																index, data.id);
												if (data.type == 1
														&& data.courseTypeCode != "qb") {
													$("#tf31").append(str);
												} else if (data.type == 2) {
													$("#tf33").append(str);
												} else if (data.courseTypeCode == "qb") {
													$("#tf32").append(str);
												}
											});
						});

	}
	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<form>
		<div style="display: table; margin: 20px auto;">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="nameM" class="labelUnit">学员姓名</label><input type="text"
						name="nameM" data-options="required:true"
						class="easyui-validatebox" style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="gender" class="labelUnit">学员性别</label><input
						type="radio" name="gender" checked="checked" value="0" />男 <input
						type="radio" name="gender" value="1" />女
				</div>
				<div style="display: table-cell;">
					<label for="birthday" class="labelUnit">学员生日</label><input type="text" id="birthday"
							name="birthday" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />
				</div>
				<div style="display: table-cell;">
					<label for="carCode" class="labelUnit">磁卡卡号</label><input
						id="carCode" type="text" name="carCode" />
				</div>
			</div>
			<br />

			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="motherTel" class="labelUnit">母亲电话</label><input
						id="motherTel" type="text" name="motherTel"
						style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="fatherTel" class="labelUnit">父亲电话</label><input
						id="fatherTel" type="text" name="fatherTel"
						style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="otherTel" class="labelUnit">其他电话</label><input
						id="otherTel" type="text" name="otherTel"
						style="margin-right: 20px;" />
				</div>
			</div>
			<br />
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="councilSchoolCode" class="labelUnit">公立学校</label><input
							class="easyui-combobox" name="councilSchoolCode"
							id="councilSchoolCode"
							data-options="valueField:'councilSchoolCode',textField:'councilSchool',url:'getCouncilSchools',panelHeight:'auto'" />
				</div>
				<div style="display: table-cell;">
					<label for="class_grade" class="labelUnit">班级年级</label><input
						id="class_grade" type="text" name="class_grade"
						style="margin-right: 20px;" />
				</div>
				<div style="display: table-cell;">
					<label for="liveArea" class="labelUnit">居住区域</label><input
						id="liveArea" type="text" name="liveArea"
						style="margin-right: 20px;" />
				</div>
			</div>
			<br />
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<label for="others" class="labelUnit">其他信息</label><input
						id="others" type="text" name="others" />
				</div>
			</div>
		</div>
		<div id="classDiv1" style="text-align: center; margin-top: 30px;">
			<span id="span1"
				style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
				type="text" id="classCode1" name="classCode1" style="width: 400px;"
				class="easyui-combobox" /><input type="button" value="新建"
				onclick="JavaScript:window.open('../jiaowu/xinjianbanji.jsp')" /> <span
				id="otherSpan1" class="none"><select
				onchange="changeDiscountType(1,this);" name="discountType1"
				id="discountType1">
					<option value="1">原价</option>
					<option value="2">优惠</option>
					<option value="3">折扣</option>
					<option value="4">插班</option>
			</select><span id="span12" class="none"><input id="preferntial1"
					onkeyup="changeTypeMoney(1,1,this);"
					onblur="CheckNonNegativeNumber(this);" name="preferntial1"
					style="width: 70px" value="0" />元</span><span id="span13" class="none"><input
					class="easyui-numberbox" style="width: 70px;" value="0"
					id="discount1" name="discount1"
					data-options="min:0,precision:1,max:9.9" />折</span><span id="span14"
				class="none">减免<input id="reduceMoney1" name="reduceMoney1"
					onkeyup="changeTypeMoney(1,2,this);"
					onblur="CheckNonNegativeNumber(this);" style="width: 70px"
					value="0" />元
			</span><span>=应收</span><span id="tuition1"></span><span>=实收</span><span><input
					style="width: 70px;" type="text" id="realTuition1"
					onkeyup="changeTypeMoney(1,3,this);"
					onblur="CheckNonNegativeNumber(this);" name="realTuition1" /> </span> </span>
			<div style="margin-top: 10px;" id="otherDiv1" class="none">
				<label for="tuitionRemark1">学费备注:</label><input type="text"
					name="tuitionRemark1" style="width: 500px;" id="tuitionRemark1" /><input
					type="hidden" id="tu1" />
			</div>
			<div style="margin-top: 10px;" id="arrearage1"></div>
			<div id="textbookFee1" class="none" style="margin-top: 10px;">
				<div>
					<button type="button"
						style="padding: 5px; background-color: #0066CC; color: white;"
						onclick="getTextbookFee(1,1);">教材项(本课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #5B8A5B; color: white;"
						onclick="getTextbookFee(1,0);">教材项(所有课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #BD8E2F; color: white;"
						onclick="getTextbookFee(1,2);">杂费项</button>
				</div>
				<div style="margin-top: 10px;">
					<span id="tf11" class="none"></span><span id="tf12" class="none"></span><span
						id="tf13" class="none"></span>
				</div>
				<div style="margin-top: 10px;">
					<span style="color: red;">教材杂费总计 <span
						id="textBookFeeTotal1">0</span> 元
					</span>
				</div>
			</div>
		</div>

		<div style="text-align: center; margin-top: 30px;" id="classDiv2">
			<span id="span2"
				style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
				type="text" id="classCode2" name="classCode2" style="width: 400px;"
				class="easyui-combobox" /><input type="button" value="新建"
				onclick="JavaScript:window.open('../jiaowu/xinjianbanji.jsp')" /><span
				id="otherSpan2" class="none"><select
				onchange="changeDiscountType(2,this);" name="discountType2"
				id="discountType2">
					<option value="1">原价</option>
					<option value="2">优惠</option>
					<option value="3">折扣</option>
					<option value="4">插班</option>
			</select><span id="span22" class="none"><input id="preferntial2"
					onkeyup="changeTypeMoney(2,1,this);"
					onblur="CheckNonNegativeNumber(this);" name="preferntial2"
					style="width: 70px" value="0" />元</span><span id="span23" class="none"><input
					class="easyui-numberbox" style="width: 70px;" value="0"
					id="discount2" name="discount2"
					data-options="min:0,precision:1,max:9.9" />折</span><span id="span24"
				class="none">减免<input id="reduceMoney2" name="reduceMoney2"
					onkeyup="changeTypeMoney(2,2,this);"
					onblur="CheckNonNegativeNumber(this);" style="width: 70px"
					value="0" />元
			</span><span>=应收</span><span id="tuition2"></span><span>=实收</span><span><input
					style="width: 70px;" type="text" id="realTuition2"
					onkeyup="changeTypeMoney(2,3,this);"
					onblur="CheckNonNegativeNumber(this);" name="realTuition2" /> </span> </span>
			<div style="margin-top: 10px;" id="otherDiv2" class="none">
				<label for="tuitionRemark2">学费备注:</label><input type="text"
					name="tuitionRemark2" style="width: 500px;" id="tuitionRemark2" /><input
					type="hidden" id="tu2" />
			</div>
			<div style="margin-top: 10px;" id="arrearage2"></div>
			<div id="textbookFee2" class="none" style="margin-top: 10px;">
				<div>
					<button type="button"
						style="padding: 5px; background-color: #0066CC; color: white;"
						onclick="getTextbookFee(2,1);">教材项(本课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #5B8A5B; color: white;"
						onclick="getTextbookFee(2,0);">教材项(所有课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #BD8E2F; color: white;"
						onclick="getTextbookFee(2,2);">杂费项</button>
				</div>
				<div style="margin-top: 10px;">
					<span id="tf21" class="none"></span><span id="tf22" class="none"></span><span
						id="tf23" class="none"></span>
				</div>
				<div style="margin-top: 10px;">
					<span style="color: red;">教材杂费总计 <span
						id="textBookFeeTotal2">0</span> 元
					</span>
				</div>
			</div>
		</div>


		<div style="text-align: center; margin-top: 30px;" id="classDiv3">
			<span id="span3"
				style="width: 200px; height: auto; display: inline-block; text-align: right;"></span><input
				type="text" id="classCode3" name="classCode3" style="width: 400px;"
				class="easyui-combobox" /><input type="button" value="新建"
				onclick="JavaScript:window.open('../jiaowu/xinjianbanji.jsp')" /><span
				id="otherSpan3" class="none"><select
				onchange="changeDiscountType(3,this);" name="discountType3"
				id="discountType3">
					<option value="1">原价</option>
					<option value="2">优惠</option>
					<option value="3">折扣</option>
					<option value="4">插班</option>
			</select><span id="span32" class="none"><input id="preferntial3"
					onkeyup="changeTypeMoney(3,1,this);"
					onblur="CheckNonNegativeNumber(this);" name="preferntial3"
					style="width: 70px" value="0" />元</span><span id="span33" class="none"><input
					class="easyui-numberbox" style="width: 70px;" value="0"
					id="discount3" name="discount3"
					data-options="min:0,precision:1,max:9.9" />折</span><span id="span34"
				class="none">减免<input id="reduceMoney3" name="reduceMoney3"
					onkeyup="changeTypeMoney(3,2,this);"
					onblur="CheckNonNegativeNumber(this);" style="width: 70px"
					value="0" />元
			</span><span>=应收</span><span id="tuition3"></span><span>=实收</span><span><input
					style="width: 70px;" type="text" id="realTuition3"
					onkeyup="changeTypeMoney(3,3,this);"
					onblur="CheckNonNegativeNumber(this);" name="realTuition3" /> </span> </span>
			<div style="margin-top: 10px;" id="otherDiv3" class="none">
				<label for="tuitionRemark3">学费备注:</label><input type="text"
					style="width: 500px;" id="tuitionRemark3" name="tuitionRemark3" /><input
					type="hidden" id="tu3" />
			</div>
			<div style="margin-top: 10px;" id="arrearage3"></div>
			<div id="textbookFee3" class="none" style="margin-top: 10px;">
				<div>
					<button type="button"
						style="padding: 5px; background-color: #0066CC; color: white;"
						onclick="getTextbookFee(3,1);">教材项(本课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #5B8A5B; color: white;"
						onclick="getTextbookFee(3,0);">教材项(所有课程)</button>
					<span>/</span>
					<button type="button"
						style="padding: 5px; background-color: #BD8E2F; color: white;"
						onclick="getTextbookFee(3,2);">杂费项</button>
				</div>
				<div style="margin-top: 10px;">
					<span id="tf31" class="none"></span><span id="tf32" class="none"></span><span
						id="tf33" class="none"></span>
				</div>
				<div style="margin-top: 10px;">
					<span style="color: red;">教材杂费总计 <span
						id="textBookFeeTotal3">0</span> 元
					</span>
				</div>
			</div>
		</div>

		<div style="margin: 30px auto; display: table;">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					总计:<input type="text" id="money" value="0" name="money"
						readonly="readonly" style="width: 70px;">元 <select
						name="payTypeCode" id="payTypeCode">
						<option value="1">现金支付</option>
						<option value="2">刷卡支付</option>
						<option value="3">转账支付</option>
						<option value="4">支票支付</option>
						<option value="5">网络支付</option>
					</select>=积分:<input type="text" name="points" value="0" style="width: 70px;"
						readonly="readonly" id="points">
				</div>
				<div style="display: table-cell;">
					<label for="handleSchoolCode">|经办:</label><input
						id="handleSchoolCode" class="easyui-combobox"
						style="width: 100px;" name="handleSchoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				</div>
				&nbsp;&nbsp;
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
	</form>
	<div style="text-align: center; margin-top: 20px;">
		<button type="button" id="btn_save">
			<img alt="保存" style="vertical-align: middle;"
				src="../../../style/image/save.gif"><span
				style="vertical-align: middle;">保存</span>
		</button>
	</div>

</body>
</html>