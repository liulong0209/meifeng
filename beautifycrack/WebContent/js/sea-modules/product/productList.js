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
				url: contextPath+'/product/pageList',       
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
			$("#productList").empty().append("<li class=\"clearfix tcenter mt20\">此分类暂无产品</li>");
			$("#kkpager").empty();
			return;
		}
		var $productli="";
		$.each(data.dataList,function(i,product){
			$productli+="<li class=\"fleft\">";
			$productli+=    "<div class=\"w275 border_f3 ml30 mt20 mb20 pointer\">"	
			$productli+=		"<a href=\""+contextPath+"/material/showDetail/"+product.providersId+"\" target=\"_blank\"><img src=\""+contextPath+"/file/image/get/"+product.imgId+"\" width=\"275\" height=\"220\"/></a>";
			$productli+=		"<div class=\"tcenter pt10 pb10 f14 c666 bold\">"+product.productName+"</div>";
			$productli+=	"</div>";
			$productli+="</li>";
		})
		
		//渲染列表
		$("#productList").empty().append($productli)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//事件绑定
	function bindEvent(){
		//导航事件绑定
		$("#nav a").click(function(){
			$("#nav a").removeClass("select");
			$(this).addClass("select");
			initData(1,$(this).attr("categoryId"));
		});
	}
	
	//初始化
	function init(categoryId){
		initData(1,categoryId);
		bindEvent();
	}
	
	//对外输出接口
	exports.init = init;
})

