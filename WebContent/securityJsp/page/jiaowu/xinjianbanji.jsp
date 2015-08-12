<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	/* 初始化页面 */
	function init() {

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div style="width: 40%; margin: 20px auto;">
			<div>
				<img src="../../../style/image/Folder.gif"
					style="vertical-align: middle;"> <span
					style="vertical-align: middle;">新建班级</span>
			</div>
			<hr />
			<div>
				<label for="nameM">&nbsp;&nbsp;校区</label><input id="schoolCode"
					class="easyui-combobox" style="width: 100px;" name="schoolCode"
					data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
				<div>
					<label for="nameM">班级名称</label><input type="text" name="nameM"
						data-options="required:true" class="easyui-validatebox" />
				</div>
				<div>
					<label>&nbsp;&nbsp;课程</label><input id="courseTypeCode"
						class="easyui-combobox" style="width: 100px;"
						name="courseTypeCode" /><input id="courseCode"
						class="easyui-combobox" style="width: 100px;" name="courseCode" />
				</div>
				<div>
					<label for="tuitionType">收费模式</label><input type="radio"
						name="tuitionType" value="1" />按期 <input type="radio"
						name="tuitionType" value="2" />按次 <input type="radio"
						name="tuitionType" value="3" />按时间 &nbsp;(保存后不能修改，谨慎选择)
				</div>
				<div>
					<label for="tuition">学费标准</label><input type="text" name="tuition"
						data-options="required:true" class="easyui-validatebox" /><span
						id="tuitionSpan">元/期</span>
				</div>
				<div>
					<label for="classTimes">课时总数</label><input type="text"
						name="classTimes" data-options="required:true"
						class="easyui-validatebox" />
				</div>
				<div>
					<label for="startDate">开班日期</label><input type="text"
						name="startDate" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />到<input
						type="text" name="endDate" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" /><input
						type="checkbox" name="dateUndetermined" value="1" />
				</div>
				<div>
					<label for="teacherCode">教师名称</label><input type="text"
						name="classTimes" data-options="required:true"
						class="easyui-validatebox" /><label for="assistant">助教</label><input
						type="text" name="assistant" class="easyui-validatebox" />

				</div>
			</div>
		</div>
	</div>
</body>
</html>