/**
 * 新闻列表
 */
$(function(){
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
	}
	
	var pageNo = getParameter('pno');
	if(!pageNo){
		pageNo = 1;
	}
	
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
				if(data && data.dataList)
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
	
	//渲染数据
	function render(data)
	{	var $newli="";
		$.each(data.dataList,function(i,news){
			$newli+="<li class=\"clearfix\">";
			$newli+=	"<div class=\"fleft\">";
			$newli+=		"<a href=\"\">"+news.title+"</a>";
			$newli+=	"</div>";
			$newli+=	"<div class=\"fright\">";
			$newli+=		"<span class=\"time\">"+$.formatDate("yyyy-MM-dd hh:mm:ss",new Date(news.publishTime))+"</span>";
			$newli+=	"</div>";
			$newli+="</li>";
		})
		
		//渲染新闻列表
		$("#newsList").empty().append($newli)
		
		//渲染分页
		Common.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords)
	}
	
	//初始化
	function init(){
		initData();
	}
	
	//执行初始化方法
	init(); 
});