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
	var init = function() {
		
		if("<%=courseCode1%>" == ""){
			$("#classDiv1").addClass("none");
		}else{
			$("#classDiv1").addClass("row");
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
				}
			});
		}
		if("<%=courseCode2%>" == ""){
			$("#classDiv2").addClass("none");
		}else{
			$("#classDiv2").addClass("row");
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
				}
			});
		}
		if("<%=courseCode3%>" == "") {
			$("#classDiv3").addClass("none");
		}else{
			$("#classDiv3").addClass("row");
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
	<div style="margin: 60px auto; display: table;">
		<div style="text-align: center;" id="classDiv1">
			<span id="span1" style="display: table-cell;"></span><input
				type="text" id="classCode1" name="classCode"
				style="width: 400px; display: table-cell;" class="easyui-combobox" /><a
				style="display: table-cell;"
				href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
				target="_blank"><button>新建</button></a>
		</div>
		<br />
		<div style="text-align: center;" id="classDiv2">
			<span id="span2" style="display: table-cell;"></span><input
				type="text" id="classCode2" name="classCode2"
				style="width: 400px; display: table-cell;" class="easyui-combobox" /><a
				style="display: table-cell;"
				href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
				target="_blank"><button>新建</button></a>
		</div>
		<br />
		<div style="text-align: center;" id="classDiv3">
			<span id="span3" style="display: table-cell;"></span><input
				type="text" id="classCode3" name="classCode3"
				style="width: 400px; display: table-cell;" class="easyui-combobox" /><a
				style="display: table-cell;"
				href="<%=basePath%>/securityJsp/page/jiaowu/xinjianbanji.jsp"
				target="_blank"><button>新建</button></a>
		</div>
	</div>
	<form id="form2">
		<div style="margin: 30px auto; display: table;">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					总计:<span id="money"></span>元<input type="text" id="payCode"
						name="payCode" style="width: 100px;" class="easyui-combobox" />
				</div>
				<div style="display: table-cell;">
					<label for="handleSchoolCode">经办:</label><input
						id="handleSchoolCode" class="easyui-combobox"
						style="width: 100px;" name="handleSchoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				</div>
				<div style="display: table-cell;">
					<label for="sellSourceCode">销售来源:</label><input
						class="easyui-combobox" name="sellSourceCode" id="sellSourceCode"
						style="width: 100px;"
						data-options="valueField:'sellSourceCode',textField:'sellSource',url:'getSellSource',panelHeight:'auto'" />&nbsp;&nbsp;
				</div>
				<div style="display: table-cell;">
					<label for="sellerCode">销售员:</label><input class="easyui-combobox"
						id="sellerCode" name="sellerCode" style="width: 100px;"
						data-options="valueField:'sellerCode',textField:'seller',url:'getSeller',panelHeight:'auto' " />
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