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
<title>教育家</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var mainMenu;
var mainTabs;
function toggleSrc(target){
	if($(target).attr("name") == "exit"){
		$.get("loginOut",function(result){
			if(result.success == true){
				window.location.replace("../index.jsp");
			}
		});
		
	}else{
		var tabs = $('#mainTabs');
		var opts = {
			title : $(target).find("span").html(),
			closable : true,
			content : cxw
					.formatString(
							'<iframe src="{0}" allowTransparency="true" style="border:0;width:99.9%;height:99%;" frameBorder="0"></iframe>',
							$(target).attr("name")),
			border : false,
			fit : true
		};
		if (tabs.tabs('exists', opts.title)) {
			tabs.tabs('select', opts.title);
		} else {
			tabs.tabs('add', opts);
		}
	}
}

function mouseover(target){
	$(target).addClass("mouse");
}

function mounseout(target){
	$(target).removeClass("mouse");
}

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
			var icon = menu.iconCls;
			if(icon.indexOf("16")>0){
				$('#subMenu').append("<li><div onmouseover='mouseover(this);' name='"+menu.url+"' onclick='toggleSrc(this);' onmouseout='mounseout(this);' class='menudiv'><img  class='"+menu.iconCls+"' /><span class='subMenuSpanSmall'>"+menu.name+"</span></div></li>");			
			}else{
				$('#subMenu').append("<li><div onmouseover='mouseover(this);' name='"+menu.url+"' onclick='toggleSrc(this);' onmouseout='mounseout(this);' class='menudiv'><img  class='"+menu.iconCls+"' /><span class='subMenuSpanBig'>"+menu.name+"</span></div></li>");
			}
		});
	});
	
	
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
	
	$.get("getResource",function(data){
		$(data).each(function(index,menu){
			$('#mainMenu').append("<li><span class='menuSpan' name='"+menu.id+"' onclick='taggleClass(this);' >"+menu.name+"</span></li>");
			if(index == 0){
				$.get("getSubResource",{pid:menu.id},function(data){
					$(data).each(function(index,menu){
						$('#subMenu').append("<li><div onmouseover='mouseover(this);' name='"+menu.url+"' onclick='toggleSrc(this);' onmouseout='mounseout(this);' class='menudiv'><img  class='"+menu.iconCls+"' /><span class='subMenuSpanBig'>"+menu.name+"</span></div></li>");
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
		<div id="mainTabs">
			<div title="桌面"
				data-options="iconCls:'ext-icon-world',closable:true,fit:true">
				<iframe src="<%=contextPath%>/securityJsp/page/welcome.jsp"
					style="border: 0; width: 100%; height: 99%;"></iframe>
			</div>
		</div>
	</div>

	<div
		data-options="region:'south',href:'<%=contextPath%>/securityJsp/south.jsp',border:false"
		style="height: 27px; overflow:hidden; border: 0;"></div>

	<script type="text/javascript">
		var stateObject = {
			id : 1
		};
		history.pushState(stateObject, '主界面', '<%=basePath%>/'+'<%=session.getAttribute("mainUrl")%>');
	</script>
</body>
</html>