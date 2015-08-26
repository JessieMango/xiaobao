<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老生虚报</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var init = function() {

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body>
	<div>
		<form>
			<div style="text-align: center;">
				<b><label for="nameM">学员完整姓名</label></b><input type="text"
					name="nameM" class="easyui-validatebox" />&nbsp; <b><label
					for="telTail">学员电话尾号</label></b><input type="text" name="telTail"
					class="easyui-validatebox" />&nbsp; <a href="javascript:void(0);"
					class="easyui-linkbutton"
					data-options="iconCls:'ext-icon-zoom',plain:true"
					onclick="grid.datagrid('load',cxw.serializeObject($('form')));">查询</a>
			</div>
		</form>
	</div>
	<div>
		<table id="grid" data-options="border:false"></table>
	</div>
</body>
</html>