<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建档案</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
function init(){
	$('#nameM').datebox({
		required : true,
		value : getCurrentDate()
	});
	
	$('#dirthday').datebox({
		required : true,
		value : getCurrentDate()
	});
	$('#startdate').datebox({
		required : true,
		value : getCurrentDate()
	});
	$('#enddate').datebox({
		required : true,
		value : getCurrentDate()
	});
	$('#confirmationdate').datebox({
		required : true,
		value : getCurrentDate()
	});
	
	$('#cb').combobox({
		url : 'readOperateType',
		valueField : 'id',
		textField : 'operateName',
		editable : false,
		panelHeight : "auto",
		required : true,
		onLoadSuccess : function(data) {
			if (data) {
				$('#cb').combobox('setValue', data[0].id);
			}
		}
	});
	
		
}

$(function() {
	init();		

});
</script>
</head>
<body>
<form method="post" class="form">
	<div style="width: 90%; height: auto; padding: 10px;">
	<div>
		
			<label>姓名：</label><input type="text" name="username" class="easyui-validatebox" />
			
			<label>性别：</label><input type="radio" name="gender" value="0" />男 <input type="radio" name="gender" value="1" />女
							
			<label>英文名：</label><input type="text" name="englishName" class="easyui-validatebox" ></input>
			
			<label>身份证号：</label><input name="IDnumber" type="text" class="easyui-validatebox" ></input>
			
			<label>生日：</label><input name="birthday" type="text" name="dirthday" class="easyui-datebox" style="width: 200px;" required="required"><label>（用于年龄计算和员工生日提醒）</label>	
			
			<label>手机：</label><input name="tel" type="text" class="easyui-validatebox" ></input>
			
			<label>邮箱：</label><input name="email" type="text" class="easyui-validatebox" ></input>
			
			<label>籍贯：</label><input name="birthPlace" type="text" class="easyui-validatebox" ></input>
			
			<label>民族：</label><input name="nation" type="text" class="easyui-validatebox" ></input>
			
			<label>政治：</label> <select name="politicalStatus" style="width: 200px;" 	class="easyui-combobox"></select>
			
			<label>婚姻：</label><select name="marriage" style="width: 200px;" class="easyui-combobox" data-options="valueField:'councilSchoolCode',textField:'councilSchool',url:''"></select>
			//在文档中的user表
			
			//在文档中的DStaffEducation表
			<label>院校：</label><input name="school" type="text" class="easyui-validatebox" ></input>
			
			<label>专业：</label><input name="major" type="text" class="easyui-validatebox" ></input>
			
			<label>学历：</label><input name="education" type="text" class="easyui-validatebox" ></input>
		
			<label>培训经历：</label><input name="trainingExperience"type="text" class="easyui-validatebox" ></input>
			
			<label>其他：</label><input name="other" type="text" class="easyui-validatebox" ></input>	
			
			
	</div>
	
	<div  style="text-align: center;" class="rowdiv">
			//在文档中的Staff 表
			<label>人事状态：</label><select name="state" style="width: 200px;" class="easyui-combobox"></select>
			
			<label>标记：</label><input type="text" name="staffTag" class="easyui-validatebox" ></input>
			
			<label>劳动合同：</label><select name="contractStatus" style="width: 200px;" class="easyui-combobox"></select>
			
			<label>合同期：</label><input type="text" name="contractStartDate" class="easyui-datebox" style="width: 200px;" required="required">到
								<input type="text" name="contractEndtDate" class="easyui-datebox" style="width: 200px;" required="required"><label>（用于合同到期提醒）</label>	
			
			<label>转正日期：</label><input type="text" name="confirmationdate" class="easyui-datebox" style="width: 200px;" required="required"><label>（用于试用到期提醒、累计工作天数计算）</label>
			
			<label>劳动关系：</label><select name="laborRelations" style="width: 200px;" class="easyui-combobox"></select>
			
			<label>社保：</label><select name="socialsecurityStatus" style="width: 200px;" class="easyui-combobox"></select>
			
			<label>工资卡：</label><input type="text" name="wagecardName"  class="easyui-validatebox" ></input><label>（开户行）</label>	
								<input type="text" name="wagecardID" class="easyui-validatebox" ></input><label>（卡号）</label>	
			
			<label>备注：</label><input type="text"  name="remarks" class="easyui-validatebox" ></input>
			
			
			<button type="submit">
				<img alt="保存" style="vertical-align: middle;"
					src="../../../style/image/save.gif"><span
					style="vertical-align: middle;">保存</span>
			</button>
		</div>
	</div>
	</form>
</body>
</html>