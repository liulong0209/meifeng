/**
 * 材料分类列表
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
		var $materialClassList="";
		$.each(data.dataList,function(i,material){
			$materialClassList+="<tr>";
			$materialClassList+=	"<td>"+(i+1)+"</td>";
			$materialClassList+=	"<td>"+material.productName+"</td>";
			$materialClassList+=	"<td>";
			$materialClassList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$materialClassList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">查看</button>";
			$materialClassList+=		"<button type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$materialClassList+=	"</td>";
			$materialClassList+="</tr>";
		})
		
		//渲染列表
		$("#materialClassList").empty().append($materialClassList)
		
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

