/**
 * 轮播广告列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/worker/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,providersId:$("#providersId").val()},
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
		});
	}
	
	//渲染数据
	function render(data,pageNo)
	{	
		if(data.dataList.length==0)
		{
			$("#workerList").empty().append("<tr><td colspan='5' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $workerList="";
		$.each(data.dataList,function(i,worker){
			$workerList+="<tr>";
			$workerList+=	"<td>"+(i+1)+"</td>";
			$workerList+=	"<td>"+worker.name+"</td>";
			$workerList+=	"<td>";
			$workerList+=		"<button type=\"button\" id=\"worker_edit_"+worker.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$workerList+=		"<button type=\"button\" id=\"worker_delete_"+worker.id+"\" class=\"btn btn-default btn-xs\" avatar="+(worker.avatar?worker.avatar:"")+">删除</button>";
			$workerList+=	"</td>";
			$workerList+="</tr>";
		})
		
		//渲染新闻列表
		$("#workerList").empty().append($workerList);
		
		//编辑按钮绑定事件
		$("button[id^='worker_edit_']").click(function(){
			window.location.href =  contextPath+'/providersResource/showWorkerEdit.do?workerId='+$(this).attr("id").replace("worker_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='worker_delete_']").click(function(){
			var workerId = $(this).attr("id").replace("worker_delete_","");
			var avatar = $(this).attr("avatar");
			if(typeof(avatar) == "undefined"){avatar=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteWorker(workerId,avatar);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteWorker(workerId,avatar){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/deleteWorker.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:workerId,avatar:avatar},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result==0){
			    		$.alertable.alert('删除成功!',{parentObj:window.parent.document});
			    		initData(1);
			    	}else{
			    		$.alertable.alert('删除失败!',{parentObj:window.parent.document})
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
		});
	}
	
	//初始化
	function init(){
		initData(1);
		//新增绑定
		$("#addWorker").click(function(){
			window.location.href =  contextPath+'/providersResource/showWorkerAdd.do?providersId='+$("#providersId").val();
		})
	}
	
	//对外输出接口
	exports.init = init;
});