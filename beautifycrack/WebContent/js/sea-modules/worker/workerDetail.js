/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	var workerId;
	
	//初始化施工工人数据
	function initWorkerData(){
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
	function initCaseData(){
		execute(contextPath+'/providers/showCase/'+workerId,renderCaseData);
	}
	
	//渲染案例数据
	function renderCaseData(data){
		if(data.length==0)
		{
			$("#caseInfo").empty().append("<li class=\"tcenter f14\">还没有上传任何施工案例</li>");
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
	
	//初始化评价信息
	function initEvaluationData(pageNo)
	{
		execute(contextPath+'/evaluation/pageList',renderEvaluationData,{"pageNo":pageNo,"gainer":workerId});
	}
	//渲染评价信息
	function renderEvaluationData(data)
	{
		if(data.dataList.length==0)
		{
			$("#evaluationInfo").empty().append("<li class=\"clearfix tcenter\">暂时没有人评价</li>");
			return;
		}
		require.async('custom',function(){
			var $evaluation="";
			$.each(data.dataList,function(i,evaluation){
				$evaluation +="<div class=\"pt20 pb20 clearfix border_bottom_f3\">";
				$evaluation +=	"<div class=\"ofHidden\">";
				$evaluation +=		"<div class=\"fleft\">";
				$evaluation +=			"<img src=\""+contextPath+"/file/image/get/"+evaluation.reviewer+"\" width=\"50\" height=\"50\" class=\"radius30\"/>"
				$evaluation +=		"</div>";
				$evaluation +=		"<div class=\"fleft pl30\">";
				$evaluation +=			"<div class=\"f14 c666\"><span class=\"pr30 bold\">"+evaluation.reviewer+"</span></span>"+$.formatDate("yyyy-MM-dd hh:mm:ss",new Date(evaluation.reviewTime))+"</span></div>";
				$evaluation +=			"<div class=\"pt10 f14 c666\">"+evaluation.content+"</div>";
				$evaluation +=		"</div>";
				$evaluation +=	"</div>";
				$evaluation +="</div>";
			})
			$("#evaluationInfo").empty().append($evaluation);
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(data.pager.pageNo,data.pager.totalPage,data.pager.totalRecords,initEvaluationData,"evaluationCell");
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
	
	//发表评论
	function commitComment(){
		//判断是否登录
		if(!userInfo){
//			require.async('bootstrap',function(){
//				$('#tipsModule').find(".modal-body").empty().append("登录后才可以进行评价，请先登录!");
//				$('#tipsModule').modal("show");
//			})
//			return;
		}
		
		var level = $('input[name="optionsRadios"]:checked').val();
		if(!level){
			require.async('bootstrap',function(){
				$('#tipsModule').find(".modal-body").empty().append("请选择评价类型");
				$('#tipsModule').modal("show");
			})
			return;
		}
		//判断内容是否为空
		var content = $("textarea").val();
		if(content==""){
			require.async('bootstrap',function(){
				$('#tipsModule').find(".modal-body").empty().append("请输入评价内容");
				$('#tipsModule').modal("show");
			})
			return;
		}
		//异步提交
		execute(contextPath+'/evaluation/evaluate',
			function(data){
				if(data.result=='0')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("登录后才可以进行评价，请先登录!");
						$('#tipsModule').modal("show");
					})
				}
				else if(data.result=='1')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("评价成功！");
						$('#tipsModule').modal("show");
						//清空表单
						$('input[name="optionsRadios"]:checked').attr('checked',false);
						$("textarea").val("");
						//重新加载评价内容
						initEvaluationData(1);
					})
				}
				else if(data.result=='2')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("评价成功！");
						$('#tipsModule').modal("show");
					})
				}
			}
		,{"gainer":workerId,"content":content,"level":level});
	}
	
	//按钮绑定事件
	function buttonBindEvent(){
		//发表评论按钮事件
		$("#commit").click(function(){
			commitComment();
		})
	}
	
	//初始化
	function init(id,workerType){
		workerId = id
		//如果是团队才展示施工工人信息
		if(workerType=="1")
		{
			initWorkerData();
		}
		initCaseData();
		
		initEvaluationData(1);
		
		buttonBindEvent();
	}
	
	//对外输出接口
	exports.init = init;
})

