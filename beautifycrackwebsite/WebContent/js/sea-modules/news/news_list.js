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
				url: contextPath+'/news/pageList.do',       
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
		});
	}
	
	//渲染数据
	function render(data,pageNo)
	{	
		if(data.dataList.length==0)
		{
			$("#newsList").empty().append("<tr><td colspan='4' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $newsList="";
		$.each(data.dataList,function(i,news){
			$newsList+="<tr>";
			$newsList+=	"<td>"+(i+1)+"</td>";
			$newsList+=	"<td>"+news.title+"</td>";
			$newsList+=	"<td>"+(news.state==0?"草稿":"已发布")+"</td>";
			$newsList+=	"<td>";
			$newsList+=		"<button type=\"button\" id=\"news_edit_"+news.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$newsList+=		"<input type=\"hidden\" value=\""+news.id+"\">";
			$newsList+=		"<button type=\"button\" id=\"news_show\" class=\"btn btn-primary btn-xs mr10\">查看</button>";
			$newsList+=		"<button type=\"button\" id=\"news_edit\" class=\"btn btn-default btn-xs\">删除</button>";
			$newsList+=	"</td>";
			$newsList+="</tr>";
		})
		
		//渲染新闻列表
		$("#newsList").empty().append($newsList);
		
		//按钮绑定事件
		$("button[id^='news_edit_']").click(function(){
			window.location.href =  contextPath+'/news/showEdit.do?newsId='+$(this).next("input[type=hidden]").val();
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//初始化
	function init(){
		initData(1);
		
		//绑定发布新闻
		$("#addNews").click(function(){
			window.location.href =  contextPath+'/news/showAdd.do';
		})
	}
	
	//对外输出接口
	exports.init = init;
});