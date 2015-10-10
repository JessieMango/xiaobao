<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
	String classCode = request.getParameter("classCode") == null
			? ""
			: request.getParameter("classCode");
	String nameM = request.getParameter("nameM") == null ? "" : request
			.getParameter("nameM");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记上课详情</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
input {
	border: 1px solid #95b8e7;
	margin: 0;
	padding: 0 2px;
	vertical-align: middle;
	border-radius: 5px;
	height: 20px;
}

input, textarea {
	border: 1px solid #95b8e7;
	margin: 0;
	padding: 0 2px;
	border-radius: 5px;
}

body, input, td, div, select, button, textarea {
	font-size: 10pt;
	font-family: Hiragino Sans GB, STHeiti Light, Heiti SC Light,
		Microsoft YaHei, Century Gothic, Verdana, Geneva, sans-serif;
}

.leftLabel {
	width: 10%;
	display: inline-block;
}

.rowDiv {
	margin-top: 15px;
}

.cell{
	width : 200px;
	display: inline-block;
}
</style>
<script type="text/javascript">
	var handler = "<%=sessionInfo.getUser().getUsername()%>	于 "
			+ getCurrentDate();
	$(document).ready(function() {
		$("#handler").html(handler);
		$.post("getStudentByClassCode",{classCode:"<%=classCode%>"},function(result){
			$.each(result,function(i,data){
				var str = cxw.formatString('<div class="rowDiv"><span class="cell"><input type="checkbox" checked="checked">{0}</span> <span class="cell"><label name="disciplinePoints">纪律专注</label><select name="disciplinePoints"><option value="5">5</option><option value="4">4</option><option value="3">3</option><option value="2">2</option><option value="1">1</option></select></span>'
						+'<span class="cell"><label for="activePoints">活跃参与</label><select name="activePoints"><option value="5">5</option><option value="4">4</option><option value="3">3</option><option value="2">2</option><option value="1">1</option></select></span><span class="cell"><label for="comment">十字评语</label><input style="width:100px;" type="text" name="comment"></span></div>',data.studentName);
				$("#students").append(str);
			});
		});
	});
</script>
</head>
<body>
	<div>
		<div style="width: 70%; margin: 0 auto;">
			<div class="easyui-panel" title="班级名称&nbsp;<%=nameM%>">
				<div style="padding-left: 20px;">
					<div class="rowDiv">
						<label for="operateDate" class="leftLabel">上课日期:</label><input
							type="text" name="operateDate" class="easyui-datebox"
							data-options="required:true,value:'getCurrentDate();'" />
					</div>
					<div class="rowDiv">
						<label class="leftLabel">上课学生:</label>
						<div style="display: inline-block;" id="students"></div>
					</div>
					<div class="rowDiv">
						<label for="" class="leftLabel">上课人数:</label><span id="numbers"></span>人数(总计<span
							id="total"></span>人)
					</div>
					<div class="rowDiv">
						<label for="" class="leftLabel">完成课次:</label><input type="text"
							name="lessonNumbers" class="easyui-numberbox"
							data-options="min:0,precision:1"><span>(可填小数,如1.5)</span>
					</div>
					<div class="rowDiv">
						<label for="teacher" class="leftLabel">教师:</label><input
							type="text" name="teacher" />
					</div>
					<div class="rowDiv">
						<label for="assistant" class="leftLabel">助教:</label><input
							type="text" name="assistant" />
					</div>
					<hr>
					<div class="rowDiv">
						<label for="lessonContent" class="leftLabel">上课内容:</label><input
							type="text" name="lessonContent" style="width: 80%;">
					</div>
					<div class="rowDiv">
						<label for="afterTask" class="leftLabel">课后作业:</label>
						<textarea rows="5" cols="98" name="afterTask"></textarea>
					</div>
					<div class="rowDiv">
						<label for="remark" class="leftLabel">备注:</label> <input
							type="text" name="remark" style="width: 80%;">
					</div>
					<div class="rowDiv">
						<label class="leftLabel">添加:</label><span id="handler"></span>
					</div>
					<div class="rowDiv" style="text-align: center;">
						<button type="button" onclick="window.close();">取消</button>
						<button type="button" id="btn_submit">保存</button>
					</div>
				</div>
			</div>
			<!-- end panel -->

		</div>
	</div>
</body>
</html>