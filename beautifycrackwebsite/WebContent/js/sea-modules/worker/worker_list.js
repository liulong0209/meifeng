/**
 * 施工工人列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	var type="1";
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo,"type":type},
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
			$("#workerList").empty().append("<tr><td>暂无数据</td></tr>");
			return;
		}
		var $workerList="";
		$.each(data.dataList,function(i,worker){
			$workerList+="<tr>";
			$workerList+=	"<td>"+(i+1)+"</td>";
			$workerList+=	"<td>"+worker.providerName+"</td>";
			$workerList+=	"<td>";
			$workerList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$workerList+=		"<button type=\"button\" class=\"btn btn-primary btn-xs mr10\">查看</button>";
			$workerList+=		"<button type=\"button\" class=\"btn btn-default btn-xs\">删除</button>";
			$workerList+=	"</td>";
			$workerList+="</tr>";
		})
		
		//渲染新闻列表
		$("#workerList").empty().append($workerList)
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	//tab页绑定点击事件
	function tblEventBind(){
		require.async('bootstrap',function(){
			$('#workerTab a').click(function (e) {
				  e.preventDefault();
				  $("#workerTab a").removeClass("active");
				  type = $(this).attr("val");
				  initData(1);
				  $(this).tab('show');
			})
		});
	}
	
	//初始化
	function init(){
		tblEventBind();
		initData(1);
	}
	
	//对外输出接口
	exports.init = init;
})

