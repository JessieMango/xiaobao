 
<style type="text/css">
.secMenu{line-height:30px;height:30px; padding-left:10px}
.secMenu a:hover{cursor:pointer}
</style>
<script type="text/javascript"> 
function toggleTab(target) {
	if ($(target).attr("name") == "exit") {
		$.get("loginOut", function(result) {
			if (result.success == true) {
				window.location.replace("../index.jsp");
			}
		});

	} else {
		var tabs = $('#mainTabs');
		var opts = {
			title : $(target).find("a").html(),
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
$(document).ready(function(){
	
	var titleArray=new Array();
	$.get("getAllResource",function(data){
		$.each(data,function(i,m){
			if(m.resource_id==null){//添加一级菜单 
				titleArray.push(m.id);
				var tempOpen = i==0?true:false;//设置第一个菜单展开 
				$('#menu_left').accordion('add', {
					title: m.name, 
					selected: tempOpen,
					id:m.id
				});
			
			} 
		});	  
		
		$.each(titleArray,function(i,m){
			$.each(data,function(j,n){
				if(n.resource_id==titleArray[i]){
					//添加二级菜单
					var panels = $('#menu_left').accordion("getPanel",i);
					$(panels).append("<div class='secMenu' onclick='toggleTab(this)' name='"+n.url+"'><img src='/xiaobao/style/image/xb/weixin.png' style='width:16px;margin-right:5px;'/> <a>"+n.name+"</a></div>");
				}
			});
		 	 
		});
	});	 

});
 
 
</script>  

	<div id="menu_left" class="easyui-accordion" data-options="fit:true">
	</div> 