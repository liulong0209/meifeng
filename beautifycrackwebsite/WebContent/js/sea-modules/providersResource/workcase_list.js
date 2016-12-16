/**
 * 公司 团队下的案例列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/workcase/pageList.do',       
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
			$("#workcaseList").empty().append("<tr><td colspan='3' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $workcaseList="";
		$.each(data.dataList,function(i,workcase){
			$workcaseList+="<tr>";
			$workcaseList+=	"<td>"+(i+1)+"</td>";
			$workcaseList+=	"<td>"+workcase.communityName+"</td>";
			$workcaseList+=	"<td>";
			$workcaseList+=		"<button type=\"button\" id=\"workcase_edit_"+workcase.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$workcaseList+=		"<button type=\"button\" id=\"workcase_delete_"+workcase.id+"\" class=\"btn btn-default btn-xs\" imageId="+(workcase.imageId?workcase.imageId:"")+">删除</button>";
			$workcaseList+=	"</td>";
			$workcaseList+="</tr>";
		})
		
		//渲染新闻列表
		$("#workcaseList").empty().append($workcaseList);
		
		//编辑按钮绑定事件
		$("button[id^='workcase_edit_']").click(function(){
			window.location.href =  contextPath+'/providersResource/showWorkcaseEdit.do?workcaseId='+$(this).attr("id").replace("workcase_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='workcase_delete_']").click(function(){
			var workcaseId = $(this).attr("id").replace("workcase_delete_","");
			var imageId = $(this).attr("imageId");
			if(typeof(imageId) == "undefined"){imageId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteWorkcase(workcaseId,imageId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteWorkcase(workcaseId,imageId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/deleteWorkcase.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:workcaseId,imageId:imageId},
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
		$("#addWorkcase").click(function(){
			window.location.href =  contextPath+'/providersResource/showWorkcaseAdd.do?providersId='+$("#providersId").val();
		})
	}
	
	//对外输出接口
	exports.init = init;
});