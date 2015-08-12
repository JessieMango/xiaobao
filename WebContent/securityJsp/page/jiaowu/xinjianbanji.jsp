<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						if (data) {
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
	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div style="width: 40%; margin: 10px auto;">
			<div>
				<img src="../../../style/image/Folder.gif"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">新建班级</span>
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
					class="easyui-combobox" style="width: 150px;" name="courseTypeCode" /><input
					id="courseCode" class="easyui-combobox" style="width: 220px;"
					name="courseCode" />
			</div>
			<div class="divRow">
				<label for="tuitionType">收费模式</label><input type="radio"
					name="tuitionType" value="1" />按期 <input type="radio"
					name="tuitionType" value="2" />按次 <input type="radio"
					name="tuitionType" value="3" />按时间 &nbsp;(保存后不能修改，谨慎选择)
			</div>
			<div class="divRow">
				<label for="tuition">学费标准</label><input type="text" name="tuition"
					data-options="required:true" class="easyui-validatebox" /><span
					id="tuitionSpan">元/期</span>
			</div>
			<div class="divRow">
				<label for="classTimes">课时总数</label><input type="text"
					name="classTimes" data-options="required:true"
					class="easyui-validatebox" />
			</div>
			<div class="divRow">
				<label for="startDate">开班日期</label><input type="text"
					style="width: 100px;" name="startDate" class="easyui-datebox"
					data-options="required:true,value:'getCurrentDate();'" />到<input
					style="width: 100px;" type="text" name="endDate"
					class="easyui-datebox"
					data-options="required:true,value:'getCurrentDate();'" /><input
					type="checkbox" name="dateUndetermined" value="1" /> 日期待定
			</div>
			<div class="divRow">
				<label for="teacherCode">教师名称</label><input type="text"
					name="classTimes" data-options="required:true"
					class="easyui-combobox" /><label for="assistant">助教</label><input
					type="text" name="assistant" class="easyui-validatebox" />
			</div>
			<div class="divRow">
				<label for="classroomCode">教室名称</label><input type="text"
					name="classroomCode" data-options="required:true"
					class="easyui-combobox" />
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
						value="00:00" style="width: 80px;" required="required"
						data-options="showSeconds:false"> &nbsp;到 &nbsp;<input
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false" value="20:00"></span>
					<br /> <select name="TimingWeekday2" id="TimingWeekday2"
						onChange="ChangeTimigWeekday(this,2);">
						<option value="">无</option>
						<option value="6">周六</option>
						<option value="7">周日</option>
						<option value="1">周一</option>
						<option value="2">周二</option>
						<option value="3">周三</option>
						<option value="4">周四</option>
						<option value="5">周五</option>
					</select> <span id="Timing2" class="none">&nbsp;<input
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br /> <select
						name="TimingWeekday3" id="TimingWeekday3" class="none"
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
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br /> <select
						name="TimingWeekday4" id="TimingWeekday4" class="none"
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
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br /> <select
						name="TimingWeekday5" id="TimingWeekday5" class="none"
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
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br /> <select
						name="TimingWeekday6" id="TimingWeekday6" class="none"
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
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br /> <select
						name="TimingWeekday7" id="TimingWeekday7" class="none"
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
						class="easyui-timespinner" value="00:00" style="width: 80px;"
						required="required" data-options="showSeconds:false">
						&nbsp;到 &nbsp;<input class="easyui-timespinner" value="00:00"
						style="width: 80px;" required="required"
						data-options="showSeconds:false" value="20:00"></span> <br />
				</div>
			</div>
			<div class="divRow">
				<label for="ratedNumber">课时总数</label><input type="text"
					style="width: 100px;" name="ratedNumber"
					data-options="required:true" class="easyui-validatebox" />
			</div>
			<div class="divRow">
				<label for="remark">&nbsp;&nbsp;备注</label><input type="text"
					style="width: 300px;" name="remark" data-options="required:true"
					class="easyui-validatebox" />
			</div>
		</div>
	</div>
</body>
</html>