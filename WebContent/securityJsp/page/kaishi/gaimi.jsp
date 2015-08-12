<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript">

</script>
</head>
<body>
<form method="post" class="form">
	<div >
	<div style="width: 70%;margin-left:auto;margin-right:auto;">
		
			<label>姓    名：</label><input name="" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			<label>原始密码：</label><input name="" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			<label> 新密码：</label><input name="" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
			<label>密码确认：</label><input name="" data-options="required:true" type="text" class="easyui-validatebox" ></input><br/>
	</div>
		<div style="text-align: center; margin-top: 20px;">
			<button type="button" id="btn_save">
				<img alt="保存" style="vertical-align: middle;"
					src="../../../style/image/save.gif"><span
					style="vertical-align: middle;">修改</span>
			</button>
		</div>
		</div>
	</form>
</body>
</html>