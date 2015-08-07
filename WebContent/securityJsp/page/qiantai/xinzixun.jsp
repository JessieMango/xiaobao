<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../../inc.jsp"></jsp:include>
<title></title>
<style type="text/css">
label {
	margin-right: 10px;
	width: 50px;
}

.rowdiv {
	margin-top: 15px;
}
</style>
<script type="text/javascript">
	var submitForm = function() {
		if (cxw.trim($("#motherTel").val()) == ""
				&& cxw.trim($("#fatherTel").val()) == ""
				&& cxw.trim($("#otherTel").val()) == "") {
			$.messager.alert('提示', '必须至少填入一个电话!', 'info');
		} else if ($('form').form('validate')) {
			if ($("#councilSchoolCode").combobox('getValue') == undefined
					&& cxw.trim($("#councilSchoolCode").combobox('getText')) != "") {
				$("#councilSchoolCode").combobox('setValue',
						$("#councilSchoolCode").combobox('getText'));
			}
			if ($("#markCode").combobox('getValue') == undefined
					&& cxw.trim($("#markCode").combobox('getText')) != "") {
				$("#markCode").combobox('setValue',
						$("#markCode").combobox('getText'));
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
			$.post("saveConsult", cxw.serializeObject($('form')), function(
					result) {
				if (result.success) {
					window.location.href = 'zixunjilu.jsp';
				} else {
					$.messager.alert('提示', '添加失败!', 'info');
				}
			}, 'json');
		}
	}
	/* 初始化页面 */
	function init() {
		$('#consultCourseCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#consultCourseCode').combobox('setValue',
									data[0].courseTypeCode);
						}
					}
				});
		$('#willDegreeCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#willDegreeCode').combobox('setValue',
									data[0].willDegreeCode);
						}
					}
				});
		$('#handleSchoolCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#handleSchoolCode').combobox('setValue',
									data[0].schoolCode);
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
	<form method="post" class="form">
		<div style="width: 90%; height: auto; padding: 10px;">
			<div>
				<div style="display: inline; float: left; width: 25%;">
					<label for="nameM">学员姓名</label><input type="text" name="nameM"
						data-options="required:true" class="easyui-validatebox" />
				</div>
				<div style="display: inline; width: 25%;">
					<label for="gender">学员性别</label><input type="radio" name="gender"
						checked="checked" value="0" />男 <input type="radio" name="gender"
						value="1" />女
				</div>
				<div style="display: inline; float: right; width: 25%;">
					<label for="birthday">学员生日</label><input type="text" id="birthday"
						name="birthday" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
			</div>
			<div class="rowdiv">
				<div style="display: inline; float: left; width: 25%;">
					<label for="motherTel">母亲电话</label><input type="text"
						id="motherTel" data-options="min:0,precision:0" name="motherTel"
						class="easyui-validatebox" />
				</div>
				<div style="display: inline; width: 25%;">
					<label for="fatherTel">父亲电话</label><input type="text"
						class="easyui-numberbox" id="fatherTel"
						data-options="min:0,precision:0" name="fatherTel"
						style="width: 300px;" />
				</div>
				<div style="display: inline; float: right; width: 25%;">
					<label for="otherTel">其他电话</label><input type="text"
						class="easyui-numberbox" name="otherTel"
						data-options="min:0,precision:0" id="otherTel" />
				</div>
			</div>
			<div class="rowdiv">
				<div style="display: inline; float: left; width: 25%;">
					<label for="councilSchoolCode">公立学校</label><input
						class="easyui-combobox" name="councilSchoolCode"
						id="councilSchoolCode"
						data-options="valueField:'councilSchoolCode',textField:'councilSchool',url:'getCouncilSchools',panelHeight:'auto'" />
				</div>
				<div style="display: inline; width: 25%;">
					<label for="class_grade">班级年级</label><input type="text"
						name="class_grade" class="easyui-validatebox"
						style="width: 300px;" />
				</div>
				<div style="display: inline; float: right; width: 25%;">
					<label for="liveArea">居住区域</label><input type="text"
						name="liveArea" class="easyui-validatebox" />
				</div>
				<div class="rowdiv">
					<label for="others">其他信息</label><input type="text" name="others"
						style="width: 800px;" class="easyui-validatebox" />
				</div>
				<div class="rowdiv">
					<label for="consultWayCode">咨询方式</label><input type="radio"
						checked="checked" name="consultWayCode" value="1" />来电<input
						type="radio" name="consultWayCode" value="2" />来访<input
						type="radio" name="consultWayCode" value="3" />网络 <input
						type="radio" name="consultWayCode" value="4" />其他
				</div>
				<div class="rowdiv">
					<label for="consultCourseCode">咨询课程</label><input
						class="easyui-combobox" name="consultCourseCode"
						id="consultCourseCode"
						data-options="valueField:'courseTypeCode',textField:'courseTypeName',url:'getCourseTypes',panelHeight:'auto',editable:false" />
				</div>
				<div class="rowdiv">
					<label for="consultContent" style="vertical-align: top;">咨询内容</label>
					<textarea name="consultContent" rows="3" cols="250"
						style="width: 300px; height: 50px;"></textarea>
				</div>
				<div class="rowdiv">
					<label for="willDegreeCode" style="text-align: right;">&nbsp;意向度</label><input
						id="willDegreeCode" class="easyui-combobox" name="willDegreeCode"
						data-options="valueField:'willDegreeCode',textField:'willDegree',url:'getWillDegree',panelHeight:'auto',editable:false" />
				</div>
				<div class="rowdiv">
					<label for="markCode">&nbsp;&nbsp;标记</label><input
						class="easyui-combobox" name="markCode" id="markCode"
						data-options="valueField:'markCode',textField:'mark',url:'getMark',panelHeight:'auto'" />
				</div>
			</div>
			<div style="text-align: center;" class="rowdiv">
				<div style="display: inline;">
					<label for="sellSourceCode">销售来源</label><input
						class="easyui-combobox" name="sellSourceCode" id="sellSourceCode"
						data-options="valueField:'sellSourceCode',textField:'sellSource',url:'getSellSource',panelHeight:'auto'" />
				</div>
				<div style="display: inline;">
					<label for="sellerCode">销售员</label><input class="easyui-combobox"
						id="sellerCode" name="sellerCode"
						data-options="valueField:'sellerCode',textField:'seller',url:'getSeller',panelHeight:'auto'" />
				</div>
				<div style="display: inline;">
					<label for="consultDate">咨询日期</label><input type="text"
						name="consultDate" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
				<div style="display: inline;">
					<label for="handleSchoolCode">经办:</label><input
						id="handleSchoolCode" class="easyui-combobox"
						name="handleSchoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
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