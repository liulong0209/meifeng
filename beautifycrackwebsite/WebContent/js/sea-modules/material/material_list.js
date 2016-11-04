/**
 * 材料列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo,categoryId,type){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/material/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"categoryId":categoryId},
				beforeSend: function () {
					$.showLoadding();
				},
				success: function (data) {
					if(data && data.dataList)
					{
						render(data,pageNo,type);
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
	function render(data,pageNo,type){
		if(data.dataList.length==0)
		{
			$("#materialList").empty().append("<tr><td>暂无数据</td></tr>");
			$("#kkpager").empty();
			return;
		}
		var $materialList="";
		$.each(data.dataList,function(i,material){
			$materialList+="<tr>";
			$materialList+=	"<td>"+(i+1)+"</td>";
			$materialList+=	"<td>"+material.productName+"</td>";
			$materialList+=	"<td>";
			$materialList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$materialList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">查看</button>";
			$materialList+=		"<button type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$materialList+=	"</td>";
			$materialList+="</tr>";
		})
		
		//渲染列表
		$("#materialList").empty().append($materialList)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	
	//初始化
	function init(categoryId,type){
		initData(1,categoryId,type);
	}
	
	//对外输出接口
	exports.init = init;
})

