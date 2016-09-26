/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化施工工人数据
	function initWorkerData(companyId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/company/showWorker/'+companyId,       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				beforeSend: function () {
					//$.showLoadding();
				},
				success: function (data) {
					if(data && data.dataList)
					{
						renderWorkerData(data);
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
		})
	}
	
	//渲染数据
	function renderWorkerData(data){
		if(data.dataList.length==0)
		{
			$("#companyList").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $companyli="";
		$.each(data.dataList,function(i,company){
			$companyli+="<li class=\"clearfix\">";
			$companyli+=	"<div class=\"fleft\">";
			$companyli+=		"<a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\"><img src=\""+contextPath+"/file/image/get/"+company.logo+"\" width=\"160\" height=\"110\"></a>";
			$companyli+=	"</div>";
			$companyli+=	"<div class=\"fleft pl30\">";
			$companyli+=		"<p class=\"bold tleft h30 pb5\"><a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\">"+company.providerName+"</a></p>"
			$companyli+=		"<p class=\"f12 tleft w800 pb5\"><i class=\"fnormal c333\">公司简介：</i>"+company.profile+"</p>"
			$companyli+=		"<p class=\"f12 tleft w800 pb5\"><i class=\"fnormal c333\">公司地址：</i>"+company.address+"<i class=\"fnormal c333 pl20\">联系方式：</i>"+company.phoneNo+"</p>";
			$companyli+=	"</div>";
			$companyli+=	"<div class=\"fright pt30 pr30\">";
			$companyli+=		"<a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\">点击进入</a>"
			$companyli+=	"</div>";
			$companyli+="</li>";
		})
		
		//渲染新闻列表
		$("#companyList").empty().append($companyli)
	}
	
	//初始化
	function init(companyId){
		initWorkerData(companyId);
	}
	
	//对外输出接口
	exports.init = init;
})

