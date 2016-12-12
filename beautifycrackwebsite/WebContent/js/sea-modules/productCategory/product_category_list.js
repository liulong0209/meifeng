/**
 * 材料分类列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/productCategory/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"productType":$("#productType").val()},
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
			$("#productCategoryList").empty().append("<tr><td>暂无数据</td></tr>");
			$("#kkpager").empty();
			return;
		}
		var $productCategoryList="";
		$.each(data.dataList,function(i,productCategory){
			$productCategoryList+="<tr>";
			$productCategoryList+=	"<td>"+(i+1)+"</td>";
			$productCategoryList+=	"<td>"+productCategory.name+"</td>";
			$productCategoryList+=	"<td>";
			$productCategoryList+=		"<button id=\"edit_"+productCategory.id+"\" type=\"button\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$productCategoryList+=		"<button id=\"delete_"+productCategory.id+"\" type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$productCategoryList+=	"</td>";
			$productCategoryList+="</tr>";
		})
		
		//渲染列表
		$("#productCategoryList").empty().append($productCategoryList)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
		
		//编辑按钮绑定事件
		$("button[id^='edit_']").click(function(){
			window.location.href =  contextPath+'/productCategory/showEdit.do?id='+$(this).attr("id").replace("edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='delete_']").click(function(){
			var id = $(this).attr("id").replace("delete_","");
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteCategory(id);
			    }, function() {
			         return;      
			    });
			})
		})
	}
	
	function deleteCategory(id){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/productCategory/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"id":id},
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
	
	//时间绑定
	function eventBind(){
		$("#product_category_add").click(function(){
			window.location.href=contextPath+"/productCategory/showAdd.do?productType="+$("#productType").val()
		})
	}
	
	
	//初始化
	function init(){
		initData(1);
		eventBind();
	}
	
	//对外输出接口
	exports.init = init;
})

