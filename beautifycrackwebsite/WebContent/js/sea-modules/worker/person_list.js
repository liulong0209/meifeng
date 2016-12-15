/**
 * 个人列表
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
				data:{"pageNo":pageNo,"type":2},
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
			$("#personList").empty().append("<tr><td>暂无数据</td></tr>");
			return;
		}
		
		var $personList="";
		$.each(data.dataList,function(i,person){
			$personList+="<tr>";
			$personList+=	"<td><input type=\"radio\" name=\"person\" id=\"person_"+person.providersId+"\" value=\""+person.providersId+"\"></td>";
			$personList+=	"<td>"+person.providerName+"</td>";
			$personList+=	"<td>";
			$personList+=		"<button type=\"button\" id=\"person_edit_"+person.providersId+"\" class=\"btn btn-primary btn-xs mr10\">编辑</button>";
			$personList+=		"<button type=\"button\" id=\"person_delete_"+person.providersId+"\" class=\"btn btn-default btn-xs\" logovalu="+(person.logo?person.logo:"")+">删除</button>";
			$personList+=	"</td>";
			$personList+="</tr>";
			
		})
		
		//渲染公司列表
		$("#personList").empty().append($personList);
		
		//radion事件绑定
		$("input[type='radio']").click(function(){
			$(".btn-info").removeAttr("disabled");
		})
		
		//编辑按钮绑定事件
		$("button[id^='person_edit_']").click(function(){
			window.location.href =  contextPath+'/worker/showEdit.do?workerId='+$(this).attr("id").replace("person_edit_","")+"&type=2";
		})
		
		//删除按钮绑定事件
		$("button[id^='person_delete_']").click(function(){
			var personId = $(this).attr("id").replace("person_delete_","");
			var logovalu = $(this).attr("logovalu");
			if(typeof(logovalu) == "undefined"){logovalu=null};
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					deleteperson(personId,logovalu);
			    }, function() {
			         return;      
			    });
			})
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData);
	}
	
	function deleteperson(personId,logovalu){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/providers/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"providersId":personId,"logo":logovalu},
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
		$("#addperson").click(function(){
			window.location.href =  contextPath+'/worker/showAdd.do?type=2';
		});
		//施工案例
		$("#case").click(function(){
			window.location.href =  contextPath+'';
		})
	}
	
	//对外输出接口
	exports.init = init;
})

