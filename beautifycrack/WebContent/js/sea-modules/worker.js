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
		var $companyli="";
		$.each(data.dataList,function(i,company){
			$companyli+="<li class=\"clearfix\">";
			$companyli+=	"<div class=\"fleft\">";
			$companyli+=		"<img src=\""+contextPath+"/file/image/get/"+company.logo+"\" width=\"160\" height=\"110\">";
			$companyli+=	"</div>";
			$companyli+=	"<div class=\"fleft pl30\">";
			$companyli+=		"<p class=\"bold tleft h30\"><a href=\"xwnr.html\">"+company.providerName+"</a></p>"
			$companyli+=		"<p class=\"f12 tleft h25\"><i class=\"fnormal c333\">公司简介：</i>"+company.profile+"</p>"
			$companyli+=		"<p class=\"f12 tleft h25\"><i class=\"fnormal c333\">公司地址：</i>"+company.address+"<i class=\"fnormal c333 pl20\">联系方式：</i>"+company.phoneNo+"</p>";
			$companyli+=	"</div>";
			$companyli+=	"<div class=\"fright pt30 pr30\">";
			$companyli+=		"<a href=\"/zxzb/\" target=\"_blank\">点击进入</a>"
			$companyli+=	"</div>";
			$companyli+="</li>";
		})
		
		//渲染新闻列表
		$("#companyList").empty().append($companyli)
		
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

