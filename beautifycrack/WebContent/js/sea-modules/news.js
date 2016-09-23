/**
 * 新闻列表
 */
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/news/pageList',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo},
				beforeSend: function () {
					$.showLoadding();
			    },
			    success: function (data) {
					if(data && data.dataList)
					{
						render(data,pageNo);
					}	
			    },
			    complete: function () {
			    	$.hideLoadding();
			    },
			    error: function (data) {
			    	$.hideLoadding();
			        console.info("error: " + data.responseText);
			    }

			});
		})
	}
	
	//渲染数据
	function render(data,pageNo)
	{	
		if(data.dataList.length==0)
		{
			$("#newsList").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		
		var $newli="";
		$.each(data.dataList,function(i,news){
			$newli+="<li class=\"clearfix\">";
			$newli+=	"<div class=\"fleft\">";
			$newli+=		"<a href=\"news/show/"+news.id+"\">"+news.title+"</a>";
			$newli+=	"</div>";
			$newli+=	"<div class=\"fright\">";
			$newli+=		"<span class=\"time f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span>";
			$newli+=	"</div>";
			$newli+="</li>";
		})
		
		//渲染新闻列表
		$("#newsList").empty().append($newli)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//初始化
	function init(){
		initData(1);
	}
	
	//对外输出接口
	exports.init = init;
})
