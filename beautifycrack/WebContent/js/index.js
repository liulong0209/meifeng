/**
 * 首页js
 */
$(function(){
	
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
		var $newli="";
		$.each(data,function(i,news){
			$newli+="<li><a href=\""+contextPath +"/news/show/"+news.id+"\">"+news.title+"<span class=\"fright f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span></a></li>"
		})
		
		$("#newsli").empty().append($newli);
	}
	
	//初始化
	function init(){
		initnews();
	}
	
	init();
})