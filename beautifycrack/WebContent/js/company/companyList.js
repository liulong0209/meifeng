/**
 * 公司列表
 */
$(function(){
	//初始化数据
	function initData(pageNo){
		$.ajax({    
			url: contextPath+'/providers/pageList',       
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
	}
	
	//渲染数据
	function render(data,pageNo)
	{	var $newli="";
		$.each(data.dataList,function(i,company){
			$newli+="<li class=\"clearfix\">";
			$newli+=	"<div class=\"fleft\">";
			$newli+=		"<img src=\""+contextPath+"/file/image/get/"+company.logo+"\" width=\"200\" height=\"150\">";
			$newli+=	"</div>";
			$newli+=	"<div class=\"fright\">";
			$newli+=		"<p class=\"bt\"><a href=\"xwnr.html\">"+company.providerName+"</a></p>"
			$newli+=		"<p class=\"jj\">"+company.profile+"</p>"
			$newli+=		"<p class=\"ck\">"+company.address+"</p>";
			$newli+=		"<p class=\"ck\">"+company.phoneNo+"</p>";
			$newli+=	"</div>";
			$newli+="</li>";
		})
		
		//渲染新闻列表
		$("#companyList").empty().append($newli)
		
		//渲染分页
		Common.loadPager(pageNo,data.pager.totalPage,data.pager.totalRecords,initData)
	}
	
	//初始化
	function init(){
		initData(1);
	}
	
	//执行初始化方法
	init(); 
});