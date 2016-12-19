/**
 * 公司资质列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/qualification/pageList.do',       
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
			$("#qualificationList").empty().append("<tr><td colspan='3' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $qualificationList="";
		$.each(data.dataList,function(i,qualification){
			$qualificationList+="<tr>";
			$qualificationList+=	"<td>"+(i+1)+"</td>";
			$qualificationList+=	"<td>"+qualification.title+"</td>";
			$qualificationList+=	"<td>";
			$qualificationList+=		"<button type=\"button\" id=\"qualification_edit_"+qualification.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$qualificationList+=		"<button type=\"button\" id=\"qualification_delete_"+qualification.id+"\" class=\"btn btn-default btn-xs\" imageId="+(qualification.imageId?qualification.imageId:"")+">删除</button>";
			$qualificationList+=	"</td>";
			$qualificationList+="</tr>";
		})
		
		//渲染新闻列表
		$("#qualificationList").empty().append($qualificationList);
		
		//编辑按钮绑定事件
		$("button[id^='qualification_edit_']").click(function(){
			window.location.href =  contextPath+'/providersResource/showQualificationEdit.do?qualificationId='+$(this).attr("id").replace("qualification_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='qualificationg_delete_']").click(function(){
			var qualificationId = $(this).attr("id").replace("qualification_delete_","");
			var imageId = $(this).attr("imageId");
			if(typeof(imageId) == "undefined"){imageId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteQualification(qualificationId,imageId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteQualification(qualificationId,imageId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/deleteQualification.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:qualificationId,imageId:imageId},
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
		$("#addQualification").click(function(){
			window.location.href =  contextPath+'/providersResource/showQualificationAdd.do?providersId='+$("#providersId").val();
		})
	}
	
	//对外输出接口
	exports.init = init;
});