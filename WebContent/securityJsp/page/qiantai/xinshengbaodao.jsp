<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id") == null ? "" : request
			.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.none {
	display: none;
}

label {
	margin-right: 10px;
	width: 50px;
}

.rowdiv {
	margin-top: 15px;
}

input {
	border: 1px solid #95b8e7;
	margin: 0;
	padding: 0 2px;
	vertical-align: middle;
	border-radius: 5px;
	height: 20px;
}

* {
	font-size: 12px;
}
</style>
<script type="text/javascript">
	var queryConsult = function() {
		var nameM = cxw.trim($("#nameM").val());
		var telTail = cxw.trim($("#telTail").val())
		if (nameM == "" && telTail == "") {
			$.messager.alert('警告', '用户名或电话尾号至少有一个不为空', 'warning');
		} else {
			window.location.href = 'zixunjilu.jsp?page=1&nameM=' + nameM
					+ '&telTail=' + telTail;
		}
	};
	var submitForm = function() {
		if ($('form').form('validate')) {
			var courseCode1 = $('#courseCode1').combobox('getValue');
			var courseCode2 = $('#courseCode2').combobox('getValue');
			var courseCode3 = $('#courseCode3').combobox('getValue');
			var courseTypeCode1 = $('#courseTypeCode1').combobox('getValue');
			var courseTypeCode2 = $('#courseTypeCode2').combobox('getValue');
			var courseTypeCode3 = $('#courseTypeCode3').combobox('getValue');
			var courseName1 = $('#courseCode1').combobox('getText');
			var courseName2 = $('#courseCode2').combobox('getText');
			var courseName3 = $('#courseCode3').combobox('getText');
			if("<%=id%>" != ""){
				window.location.href = "baoming.jsp?courseCode1="
						+ courseCode1 + "&courseCode2=" + courseCode2
						+ "&courseCode3=" + courseCode3+"&courseName1="+courseName1+"&courseName2="+
						courseName2+"&courseName3="+courseName3 + "&courseTypeCode1="+ courseTypeCode1 + "&courseTypeCode2=" 
						+ courseTypeCode2  + "&courseTypeCode3=" + courseTypeCode3 +"&id="+"<%=id%>";
			}else{
				window.location.href = "wuzixunbaoming.jsp?courseCode1="
					+ courseCode1 + "&courseCode2=" + courseCode2
					+ "&courseCode3=" + courseCode3+"&courseName1="+courseName1+"&courseName2="+
					courseName2+"&courseName3="+courseName3 + "&courseTypeCode1="+ courseTypeCode1 + "&courseTypeCode2=" 
					+ courseTypeCode2  + "&courseTypeCode3=" + courseTypeCode3;
			}
		}
	};
	function init() {
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
		$('#courseTypeCode2').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#courseTypeCode2').combobox('setValue',
									data[0].courseTypeCode);
						}
					},
					onSelect : function(data) {
						var url = 'getAllCourses?courseTypeCode='
								+ data.courseTypeCode;
						$('#courseCode2').combobox('reload', url);
					}
				});
		$('#courseCode2').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#courseCode2').combobox('setValue', data[0].courseCode);
				}
				if (data[0] == undefined) {
					$('#courseCode2').combobox('setValue', '');
				}
			}
		});
		$('#courseTypeCode3').combobox(
				{
					onLoadSuccess : function(data) {
						if (data[0]) {
							$('#courseTypeCode3').combobox('setValue',
									data[0].courseTypeCode);
						}
					},
					onSelect : function(data) {
						var url = 'getAllCourses?courseTypeCode='
								+ data.courseTypeCode;
						$('#courseCode3').combobox('reload', url);
					}
				});
		$('#courseCode3').combobox({
			onLoadSuccess : function(data) {
				if (data[0] && data[0] != undefined) {
					$('#courseCode3').combobox('setValue', data[0].courseCode);
				}
				if (data[0] == undefined) {
					$('#courseCode3').combobox('setValue', '');
				}
			}
		});
		$("#btn_save").click(function() {
			submitForm();
		});
	}
	$(document).ready(function() {
		init();
		if("<%=id%>" != "") {
			$("#leftDiv").addClass("none");
		}
	});
</script>
</head>
<body>
	<div style="padding: 10px">
		<div>
			<div>
				<div style="float: left; width: 40%;">
					<div class="easyui-panel" title="有咨询记录(快速报名)">
						<div class="rowdiv" style="text-align: center">
							<label for="nameM">学员姓名</label> <input type="text" id="nameM"
								name="nameM" class="easyui-validatebox" />
						</div>
						<div class="rowdiv" style="text-align: center">
							<label for="telTail">学员电话尾号</label><input type="text"
								id="telTail" name="telTail" class="easyui-validatebox" />

						</div>
						<div class="rowdiv" style="text-align: center">

							<a href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-zoom',plain:true"
								onclick="queryConsult();">查询</a>
						</div>
					</div>
				</div>
				<div style="float: right; width: 59%">
					<form>
						<div class="easyui-panel" title="无咨询记录(直接报名)">
							<div class="rowdiv" style="text-align: center">
								<input id="courseTypeCode1" class="easyui-combobox"
									style="width: 150px;"
									data-options="required:true,valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=2',panelHeight:'auto',editable:false"
									name="courseTypeCode1" />&nbsp;<input id="courseCode1"
									data-options="required:true,valueField:'courseCode',textField:'courseName',url:'getAllCourses?courseTypeCode=qb',panelHeight:'auto',editable:false"
									class="easyui-combobox" style="width: 220px;"
									name="courseCode1" />
							</div>

							<div class="rowdiv" style="text-align: center">
								<input id="courseTypeCode2" class="easyui-combobox"
									style="width: 150px;"
									data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=2',panelHeight:'auto',editable:false"
									name="courseTypeCode2" />&nbsp;<input id="courseCode2"
									data-options="valueField:'courseCode',textField:'courseName',url:'getAllCourses?courseTypeCode=qb',panelHeight:'auto',editable:false"
									class="easyui-combobox" style="width: 220px;"
									name="courseCode2" />
							</div>
							<div class="rowdiv" style="text-align: center">
								<input id="courseTypeCode3" class="easyui-combobox"
									style="width: 150px;"
									data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes?type=2',panelHeight:'auto',editable:false"
									name="courseTypeCode3" />&nbsp;<input id="courseCode3"
									data-options="valueField:'courseCode',textField:'courseName',url:'getAllCourses?courseTypeCode=qb',panelHeight:'auto',editable:false"
									class="easyui-combobox" style="width: 220px;"
									name="courseCode3" />


							</div>
							<div class="rowdiv" style="text-align: center">
								<button type="button" id="btn_save">
									<img alt="保存" style="vertical-align: middle;"
										src="../../../style/image/save.gif"><span
										style="vertical-align: middle;">继续</span>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div></div>
	</div>
</body>
</html>