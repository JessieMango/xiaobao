<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
function init(){
	$('#cc').datebox({
		required : true,
		value : getCurrentDate()
	});
}

$(function() {
	init();		

});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div style="width: 90%; height: auto; padding: 10px;">
	<div>
		
			<label>姓名：</label><input type="text" name="nameM" class="easyui-validatebox" />
			
			<label>性别：</label><input type="radio" name="gender"
							value="0" />男 <input type="radio" name="gender" value="1" />女
							
			<label>英文名：</label><input type="text"></input>
			
			<label>身份证号：</label><input type="text"></input>
			
			<label>生日：</label><input type="text" name="dirthday" class="easyui-datebox" style="width: 200px;" required="required"><label>（用于年龄计算和员工生日提醒）</label>	
			
			<label>手机：</label><input type="text"></input>
			
			<label>邮箱：</label><input type="text"></input>
			
			<label>籍贯：</label><input type="text"></input>
			
			<label>民族：</label><input type="text"></input>
			
			<label>政治：</label><input type="text"></input>
			
			<label>婚姻：</label><input type="text"></input>
			
			<label>院校：</label><input type="text"></input>
			
			<label>专业：</label><input type="text"></input>
			
			<label>学历：</label><input type="text"></input>
			
			<label>培训经历：</label><input type="text"></input>
			
			<label>其他：</label><input type="text"></input>		
	</div>
	<div  style="text-align: center;" class="rowdiv">
			<label>人事状态：</label><input type="text"></input>
			
			<label>标记：</label><input type="text"></input>
			
			<label>劳动合同：</label><input type="text"></input>
			
			<label>合同期：</label><input type="text" name="startdate" class="easyui-datebox" style="width: 200px;" required="required">到
								<input type="text" name="enddate" class="easyui-datebox" style="width: 200px;" required="required"><label>（用于合同到期提醒）</label>	
			
			<label>转正日期：</label><input type="text" name="confirmationdate" class="easyui-datebox" style="width: 200px;" required="required">（用于试用到期提醒、累计工作天数计算）</label>
			
			<label>劳动关系：</label><input type="text"></input>
			
			<label>社保：</label><input type="text"></input>
			
			<label>工资卡：</label><input type="text"></input><label>（开户行）</label>	
								<input type="text"></input><label>（卡号）</label>	
			
			<label>备注：</label><input type="text"></input>
		</div>
	</div>
</body>
</html>