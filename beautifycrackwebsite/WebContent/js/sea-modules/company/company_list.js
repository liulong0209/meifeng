/**
 * 公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"type":0},
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
			$("#companyList").empty().append("<tr><td>暂无数据</td></tr>");
			return;
		}
		
		var $companyList="";
		$.each(data.dataList,function(i,company){
			$companyList+="<tr>";
			$companyList+=	"<td>"+(i+1)+"</td>";
			$companyList+=	"<td>"+company.providerName+"</td>";
			$companyList+=	"<td>";
			$companyList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$companyList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">查看</button>";
			$companyList+=		"<button type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$companyList+=	"</td>";
			$companyList+="</tr>";
			
		})
		
		//渲染公司列表
		$("#companyList").empty().append($companyList)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//初始化
	function init(){
		initData(1);
	}
	
	//对外输出接口
	exports.init = init;
})

