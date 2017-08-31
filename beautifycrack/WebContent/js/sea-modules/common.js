/**
 * 基础的js方法
 */
define(function(require, exports, module){
	//通过 require 引入依赖
	require('jquery');
	
	/**
	 * pageNo:当前页面
	 * totalPage:总数
	 * totalRecords:总记录数
	 */
	function loadPager(pageNo,totalPage,totalRecords,queryMethodName,href){
		//引入分页组件模块
		var kkpager = require("kkpager").kkpager
		//生成分页
		//有些参数是可选的，比如lang，若不传有默认值
		kkpager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			mode : 'click',//默认值是link，可选link或者click
			click : function(n){
				//执行查询方法
				eval(queryMethodName(n)); 
				//手动选中按钮
				this.selectPage(n);
				return false;
			},
			//getHref是在click模式下链接算法
			getHref : function(n){
				if(!href)
				{
					return '#';
				}
		        return '#'+href;
		    },
			isGoPage:false
		},true);
	}
	
	//同步菜单样式
	function syncMenuClass(){
		String.prototype.endWith=function(endStr){
	      var d=this.length-endStr.length;
	      return (d>=0&&this.lastIndexOf(endStr)==d)
	    }
		
		require.async("jquery",function(){
			//如果当前url以上下文根结尾，说明是首页
			if((String(window.location)).endWith(contextPath+"/"))
			{
				$(".nav-content-list li").first().addClass("on"); 
				return;
			}
			//切割当前url
			$(".nav-content-list li").each(function(){  
				var $this = $(this); 
				var href =$this.find("a").attr("href");
				//用“/”分割href
				var arr = href.split("/");
				if(href!=contextPath &&(String(window.location)).indexOf("/"+arr[arr.length-1])>0)
				{
					$this.addClass("on"); 
					return false;
				}
			});  
		})
	}
	
	//获取当前时间
	function showLocale(objD)  
	{  
	    var str,colorhead,colorfoot;  
	    var yy = objD.getYear();  
	    if(yy<1900) yy = yy+1900;  
	    var MM = objD.getMonth()+1;  
	    if(MM<10) MM = '0' + MM;  
	    var dd = objD.getDate();  
	    if(dd<10) dd = '0' + dd;  
	    var hh = objD.getHours();  
	    if(hh<10) hh = '0' + hh;  
	    var mm = objD.getMinutes();  
	    if(mm<10) mm = '0' + mm;  
	    var ss = objD.getSeconds();  
	    if(ss<10) ss = '0' + ss;  
	    var ww = objD.getDay();  
	    if  ( ww==0 )  colorhead="<span>";  
	    if  ( ww > 0 && ww < 6 )  colorhead="<span>";  
	    if  ( ww==6 )  colorhead="<span>";  
	    if  (ww==0)  ww="星期日";  
	    if  (ww==1)  ww="星期一";  
	    if  (ww==2)  ww="星期二";  
	    if  (ww==3)  ww="星期三";  
	    if  (ww==4)  ww="星期四";  
	    if  (ww==5)  ww="星期五";  
	    if  (ww==6)  ww="星期六";  
	    colorfoot="</font>"  
	    str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "  " + ww + colorfoot;  
	    return(str);  
	};  
	function showTime()  
	{  
	    var today;  
	    today = new Date();  
	    document.getElementById("nowTime").innerHTML = showLocale(today);  
	    setTimeout('seajs.use("sea-modules/common",function(module){module.showTime()})', 1000);  
	};  
	
	//返回顶部
	function backTop(){
		var x=$(window);
		var e=$("#shape");

		$("html,body").ready(function(){
			var scrollbar=x.scrollTop();
			var isClick=0;

			(scrollbar<=0)?($("#shape").hide()):($("#shape").show());

			$(window).scroll(function(){
				scrollbar=x.scrollTop();
				(scrollbar<=0)?($("#shape").hide()):($("#shape").show());			
			})

			$("#shape").hover(
				function(){
					$(".shapeColor").show();
				},

				function(){
					$(".shapeColor").hide();
				}
			)

			$(".shapeColor").click(
				function(){
					$(".shapeFly").show();
					$("html,body").animate({scrollTop: 0},"slow");
					$("#shape").delay("200").animate({marginTop:"-1000px"},"slow",function(){
						$("#shape").css("margin-top","-125px");
						$(".shapeFly").hide();
					});
					
			})

		})
	}
	
	
	exports.loadPager = loadPager;
	exports.syncMenuClass = syncMenuClass;
	exports.showTime=showTime;
	exports.backTop=backTop;
})