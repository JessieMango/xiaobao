 
<style type="text/css">
.secMenu{line-height:30px;height:30px; padding-left:10px}
.secMenu a:hover{cursor:pointer}
</style>
<script type="text/javascript"> 
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
					$(panels).append("<div class='secMenu' onclick='toggleSrc(this)' name='"+n.url+"'><img src='/xiaobao/style/image/xb/weixin.png' style='width:16px;margin-right:5px;'/> <a>"+n.name+"</a></div>");
				}
			});
		 	 
		});
	});	 

});
 
 
</script>  

	<div id="menu_left" class="easyui-accordion">
	</div> 