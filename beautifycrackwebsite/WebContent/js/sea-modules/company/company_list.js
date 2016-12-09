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
			$companyList+=		"<button type=\"button\" id=\"company_edit_"+company.providersId+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$companyList+=		"<button type=\"button\" id=\"company_delete_"+company.providersId+"\" class=\"btn btn-default btn-xs\">删除</button>";
			$companyList+=	"</td>";
			$companyList+="</tr>";
			
		})
		
		//渲染公司列表
		$("#companyList").empty().append($companyList);
		
		//编辑按钮绑定事件
		$("button[id^='company_edit_']").click(function(){
			window.location.href =  contextPath+'/company/showEdit.do?companyId='+$(this).attr("id").replace("company_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='company_delete_']").click(function(){
			var companyId = $(this).attr("id").replace("company_delete_","");
			var imgId = $(this).attr("imgvalu");
			if(typeof(imgId) == "undefined"){imgId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteAds(companyId,imgId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteAds(companyId,imgId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"companyId":companyId,"imgId":imgId},
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
		//绑定新增公司
		$("#addCompany").click(function(){
			window.location.href =  contextPath+'/company/showAdd.do';
		})
	}
	
	//对外输出接口
	exports.init = init;
})

