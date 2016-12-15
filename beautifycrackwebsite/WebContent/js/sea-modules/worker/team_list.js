/**
 * 团队列表
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
				data:{"pageNo":pageNo,"type":1},
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
			$("#teamList").empty().append("<tr><td>暂无数据</td></tr>");
			return;
		}
		
		var $teamList="";
		$.each(data.dataList,function(i,team){
			$teamList+="<tr>";
			$teamList+=	"<td><input type=\"radio\" name=\"team\" id=\"team_"+team.providersId+"\" value=\""+team.providersId+"\"></td>";
			$teamList+=	"<td>"+team.providerName+"</td>";
			$teamList+=	"<td>";
			$teamList+=		"<button type=\"button\" id=\"team_edit_"+team.providersId+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$teamList+=		"<button type=\"button\" id=\"team_delete_"+team.providersId+"\" class=\"btn btn-default btn-xs\" logovalu="+(team.logo?team.logo:"")+">删除</button>";
			$teamList+=	"</td>";
			$teamList+="</tr>";
			
		})
		
		//渲染公司列表
		$("#teamList").empty().append($teamList);
		
		//radion事件绑定
		$("input[type='radio']").click(function(){
			$(".btn-info").removeAttr("disabled");
		})
		
		//编辑按钮绑定事件
		$("button[id^='team_edit_']").click(function(){
			window.location.href =  contextPath+'/worker/showEdit.do?workerId='+$(this).attr("id").replace("team_edit_","")+"&type=1";
		})
		
		//删除按钮绑定事件
		$("button[id^='team_delete_']").click(function(){
			var teamId = $(this).attr("id").replace("team_delete_","");
			var logovalu = $(this).attr("logovalu");
			if(typeof(logovalu) == "undefined"){logovalu=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteteam(teamId,logovalu);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteteam(teamId,logovalu){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"providersId":teamId,"logo":logovalu},
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
		$("#addTeam").click(function(){
			window.location.href =  contextPath+'/worker/showAdd.do?type=1';
		})
		
		//施工人员
		$("#worker").click(function(){
			window.location.href =  contextPath+'/providersResource/workerList.do?providersId='+$('input:radio:checked').val();
		})
		//施工案例
		$("#case").click(function(){
			window.location.href =  contextPath+'';
		})
	}
	
	//对外输出接口
	exports.init = init;
})

