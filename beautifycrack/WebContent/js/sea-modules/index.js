/**
 * 首页相关js
 */
define(function(require, exports, module) {
	//通过 require 引入依赖
	require('jquery');
	
	//初始化幻灯片
	function initSlide(){
		require.async('unSlide',function(){
			$("#banner").unslider({dots: true});
		});
	}
	
	//初始化新闻列表数据
	function initnews(){
		$.ajax({    
			url: contextPath+'/news/index/newsList',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			beforeSend: function () {
				//$.showLoadding();
		    },
		    success: function (data) {
				if(data)
				{
					renderNews(data);
				}	
		    },
		    complete: function () {
		    	//$.hideLoadding();
		    },
		    error: function (data) {
		    	//$.hideLoadding();
		        console.info("error: " + data.responseText);
		    }

		});
	}
	
	function renderNews(data){
		require('custom');
		var $newli="";
		$.each(data,function(i,news){
			$newli+="<li><a href=\""+contextPath +"/news/show/"+news.id+"\">"+news.title+"<span class=\"fright f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span></a></li>"
		})
		
		$("#newsli").empty().append($newli);
	}
	
	//初始化
	function init(){
		//幻灯片
		initSlide();
		//新闻
		initnews();
	}
	
	exports.init = init;
});