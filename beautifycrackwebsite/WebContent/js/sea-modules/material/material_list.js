/**
 * 材料列表
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
				data:{"pageNo":pageNo,"productType":1},
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
			$("#materialList").empty().append("<tr><td colspan='5' align=center>暂无数据</td></tr>");
			$("#kkpager").empty();
			return;
		}
		var $materialList="";
		$.each(data.dataList,function(i,material){
			$materialList+="<tr>";
			$materialList+=	"<td>"+(i+1)+"</td>";
			$materialList+=	"<td>"+material.productName+"</td>";
			$materialList+=	"<td>"+material.categoryName+"</td>";
			$materialList+=	"<td>"+material.providersName+"</td>";
			$materialList+=	"<td>";
			$materialList+=		"<button type=\"button\" id=\"material_edit_"+material.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$materialList+=		"<button type=\"button\" id=\"material_delete_"+material.id+"\"  class=\"btn btn-default btn-xs\" imgId="+(material.imgId?material.imgId:"")+">删除</button>";
			$materialList+=	"</td>";
			$materialList+="</tr>";
		})
		
		//渲染列表
		$("#materialList").empty().append($materialList);
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
		
		//编辑按钮绑定事件
		$("button[id^='material_edit_']").click(function(){
			window.location.href =  contextPath+'/material/showEdit.do?productId='+$(this).attr("id").replace("material_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='material_delete_']").click(function(){
			var materialId = $(this).attr("id").replace("material_delete_","");
			var imgId = $(this).attr("imgId");
			if(typeof(imgId) == "undefined"){imgId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deletematerial(materialId,imgId);
			    }, function() {
			         return;      
			    });
			})
		})
	}
	
	function deletematerial(materialId,imgId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/product/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"id":materialId,"imgId":imgId},
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
		$("#addMaterial").click(function(){
			window.location.href=contextPath+"/material/showAdd.do"
		})
	}
	
	//对外输出接口
	exports.init = init;
})

