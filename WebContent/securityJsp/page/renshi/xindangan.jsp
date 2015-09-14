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
var submitForm = function() {
	if ($('form').form('validate')) {
		$.post("createStaff", cxw.serializeObject($('form')), function(
				result) {
			if (result.success) {
				$.messager.alert('提示', '添加成功!', 'info');
			} else {
				$.messager.alert('提示', '添加失败!', 'info');
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
		$('#politicalStatus').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#politicalStatus').combobox('setValue',
									data[0].id);
						}
					}
				});
		$('#laborRelationsCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#laborRelationsCode').combobox('setValue',
									data[0].id);
						}
					}
				});
		$('#personnelstatus').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#personnelstatus').combobox('setValue',
									data[0].id);
						}
					}
				});	
		$('#socialsecurityStatusCode').combobox(
				{
					onLoadSuccess : function(data) {
						if (data) {
							$('#socialsecurityStatusCode').combobox('setValue',
									data[0].id);
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
<style type="text/css">
	input{
 border: 1px solid #95b8e7; margin: 0;padding: 0 2px;vertical-align: middle;border-radius: 5px;height:20px;
 }
textarea{
 border: 1px solid #95b8e7; margin: 0;padding: 0 2px;vertical-align: middle;border-radius: 5px
}
lable{
	font-size:14px;
}
.dvRowSpan{
	margin-top:5px;
}
</style>
</head>
<body>
<form method="post" class="form">
	<div >
	<div style="width: 70%;margin-left:auto;margin-right:auto;">
		
		<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>姓  名：</label> &nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="username"  data-options="required:true" class="easyui-validatebox" />
			</div> 
		</div>
     
     <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>性  别：</label> &nbsp;
			</div>
			<div style="display:inline">
				<input type="radio" checked="checked" name="gender" value="0" />男 <input type="radio" name="gender" value="1" />女
			</div> 
		</div>
			
			
	  <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>英文名 ：</label> &nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="englishName" class="easyui-validatebox" ></input>
			</div> 
		</div>
		
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>身份证号：</label> &nbsp;
			</div>
			<div style="display:inline">
				<input name="IDnumber" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>	
				
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>生  日：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="birthday" type="text" name="dirthday" class="easyui-datebox"  data-options="required:true,editable:false,value:'getCurrentDate();'"><label>（用于年龄计算和员工生日提醒）</label>
			</div> 
		</div>			
			
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>手  机：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="tel"  type="text"  data-options="min:0,required:true" class="easyui-numberbox" ></input>
			</div> 
		</div>			
			
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>邮  箱：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="email" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>	
			
	 <div class="dvRowSpan">
			<div style="width:100px;float:left">
				<label>籍  贯：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="birthPlace"  type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>		
			
			
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>民  族：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="nation" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>	
			
			
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>政  治：</label> &nbsp;
			</div>
			<div style="display:inline">
				<input class="easyui-combobox" name="politicalStatus"
							id="politicalStatus" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getpoliticalStatus',required:true,panelHeight:'auto',editable:false" />
			</div> 
		</div>		 
		
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>婚  姻：</label> &nbsp;
			</div>
			<div style="display:inline">
				<select name="marriage" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
						<option value="0">未婚</option>
						<option value="1">已婚未育</option>	
						<option value="1">已婚已育</option>		
					</select>
			</div> 
		</div>		
			 
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>院  校：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="school" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>			
			
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>专  业：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="major" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>		
			
	  <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>学  历：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="education" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>	 
			
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>培训经历：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="trainingExperience" data-options="required:true" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>		
		
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>其  他：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input name="other" type="text" class="easyui-validatebox" ></input>
			</div> 
		</div>	 
	</div> 
	<div  style="width: 70%;margin-left:auto;margin-right:auto;">
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>人事状态：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input class="easyui-combobox" name="personnelstatus"
							id="personnelstatus" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getpersonnelstatus',panelHeight:'auto',required:true,editable:false" />
			</div> 
		</div>	
	
		 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>标  记：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="staffTag"  data-options="required:true" class="easyui-validatebox" ></input>
			</div> 
		</div>	
	
	 <div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>劳动合同：</label>&nbsp;
			</div>
			<div style="display:inline">
				<select name="contractState" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'" style="width: 155px;">
									<option value="0">未签</option>
									<option value="1">已期</option>	
							</select>
			</div> 
		</div>	
	  
		<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>合同期 ：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="contractStartDate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'">到
								<input type="text" name="contractEndtDate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'"><label>（用于合同到期提醒）</label>	
			</div> 
		</div>		
			
		<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>转正日期：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="confirmationdate" class="easyui-datebox" data-options="required:true,editable:false,value:'getCurrentDate();'"><label>（用于试用到期提醒、累计工作天数计算）</label>	
			</div> 
		</div>	 
			 
	<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>劳动关系：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input class="easyui-combobox" name="laborRelationsCode"
							id="laborRelationsCode" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getlaborRelations',required:true,panelHeight:'auto',editable:false" />	
			</div> 
		</div>	 		
			 
	<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>社  保：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input class="easyui-combobox" name="socialsecurityStatusCode"
							id="socialsecurityStatusCode" style="width: 155px;"
							data-options="valueField:'id',textField:'nameM',url:'getsocialsecurityStatus',required:true,panelHeight:'auto',editable:false" />	
			</div> 
		</div>	 	
		  
		  
		<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>工资卡 ：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input type="text" name="wagecardName"   class="easyui-validatebox" ></input>
				<label>（开户行）</label>&nbsp;&nbsp;&nbsp;<input type="text" name="wagecardID"  class="easyui-validatebox" ></input><label>（卡号）</label>	
			</div> 
		</div>	
		
		
				<div class="dvRowSpan">
			<div style="width:100px;float:left;">
				<label>备  注：</label>&nbsp;
			</div>
			<div style="display:inline">
				<input type="text"  name="remark" class="easyui-validatebox" ></input>
			</div> 
		</div> 
			 
			
		<div style="text-align: center; margin-top: 20px;">
			<button type="button" id="btn_save">
				<img alt="保存" style="vertical-align: middle;"
					src="../../../style/image/save.gif"><span
					style="vertical-align: middle;">保存</span>
			</button>
		</div>
		</div>
	</div>
	</form>
</body>
</html>