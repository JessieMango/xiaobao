<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="com.hqgj.xb.bean.easyui.SessionInfo"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String contextPath = request.getContextPath();
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute("sessionInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校宝</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var mainMenu;
function taggleClass(target){
	$("#mainMenu > li > span").each(function (index,dom){
		if($(dom).hasClass("clicked")){
			$(dom).removeClass("clicked");
		}
		$(target).addClass("clicked");
	});
	$("#subMenu").empty();
	$.get("getSubResource",{pid:$(target).attr("name")},function(data){
		$(data).each(function(index,menu){
			$('#subMenu').append("<li><a href='#'>"+menu.name+"</a></li>");
		});
	});
	
}
$(function() {
	$.get("getResource",function(data){
		$(data).each(function(index,menu){
			$('#mainMenu').append("<li><span class='menuSpan' name='"+menu.id+"' onclick='taggleClass(this);' >"+menu.name+"</span></li>");
			if(index == 1){
				$.get("getSubResource",{pid:menu.id},function(data){
					$(data).each(function(index,menu){
						$('#subMenu').append("<li><a href='#'>"+menu.name+"</a></li>");
					});
				});
			}
		});
	});
	
});
</script>
</head>
<body id="mainLayout" class="easyui-layout">
	<div
		data-options="region:'north',href:'<%=contextPath%>/securityJsp/north.jsp'"
		style="height: 120px; overflow: hidden; border: 0;"></div>

	<div data-options="region:'center'"
		style="overflow: hidden; border: 0;">
		<iframe src="<%=contextPath%>/welcome.jsp"
			style="border: 0; width: 100%; height: 99%;"></iframe>
	</div>

	<div
		data-options="region:'south',href:'<%=contextPath%>/securityJsp/south.jsp',border:false"
		style="height: 27px; overflow: hidden; border: 0;"></div>

	<script type="text/javascript">
		var stateObject = {
			id : 1
		};
		history.pushState(stateObject, '主界面', '<%=basePath%>/'+'<%=session.getAttribute("mainUrl")%>');
	</script>
</body>
</html>