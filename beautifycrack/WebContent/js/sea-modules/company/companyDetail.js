/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化施工工人数据
	function initWorkerData(companyId){
		execute(contextPath+'/providers/showWorker/'+companyId,renderWorkerData);
	}

	//渲染施工工人数据
	function renderWorkerData(data){
		if(data.length==0)
		{
			$("#workerInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任何施工工人信息</li>");
			return;
		}
		var $worker="";
		$.each(data,function(i,worker){
			$worker+=	"<div class=\"fleft pr75\">";
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
		execute(contextPath+'/providers/showCase/'+companyId,renderCaseData);
	}
	
	//渲染案例数据
	function renderCaseData(data){
		if(data.length==0)
		{
			$("#caseInfo").empty().append("<li class=\" tcenter\">该公司还没有上传任何施工案例</li>");
			return;
		}
		var $case="";
		$.each(data,function(i,ccase){
			if(i%4==0)
			{
				$case+=	"<div class=\"w275 fleft pb15 mb20 box-shadow\">";
			}
			else
			{
				$case+=	"<div class=\"w275 fleft pb15 mb20 ml30 box-shadow\">";
			}
			$case+=		"<img src=\""+contextPath+"/file/image/get/"+ccase.imageId+"\" width=\"275\" height=\"220\" class=\"zoomify\" style=\"transform: scale(1) translate(0px, 0px);\">";
			$case+=		"<div class=\"tcenter pt5 f14\">"+ccase.communityName+"</div>"
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
			$("#bookingInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任何预约小区</li>");
			return;
		}
		var $booking="";
		$.each(data,function(i,booking){
			if(i%4==0)
			{
				$booking+=	"<div class=\"w275 fleft pb15 mb20 box-shadow\">";
			}
			else
			{
				$booking+=	"<div class=\"w275 fleft pb15 mb20 ml30 box-shadow\">";
			}
			$booking+=		"<img src=\""+contextPath+"/file/image/get/"+booking.imageId+"\" width=\"275\" height=\"220\">";
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
			$("#qualificationInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任何资质</li>");
			return;
		}
		var $qualification="";
		$.each(data,function(i,qualification){
			$qualification+=	"<div class=\"fleft pr30 pb30\">";
			$qualification+=		"<img src=\""+contextPath+"/file/image/get/"+qualification.imageId+"\" width=\"187\" height=\"189\">";
			$qualification+=	"</div>";
		})
		$qualification+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#qualificationInfo").empty().append($qualification)
	}
	
	//初始化评价信息
	function initEvaluationData(companyId,pageNo){
		$.ajax({    
			url: contextPath+'/evaluation/pageList',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{"pageNo":pageNo,"gainer":companyId},
			beforeSend: function () {
				//$.showLoadding();
			},
			success: function (data) {
				if(data)
				{
					renderEvaluationData(data,pageNo);
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
	//渲染评价信息
	function renderEvaluationData(data,pageNo)
	{
		if(data.dataList.length==0)
		{
			$("#evaluationInfo").empty().append("<li class=\"clearfix tcenter\">暂时没有人评价</li>");
			return;
		}
		require.async('custom',function(){
			var $evaluation="<ul>";
			$.each(data.dataList,function(i,evaluation){
				$evaluation +="<li>";
				$evaluation +="<div class=\"\">"+evaluation.reviewer+$.formatDate("yyyy-MM-dd hh:mm:ss",new Date(evaluation.reviewTime))+"</div>";
				$evaluation +="<div class=\"\">"+evaluation.content+"</div>";
				$evaluation +="</li>";
			})
			$evaluation+="</ul>";
			$("#evaluationInfo").empty().append($evaluation);
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initEvaluationData);
	}

	//ajax获取数据共方法
	function execute(url,callback,postData){
		$.ajax({    
			url: url,       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:postData,
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
	
	require.async('zoomify',function(){
		$("#caseInfo img,#bookingInfo img,#qualificationInfo img").zoomify()
	});
	
	
	//初始化
	function init(companyId){
		initWorkerData(companyId);
		initCaseData(companyId);
		initBookingData(companyId);
		initQualificationData(companyId);
		initEvaluationData(companyId,1);
	}
	
	//对外输出接口
	exports.init = init;
})

