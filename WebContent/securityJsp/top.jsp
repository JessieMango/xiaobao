<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<!-- saved from url=(0039)http://vip.schoolpal.cn/SchoolPal/Title -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=8" />-->

<title>菜单</title>
<script src="<%=contextPath%>/jslib/jquery-2.0.3.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.each($(".menu a"), function(i, m) {
			$(this).click(function() {
				$(".menu a").attr("class", "");
				$(".menu li ul").attr("class", "");
				$(".menu li ul").css("display", "none");

				$(this).attr("class", "active");
				$(this).next().css("display", "block");
				$(this).next().attr("class", "submenu");
			});

		});
	});
	function jumpUrl(url) {

		window.parent.document.getElementById('centerFrame').src = url;

	}
	function menuFilp() {
		if ($(".nav_popupup").css("display") == "none") {
			$(".nav_popupup").css("display", "block");
		} else {

			$(".nav_popupup").css("display", "none");
		}
	}
</script>

<link href="<%=contextPath%>/style/xbcss/top.css" rel="stylesheet"
	type="text/css" />


<link href="<%=contextPath%>/style/xbcss/icon.css" rel="stylesheet"
	type="text/css" />
</head>

<body class="newui-bg">
	<div class="mainContainer">
		<ul class="ribbon">
			<li>
				<ul class="orb">
					<li><a onclick="menuFilp()" class="nav_orb_btn"></a> <!--<span>菜单</span>-->
						<div class="nav_popupup" style="display: none;">
							<span class="nav_orb_btn2" onclick="menuFilp()"></span>
							<div class="nav_popupinner">
								<a class="nav_popup_link" href="#" target="main"> <img
									src="<%=contextPath%>/style/xbimg/exchangefolder.png" alt="New"
									width="32" height="32" /><span>返回桌面</span>
								</a> <a class="nav_popup_link" href="#" target="_self"> <img
									src="<%=contextPath%>/style/xbimg/groupcolormodeclose.png"
									alt="Exit" width="32" height="32" /><span>安全退出</span>
								</a>
							</div>
						</div>
						<ul style="display: none;">
							<img src="<%=contextPath%>/style/xbimg/menu_top.png"
								style="margin-left: -10px; margin-top: -22px;" />
							<li><a href="#" target="main"> <img
									src="<%=contextPath%>/style/xbimg/exchangefolder.png" alt="New"
									width="32" height="32" /><span>返回桌面</span>
							</a></li>
							<li><a href="#" target="_self"> <img
									src="<%=contextPath%>/style/xbimg/groupcolormodeclose.png"
									alt="Exit" width="32" height="32" /><span>安全退出</span>
							</a></li>
							<img src="<%=contextPath%>/style/xbimg/menu_bottom.png"
								style="margin-left: -10px; margin-bottom: -22px;" />
						</ul></li>
				</ul>
			</li>
			<li>
				<ul class="menu">
					<li><a href="#" class="active">开始</a>
						<ul class="submenu" style="display: block;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/exchangefolder.png"
										alt="New" width="32" height="32" /><span>桌面</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/weixin.png" width="32"
										height="32" />微信APP
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/icon_paint.png"
										width="32" height="32" /><strong><font color="blue">校宝学院</font></strong>
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/groupmessageoptions.png"
										alt="New" width="32" height="32" /><span>我要省钱</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2"></font>&nbsp;
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/quickparts32.png"
										width="32" height="32" />文档中心
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/distributionlistselectmembers.png"
										width="32" height="32" />通讯录
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/reviewInkcommentnew.png"
											width="16" height="16" />写信息
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/showmessagepage.png"
											width="16" height="16" />收信箱
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/converttosmartart.png"
											width="16" height="16" />发信箱
									</div>
								</div>

							</li>

							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2> <!--<div onClick="parent.main.location.href='User_ViewMyAuthor.asp'"><img src="/common/images_newui/databasepermissionsmenu.png" alt="Exit" width="32" height="32"/><span>我的权限</span></div>-->
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/adpprimarykey.png"
										alt="Exit" width="32" height="32" /><span>更改密码</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<span> <img
										src="<%=contextPath%>/style/xbimg/headerfootercurrenttimeinsert2.png"
										alt="About" width="32" height="32" />登录日志
									</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/viewslideshowview2.png"
										width="32" height="32" /><strong>YY课堂</strong>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/tentativeacceptinvitation.png"
										width="32" height="32" />帮助中心
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/groupcolormodeclose.png"
										alt="Exit" width="32" height="32" /><span>安全退出</span>
								</div>
							</li>
						</ul></li>
					<li><a href="#">前台业务</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">咨询</font>
								</h2>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/comments.png" width="32"
										height="32" />新咨询
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/zixunjilu.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/thesaurus.png"
										width="32" height="32" />咨询记录
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/dateandtimeinsert.png"
										width="32" height="32" />沟通记录
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">办理</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/add.png"
										alt="Date and time" width="32" height="32" />新生报名
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/chart_up.png"
										alt="Picture" width="32" height="32" />老生续报
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypeotherinsertgallery3.png"
											alt="Replace" width="16" height="16" />补费续费
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/cellsInsertsmart.png"
											alt="Replace" width="16" height="16" />办理转班
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/quickpartsinsertgallery.png"
											alt="Replace" width="16" height="16" />教材杂费
									</div>
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/blogcategoryinsert.png"
											alt="Find" width="16" height="16" />积分兑换
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/reviewrejectchangemenu.png"
											alt="Select all" width="16" height="16" />办理退费
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/PauseTimer.png"
											alt="Find" width="16" height="16" />办理停课
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">查询</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/zoomclassic.png"
										width="32" height="32" />查学员
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/calculator.png"
										alt="Date and time" width="32" height="32" />查库存
								</div>
							</li>

							<li style="list-style: none none inside;">
								<h2>
									<font size="2">交接</font>
								</h2>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/printdialogaccess3.png"
											alt="Find" width="16" height="16" />我的今日
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/printdialogaccess4.png"
											alt="Find" width="16" height="16" />我的昨日
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/adpdiagramrelationships.png"
											alt="Find" width="16" height="16" />校区总计
									</div>
								</div>
							</li>

						</ul></li>

					<li><a href="#">教务教学</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">班级</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/groupmasteredit.png"
										width="32" height="32" />新建班级
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/importsavedimports.png"
										width="32" height="32" />班级查询
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2"> <b>上课记录</b></font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/filepreparemenu.png"
										alt="Find" width="32" height="32" /><span>记上课</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp') "
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/_teachinglog.png"
										alt="Find" width="66" height="32" /><span>上课记录/学费消耗</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/votemenu.png" alt=""
										width="32" height="32" />教师课时
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">沟通记录</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/call.png" alt="Find"
										width="32" height="32" />售后沟通
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">教务</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp') "
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/contactpicturemenu.png"
										alt="Date and time" width="32" height="32" />教师时段
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/grouptransitiontothisslide.png"
										alt="Picture" width="32" height="32" />教室时段
								</div>

								<div class="ribbon-list">

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/printdialogaccess2.png"
											alt="Find" width="16" height="16" />点名表
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/printdialogaccess.png"
											alt="Find" width="16" height="16" />信息表
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/zoomclassic(1).png"
											width="16" height="16" /> 查学员
									</div>
								</div>

							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">学员</font>
								</h2>
								<div class="ribbon-list">

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/filepermissionview.png"
											alt="Find" width="16" height="16" /> 欠费学员
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/cancelmeeting.png"
											alt="Find" width="16" height="16" /> 到期学员
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/showcustomactionspage.png"
											alt="Find" width="16" height="16" />生日学员
									</div>
								</div>
							</li>
						</ul></li>

					<li><a href="#">市场分析</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">咨询本分析</font>
								</h2>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/chartchangetype.png"
											width="16" height="16" />校区咨询量
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/propertysheet.png"
											width="16" height="16" />咨询来源
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/createtabletemplatesgallery.png"
											width="16" height="16" />咨询销售员
									</div>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/charttypelineinsertgallery.png"
										width="32" height="32" /><span class="F_Red">咨询来源趋势</span>
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/customequationsgallery.png"
										alt="Find" width="32" height="32" />每月新生
								</div>

							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">沟通记录</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/call.png" alt="Find"
										width="32" height="32" />售前沟通
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">报名分析</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/editbusinesscard.png"
										width="32" height="32" />报名来源
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/mailmergerecipientseditlist.png"
										width="32" height="32" />报名销售员
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/charttypeareainsertgallery.png"
										width="32" height="32" /><span class="F_Red">报名来源趋势</span>
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/viewvisualbasiccodeaccess.png"
											width="16" height="16" /> 公立学校
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/bloghomepage.png"
											width="16" height="16" />居住区域
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/pivottablegroupfield.png"
											width="16" height="16" />学生年龄
									</div>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/controlproperties.png"
										width="32" height="32" /><span class="F_Red">前台报名量</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/groupink.png" width="32"
										height="32" />科学选址
								</div>
							</li>
						</ul></li>

					<li><a href="#">财务统计</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">业务流水帐</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/adpdiagramaddtable.png"
										width="32" height="32" />流水帐
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/adpdiagramrelationships(1).png"
										width="32" height="32" />流水日报
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypepieinsertgallery.png"
											width="16" height="16" />流水按校区
									</div>

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/chartchangetype2.png"
											width="16" height="16" />流水月对比
									</div>

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="F_Red nav">
										<img
											src="<%=contextPath%>/style/xbimg/functionsfinancialinsertgallery.png"
											width="16" height="16" />流水按人员
									</div>
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypepieinsertgallery2.png"
											width="16" height="16" /><span>退费按校区</span>
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypeotherinsertgallery.png"
											width="16" height="16" />学费按课程
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypepieinsertgallery3.png"
											width="16" height="16" /><span class="F_Red">退费按课程</span>
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">支出帐</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/adpdiagramhidetable.png"
										width="32" height="32" />支出帐
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypepieinsertgallery4.png"
											width="16" height="16" />支出按大类
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypeotherinsertgallery2.png"
											width="16" height="16" />支出按子项
									</div>
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/chartchangetype2.png"
											width="16" height="16" />支出月对比
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/xbimg/charttypepieinsertgallery5.png"
											width="16" height="16" />支出按校区
									</div>
								</div>
							</li>

							<li style="list-style: none none inside;">
								<h2>
									<font size="2">库存</font>
								</h2>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/calculator(1).png"
											alt="Date and time" width="16" height="16" />库存管理
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/viewsreportview.png"
											alt="OOXML" width="16" height="16" /><span>教材</span>设置
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">积分系统</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/clipartinsert.png"
										alt="Date and time" width="32" height="32" /><span
										class="F_Red">兑换记录</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">回收站</font>
								</h2>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/cellsdelete.png"
											width="16" height="16" />交易回收站
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/xbimg/groupchanges.png"
											width="16" height="16" />档案回收站
									</div>
								</div>

							</li>

						</ul></li>


					<li><a href="#">人事档案</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">录入</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/distributionlistaddnewmember2.png"
										alt="Find" width="32" height="32" />新档案
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">档案管理</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/accountmenu2.png" alt=""
										width="32" height="32" />面试期
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/viewslideshowview.png"
										alt="" width="32" height="32" />培训/试用
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/directrepliesto.png"
										alt="" width="32" height="32" />转正失败
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/createtabletemplatesgallery(1).png"
										alt="" width="32" height="32" />正式/停职
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/distributionlistremovemember.png"
										alt="" width="32" height="32" />离职解聘
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">工具</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/votemenu2.png" alt=""
										width="32" height="32" />教师课时统计
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/crossreferenceinsert.png"
										alt="" width="32" height="32" />人事变动调整
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/showcustomactionspage(1).png"
										alt="" width="32" height="32" />员工生日
								</div>
							</li>
						</ul></li>

					<li><a href="#">磁卡考勤</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">员工刷卡</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/newmeetingwithcontact.png"
										width="32" height="32" />员工考勤记录
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/newdistributionlist.png"
										width="32" height="32" />员工刷卡
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">学员刷卡</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/showtrackingpage.png"
										width="32" height="32" />学员刷卡记录
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/zoomprintpreviewexcel.png"
										width="32" height="32" />刷卡找学员
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/wordartedittextclassic.png"
										width="32" height="32" />忘带磁卡
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/acceptchanges.png"
										width="32" height="32" />学员刷卡
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/icon_about.png"
										width="32" height="32" />磁卡机安装
								</div>
							</li>
						</ul></li>


					<li><a href="#">系统设置</a>
						<ul style="display: none;">
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">常用功能</font>
								</h2>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/icon_datetime.png"
										alt="Exit" width="32" height="32" /><span>系统日志</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/addorremoveattendees.png"
										alt="About" width="32" height="32" /><span>账号管理</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">基础设置</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/businessformwizard.png"
										alt="Rich Text" width="32" height="32" /><span>系统参数</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/xmlsource.png"
										alt="Rich Text" width="32" height="32" /><span>支出项目</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/viewsreportview(1).png"
										alt="OOXML" width="32" height="32" /><span>教材杂项</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/viewsswitchtodefaultview.png"
										alt="Open Document" width="32" height="32" /><span>课程设置</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/xbimg/organizationchartselectlevel.png"
										alt="Plain text" width="32" height="32" /><span>校区设置</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">短信</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')">
									<img
										src="<%=contextPath%>/style/xbimg/delaydeliveryoutlook.png"
										width="32" height="32" />短信查询
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinzixun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/xbimg/encodingmenu.png"
										width="32" height="32" />短信充值
								</div>
							</li>
						</ul></li>
				</ul>
			</li>

		</ul>
	</div>
	<div class="textbox"></div>

</body>
</html>