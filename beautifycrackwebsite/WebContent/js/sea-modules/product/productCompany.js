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
			$productobj+=		"<img src=\"/mf/file/image/get/"+product.imgId+"\" width=\"275\" height=\"220\">";
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
	
	//初始化
	function init(id){
		companyId = id;
		initProductCategoryData();
		initCertificateData();
		initantifakeData();
	}
	
	//对外输出接口
	exports.init = init;
})

