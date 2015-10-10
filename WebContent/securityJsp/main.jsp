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
<title>教育+ 校务管理系统 Educator</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var mainMenu;
	var mainTabs;
	/* 切换子菜单 */
	var clickIndex = function(target){
		$('#menu_left').accordion("select",$(target).html());
	}
	$(function() {
		$('#mainLayout').layout('panel', 'center').panel(
				{
					onResize : function(width, height) {
						cxw.setIframeHeight('centerIframe',
								$('#mainLayout').layout('panel', 'center')
										.panel('options').height - 5);
					}
				});

		mainTabs = $('#mainTabs')
				.tabs(
						{
							fit : true,
							border : false,
							tools : [
									{
										iconCls : 'ext-icon-arrow_up',
										handler : function() {
											mainTabs.tabs({
												tabPosition : 'top'
											});
										}
									},
									{
										iconCls : 'ext-icon-arrow_down',
										handler : function() {
											mainTabs.tabs({
												tabPosition : 'bottom'
											});
										}
									},
									{
										text : '刷新',
										iconCls : 'ext-icon-arrow_refresh',
										handler : function() {
											var panel = mainTabs.tabs(
													'getSelected').panel(
													'panel');
											var frame = panel.find('iframe');
											try {
												if (frame.length > 0) {
													for (var i = 0; i < frame.length; i++) {
														frame[i].contentWindow.document
																.write('');
														frame[i].contentWindow
																.close();
														frame[i].src = frame[i].src;
													}
													if (navigator.userAgent
															.indexOf("MSIE") > 0) {// IE特有回收内存方法
														try {
															CollectGarbage();
														} catch (e) {
														}
													}
												}
											} catch (e) {
											}
										}
									},
									{
										text : '关闭',
										iconCls : 'ext-icon-cross',
										handler : function() {
											var index = mainTabs
													.tabs(
															'getTabIndex',
															mainTabs
																	.tabs('getSelected'));
											var tab = mainTabs.tabs('getTab',
													index);
											if (tab.panel('options').closable) {
												mainTabs.tabs('close', index);
											} else {
												$.messager
														.alert(
																'提示',
																'['
																		+ tab
																				.panel('options').title
																		+ ']不可以被关闭！',
																'error');
											}
										}
									} ]
						});

		$.get("getResource", function(data) {
			$(data).each(
					function(index, menu) {
						$('#mainMenu').append(
								"<li><span class='menuSpan' name='" + menu.id
										+ "' onclick='clickIndex(this);' >"
										+ menu.name + "</span></li>");
					});
		});

	});
</script>
<style type="text/css">
.accordion .accordion-header-selected{
	background:#605ca8; 
}
.tabs-title{
 color:#605ca8;
}


</style>
</head>
<body id="mainLayout" class="easyui-layout">
	<div
		data-options="region:'north'"
		style="height:140px; overflow: hidden; border: 0;">
		<iframe src="<%=contextPath%>/securityJsp/top.jsp"
					style="border: 0; width: 100%; height: 99%;"></iframe>
		</div> 
	<div data-options="region:'center'"
		style="overflow: hidden; border: 0; background: #ddd;">
	 <iframe id="centerFrame" src="<%=contextPath%>/securityJsp/page/welcome.jsp"
					style="border: 0; width: 100%; height: 99%;padding-top:10px"></iframe>
	</div>

	<div
		data-options="region:'south',href:'<%=contextPath%>/securityJsp/south.jsp',border:false"
		style="height: 27px; overflow: auto; border: 0;"></div>

</body>
</html>