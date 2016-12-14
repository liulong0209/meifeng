/**
 * 材料所属公司详情
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	var companyId;
	
	//初始化公司经营产品条目
	function initProductCategoryData(){
		execute(contextPath+'/company/productCategory/'+companyId,rendProductCategoryData);
	}
	//渲染公司证书数据
	function rendProductCategoryData(data){
		if(data.length==0)
		{
			$("#productInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任何产品信息</li>");
			return;
		}
		var $category="";
		$.each(data,function(i,category){
			$category+=	"<li role=\"presentation\"";
			if(i==0){
				$category+=	"class=\"active\"";
			}
			$category+=	"><a href=\"#product_"+category.id+"\" role=\"tab\" data-toggle=\"tab\" categoryId="+category.id+" class=\"f14 bold\">"+category.name+"</a></li>";
		})
		//渲染标签页
		$("#productTab").empty().append($category);
		//tab页绑定点击事件
		require.async('bootstrap',function(){
			$('#productTab a').click(function (e) {
				  e.preventDefault();
				  $("div[id^=product_]").removeClass("active");
				  queryProduct($(this).attr("categoryId"));
				  $(this).tab('show');
			})
			//查询第一个tab页内容
			queryProduct($("#productTab a").first().attr("categoryId"));
		});
	}
	
	//根据分类查找产品
	function queryProduct(categoryId){
		execute(contextPath+'/product/queryProduct',rendProductData,{"categoryId":categoryId,"companyId":companyId});
	}
	
	function rendProductData(data){
		if(data.length==0)
		{
			$("#product_content").empty().append("<div role=\"tabpanel\" class=\"tab-pane active tcenter pt30\" id=\"product_00\">该分类暂时没有产品</div>");
			return;
		}
		var $productobj="<div role=\"tabpanel\" class=\"tab-pane active clearfix\" id=\"product_"+data[0].category+"\">";
		$.each(data,function(i,product){
			$productobj+="<div class=\"wper25 clearfix inline-block mb20\">";
			$productobj+=	"<div class=\"fleft border_f3 pointer\">";
			$productobj+=		"<img src="+contextPath+"/file/image/get/"+product.imgId+" width=\"275\" height=\"220\">";
			$productobj+=		"<div class=\"tcenter pt10 pb10 f14 c666 bold\">"+product.productName+"</div>";
			$productobj+=	"</div>";
			$productobj+="</div>";
		});
		$productobj+="</div>";
		//先清空再追加，保证数据最新
		$("#product_content").find("#product_"+data[0].category).remove();
		$("#product_content").append($productobj)
	}
	
	//初始公司证书数据
	function initCertificateData(){
		execute(contextPath+'/company/certificate/'+companyId,rendCertificateData);
	}

	//渲染公司证书数据
	function rendCertificateData(data){
		if(data.length==0)
		{
			$("#certificateInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任何证书信息</li>");
			return;
		}
		var $certificate="";
		$.each(data,function(i,certificate){
			$certificate+=	"<div class=\"fleft pr75\">";
			$certificate+=		"<img src=\""+contextPath+"/file/image/get/"+certificate.imageId+"\" width=\"187\" height=\"189\">";
			$certificate+=		"<div class=\"tcenter pt5 f14\">"+certificate.title+"</div>"
			$certificate+=	"</div>";
		})
		$certificate+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#certificateInfo").empty().append($certificate)
	}
	
	//初始防伪查询数据
	function initantifakeData(){
		execute(contextPath+'/company/antifake/'+companyId,renderantifakeData);
	}

	//渲染防伪查询数据
	function renderantifakeData(data){
		if(data.length==0)
		{
			$("#antifakeInfo").empty().append("<li class=\"tcenter\">该公司还没有上传任防伪信息</li>");
			return;
		}
		var $antifake="";
		$.each(data,function(i,antifake){
			$antifake+=	"<div class=\"fleft pr75\">";
			$antifake+=		"<img src=\""+contextPath+"/file/image/get/"+antifake.avatar+"\" width=\"187\" height=\"189\">";
			$antifake+=		"<div class=\"tcenter pt5 f14\">"+antifake.name+"</div>"
			$antifake+=	"</div>";
		})
		$antifake+="<div class=\"clearfix\"></div>";
		//渲染新闻列表
		$("#antifakeInfo").empty().append($antifake)
	}
	
	//初始化评价信息
	function initEvaluationData(pageNo)
	{
		execute(contextPath+'/evaluation/pageList',renderEvaluationData,{"pageNo":pageNo,"gainer":companyId});
	}
	//渲染评价信息
	function renderEvaluationData(data)
	{
		if(data.dataList.length==0)
		{
			$("#evaluationInfo").empty().append("<li class=\"clearfix tcenter\">暂时没有人评价</li>");
			return;
		}
		require.async('custom',function(){
			var $evaluation="";
			$.each(data.dataList,function(i,evaluation){
				$evaluation +="<div class=\"pt20 pb20 clearfix border_bottom_f3\">";
				$evaluation +=	"<div class=\"ofHidden\">";
				$evaluation +=		"<div class=\"fleft\">";
				$evaluation +=			"<img src=\""+contextPath+"/file/image/get/"+evaluation.reviewer+"\" width=\"50\" height=\"50\" class=\"radius30\"/>"
				$evaluation +=		"</div>";
				$evaluation +=		"<div class=\"fleft pl30\">";
				$evaluation +=			"<div class=\"f14 c666\"><span class=\"pr30 bold\">"+evaluation.reviewerName+"</span></span>"+$.formatDate("yyyy-MM-dd hh:mm:ss",new Date(evaluation.reviewTime))+"</span></div>";
				$evaluation +=			"<div class=\"pt10 f14 c666\">"+evaluation.content+"</div>";
				$evaluation +=		"</div>";
				$evaluation +=	"</div>";
				$evaluation +="</div>";
			})
			$("#evaluationInfo").empty().append($evaluation);
		})
		
		//渲染分页
		var pager = require("sea-modules/common");
		pager.loadPager(data.pager.pageNo,data.pager.totalPage,data.pager.totalRecords,initEvaluationData,"evaluationCell");
	}
	
	

	//ajax获取数据共方法
	function execute(url,callback,postData){
		$.ajax({    
			url: url,       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:postData,
			beforeSend: function () {
				//$.showLoadding();
			},
			success: function (data) {
				if(data && $.isFunction(callback))
				{
					callback(data);
				}	
			},
			complete: function () {
				//$.hideLoadding();
			},
			error: function (data) {
				//$.hideLoadding();
				console.info("error: " + data.responseText);
			}
			
		});
	}
	
	//发表评论
	function commitComment(){
		//判断是否登录
		if(!userInfo){
			require.async('bootstrap',function(){
				$('#tipsModule').find(".modal-body").empty().append("登录后才可以进行评价，请先登录!");
				$('#tipsModule').modal("show");
			})
			return;
		}
		
		var level = $('input[name="optionsRadios"]:checked').val();
		if(!level){
			require.async('bootstrap',function(){
				$('#tipsModule').find(".modal-body").empty().append("请选择评价类型");
				$('#tipsModule').modal("show");
			})
			return;
		}
		//判断内容是否为空
		var content = $("textarea").val();
		if(content==""){
			require.async('bootstrap',function(){
				$('#tipsModule').find(".modal-body").empty().append("请输入评价内容");
				$('#tipsModule').modal("show");
			})
			return;
		}
		//异步提交
		execute(contextPath+'/evaluation/evaluate',
			function(data){
				if(data.result=='0')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("登录后才可以进行评价，请先登录!");
						$('#tipsModule').modal("show");
					})
				}
				else if(data.result=='1')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("评价成功！");
						$('#tipsModule').modal("show");
						//清空表单
						$('input[name="optionsRadios"]:checked').attr('checked',false);
						$("textarea").val("");
						//重新加载评价内容
						initEvaluationData(1);
					})
				}
				else if(data.result=='2')
				{
					require.async('bootstrap',function(){
						$('#tipsModule').find(".modal-body").empty().append("评价成功！");
						$('#tipsModule').modal("show");
					})
				}
			}
		,{"gainer":companyId,"content":content,"level":level});
	}
	
	//按钮绑定事件
	function buttonBindEvent(){
		//登录按钮绑定
		$("#cLogin").click(function(){
			var login = require('sea-modules/login');
			login.showLoginModel();
		});
		//发表评论按钮事件
		$("#commit").click(function(){
			commitComment();
		})
	}
	
	
	//初始化
	function init(id){
		companyId = id;
		initProductCategoryData();
		initCertificateData();
		initantifakeData();
		initEvaluationData(1);
		buttonBindEvent();
	}
	
	//对外输出接口
	exports.init = init;
})

