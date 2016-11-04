/**
 * 首页js
 */
$(function(){
	//事件绑定
	function eventBind(){
		//左侧菜单收起展开事件绑定
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
		
		//菜单事件绑定
		$("#main-menu li a").click(function(){
			//同步样式
			$("#main-menu li a[class='active-menu']").removeClass("active-menu");
			$(this).addClass('active-menu');
			
			//根据属性值，渲染iframe
			var url = $(this).attr("url");
			$("#page-inner iframe").attr("src",url);
		})
		
		//退出按钮事件绑定
		$("#logout").click(function(){
			
		})
	}
	
	//加载第一个菜单
	function loadFirstMenu(){
		var firstMenu = $("#main-menu li a").first();
		firstMenu.addClass('active-menu');
		var url = firstMenu.attr("url");
		$("#page-inner iframe").attr("src",url);
	}
	
	//初始化
	function init(){
		loadFirstMenu();
		eventBind();
	}
	
	init();
})