<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出入库</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<style type="text/css">
.tr {
	display: table-row;
}

.th {
	display: table-cell;
}
</style>
<script type="text/javascript">
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url = cxw.contextPath
					+ '/securityJsp/page/form/churuku';
			$.post(url, cxw.serializeObject($('form')), function(result) {
				if (result.success) {
					$grid.datagrid('load');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	}
	
	$(document).ready(function() {
		
	}
</script>
</head>
<body>
	<div style="display: table;">
		<div class="tr">
			<div class="th">库房</div>
			<div class="th">
				<select name="school" class="easyui-combobox"
					data-options="required:true,editable:false,panelHeight:'auto'"
					style="width: 100px;">
					<option value="1">库房</option>
					<option value="2"><%=sessionInfo.getUser().getSchool()%></option>
				</select>
			</div>
		</div>
		<div class="tr">
			<div class="th">教材</div>
			<div class="th"></div>
		</div>
		<div class="tr">
			<div class="th">操作</div>
			<div class="th"></div>
		</div>
		<div class="tr">
			<div class="th">数量</div>
			<div class="th"></div>
		</div>
		<div class="tr">
			<div class="th">日期</div>
			<div class="th"></div>
		</div>
		<div class="tr">
			<div class="th">备注</div>
			<div class="th"></div>
		</div>
	</div>
</body>
</html>