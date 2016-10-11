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
		require.async('bootstrap',function(){
			$('#productTab a').click(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
			})
		});
		
		companyId = id;
		initCertificateData();
		initantifakeData();
	}
	
	//对外输出接口
	exports.init = init;
})

