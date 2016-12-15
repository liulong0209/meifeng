/**
 * 首页js
 */
$(function(){
    "use strict";
    var mainApp = {

        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });

     }
    };
    // Initializing ///
    
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
		
		//鼠标经过离开菜单事件绑定
		$("#main-menu li a").hover(function(){
			$(this).addClass('active-menu');
		},function(){
			//已有选中的，再确定该菜单的选中样式
			if($("#main-menu li .active-menu").length>1){
				$(this).removeClass('active-menu');
			}
		});
		
		//退出按钮事件绑定
		$("#logout").click(function(){
			 $.alertable.confirm('确认退出吗?').then(function() {
			      window.location.href=contextPath+"/logout.do"
			 }, function() {
			      return;   
			 });
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
		mainApp.initFunction();
		loadFirstMenu();
		eventBind();
	}
	
	init();
})