/**
 * 材料列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo,categoryId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/material/pageList',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"categoryId":categoryId},
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
	function render(data,pageNo){
		if(data.dataList.length==0)
		{
			$("#materialList").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $companyli="";
		$.each(data.dataList,function(i,material){
			$companyli+="<li class=\"fleft\">";
			$companyli+=    "<div class=\"w275 box-shadow\">"	
			$companyli+=		"<img src=\""+contextPath+"/file/image/get/"+material.imgId+"\" width=\"275\" height=\"220\">";
			$companyli+=		"<div class=\"tcenter pt5 f14\">"+material.productName+"</div>";
			$companyli+=	"</div>";
			$companyli+="</li>";
		})
		
		//渲染列表
		$("#materialList").empty().append($companyli)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//初始化
	function init(categoryId){
		initData(1,categoryId);
	}
	
	//对外输出接口
	exports.init = init;
})

