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
			$("#newsli").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		
		var $newli="";
		$.each(data.dataList,function(i,news){
			$newli+="<li>";
			$newli+=	"<div class=\"col-md-10\">";
			$newli+=		"<div class=\"news-title\">";
			$newli+=			"<a href=\""+contextPath +"/news/show/"+news.id+"\">"+news.title+"</a>";
			$newli+=		"</div>";
			$newli+=		"<div class=\"news-content\">"+news.content+"</div>";
			$newli+=	"</div>"
			$newli+=	"<div class=\"col-md-2 pt5\"><span class=\"f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span></div>"
			$newli+="</li>"
		})
		
		//渲染新闻列表
		$("#newsli").empty().append($newli)
		
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
