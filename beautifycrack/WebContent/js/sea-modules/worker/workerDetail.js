/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化施工工人数据
	function initWorkerData(workerId){
		execute(contextPath+'/providers/showWorker/'+workerId,renderWorkerData);
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
		//渲染列表
		$("#workerInfo").empty().append($worker)
	}
	
	//初始化施工案例数据
	function initCaseData(workerId){
		execute(contextPath+'/providers/showCase/'+workerId,renderCaseData);
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
				$case+=	"<div class=\"w275 fleft ofHidden pb15 mb20 box-shadow\">";
			}
			else
			{
				$case+=	"<div class=\"w275 fleft ofHidden pb15 mb20 ml30 box-shadow\">";
			}
			$case+=		"<img src=\""+contextPath+"/file/image/get/"+ccase.imageId+"\" width=\"275\" height=\"220\">";
			$case+=		"<div class=\"tcenter pt5 f14\">"+ccase.communityName+"</div>"
			$case+=	"</div>";
		})
		$case+="<div class=\"clearfix\"></div>";
		
		$("#caseInfo").empty().append($case)
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
	function init(workerId,workerType){
		//如果是团队才展示施工工人信息
		if(workerType=="1")
		{
			initWorkerData(workerId);
		}
		initCaseData(workerId);
	}
	
	//对外输出接口
	exports.init = init;
})

