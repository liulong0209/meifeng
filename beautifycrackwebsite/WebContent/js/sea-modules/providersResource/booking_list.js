/**
 * 公司下的预约小区列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//初始化数据
	function initData(pageNo){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/booking/pageList.do',       
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
			$("#bookingList").empty().append("<tr><td colspan='3' align=center>暂无数据</td></tr>");
			return;
		}
		
		var $bookingList="";
		$.each(data.dataList,function(i,booking){
			$bookingList+="<tr>";
			$bookingList+=	"<td>"+(i+1)+"</td>";
			$bookingList+=	"<td>"+booking.communityName+"</td>";
			$bookingList+=	"<td>";
			$bookingList+=		"<button type=\"button\" id=\"booking_edit_"+booking.id+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$bookingList+=		"<button type=\"button\" id=\"booking_delete_"+booking.id+"\" class=\"btn btn-default btn-xs\" imageId="+(booking.imageId?booking.imageId:"")+">删除</button>";
			$bookingList+=	"</td>";
			$bookingList+="</tr>";
		})
		
		//渲染新闻列表
		$("#bookingList").empty().append($bookingList);
		
		//编辑按钮绑定事件
		$("button[id^='booking_edit_']").click(function(){
			window.location.href =  contextPath+'/providersResource/showBookingEdit.do?bookingId='+$(this).attr("id").replace("booking_edit_","");
		})
		
		//删除按钮绑定事件
		$("button[id^='booking_delete_']").click(function(){
			var bookingId = $(this).attr("id").replace("booking_delete_","");
			var imageId = $(this).attr("imageId");
			if(typeof(imageId) == "undefined"){imageId=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteBooking(bookingId,imageId);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteBooking(bookingId,imageId){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providersResource/deleteBooking.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:bookingId,imageId:imageId},
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
		$("#addBooking").click(function(){
			window.location.href =  contextPath+'/providersResource/showBookingAdd.do?providersId='+$("#providersId").val();
		})
	}
	
	//对外输出接口
	exports.init = init;
});