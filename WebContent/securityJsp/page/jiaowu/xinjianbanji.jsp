<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	/* 初始化页面 */
	function init() {

	}

	$(document).ready(function() {
		init();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div style="width: 40%;margin: 20px auto;">
			<div><img  src="../../../style/image/Folder.gif" style="vertical-align: middle;"> <span style="vertical-align: middle;">新建班级</span></div>
			<hr/>
			<div><label>&nbsp;&nbsp;校区</label><input type="text"/></div>
			<div><label>班级名称</label><input type="text"/></div>
			<div><label>&nbsp;&nbsp;课程</label><input type="text"/></div>
			<div><label>收费模式</label><input type="text"/></div>
		</div>
	</div>
</body>
</html>