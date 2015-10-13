<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>菜单</title>
<script src="<%=contextPath%>/jslib/jquery-2.0.3.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function exit() {
		$.get("loginOut", function(result) {
			if (result.success == true) {
				parent.window.location.replace("../index.jsp");
			}
		});
	}
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
					<li><a onclick="menuFilp()" class="nav_orb_btn"></a>
						<div class="nav_popupup" style="display: none;">
							<span class="nav_orb_btn2" onclick="menuFilp()"></span>
							<div class="nav_popupinner">
								<a class="nav_popup_link"
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/welcome.jsp');"
									target="main"> <img
									src="<%=contextPath%>/style/linke/zhuomian.png" alt="New"
									width="32" height="32" /><span>返回桌面</span>
								</a> <a class="nav_popup_link" onclick="exit();" target="_self">
									<img src="<%=contextPath%>/style/linke/tuichu.png"
									alt="Exit" width="32" height="32" /><span>安全退出</span>
								</a>
							</div>
						</div>
						<ul style="display: none;">
							<li><a href="#" target="main"> <img
									src="<%=contextPath%>/style/linke/zhuomian.png" alt="New"
									width="32" height="32" /><span>返回桌面</span>
							</a></li>
							<li><a target="_self" onclick="exit();"> <img
									src="<%=contextPath%>/style/linke/tuichu.png"
									alt="Exit" width="32" height="32" /><span>安全退出</span>
							</a></li>
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
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/welcome.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/zhuomian.png" alt="New"
										width="32" height="32" /><span>桌面</span>
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/weixin.png" width="32"
										height="32" />微信APP
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/xiaozhangketang.png"
										width="32" height="32" /><strong><font color="blue">校长课堂</font></strong>
								</div>

								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/woyaoshengqian.png"
										alt="New" width="32" height="32" /><span>我要省钱</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2"></font>&nbsp;
								</h2>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/wendangxinxi.png"
										width="32" height="32" />文档中心
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/kaishi/tongxun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/tongxunlu.png"
										width="32" height="32" />通讯录
								</div>
								<div class="ribbon-list">
									<div onclick="javascript:void(0)" class="nav">
										<img
											src="<%=contextPath%>/style/linke/xiexin.png"
											width="16" height="16" />写信息
									</div>
									<div onclick="javascript:void(0)" class="nav">
										<img src="<%=contextPath%>/style/linke/shouwenjian.png"
											width="16" height="16" />收信箱
									</div>
									<div onclick="javascript:void(0)" class="nav">
										<img src="<%=contextPath%>/style/linke/fawenjian.png"
											width="16" height="16" />发信箱
									</div>
								</div>

							</li>

							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/kaishi/gaimi.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/gaimima.png" alt="Exit"
										width="32" height="32" /><span>更改密码</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/kaishi/denglurizhi.jsp')"
									class="nav">
									<span> <img
										src="<%=contextPath%>/style/linke/dengluriji.png" alt="About"
										width="32" height="32" />登录日志
									</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/YYketang.png"
										width="32" height="32" /><strong>YY课堂</strong>
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/bangzhuzhongxin.png"
										width="32" height="32" />帮助中心
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">&nbsp;</font>
								</h2>
								<div onclick="exit();" class="nav">
									<img src="<%=contextPath%>/style/linke/tuichu.png" alt="Exit"
										width="32" height="32" /><span>安全退出</span>
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
									<img src="<%=contextPath%>/style/linke/xinzixun.png" width="32"
										height="32" />新咨询
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/zixunjilu.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/zixunjilu.png"
										width="32" height="32" />咨询记录
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/goutongjilu.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/goutongjilu.png"
										width="32" height="32" />沟通记录
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">办理</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xinshengbaodao.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/xinshengbaoming.png"
										alt="Date and time" width="32" height="32" />新生报名
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/laoshengxubao.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/xubaoming.png"
										alt="Picture" width="32" height="32" />老生续报
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/bufei.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/bufeixufei.png"
											alt="Replace" width="16" height="16" />补费续费
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/zhuanban.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/banlizhuanban.png"
											alt="Replace" width="16" height="16" />办理转班
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/jiaocaizafei.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/jiaocaizafei.png"
											alt="Replace" width="16" height="16" />教材杂费
									</div>
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/jifenduihuan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/jifenduihuan.png"
											alt="Find" width="16" height="16" />积分兑换
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/tuifei.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/banlituifei.png"
											alt="Select all" width="16" height="16" />办理退费
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/tingke.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/banlitingke.png"
											alt="Find" width="16" height="16" />办理停课
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">查询</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/chaxueyuan.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/chaxueyuan.png"
										width="32" height="32" />查学员
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/chakucun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/chakucun.png"
										alt="Date and time" width="32" height="32" />查库存
								</div>
							</li>

							<li style="list-style: none none inside;">
								<h2>
									<font size="2">交接</font>
								</h2>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/jinri.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/wodejinri.png"
											alt="Find" width="16" height="16" />我的今日
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/zuori.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/wodezuori.png"
											alt="Find" width="16" height="16" />我的昨日
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/qiantai/xiaoquzongji.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/xiaoqu.png"
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
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/xinjianbanji.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/xinjianbanji.png"
										width="32" height="32" />新建班级
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/banjichaxun.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/banjichaxun.png"
										width="32" height="32" />班级查询
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2"> <b>上课记录</b></font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/jishangke.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/jishangke.png"
										alt="Find" width="32" height="32" /><span>记上课</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/shangkejilu.jsp') "
									class="nav">
									<img src="<%=contextPath%>/style/linke/xuefeixiaohao.png"
										alt="Find" width="32" height="32" /><span>上课记录/学费消耗</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/jiaoshikeshi.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/jiaoshikeshi.png" alt=""
										width="32" height="32" />教师课时
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">沟通记录</font>
								</h2>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/shouhougoutong.png" alt="Find"
										width="32" height="32" />售后沟通
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">教务</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/teachertime.jsp') "
									class="nav">
									<img src="<%=contextPath%>/style/linke/jiaoshishiduan.png"
										alt="Date and time" width="32" height="32" />教师时段
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/classroomtime.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/jiaoshishiduan1.png"
										alt="Picture" width="32" height="32" />教室时段
								</div>

								<div class="ribbon-list">

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/dianming.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/dianmingbiao.png"
											alt="Find" width="16" height="16" />点名表
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/xinxibiao.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/xinxibiao.png"
											alt="Find" width="16" height="16" />信息表
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/chaxueyuan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/chaxueyuanxiao.png"
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
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/qianfeixueyuan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/qianfeixueyuan.png"
											alt="Find" width="16" height="16" /> 欠费学员
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/daoqixueyuan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/daoqixueyuan.png"
											alt="Find" width="16" height="16" /> 到期学员
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/jiaowu/shengrixueyuan.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/shengrixueyuan.png"
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
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/xiaoquzixunliang.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/xiaoquzixunliang.png"
											width="16" height="16" />校区咨询量
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/zixunlaiyuan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/zixunlaiyuan.png"
											width="16" height="16" />咨询来源
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/zixunxiaoshouyuan.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/zixunxiaoshouyuan.png"
											width="16" height="16" />咨询销售员
									</div>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/zixunlaiyuanqushi.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/zixunlaiyuanqushi.png"
										width="32" height="32" /><span class="F_Red">咨询来源趋势</span>
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/meiyuexinsheng.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/meiyuexinsheng.png"
										alt="Find" width="32" height="32" />每月新生
								</div>

							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">沟通记录</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/shouqiangoutong.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/shouqiangoutong.png" alt="Find"
										width="32" height="32" />售前沟通
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">报名分析</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/baominglaiyuan.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/baominglaiyuan.png"
										width="32" height="32" />报名来源
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/baomingxiaoshouyuan.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/baomingxiaoshouyuan.png"
										width="32" height="32" />报名销售员
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/baomingqushi.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/baominglaiyuanqushi.png"
										width="32" height="32" /><span class="F_Red">报名来源趋势</span>
								</div>

								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/gonglixuexiao.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/gonglixuexiao.png"
											width="16" height="16" /> 公立学校
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/juzhuquyu.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/juzhuquyu.png"
											width="16" height="16" />居住区域
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/xueshengnianling.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/xueshengnianling.png"
											width="16" height="16" />学生年龄
									</div>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/shichang/qiantaibaomingliang.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/qiantaibaomingliang.png"
										width="32" height="32" /><span class="F_Red">前台报名量</span>
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/kexuexuanzhi.png" width="32"
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
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/liushuizhang.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/liushuizhang.png"
										width="32" height="32" />流水帐
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/liushuiribao.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/ribaobiao.png"
										width="32" height="32" />流水日报
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/liushuianxiaoqu.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/tuifeianxiaoqu.png"
											width="16" height="16" />流水按校区
									</div>

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/liushuiyueduibi.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/zhichuyueduibi.png"
											width="16" height="16" />流水月对比
									</div>

									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/liushuianrenyuan.jsp')"
										class="F_Red nav">
										<img
											src="<%=contextPath%>/style/linke/liushuianrenyuan.png"
											width="16" height="16" />流水按人员
									</div>
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/tuifeianxiaoqu.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/tuifeianxiaoqu.png"
											width="16" height="16" /><span>退费按校区</span>
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/xuefeiankecheng.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/xuefeiankecheng.png"
											width="16" height="16" />学费按课程
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/tuifeiankecheng.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/xuefeiankecheng.png"
											width="16" height="16" /><span class="F_Red">退费按课程</span>
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">支出帐</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/zhichuzhang.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/zhichuzhang.png"
										width="32" height="32" />支出帐
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/zhichuandalei.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/zhichuandalei.png"
											width="16" height="16" />支出按大类
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/zhichuanzixiang.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/zhichuandalei.png"
											width="16" height="16" />支出按子项
									</div>
								</div>
								<div class="ribbon-list">
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/zhichuyueduibi.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/zhichuyueduibi.png"
											width="16" height="16" />支出月对比
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/zhichuanxiaoqu.jsp')"
										class="nav">
										<img
											src="<%=contextPath%>/style/linke/tuifeianxiaoqu.png"
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
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/kucunguanli.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/kucunguanli.png"
											alt="Date and time" width="16" height="16" />库存管理
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/jiaocaishezhi.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/jiaocaishezhi.png"
											alt="OOXML" width="16" height="16" />教材设置
									</div>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">积分系统</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/duihuanjilu.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/duihuanjilu.png"
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
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/jiaoyihuishouzhan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/jiaoyihuishouzhan.png"
											width="16" height="16" />交易回收站
									</div>
									<div
										onclick="jumpUrl('<%=contextPath%>/securityJsp/page/caiwu/danganhuishouzhan.jsp')"
										class="nav">
										<img src="<%=contextPath%>/style/linke/danganhuishouzhan.png"
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
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/xindangan.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/xindangan.png"
										alt="Find" width="32" height="32" />新档案
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">档案管理</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/mianshiqi.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/mianshiqi.png" alt=""
										width="32" height="32" />面试期
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/peixunshiyong.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/peixunshiyong.png"
										alt="" width="32" height="32" />培训/试用
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/zhuanzhengshibai.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/zhuanzhengshibai.png"
										alt="" width="32" height="32" />转正失败
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/zhengshitingzhi.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/zhengshitingzhi.png"
										alt="" width="32" height="32" />正式/停职
								</div>

								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/lizhijiepin.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/lizhijiepin.png"
										alt="" width="32" height="32" />离职解聘
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">工具</font>
								</h2>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/teacherSchedule.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/jiaoshikeshitongji.png" alt=""
										width="32" height="32" />教师课时统计
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/renshibiandong.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/renshibiandongtiaozheng.png"
										alt="" width="32" height="32" />人事变动调整
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/renshi/yuangongshengri.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/yuangongshengri.png"
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
								<div onclick="javascript:void(0)" class="nav">
									<img
										src="<%=contextPath%>/style/linke/yuangongkaoqinjilu.png"
										width="32" height="32" />员工考勤记录
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/yuangongshuaka.png"
										width="32" height="32" />员工刷卡
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">学员刷卡</font>
								</h2>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/xueyuanshuaka.png"
										width="32" height="32" />学员刷卡记录
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img
										src="<%=contextPath%>/style/linke/shuakazhaoxueyuan.png"
										width="32" height="32" />刷卡找学员
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img
										src="<%=contextPath%>/style/linke/wangdaicika.png"
										width="32" height="32" />忘带磁卡
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/xueyuanshuaka.png"
										width="32" height="32" />学员刷卡
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/cikajianzhuang.png"
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
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/SystemLog.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/dengluriji.png"
										alt="Exit" width="32" height="32" /><span>系统日志</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/AccountManage.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/zhanghaoguanli.png"
										alt="About" width="32" height="32" /><span>账号管理</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">基础设置</font>
								</h2>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/xitongcanshu.png"
										alt="Rich Text" width="32" height="32" /><span>系统参数</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/PayProject.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/zhichuxiangmu.png"
										alt="Rich Text" width="32" height="32" /><span>支出项目</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/TextbookOther.jsp')"
									class="nav">
									<img src="<%=contextPath%>/style/linke/jiaocaizaxiang.png"
										alt="OOXML" width="32" height="32" /><span>教材杂项</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/CourseSetting.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/kechengshezhi.png"
										alt="Open Document" width="32" height="32" /><span>课程设置</span>
								</div>
								<div
									onclick="jumpUrl('<%=contextPath%>/securityJsp/page/xitong/SchoolSetting.jsp')"
									class="nav">
									<img
										src="<%=contextPath%>/style/linke/xiaoqushezhi.png"
										alt="Plain text" width="32" height="32" /><span>校区设置</span>
								</div>
							</li>
							<li style="list-style: none none inside;">
								<h2>
									<font size="2">短信</font>
								</h2>
								<div onclick="javascript:void(0)">
									<img
										src="<%=contextPath%>/style/linke/duanxinchaxun.png"
										width="32" height="32" />短信查询
								</div>
								<div onclick="javascript:void(0)" class="nav">
									<img src="<%=contextPath%>/style/linke/duanxinchongzhi.png"
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