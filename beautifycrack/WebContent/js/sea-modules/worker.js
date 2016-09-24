/**
 * 施工工人列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/pageList',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"type":"1,2"},
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
			$("#workerList").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $workerli="";
		$.each(data.dataList,function(i,worker){
			$workerli+="<li class=\"fleft wper50\">";
			$workerli+=	"<div class=\"fleft\">";
			$workerli+=		"<img src=\""+contextPath+"/file/image/get/"+worker.logo+"\" width=\"160\" height=\"110\">";
			$workerli+=	"</div>";
			$workerli+=	"<div class=\"fleft pl30\">";
			$workerli+=		"<p class=\"bold tleft h30 pb5\"><a href=\"xwnr.html\">"+worker.providerName+"("+judge(worker.type)+")</a></p>"
			$workerli+=		"<p class=\"f12 tleft w400 pb5\"><i class=\"fnormal c333\">"+judge(worker.type)+"简介：</i>"+worker.profile+"</p>"
			$workerli+=		"<p class=\"f12 tleft w400 pb5\"><i class=\"fnormal c333\">服务区域：</i>"+worker.address+"<i class=\"fnormal c333 pl20\">联系方式：</i>"+worker.phoneNo+"</p>";
			$workerli+=	"</div>";
			$workerli+="</li>";
		})
		
		//渲染新闻列表
		$("#workerList").empty().append($workerli)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//判断团队还是个人，返回文字
	function judge(type){
		if(type==1)
		{
			return "团队";
		}
		else if(type==2)
		{
			return "个人";
		}
	}
	
	//初始化
	function init(){
		initData(1);
	}
	
	//对外输出接口
	exports.init = init;
})

