/**
 * 轮播广告列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/ads/pageList.do',       
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
			$("#adsList").empty().append("<tr><td colspan='5' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $adsList="";
		$.each(data.dataList,function(i,ads){
			$adsList+="<tr>";
			$adsList+=	"<td style='vertical-align: middle;'>"+ads.title+"</td>";
			if(ads.imgId && ads.imgId!=-1){
				$adsList+=	"<td><img src="+contextPath+"/file/image/get.do?imageId="+ads.imgId+" width='100' height='50'></td>";
			}else{
				$adsList+=	"<td style='vertical-align: middle;'>还未上图片</td>";
			}
			$adsList+=	"<td style='vertical-align: middle;'>"+(ads.orderNo?ads.orderNo:"")+"</td>";
			$adsList+=	"<td style='vertical-align: middle;'>"+(ads.state==0?"草稿":"已发布")+"</td>";
			$adsList+=	"<td style='vertical-align: middle;'>";
			$adsList+=		"<button type=\"button\" id=\"news_edit_"+ads.id+"\" class=\"btn btn-primary btn-xs mr10\" valu="+ads.id+">编辑</button>";
			$adsList+=		"<button type=\"button\" id=\"news_delete_"+ads.id+"\" class=\"btn btn-default btn-xs\" valu="+ads.id+" imgvalu="+(ads.imgId?ads.imgId:"")+">删除</button>";
			$adsList+=	"</td>";
			$adsList+="</tr>";
		})
		
		//渲染新闻列表
		$("#adsList").empty().append($adsList);
		
		//编辑按钮绑定事件
		$("button[id^='news_edit_']").click(function(){
			window.location.href =  contextPath+'/ads/showEdit.do?adsId='+$(this).attr("valu");
		})
		
		//删除按钮绑定事件
		$("button[id^='news_delete_']").click(function(){
			var adsId = $(this).attr("valu");
			var imgId = $(this).attr("imgvalu");
			if(typeof(imgId) == "undefined"){imgId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteAds(adsId,imgId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteAds(adsId,imgId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/ads/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"id":adsId,"imgId":imgId},
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
		//新增绑定
		$("#addAds").click(function(){
			window.location.href =  contextPath+'/ads/showAdd.do';
		})
	}
	
	//对外输出接口
	exports.init = init;
});