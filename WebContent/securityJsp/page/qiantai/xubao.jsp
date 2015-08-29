<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("consultId") == null ? "" : request
			.getParameter("consultId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>续报</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
body {
	text-align: center;
}
</style>
<script type="text/javascript">
var submitForm = function() {
	if ($('form').form('validate')) {
		var courseCode1 = $('#courseCode1').combobox('getValue');
		var courseTypeCode1 = $('#courseTypeCode1').combobox('getValue');
		var courseName1 = $('#courseCode1').combobox('getText');
			window.location.href = "baoming.jsp?courseCode1="
					+ courseCode1
					+ "&courseName1="+courseName1+ "&courseTypeCode1="+ courseTypeCode1  +"&id="+"<%=id%>";
		}
	};
	var init = function() {
		$('#courseTypeCode1').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#courseTypeCode1').combobox('setValue',
									data[0].courseTypeCode);
						}
					},
					onSelect : function(data) {
						var url = 'getAllCourses?courseTypeCode='
								+ data.courseTypeCode;
						$('#courseCode1').combobox('reload', url);
					}
				});

		$('#courseCode1').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#courseCode1').combobox('setValue', data[0].courseCode);
				}
				if (data[0] == undefined) {
					$('#courseCode1').combobox('setValue', '');
				}
			}
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
	<div style="position: absolute; top: 40%; left: 40%; z-index: 1;">
		<form>
			<div style="display: inline-table;">
				<br /> <br /> <span>选择报名课程</span><br />
				<div style="margin-top: 30px;">
					<input id="courseTypeCode1" class="easyui-combobox"
						style="width: 150px;"
						data-options="required:true,valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=2',panelHeight:'auto',editable:false"
						name="courseTypeCode1" /><input id="courseCode1"
						data-options="required:true,valueField:'courseCode',textField:'courseName',url:'getAllCourses?courseTypeCode=qb',panelHeight:'auto',editable:false"
						class="easyui-combobox" style="width: 220px;" name="courseCode1" />
				</div>
				<div style="text-align: center; margin-top: 20px;">
					<button type="button" id="btn_save">
						<img alt="保存" style="vertical-align: middle;"
							src="../../../style/image/save.gif"><span
							style="vertical-align: middle;">继续</span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>