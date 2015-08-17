<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%
	String classCode = request.getParameter("classCode");
	boolean flag = StringUtils.isNotBlank(classCode);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
label {
	margin-right: 10px;
}

.divRow {
	margin-top: 5px;
}

.none {
	display: none;
}
</style>
<script type="text/javascript">
	var submitForm = function() {
		if ($("#tuitionType1").attr('checked') == true
				&& $("#tuitionType1").val() == "1") {
			if (cxw.trim($("#classTimes").val()) == "") {
				$.messager.alert('提示', '课时总数不能为空', 'info');
			}
			return;
		}
		if ($('form').form('validate')) {

			if ($("#classRoomCode").combobox('getValue') == undefined
					&& cxw.trim($("#classRoomCode").combobox('getText')) != "") {
				$("#classRoomCode").combobox('setValue',
						$("#classRoomCode").combobox('getText'));
			}
			if ($("#teacherCode").combobox('getValue') == undefined
					&& cxw.trim($("#teacherCode").combobox('getText')) != "") {
				$("#teacherCode").combobox('setValue',
						$("#teacherCode").combobox('getText'));
			}
			if ($("#assistantCode").combobox('getValue') == undefined
					&& cxw.trim($("#assistantCode").combobox('getText')) != "") {
				$("#assistantCode").combobox('setValue',
						$("#assistantCode").combobox('getText'));
			}

			var url = "";
			if(<%=flag%>){
				url = "updateClass";	
			}else{
				url = "addClass";
			}
			$.post(url, cxw.serializeObject($('form')), function(result) {
				if (result.success) {
					window.location.href = 'banjichaxun.jsp';
				} else {
					$.messager.alert('提示', '添加失败!', 'info');
				}
			}, 'json');
		}
	}

	/* 初始化页面 */
	function init() {
		$('#schoolCode').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#schoolCode').combobox('setValue', data[0].schoolCode);
				}
			}
		});
		$('#courseTypeCode').combobox(
				{
					url : 'getCourseTypes?type=2',
					valueField : 'courseTypeCode',
					textField : 'courseTypeName',
					panelHeight : 'auto',
					editable : false,
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#courseTypeCode').combobox('setValue',
									data[0].courseTypeCode);
						}
					},
					onSelect : function(data) {
						var url = 'getAllCourses?courseTypeCode='
								+ data.courseTypeCode;
						$('#courseCode').combobox('reload', url);
					}
				});

		$('#courseCode').combobox({
			url : 'getAllCourses?courseTypeCode=qb',
			valueField : 'courseCode',
			textField : 'courseName',
			panelHeight : 'auto',
			editable : false,
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#courseCode').combobox('setValue', data[0].courseCode);
				}
				if (data[0] == undefined) {
					$('#courseCode').combobox('setValue', '');
				}
			}
		});

		$('#classRoomCode').combobox({
			url : 'getClassRooms',
			valueField : 'classRoomCode',
			textField : 'classRoomName',
			panelHeight : 'auto'
		});
		$('#teacherCode').combobox({
			url : 'getUsersByRoleId?roleId=4',
			valueField : 'userId',
			textField : 'username',
			panelHeight : 'auto'
		});
		$('#assistantCode').combobox({
			url : 'getUsersByRoleId?roleId=11',
			valueField : 'userId',
			textField : 'username',
			panelHeight : 'auto'
		});

		$("#btn_save").click(function() {
			submitForm();
		});

	}

	$(document).ready(function() {
		init();
		if(<%=flag%>){
			$.post("getClassSByClassCode", {classCode :"<%=classCode%>"}, function(result) {
				tuitionChange(result.tuitionType);
				tuitionDivChange(result.tuitionType);
				loadTimigWeekday(result.weekString.split(";"));
				var url = 'getAllCourses?courseTypeCode='
					+ result.courseTypeCode;
				$('#courseCode').combobox({
					url : url,
					valueField : 'courseCode',
					textField : 'courseName',
					panelHeight : 'auto',
					editable : false,
					onLoadSuccess : function(data) {
						$('form').form('load', {
							"schoolCode" : result.schoolCode,
							"nameM" : result.nameM,
							"courseTypeCode" : result.courseTypeCode,
							"courseCode" : result.courseCode,
							"tuition" : result.tuition,
							"classTimes" : result.classTimes,
							"startDate" : result.startDate,
							"endDate" : result.endDate,
							"dateUndetermined" : result.dateUndetermined,
							"teacherCode" : result.teacherCode,
							"assistantCode" : result.assistantCode,
							"ratedNumber" : result.ratedNumber,
							"remark" : result.remark,
							"classRoomCode" : result.classRoomCode
						});
					}
				});
				
			});
		}
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<form>
			<div style="width: 40%; margin: 10px auto;">
				<div>
					<img src="../../../style/image/Folder.gif"
						style="vertical-align: middle;"> <span
						style="vertical-align: middle;">新建班级</span><input type="hidden" name="classCode" value="<%=classCode%>"/>
				</div>
				<hr />
				<div class="divRow">
					<label for="nameM">&nbsp;&nbsp;校区</label><input id="schoolCode"
						class="easyui-combobox" style="width: 100px;" name="schoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				</div>
				<div class="divRow">
					<label for="nameM">班级名称</label><input type="text" name="nameM"
						data-options="required:true" class="easyui-validatebox" />
				</div>
				<div class="divRow">
					<label>&nbsp;&nbsp;课程</label><input id="courseTypeCode"
						class="easyui-combobox" style="width: 150px;"
						data-options="required:true" name="courseTypeCode" /><input
						id="courseCode" data-options="required:true"
						class="easyui-combobox" style="width: 220px;" name="courseCode" />
				</div>
				<div class="divRow" id="tuitionDiv">
					<label for="tuitionType">收费模式</label><span id="tuitionSpan1"><input type="radio"
						id="tuitionType1" checked="checked" onclick="tuitionChange(1);"
						name="tuitionType" value="1" />按期 </span><span id="tuitionSpan2"><input type="radio" id="tuitionType2"
						name="tuitionType" value="2" onclick="tuitionChange(2);" />按次</span>
					<span id="tuitionSpan3"><input type="radio" name="tuitionType" value="3" id="tuitionType3"
						onclick="tuitionChange(3);" />按时间 &nbsp;</span><span id="tuitionTip">(保存后不能修改，谨慎选择)</span>
				</div>
				<div class="divRow">
					<label for="tuition">学费标准</label><input type="text" name="tuition"
						data-options="required:true,min:0,precision:0"
						class="easyui-numberbox" /><span id="tuitionSpanTerm">元/期</span><span
						id="tuitionSpanTimes" class="none">元/次</span><span
						id="tuitionSpanMonth" class="none">元/月</span>
				</div>
				<div class="divRow" id="classTimesDiv">
					<label for="classTimes">课时总数</label><input type="text"
						id="classTimes" name="classTimes" data-options="min:0,precision:0"
						class="easyui-numberbox" /><span id="classTimesSpan">次</span>
				</div>
				<div class="divRow" id="termDiv">
					<label for="startDate">开班日期</label><input type="text"
						style="width: 100px;" name="startDate" class="easyui-datebox"
						id="startDate1"
						data-options="value:'getCurrentDate();'" />到<input
						style="width: 100px;" type="text" name="endDate" id="endDate2"
						class="easyui-datebox"
						data-options="value:'getCurrentDate();',validType:'notBigger[\'#startDate1\']'" /><input
						type="checkbox" name="dateUndetermined" value="1" /> 日期待定
				</div>
				<div class="none" style="margin-top: 5px;" id="timeMonthDiv">
					<label for="startDate2">开班日期</label><input type="text"
						style="width: 100px;" name="startDate2" class="easyui-datebox"
						data-options="value:'getCurrentDate();'" /><input
						type="checkbox" name="dateUndetermined" value="1" /> 日期待定
				</div>
				<div class="divRow">
					<label for="teacherCode">教师名称</label><input type="text"
						id="teacherCode" name="teacherCode" class="easyui-combobox" /><label
						for="assistantCode">助教</label><input type="text"
						name="assistantCode" id="assistantCode" class="easyui-combobox" />
				</div>
				<div class="divRow">
					<label for="classRoomCode">教室名称</label><input type="text"
						id="classRoomCode" name="classRoomCode" class="easyui-combobox" />
				</div>
				<div class="divRow">
					<label style="vertical-align: top; display: inline-table;">上课时间</label>
					<div style="width: 350px; height: 160px; display: inline-table;">
						<select name="TimingWeekday1" id="TimingWeekday1"
							onChange="ChangeTimigWeekday(this,1);">
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
							<option value="0">不定</option>
						</select> <span id="Timing1">&nbsp;<input class="easyui-timespinner"
							name="startTime1" value="00:00" style="width: 80px;"
							id="startTime1" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime1"
							name="endTime1" class="easyui-timespinner" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime1\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday2"
							id="TimingWeekday2" onChange="ChangeTimigWeekday(this,2);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing2" class="none">&nbsp;<input
							name="startTime2" class="easyui-timespinner" value="00:00"
							id="startTime2" style="width: 80px;" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime2"
							class="easyui-timespinner" name="endTime2" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime2\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday3"
							id="TimingWeekday3" class="none"
							onChange="ChangeTimigWeekday(this,3);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing3" class="none">&nbsp;<input
							name="startTime3" class="easyui-timespinner" value="00:00"
							id="startTime3" style="width: 80px;" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime3"
							class="easyui-timespinner" name="endTime3" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime3\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday4"
							id="TimingWeekday4" class="none"
							onChange="ChangeTimigWeekday(this,4);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing4" class="none">&nbsp;<input
							name="startTime4" class="easyui-timespinner" value="00:00"
							id="startTime4" style="width: 80px;" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime4"
							class="easyui-timespinner" name="endTime4" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime4\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday5"
							id="TimingWeekday5" class="none"
							onChange="ChangeTimigWeekday(this,5);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing5" class="none">&nbsp;<input
							class="easyui-timespinner" value="00:00" style="width: 80px;"
							id="startTime5" name="startTime5" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime5"
							class="easyui-timespinner" name="endTime5" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime5\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday6"
							id="TimingWeekday6" class="none"
							onChange="ChangeTimigWeekday(this,6);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing6" class="none">&nbsp;<input
							name="startTime6" class="easyui-timespinner" value="00:00"
							id="startTime6" style="width: 80px;" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime6"
							class="easyui-timespinner" name="endTime6" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime6\']'"
							value="20:00"></span> <br /> <select name="TimingWeekday7"
							id="TimingWeekday7" class="none"
							onChange="ChangeTimigWeekday(this,7);">
							<option value="">无</option>
							<option value="6">周六</option>
							<option value="7">周日</option>
							<option value="1">周一</option>
							<option value="2">周二</option>
							<option value="3">周三</option>
							<option value="4">周四</option>
							<option value="5">周五</option>
						</select> <span id="Timing7" class="none">&nbsp;<input
							name="startTime7" class="easyui-timespinner" value="00:00"
							id="startTime7" style="width: 80px;" required="required"
							data-options="showSeconds:false"> &nbsp;到 &nbsp;<input id="endTime7"
							class="easyui-timespinner" name="endTime7" style="width: 80px;"
							required="required"
							data-options="showSeconds:false,validType:'notBigger[\'#startTime7\']'"
							value="20:00"></span> <br />
					</div>
				</div>
				<div class="divRow">
					<label for="ratedNumber">额定人数</label><input type="text"
						style="width: 100px;" name="ratedNumber"
						data-options="required:true,min:0,precision:0"
						class="easyui-numberbox" />
				</div>
				<div class="divRow">
					<label for="remark">&nbsp;&nbsp;备注</label><input type="text"
						style="width: 300px;" name="remark" class="easyui-validatebox" />
				</div>
				<div style="text-align: center; margin-top: 20px;">
					<button type="button" id="btn_save">
						<img alt="保存" style="vertical-align: middle;"
							src="../../../style/image/save.gif"><span
							style="vertical-align: middle;">保存</span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>