/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化施工工人数据
	function initWorkerData(companyId){
		execute(contextPath+'/company/showWorker/'+companyId,renderWorkerData);
	}

	//渲染施工工人数据
	function renderWorkerData(data){
		if(data.length==0)
		{
			$("#workerInfo").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $worker="";
		$.each(data,function(i,worker){
			$worker+=	"<div class=\"fleft pr30\">";
			$worker+=		"<img src=\""+contextPath+"/file/image/get/"+worker.avatar+"\" width=\"187\" height=\"189\">";
			$worker+=		"<div class=\"tcenter pt5 f14\">"+worker.name+"</div>"
			$worker+=	"</div>";
		})
		$worker+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#workerInfo").empty().append($worker)
	}
	
	//初始化施工案例数据
	function initCaseData(companyId){
		execute(contextPath+'/company/showCase/'+companyId,renderCaseData);
	}
	
	//渲染案例数据
	function renderCaseData(data){
		if(data.length==0)
		{
			$("#caseInfo").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $case="";
		$.each(data,function(i,ccase){
			$case+=	"<div class=\"fleft pr30 ofHidden\">";
			$case+=		"<img src=\""+contextPath+"/file/image/get/"+ccase.imageId+"\" width=\"187\" height=\"189\">";
			$case+=		"<p class=\"f16\">"+ccase.communityName+"</p>";
			$case+=		"<b class=\"h45\"></b>";
			//$case+=		"<div class=\"tcenter pt5 f14\">"+ccase.communityName+"</div>"
			$case+=	"</div>";
		})
		$case+="<div class=\"clearfix\"></div>";
		
		$("#caseInfo").empty().append($case)
	}
	
	//初始化预约小区数据
	function initBookingData(companyId){
		execute(contextPath+'/company/showBookingCommunity/'+companyId,renderBookingData);
	}
	
	//渲染预约小区数据
	function renderBookingData(data){
		if(data.length==0)
		{
			$("#bookingInfo").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $booking="";
		$.each(data,function(i,booking){
			$booking+=	"<div class=\"fleft pr30\">";
			$booking+=		"<img src=\""+contextPath+"/file/image/get/"+booking.imageId+"\" width=\"187\" height=\"189\">";
			$booking+=		"<div class=\"tcenter pt5 f14\">"+booking.communityName+"</div>"
			$booking+=	"</div>";
		})
		$booking+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#bookingInfo").empty().append($booking)
	}
	
	//初始化公司资质数据
	function initQualificationData(companyId){
		execute(contextPath+'/company/showQualification/'+companyId,renderQualificationData);
	}
	
	//渲染公司资质数据
	function renderQualificationData(data){
		if(data.length==0)
		{
			$("#qualificationInfo").empty().append("<li class=\"clearfix tcenter\">暂无数据</li>");
			return;
		}
		var $qualification="";
		$.each(data,function(i,qualification){
			$qualification+=	"<div class=\"fleft pr30\">";
			$qualification+=		"<img src=\""+contextPath+"/file/image/get/"+qualification.imageId+"\" width=\"187\" height=\"189\">";
			$qualification+=		"<div class=\"tcenter pt5 f14\">"+qualification.title+"</div>"
			$qualification+=	"</div>";
		})
		$qualification+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#qualificationInfo").empty().append($qualification)
	}

	//ajax获取数据共方法
	function execute(url,callback){
		$.ajax({    
			url: url,       
			type:'post',    
			cache:false,  			
			dataType:'json', 
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
	function init(companyId){
		initWorkerData(companyId);
		initCaseData(companyId);
		initBookingData(companyId);
		initQualificationData(companyId);
	}
	
	//对外输出接口
	exports.init = init;
})

