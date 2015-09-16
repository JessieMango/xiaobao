<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
	String id = request.getParameter("id");
	if(StringUtils.isBlank(id)){
		id = "";
	}
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
			url = cxw.contextPath + '/securityJsp/page/form/chuRuKu';
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

	/* 初始化 */
	var init = function() {
		$('#textbookFee_id').combobox({
			onLoadSuccess : function(data) {
				if (data) {
					$('#textbookFee_id').combobox('setValue', data[0].id);
				}
			}
		});
	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<form>
		<div style="display: table;">
			<div class="tr">
				<div class="th">库房</div>
				<input type="hidden" name="handler"
					value="<%=sessionInfo.getUser().getUsername()%>">
				<div class="th">
					<select name="location" class="easyui-combobox"
						data-options="required:true,editable:false,panelHeight:'auto'"
						style="width: 100px;">
						<option value="1">库房</option>
						<option value="2"><%=sessionInfo.getUser().getSchool()%></option>
					</select>
				</div>
			</div>
			<div class="tr">
				<div class="th">教材</div>
				<div class="th">
					<input type="text" class="easyui-combobox" name="textbookFee_id"
						style="width: 100px;" id="textbookFee_id"
						data-options="valueField:'id',textField:'nameM',url:'getKuCun',panelHeight:'auto',editable:false" />
				</div>
			</div>
			<div class="tr">
				<div class="th">操作</div>
				<div class="th">
					<select name="operate" class="easyui-combobox"
						data-options="required:true,editable:false,panelHeight:'auto'"
						style="width: 100px;">
						<option value="1">入库</option>
						<option value="2">出库</option>
					</select>
				</div>
			</div>
			<div class="tr">
				<div class="th">数量</div>
				<div class="th">
					<input type="text" class="easyui-numberbox" value="0" name="number"
						style="width: 100px;" data-options="precision:0,min:0">
				</div>
			</div>
			<div class="tr">
				<div class="th">日期</div>
				<div class="th">
					<input style="width: 100px;" type="text" id="operateDate"
						name="operateDate" class="easyui-datebox"
						data-options="required:true,value:'getCurrentDate();'" />
				</div>
			</div>
			<div class="tr">
				<div class="th">备注</div>
				<div class="th">
					<input type="text" name="remark" style="width: 300px;">
				</div>
			</div>
		</div>
	</form>
</body>
</html>