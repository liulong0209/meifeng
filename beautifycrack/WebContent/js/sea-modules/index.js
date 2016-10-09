/**
 * 首页相关js
 */
define(function(require, exports, module) {
	//通过 require 引入依赖
	require('jquery');
	
	//初始化幻灯片
	function initSlide(){
		require.async('unSlide',function(){
			$("#banner").unslider({dots: true});
		});
	}
	
	//初始化美缝材料数据
	function initMaterial(){
		execute(contextPath+'/product/indexShow/1',renderMaterial);
	}
	//渲染材料
	function renderMaterial(data){
		if(data.length==0){
			$("#materialList").empty().append("<li class=\"clearfix tcenter\">暂无材料</li>");
			return;
		}
		var $materiadiv="";
		$.each(data,function(i,material){
			if(i!=0){
				$materiadiv+="<div class=\"w275 fleft h165 ofHidden ml30\">";
			}else{
				$materiadiv+="<div class=\"w275 fleft h165 ofHidden\">";
			}
			$materiadiv+=	"<a href=\""+contextPath+"/material/showDetail/"+material.providersId+"\" target=\"_blank\" class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+material.imgId+"\" width=\"275\" height=\"165\">";
			$materiadiv+=		"<p class=\"f16\">"+material.productName+"</p>";
			$materiadiv+=		"<b class=\"h45\"></b>";
			$materiadiv+=	"</a>";
			$materiadiv+="</div>"
		});
		
		$("#materialList").empty().append($materiadiv);
	}
	
	//初始化美缝工具数据
	function initTools(){
		execute(contextPath+'/product/indexShow/0',rendertools);
	}
	//渲染工具
	function rendertools(data){
		if(data.length==0){
			$("#toolsList").empty().append("<li class=\"clearfix tcenter\">暂无工具</li>");
			return;
		}
		var $toolsdiv="";
		$.each(data,function(i,tools){
			if(i!=0){
				$toolsdiv+="<div class=\"w275 fleft h165 ofHidden ml30\">";
			}else{
				$toolsdiv+="<div class=\"w275 fleft h165 ofHidden\">";
			}
			$toolsdiv+=	"<a href=\""+contextPath+"/material/showDetail/"+tools.providersId+"\" target=\"_blank\" class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+tools.imgId+"\" width=\"275\" height=\"165\">";
			$toolsdiv+=		"<p class=\"f16\">"+tools.productName+"</p>";
			$toolsdiv+=		"<b class=\"h45\"></b>";
			$toolsdiv+=	"</a>";
			$toolsdiv+="</div>"
		});
		
		$("#toolsList").empty().append($toolsdiv);
	}
	
	//初始化美缝公司数据
	function initCompany(){
		execute(contextPath+'/index/providersList',renderCompany,{type:"0"});
	}
	//渲染公司数据
	function renderCompany(data){
		if(data.length==0){
			$("#company").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $companyli="";
		$.each(data,function(i,company){
			$companyli+="<li>"
			$companyli+=	"<div class=\"fleft w150\">";
			$companyli+=		"<a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\"  class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+company.logo+"\" width=\"150\" height=\"150\"></a>";
			$companyli+=	"</div>";
			$companyli+=	"<div class=\"fleft pl15 w235\">";
			$companyli+=		"<div class=\"f16 bold ellipsis w235\" title=\""+company.providerName+"\"><a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\">"+company.providerName+"</a></div>";
			$companyli+=		"<div class=\"pt5\">地址："+company.address+"</div>";
			$companyli+=		"<div class=\"pt5\">电话："+company.phoneNo+"</div>";
			$companyli+=	"</div>"
			$companyli+=	"<div class=\"clearfix\"></div>";
			$companyli+="</li>";
		});
		$("#company").empty().append($companyli);
	}
	
	//初始化施工工人数据
	function initWorker(){
		execute(contextPath+'/index/providersList',rederWorker,{type:"1,2"});
	}
	
	//渲染施工工人数据
	function rederWorker(data){
		if(data.length==0){
			$("#worker").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $workerli="";
		$.each(data,function(i,worker){
			$workerli+="<li>"
			$workerli+=	"<div class=\"fleft w150\">";
			$workerli+=		"<a href=\""+contextPath+"/worker/showDetail/"+worker.providersId+"\" target=\"_blank\" class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+worker.logo+"\" width=\"150\" height=\"150\"></a>";
			$workerli+=	"</div>";
			$workerli+=	"<div class=\"fleft pl15 w235\">";
			$workerli+=		"<div class=\"f16 bold \">"+worker.providerName+"</div>";
			$workerli+=		"<div class=\"pt5\">服务区域："+worker.address+"</div>";
			$workerli+=		"<div class=\"pt5\">电话："+worker.phoneNo+"</div>";
			$workerli+=	"</div>"
			$workerli+=	"<div class=\"clearfix\"></div>";
			$workerli+="</li>";
		});
		$("#worker").empty().append($workerli);
	}
	
	//初始化新闻列表数据
	function initnews(){
		execute(contextPath+'/news/index/newsList',renderNews);
	}
	
	//渲染新闻数据
	function renderNews(data){
		if(data.length==0){
			$("#newsli").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		require.async('custom',function(){
			var $newli="";
			$.each(data,function(i,news){
				$newli+="<li><a href=\""+contextPath +"/news/show/"+news.id+"\">"+news.title+"<span class=\"fright f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span></a></li>"
			})
			
			$("#newsli").empty().append($newli);
		});
	}
	
	//ajax获取数据共方法
	function execute(url,callback,param){
		$.ajax({    
			url: url,       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:param,
			beforeSend: function () {
				//$.showLoadding();
		    },
		    success: function (data) {
				if(data && $.isFunction(callback))
				{
					callback(data);
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
	
	//初始化
	function init(){
		//幻灯片
		initSlide();
		//材料
		initMaterial();
		//工具
		initTools();
		//公司
		initCompany();
		//工人
		initWorker();
		//新闻
		initnews();
	}
	
	exports.init = init;
});