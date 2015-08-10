<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.divRow {
	margin-bottom: 10px;
	margin-left: 20px;
}

input[type='text'] {
	text-align: center;
}

.divUnit {
	display: inline;
	width: 20%;
}

.labelUnit {
	margin-right: 20px;
}
</style>
<script type="text/javascript">
	/* 初始化操作 */
	function init(){
		$("#aa").accordion({
			tools:[{
			    iconCls:'icon-add',
			    title : '添加',
			    handler:function(){
			    	alert('new');
			    	}
			}]
		});	
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
	});
</script>
</head>
<body>
	<div style="text-align: center;">
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
				<div style="display: inline;">
					<button>修改信息</button>
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
				<div style="display: inline;">
					<button>余额管理</button>
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
				<div style="display: inline;">
					<button>积分管理</button>
				</div>
			</div>
			<div class="divRow">
				<div style="display: inline; width: 78%;">
					<label for="others" class="labelUnit" style="width: 10%;">其他信息</label><input
						type="text" style="width: 68%; margin-right: 40px;" name="others"
						readonly="readonly" />
				</div>
				<div style="display: inline; margin-right: 0px;">
					<button>再报一科</button>
				</div>
			</div>
		</form>
	</div>

	<div style="text-align: center; margin-left: 20px; margin-right: 20px;">
		<div id="aa" class="easyui-accordion" style="text-align: center;">
			<div title="沟通记录" data-options="fit:true"
				style="overflow: auto; padding: 10px;"></div>
		</div>
	</div>
</body>
</html>