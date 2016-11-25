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
			$newsList+=		"<button type=\"button\" id=\"news_edit_"+news.id+"\" class=\"btn btn-primary btn-xs mr10\" valu="+news.id+">编辑</button>";
			$newsList+=		"<button type=\"button\" id=\"news_delete_"+news.id+"\" class=\"btn btn-default btn-xs\" valu="+news.id+">删除</button>";
			$newsList+=	"</td>";
			$newsList+="</tr>";
		})
		
		//渲染新闻列表
		$("#newsList").empty().append($newsList);
		
		//编辑绑定事件
		$("button[id^='news_edit_']").click(function(){
			window.location.href =  contextPath+'/news/showEdit.do?newsId='+$(this).attr("valu");
		})
		
		//删除绑定事件
		$("button[id^='news_delete_']").click(function(){
			var newsId = $(this).attr("valu");
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteNews(newsId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteNews(newsId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/news/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{newsId:newsId},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result==0){
			    		$.alertable.alert('删除成功!',{parentObj:window.parent.document});
			    		initData(1);
			    	}else{
			    		$.alertable.alert('删除失败!',{parentObj:window.parent.document})
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