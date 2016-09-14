/**
 * 新闻列表
 */
$(function(){
	//初始化数据
	function initData(){
		$.ajax({    
			url: contextPath+'/news/pageList',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			beforeSend: function () {
				//$.showLoadding();
		    },
		    success: function (data) {
				if(data)
				{
					render(data);
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
	
	function render(newsList)
	{	var $newli="";
		$.each(newsList,function(i,news){
			$newli+="<li class=\"clearfix\">";
			$newli+=	"<div class=\"fleft\">";
			$newli+=		"<a href=\"\">"+news.title+"</a>";
			$newli+=	"</div>";
			$newli+=	"<div class=\"fright\">";
			$newli+=		"<span class=\"time\">"+news.publishTime+"</span>";
			$newli+=	"</div>";
			$newli+="</li>";
		})
		
		$("#newsList").empty().append($newli)
	}
	
	//初始化
	function init(){
		initData();
	}
	
	init(); 
})