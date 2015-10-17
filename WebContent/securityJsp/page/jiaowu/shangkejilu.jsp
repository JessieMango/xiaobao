<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上课记录/学费消耗</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(
			function() {
				var dateFirst = firstOfMouthDate();
				var currentDate = getCurrentDate();
				$("#startTime").datebox('setValue', dateFirst);
				$("#endTime").datebox('setValue', currentDate);
				/* 选中学校中的第一个 */
				$('#handleSchoolCode').combobox(
						{
							onLoadSuccess : function(data) {
								if (data) {
									$('#handleSchoolCode').combobox('setValue',
											data[0].schoolCode);
								}
							}
						});
				/* 选中教师中的第一个 */
				$('#teacherCode').combobox(
						{
							onLoadSuccess : function(data) {
								if (data) {
									$('#teacherCode').combobox('setValue',
											data[0].userId);
								}
							}
						});
				/* 选中助教中的第一个 */
				$('#assistantCode').combobox(
						{
							onLoadSuccess : function(data) {
								if (data) {
									$('#assistantCode').combobox('setValue',
											data[0].userId);
								}
							}
						});

			});
</script>
</head>
<body>
	<div style="text-align: center;">
		<select style="width: 120px;"><option value="1">上课日期</option>
			<option value="2">新建日期</option>
		</select><input type="text" name="startTime" id="startTime"
			style="width: 120px;" class="easyui-datebox"
			data-options="required:true" /> 到 <input style="width: 120px;"
			type="text" name="endTime" id="endTime" class="easyui-datebox"
			data-options="required:true" /><input id="handleSchoolCode"
			class="easyui-combobox" style="width: 120px;" name="handleSchoolCode"
			data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools?type=1',panelHeight:'auto',editable:false" />
		<input type="text" style="width: 120px;" class="easyui-combobox"
			data-options="valueField:'userId',textField:'username',url:'getUsersByRoleId?roleId=4&combo=1',panelHeight:'auto',editable:false"
			id="teacherCode" name="teacherCode" class="easyui-combobox" /> <input
			type="text" style="width: 120px;" class="easyui-combobox"
			data-options="valueField:'userId',textField:'username',url:'getUsersByRoleId?roleId=11&combo=1',panelHeight:'auto',editable:false"
			id="assistantCode" name="assistantCode" class="easyui-combobox" />
	</div>
</body>
</html>