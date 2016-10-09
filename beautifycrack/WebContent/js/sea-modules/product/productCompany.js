/**
 * 材料所属公司详情
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	var companyId;
	//初始化施工工人数据
	function initWorkerData(){
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
	
	//初始化
	function init(id){
		initWorkerData();
	}
	
	//对外输出接口
	exports.init = init;
})

