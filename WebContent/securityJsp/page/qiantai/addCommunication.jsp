<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String commuId = request.getParameter("commuId");
	String type = request.getParameter("type");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.divRow {
	text-align: center;
	margin-bottom: 10px;
}

input[type='text'] {
	text-align: center;
}

.divUnit {
	display: inline;
	width: 19%;
}

.labelUnit {
	margin-right: 20px;
}

.type{
	display: none;
}
</style>
<script type="text/javascript">
	var submitForm = function() {
		parent.$.messager.progress({
			text : '保存中....'
		});
		var url="";
		if('<%=type%>' == 'edit' || '<%=type%>' == 'editg'){
			url = "updateCommunication";
		} else {
			url = "addCommunication";
		}
		$.post(url, cxw.serializeObject($('#form2')), function(
				result) {
			if (result.success) {
				parent.$.messager.progress('close');
				if('<%=type%>' == 'edit'){
					window.location.href = 'showCommunication.jsp?id='+'<%=id%>';
				}else{
					window.location.href = 'goutongjilu.jsp';
				}
			} else {
				$.messager.alert('提示', '添加失败!', 'info');
				parent.$.messager.progress('close');
			}
		}, 'json');
	}
	/* 初始化操作 */
	function init(){
		var nextdate = getNextDate();
		$("#returnVisitDate").datebox("setValue",nextdate);
		
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
		
		if('<%=type%>' == 'edit' || '<%=type%>' == 'editg'){
			if(!$("#edit").hasClass('type')){
				$("#edit").removeClass("type");
			}
			if(!$("#add").hasClass('type')){
				$("#add").addClass("type");
			}
		}else{
			if(!$("#edit").hasClass('type')){
				$("#edit").addClass("type");
			}
			if(!$("#add").hasClass('type')){
				$("#add").removeClass("type");
			}
		}
		
	}
	
	$(document).ready(function(){
		init();
		$.post("getConsultById", {id :"<%=id%>"}, function(result) {
			if (result.gender == 0) {
				$('#gender').val("男");
			} else {
				$('#gender').val("女");
			}
			$('#form1').form('load', {
				"birthday" : result.birthday,
				"class_grade" : result.class_grade,
				"councilSchoolCode" : result.councilSchoolCode,
				"councilSchool" : result.councilSchool,
				"fatherTel" : result.fatherTel,
				"liveArea" : result.liveArea,
				"motherTel" : result.motherTel,
				"nameM" : result.nameM,
				"otherTel" : result.otherTel,
				"others" : result.others,
				"carCode" : result.carCode,
				"banlance" : result.banlance,
				"availabelPoints" : result.availabelPoints
			});
		});
		if('<%=type%>' == 'edit' || '<%=type%>' == 'editg'){
			$.post("getCommunicationById", {id :"<%=commuId%>"}, function(result) {
				$('#form2').form('load', {
					"communicationType" : result.communicationType,
					"communicationContent" : result.communicationContent,
					"communicationResult" : result.communicationResult,
					"returnVisitDate" : result.returnVisitDate,
					"handleSchoolCode" : result.handleSchoolCode,
					"communicationDate" : result.communicationDate,
					"isRemind" : result.isRemind
				});
			});
		}
	});
</script>
</head>
<body>
	<div>
		<form id="form1">
			<div class="divRow">
				<div class="divUnit">
					<label for="nameM" class="labelUnit">学员姓名</label><input type="text"
						name="nameM" readonly="readonly" style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="gender" class="labelUnit">学员性别</label><input
						id="gender" type="text" name="gender" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="birthday" class="labelUnit">学员生日</label><input
						type="text" name="birthday" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="carCode" class="labelUnit">磁卡卡号</label><input
						type="text" name="carCode" readonly="readonly" />
				</div>
			</div>

			<div class="divRow">
				<div class="divUnit">
					<label for="motherTel" class="labelUnit">母亲电话</label><input
						type="text" name="motherTel" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="fatherTel" class="labelUnit">父亲电话</label><input
						type="text" name="fatherTel" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="otherTel" class="labelUnit">其他电话</label><input
						type="text" name="otherTel" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="banlance" class="labelUnit">可用余额</label><input
						type="text" name="banlance" readonly="readonly" />
				</div>
			</div>

			<div class="divRow">
				<div class="divUnit">
					<label for="councilSchool" class="labelUnit">公立学校</label><input
						type="text" name="councilSchool" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="class_grade" class="labelUnit">班级年级</label><input
						type="text" name="class_grade" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="liveArea" class="labelUnit">居住区域</label><input
						type="text" name="liveArea" readonly="readonly"
						style="margin-right: 20px;" />
				</div>
				<div class="divUnit">
					<label for="availabelPoints" class="labelUnit">可用积分</label><input
						type="text" name="availabelPoints" readonly="readonly" />
				</div>
			</div>
			<div class="divRow">
				<div class="divUnit">
					<label for="others" class="labelUnit">其他信息</label><input
						type="text" style="width: 75%;" name="others" readonly="readonly" />
				</div>
			</div>
		</form>
	</div>

	<div style="margin-left: 50px; margin-top: 20px;">
		<form id="form2">
			<div style="margin-top: 10px;" id="add">
				<label for="communicationType" class="labelUnit">沟通类型</label><input
					type="radio" checked="checked" name="communicationType" value="8" />售前沟通
				<input type="radio" name="communicationType" value="1" />试听邀约 <input
					type="radio" name="communicationType" value="2" />活动通知 <input
					type="radio" name="communicationType" value="7" />其他
			</div>
			<div style="margin-top: 10px;" id="edit">
				<label for="communicationType" class="labelUnit" style="float: left;vertical-align: baseline;">沟通类型</label>
				<div style="margin-left: 20px;">
					<div style="width: 50%;">
						<label for="communicationType">售前沟通:</label> <input type="radio" checked="checked"
							name="communicationType" value="8" />售前沟通 <input type="radio"
							name="communicationType" value="1" />试听邀约 <input type="radio"
							name="communicationType" value="2" />活动通知
					</div>
					<div style="margin-left: 65px;width: 50%;"> 
						<label for="communicationType">售后沟通:</label><input type="radio" name="communicationType"
							value="3" />电话通知<input type="radio" name="communicationType"
							value="5" />电话服务<input type="radio" name="communicationType"
							value="6" />电话家访 <input type="radio" name="communicationType"
							value="7" />其他
					</div>
				</div>
			</div>
			<div style="margin-top: 10px;">
				<div>
					<label for="communicationContent" style="vertical-align: top;"
						class="labelUnit">沟通内容</label>
					<textarea rows="3" cols="250" style="width: 300px; height: 50px;"
						name="communicationContent"></textarea>
				</div>
			</div>

			<div style="margin-top: 10px;">
				<div>
					<label for="communicationResult" style="vertical-align: top;"
						class="labelUnit">沟通结果</label>
					<textarea rows="3" cols="250" style="width: 300px; height: 50px;"
						name="communicationResult"></textarea>
					<input type="hidden" name="consultId" value="<%=id%>" />
				</div>
			</div>
			<div style="margin-top: 10px;">
				<div>
					<label class="labelUnit">回访提醒</label><input type="checkbox"
						value="1" name="isRemind" />开启提醒: <input class="easyui-datebox"
						type="text" id="returnVisitDate" name="returnVisitDate"
						data-options="required:true" /><input type="hidden" name="id" value="<%=commuId%>"/>
				</div>
			</div>
			<div style="text-align: center; margin-top: 20px;">
				<div style="display: inline;">
					<label for="communicationDate" class="labelUnit">沟通日期</label><input
						class="easyui-datebox" type="text" id="communicationDate"
						style="width: 160px;" name="communicationDate"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>

				<div style="display: inline;">
					<label for="handleSchoolCode">经办</label><input
						id="handleSchoolCode" class="easyui-combobox"
						name="handleSchoolCode"
						data-options="valueField:'schoolCode',textField:'schoolName',url:'getAllSchools',panelHeight:'auto',editable:false" />
				</div>

				<div style="text-align: center; margin-top: 20px;">
					<button type="button" id="btn_save">
						<img alt="保存" style="vertical-align: middle;"
							src="../../../style/image/save.gif"><span
							style="vertical-align: middle;">保存</span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>