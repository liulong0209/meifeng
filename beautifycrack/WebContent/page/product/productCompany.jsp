<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../common/header.jsp" %>  
	<div class="container yh">
    	<div class="clearfix pt20">
    			<div class="fleft w235">
					<div class="w160 border_ccc margin-auto  pt20 pb20 pl20">
						<img src="${contextPath}/file/image/get/${company.logo}" width="120" height="120" class="radius4">
					</div>
				</div>
				<div class="fleft w955 pl20">
					<p class="h30 pb30 f24">${company.providerName}</p>
					<p class="f14 text-indent28 mb30 c333">${company.profile}</p>
					<p class="f14 pb5"><span class="glyphicon glyphicon-home f18 mr10"></span>${company.address}</p>
					<p class="f18 l_phone "><span class="glyphicon glyphicon-phone-alt mr10"></span>${company.phoneNo}</p>
				</div>
		</div>
		
		<div class="clearfix pt20">
			<div class="t1">主营产品</div>
			<div id="productInfo" class="index-image pt10">
				<ul id="productTab" class="nav nav-tabs" role="tablist"></ul>
				<!-- Tab panes -->
				<div id="product_content" class="tab-content clearfix minh256 mt20 mb20"></div>
			</div>
		</div>
		
		<div class="clearfix pt20">
			<div class="t1">公司证书</div>
			<div id="certificateInfo" class="index-image pt10"></div>
		</div>
		<div class="clearfix pt20">
			<div class="t1">防伪查询</div>
			<div id="antifakeInfo" class="index-image pt10"></div>
		</div>
    </div>
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/product/productCompany",function(module){module.init("${company.providersId}");});	
	</script> 
</html>