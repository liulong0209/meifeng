/**
 * 工具/材料供应公司列表
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/productCompany/pageList.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"pageNo":pageNo},
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
			$("#companyList").empty().append("<tr><td colspan='3' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $companyList="";
		$.each(data.dataList,function(i,company){
			$companyList+="<tr>";
			$companyList+=	"<td><input type=\"radio\" name=\"company\" id=\"company_"+company.providersId+"\" value=\""+company.providersId+"\"></td>";
			$companyList+=	"<td>"+company.providerName+"</td>";
			$companyList+=	"<td>";
			$companyList+=		"<button type=\"button\" id=\"company_edit_"+company.providersId+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$companyList+=		"<button type=\"button\" id=\"company_delete_"+company.providersId+"\" class=\"btn btn-default btn-xs\" logovalu="+(company.logo?company.logo:"")+">删除</button>";
			$companyList+=	"</td>";
			$companyList+="</tr>";
			
		})
		
		//渲染公司列表
		$("#companyList").empty().append($companyList);
		
		//radion事件绑定
		$("input[type='radio']").click(function(){
			$(".btn-info").removeAttr("disabled");
		})
		
		//编辑按钮绑定事件
		$("button[id^='company_edit_']").click(function(){
			window.location.href =  contextPath+'/productCompany/showEdit.do?companyId='+$(this).attr("id").replace("company_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='company_delete_']").click(function(){
			var companyId = $(this).attr("id").replace("company_delete_","");
			var logovalu = $(this).attr("logovalu");
			if(typeof(imgId) == "undefined"){imgId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deletecompany(companyId,logovalu);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deletecompany(companyId,logovalu){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/productCompany/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"providersId":companyId,"logo":logovalu},
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
			window.location.href =  contextPath+'/productCompany/showAdd.do';
		});
		
		//公司证书
		$("#certificate").click(function(){
			window.location.href =  contextPath+'';
		})
		//防伪
		$("#case").click(function(){
			window.location.href =  contextPath+'';
		})
	}
	
	//对外输出接口
	exports.init = init;
})

