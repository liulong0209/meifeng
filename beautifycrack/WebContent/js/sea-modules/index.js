/**
 * 首页相关js
 */
define(function(require, exports, module) {
	//通过 require 引入依赖
	require('jquery');
	
	//初始化幻灯片
	function initSlide(){
		execute(contextPath+'/index/slideList',renderSlideImg);
		
	}
	
	function renderSlideImg(data){
		if(data.length==0){
			return;
		}
		var $slide='<ul style="overflow: hidden">';
		
		$.each(data,function(i,slide){
			$slide+='<li>';
			
			if(slide.linkUrl!='' && slide.linkUrl){
				$slide+='<a href="${slide.linkUrl}" target="_blank">';
			}else{
				$slide+='<a href="javaScript:void("0")">';
			}		
			$slide+=	'<img src="'+contextPath+'/file/image/get/'+slide.imgId+'" height="450px" width="100%"></a>';		
			$slide+='</li>';
		});
		$slide+='</ul>';
		
		$("#banner").empty().append($slide);
		
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
			$("#materialList").empty().append("<div class=\"clearfix tcenter\">暂无材料</div>");
			return;
		}
		var $materiadiv="";
		$.each(data,function(i,material){
			$materiadiv+="<div class=\"col-md-3 mb20\">";
			$materiadiv+=	"<div class=\"border_ddd wow ";
			if(i==0||i==1){
				$materiadiv+="bounceInLeft\">";
			}
			if(i==2||i==3){
				$materiadiv+="bounceInRight\">";
			}
			$materiadiv+=		"<div class=\"w283 margin-auto ofHidden\">";
			$materiadiv+=			"<a href=\""+contextPath+"/material/showCompanyMaterial/"+material.providersId+"\" target=\"_blank\"><img src=\""+contextPath+"/file/image/get/"+material.imgId+"\" width=\"283\" height=\"283\"></a>";
			$materiadiv+=		"</div>";
			$materiadiv+=		"<div class=\"pt20 pb20 pl30\">";
			$materiadiv+=			"<div>";
			$materiadiv+=				"<div class=\"f16 c333 h30\"><a href=\""+contextPath+"/material/showCompanyMaterial/"+material.providersId+"\" target=\"_blank\">"+material.productName+"</a></div>";
			$materiadiv+=				"<div class=\"f14 c80 h30\"><span>商家："+material.providersName+"</span></div>";
			$materiadiv+=			"</div>";
			$materiadiv+=		"</div>";
			$materiadiv+=	"</div>";
			$materiadiv+="</div>";
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
			$("#toolsList").empty().append("<div class=\"clearfix tcenter\">暂无工具</div>");
			return;
		}
		var $toolsdiv="";
		$.each(data,function(i,tools){
			$toolsdiv+="<div class=\"col-md-3 mb20\">";
			$toolsdiv+=	"<div class=\"border_ddd wow ";
			if(i==0||i==1){
				$toolsdiv+="bounceInLeft\">";
			}
			if(i==2||i==3){
				$toolsdiv+="bounceInRight\">";
			}
			$toolsdiv+=		"<div class=\"w283 margin-auto ofHidden\">";
			$toolsdiv+=			"<a href=\""+contextPath+"/tools/showCompanyTools/"+tools.providersId+"\" target=\"_blank\"><img src=\""+contextPath+"/file/image/get/"+tools.imgId+"\" width=\"283\" height=\"283\"></a>";
			$toolsdiv+=		"</div>";
			$toolsdiv+=		"<div class=\"pt20 pb20 pl30\">";
			$toolsdiv+=			"<div>";
			$toolsdiv+=				"<div class=\"f16 c333 h30\"><a href=\""+contextPath+"/tools/showCompanyTools/"+tools.providersId+"\" target=\"_blank\">"+tools.productName+"</a></div>";
			$toolsdiv+=				"<div class=\"f14 c80 h30\"><span>商家："+tools.providersName+"</span></div>";
			$toolsdiv+=			"</div>";
			$toolsdiv+=		"</div>";
			$toolsdiv+=	"</div>";
			$toolsdiv+="</div>";
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
			$("#company").empty().append("<div class=\"clearfix tcenter\">暂无公司</div>");
			return;
		}
		var $companyli="";
		$.each(data,function(i,company){
			$companyli+="<div class=\"col-md-4 mb20\">"
			$companyli+=	"<div class=\"border_ededed pt15 pr15 pb15 pl15 wow "
			if(i==0||i==3){
				$companyli+="bounceInLeft\">";
			}else if(i==2){
				$companyli+="bounceInRight\">";
			}else{
				$companyli+="\">";
			}
			$companyli+=		"<div class=\"fleft w150\">";
			$companyli+=			"<a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\"  class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+company.logo+"\" width=\"150\" height=\"150\"></a>";
			$companyli+=		"</div>";
			$companyli+=		"<div class=\"fleft pl15 w200\">";
			$companyli+=			"<div class=\"f16 bold\" title=\""+company.providerName+"\"><a href=\""+contextPath+"/company/showDetail/"+company.providersId+"\" target=\"_blank\">"+company.providerName+"</a></div>";
			$companyli+=			"<div class=\"pt5\">地址：<span class=\"c80\">"+company.address+"</span></div>";
			$companyli+=			"<div class=\"pt5\">电话：<span class=\"c80\">"+company.phoneNo+"</span></div>";
			$companyli+=		"</div>"
			$companyli+=		"<div class=\"clearfix\"></div>";
			$companyli+=	"</div>";
			$companyli+="</div>";
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
			$("#worker").empty().append("<div class=\"clearfix tcenter\">暂无施工工人</div>");
			return;
		}
		var $workerli="";
		$.each(data,function(i,worker){
			$workerli+="<div class=\"col-md-6 mb20\">";
			$workerli+=	"<div class=\"wow "
				if(i==0||i==2){
					$workerli+="bounceInLeft\">";
				}
				if(i==1||i==3){
					$workerli+="bounceInRight\">";
				}
			$workerli+="	<div class=\"fleft w150\">";
			$workerli+=			"<a href=\""+contextPath+"/worker/showDetail/"+worker.providersId+"\" target=\"_blank\" class=\"h165\"><img src=\""+contextPath+"/file/image/get/"+worker.logo+"\" width=\"150\" height=\"150\" class=\"radius75\"></a>";
			$workerli+=		"</div>";
			$workerli+="	<div class=\"fleft pt15 pl30 workertext w310\">";
			$workerli+="		<div class=\"f16 bold\"><a href=\""+contextPath+"/worker/showDetail/"+worker.providersId+"\" target=\"_blank\" class=\"h165\">"+worker.providerName;
			if(worker.type==1){
				$workerli+="(团队)";
			}
			else{
				$workerli+="(个人)";
			}
			$workerli+="</a></div>";
			$workerli+="		<div class=\"pt5\">服务区域：<span class=\"c80\">"+worker.address+"</span></div>";
			$workerli+="		<div class=\"pt5\">电话：<span class=\"c80\">"+worker.phoneNo+"</span></div>";
			$workerli+="	</div>";
			$workerli+="	<div class=\"clearfix\"></div>";
			$workerli+="  </div>";
			$workerli+="</div>";
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
			$("#newsli").empty().append("<li class=\"clearfix tcenter\">暂无新闻</li>");
			return;
		}
		require.async('custom',function(){
			var $newli="";
			$.each(data,function(i,news){
				$newli+="<li>";
				$newli+=	"<div class=\"col-md-10\">";
				$newli+=		"<div class=\"news-title\">";
				$newli+=			"<a href=\""+contextPath +"/news/show/"+news.id+"\">"+news.title+"</a>";
				$newli+=		"</div>";
				$newli+=		"<div class=\"news-content\">"+(news.subtitle?news.subtitle:"")+"</div>";
				$newli+=	"</div>"
				$newli+=	"<div class=\"col-md-2 pt5\"><span class=\"f12\">"+$.formatDate("yyyy-MM-dd",new Date(news.publishTime))+"</span></div>"
				$newli+="</li>"
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
		
		require.async('wow',function(){
			new WOW().init();
		})
	}
	
	exports.init = init;
});