<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String userId = request.getParameter("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工档案</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
var submitForm = function($dialog,$grid,$pjq) {
	if ($('form').form('validate')) {		
		$.post("editStaff", cxw.serializeObject($('form')), function(result) {
			if (result.success) {
				$grid.datagrid('load');
				$dialog.dialog('destroy');
			} else {
				$.messager.alert('提示', '修改失败!', 'info');
			}
		}, 'json');
	}
	else
		{
			$.messager.alert('提示', '请将信息填写完整!', 'info');		
		}
	}
/* 初始化页面 */
	function init() {
		$("#btn_save").click(function() {
			submitForm();
		});
		
		var permission;
		$.post("getstaffByuserId", {userId :"<%=userId%>"}, function(rs) {
			$('form').form('load', {
				"username" : rs.username,
				"userId" :rs.userId,
				"gender" : rs.gender,
				"tel" : rs.tel,
				"IDnumber" : rs.idnumber,
				"nation" : rs.nation,
				"birthPlace" : rs.birthPlace ,
				"birthday" :rs.birthday,
				"email" : rs.email,
				"politicalStatus" : rs.politicalStatus,
				"marriage" : rs.marriage,
				"wage" : rs.wage,
				"other" : rs.other,
				"personnelstatus" : rs.personnelstatus,
				"socialsecurityStatus" : rs.socialsecurityStatus,
				"laborRelations" : rs.laborRelations,
				"contractStartDate" : rs.contractStartDate,
				"contractEndtDate" : rs.contractEndtDate,
				"confirmationdate" : rs.confirmationdate,
				"englishName" : rs.englishName,
				"trainingExperience" : rs.trainingExperience,
				"staffTag" : rs.staffTag,
				"wagecardName" : rs.wagecardName,		
				"confirmationdate" : rs.confirmationdate,	
				"trainingExperience" : rs.trainingExperience,
				"wagecardID" : rs.wagecardID,	
				"remark" : rs.remark,	
				"contractState" : rs.contractState,	
				"education" : rs.education,	
				"school" : rs.school,	
				"major" : rs.major
			});
		});

	}
	
	$(document).ready(function() {
	init();
	});
</script>
<style type="text/css">
.dvRow{
	margin-top:10px;
}
	input{
 border: 1px solid #95b8e7; margin: 0;padding: 0 2px;vertical-align: middle;border-radius: 5px;height:20px;
 }
textarea{
 border: 1px solid #95b8e7; margin: 0;padding: 0 2px;vertical-align: middle;border-radius: 5px
}
</style>
</head>
<body>
<form method="post" class="form">
	<div >
	<div style="width:80%;margin-left:auto;margin-right:auto;">
			<input type="text" name="userId" style="display:none;"  data-options="required:true" class="easyui-validatebox" />
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>姓名：</label>
			</div>
			<input type="text" name="username" data-options="required:true" class="easyui-validatebox" /><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>性  别：</label>
			</div>
			<input type="radio" checked="checked" name="gender" value="0" />男 <input type="radio" name="gender" value="1" />女<br/>
					</div>
					<div class="dvRow">
				<div style="float:left;width:20%">		
			<label>英文名 ：</label>
			</div>
			
			<input type="text" name="englishName" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>身份证号：</label>
			</div>
			<input name="IDnumber" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>生  日：</label>
			</div>
			<input name="birthday" type="text" name="dirthday" class="easyui-datebox"  data-options="required:true,editable:false,value:'getCurrentDate();'"><label>（用于年龄计算和员工生日提醒）</label><br/>	
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>手  机：</label>
			</div>
			<input name="tel" type="text"  data-options="min:0,required:true" class="easyui-numberbox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>邮  箱：</label>
			</div>
			<input name="email" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>籍  贯：</label>
			</div>
			<input name="birthPlace"  type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>民  族：</label>
			</div>
			<input name="nation" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>政  治：</label> 
			</div>
			<select name="politicalStatus" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option  value="0">群众</option>
						<option value="1">团员</option>
						<option value="2">预备党员</option>
						<option value="3">党员</option>						
					</select></div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>婚  姻：</label>
			</div>
			<select name="marriage" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">未婚</option>
						<option value="1">已婚未育</option>	
						<option value="1">已婚已育</option>		
					</select>	</div>		
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>院  校：</label>
			</div>
			<input name="school" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>专  业：</label>
			</div>
			<input name="major" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>学  历：</label>
			</div>
			<input name="education" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
		</div>
		<div class="dvRow">
				<div style="float:left;width:20%">
			<label>培训经历：</label>
			</div>
			<input name="trainingExperience" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>其  他：</label>
			</div>
			<input name="other" type="text" class="easyui-validatebox" ></input>	<br/>
			</div>
			
	</div> 
	<div  style="width: 80%;margin-left:auto;margin-right:auto;">
	<div class="dvRow">
				<div style="float:left;width:20%">
	<label>人事状态：</label>
	</div>
	
	<select name="personnelstatus" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">面试期</option>
						<option value="1">培训期</option>	
						<option value="2">试用期</option>		
						<option value="3">正式员工</option>		
						<option value="4">转正失败</option>		
						<option value="5">停薪留职</option>		
						<option value="6">主动离职</option>		
						<option value="7">被解聘</option>		
					</select>
		</div>
		<div class="dvRow">
				<div style="float:left;width:20%">
			<label>标  记：</label>
			</div>
			<input type="text" name="staffTag"  data-options="required:true" class="easyui-validatebox" ></input><br/>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>劳动合同：</label>
			</div>
			<select name="contractState" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
									<option value="0">未签</option>
									<option value="1">已期</option>	
							</select></div>
							<div class="dvRow">
				<div style="float:left;width:20%">
			
			<label>合同期 ：</label>
			</div>
			<input type="text" name="contractStartDate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'">到
								<input type="text" name="contractEndtDate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'">
								
								
								<label>（用于合同到期提醒）</label>	
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>转正日期：</label>
			</div>
			<input type="text" name="confirmationdate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'"><label>（用于试用到期提醒、累计工作天数计算）</label>
			</div>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>劳动关系：</label>
			</div>
			<select name="laborRelationsCode" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">全职</option>
						<option value="1">兼职</option>	
						<option value="1">合作</option>		
					</select>	</div>
					<div class="dvRow">
				<div style="float:left;width:20%">
			<label>社  保：</label>
			</div>
			<select name="socialsecurityStatusCode" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">已办理</option>
						<option value="1">未办理</option>		
					</select></div>
					<div class="dvRow">
				<div style="float:left;width:20%">
			<label>工资卡 ：</label>
			</div>
			<input type="text" name="wagecardName"   class="easyui-validatebox" ></input>
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>（开户行）</label>
			</div>
			<input type="text" name="wagecardID"  class="easyui-validatebox" ></input>
			<label>（卡号）</label>
			</div> 
			
			  
			<div class="dvRow">
				<div style="float:left;width:20%">
			<label>备  注：</label>
			</div>
			<input type="text"  name="remark" class="easyui-validatebox" ></input><br/><br/>
			</div>
		</div>
	</div>
	</form>
</body>
</html>