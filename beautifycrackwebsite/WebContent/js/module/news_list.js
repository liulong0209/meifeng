/**
 * 新闻列表
 */
$(function(){
	//初始化数据
	function initData(pageNo){
			$.ajax({    
				url: contextPath+'/news/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo},
				beforeSend: function () {
					//$.showLoadding();
			    },
			    success: function (data) {
					if(data && data.dataList)
					{
						render(data,pageNo);
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
	function render(data,pageNo)
	{	
		if(data.dataList.length==0)
		{
			$("#newsList").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		
		var $newsList="";
		$.each(data.dataList,function(i,news){
			$newsList+="<tr>";
			$newsList+=	"<td>"+(i+1)+"</td>";
			$newsList+=	"<td>"+news.title+"</td>";
			$newsList+=	"<td>"+news.content+"</td>";
			$newsList+=	"<td>";
			$newsList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs\">编辑</button>";
			$newsList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs\">查看</button>";
			$newsList+=		"<button type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$newsList+=	"</td>";
			$newsList+="</tr>";
			
		})
		
		//渲染新闻列表
		$("#newsList").empty().append($newsList)
		
		//渲染分页
		//var pager = require("sea-modules/common");
		//pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//初始化
	function init(){
		initData(1);
	}
	
	init();
	
})