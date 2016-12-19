/**
 * 防伪查询列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/antiFake/pageList.do',       
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
			$("#antifakeList").empty().append("<tr><td colspan='3' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $antifakeList="";
		$.each(data.dataList,function(i,antifake){
			$antifakeList+="<tr>";
			$antifakeList+=	"<td>"+(i+1)+"</td>";
			$antifakeList+=	"<td>"+antifake.title+"</td>";
			$antifakeList+=	"<td>";
			$antifakeList+=		"<button type=\"button\" id=\"antifake_edit_"+antifake.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$antifakeList+=		"<button type=\"button\" id=\"antifake_delete_"+antifake.id+"\" class=\"btn btn-default btn-xs\" imageId="+(antifake.imageId?antifake.imageId:"")+">删除</button>";
			$antifakeList+=	"</td>";
			$antifakeList+="</tr>";
		})
		
		//渲染新闻列表
		$("#antifakeList").empty().append($antifakeList);
		
		//编辑按钮绑定事件
		$("button[id^='antifake_edit_']").click(function(){
			window.location.href =  contextPath+'/providersResource/showAntiFakeEdit.do?antiFakeId='+$(this).attr("id").replace("antifake_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='antifake_delete_']").click(function(){
			var antifakeId = $(this).attr("id").replace("antifake_delete_","");
			var imageId = $(this).attr("imageId");
			if(typeof(imageId) == "undefined"){imageId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteAntifake(antifakeId,imageId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteAntifake(antifakeId,imageId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/deleteAntiFake.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:antifakeId,imageId:imageId},
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
		$("#addAntiFake").click(function(){
			window.location.href =  contextPath+'/providersResource/showAntiFakeAdd.do?providersId='+$("#providersId").val();
		})
	}
	
	//对外输出接口
	exports.init = init;
});