/**
 * 工具列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/product/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"productType":0},
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
		})
	}
	
	//渲染数据
	function render(data,pageNo){
		if(data.dataList.length==0)
		{
			$("#toolsList").empty().append("<tr><td>暂无数据</td></tr>");
			$("#kkpager").empty();
			return;
		}
		var $toolsList="";
		$.each(data.dataList,function(i,tools){
			$toolsList+="<tr>";
			$toolsList+=	"<td>"+(i+1)+"</td>";
			$toolsList+=	"<td>"+tools.productName+"</td>";
			$toolsList+=	"<td>"+tools.categoryName+"</td>";
			$toolsList+=	"<td>"+tools.providersName+"</td>";
			$toolsList+=	"<td>";
			$toolsList+=		"<button type=\"button\" id=\"tools_edit_"+tools.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$toolsList+=		"<button type=\"button\" id=\"tools_delete_"+tools.id+"\"  class=\"btn btn-default btn-xs\" imgId="+(tools.imgId?tools.imgId:"")+">删除</button>";
			$toolsList+=	"</td>";
			$toolsList+="</tr>";
		})
		
		//渲染列表
		$("#toolsList").empty().append($toolsList);
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
		
		//编辑按钮绑定事件
		$("button[id^='tools_edit_']").click(function(){
			window.location.href =  contextPath+'/tools/showEdit.do?productId='+$(this).attr("id").replace("tools_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='tools_delete_']").click(function(){
			var toolsId = $(this).attr("id").replace("tools_delete_","");
			var imgId = $(this).attr("imgId");
			if(typeof(imgId) == "undefined"){imgId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deletetools(toolsId,imgId);
			    }, function() {
			         return;      
			    });
			})
		})
	}
	
	function deletetools(toolsId,imgId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/product/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"id":toolsId,"imgId":imgId},
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
		$("#addTools").click(function(){
			window.location.href=contextPath+"/tools/showAdd.do"
		})
	}
	
	//对外输出接口
	exports.init = init;
})

