<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	String contextPath = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面试期员工档案</title>
<jsp:include page="../../../inc.jsp"></jsp:include>
<script type="text/javascript">
function init(){
	
}

$(function() {
	init();		

});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar" style="display: none;">
		<table>
			<tr>
				<td>
					<form id="searchFormS">
						<table>
							<tr>
								<td>合同状态：</td>
								<td><select name="contractStatus" style="width: 200px;" class="easyui-combobox"></select></td>

								<td>社保状态：</td>
								<td><select name="socialsecurityStatus" style="width: 200px;" class="easyui-combobox"></select></td>
								
								<td>劳动关系：</td>
								<td><select name="laborRelations" style="width: 200px;" class="easyui-combobox"></select></td>
								<td>标记：</td>
								<td><select name="" style="width: 200px;" class="easyui-combobox"></select></td>
								
								<td>排序方式：</td>
								<td><select name="" style="width: 200px;" class="easyui-combobox"></select></td>
								
								<td><a href="javascript:void(0);" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom',plain:true"
									onclick="grid.datagrid('load',cxw.serializeObject($('#searchForm')));">查询</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>

	<div data-options="region:'center',fit:true,border:false">
		<table id="grid" data-options="border:false"></table>
	</div>
</body>
</html>