 
<style type="text/css">
.secMenu{line-height:30px;height:30px; padding-left:10px}
.secMenu a:hover{cursor:pointer}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$.get("getAllResource",function(data){
		$.each(data,function(i,m){
			if(m.resource_id==null){//添加一级菜单 
				var tempOpen = i==0?true:false;//设置第一个菜单展开
				
				$('#menu_left').accordion('add', {
					title: m.name, 
					selected: tempOpen
				});
			}else{ 
				//添加二级菜单
				var panelIndex =$('#menu_left').accordion("panels").length;
				var panels = $('#menu_left').accordion("getPanel",panelIndex-1);
				$(panels).append("<div class='secMenu' onclick='toggleSrc(this)' name='"+m.url+"'><img src='/xiaobao/style/image/xb/weixin.png' style='width:16px;margin-right:5px;'/> <a>"+m.name+"</a></div>");
			}
		});	 
		
	});
	
});
</script>  
	<div id="menu_left" class="easyui-accordion">
	</div> 