<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../common/header.jsp" %>  
	<div class="container yh">
    	<div class="block clearfix ">
    			<div class="fleft w235">
					<div class="w160 border_ccc margin-auto  pt20 pb20 pl20">
						<img src="${contextPath}/file/image/get/${company.logo}" width="120" height="120" class="radius4">
					</div>
				</div>
				<div class="fleft w955">
					<p class="h30 pb30 f24">${company.providerName}</p>
					<p class="f14 tleft text-indent28 mb30 c333">${company.profile}</p>
					<i class="fnormal address_icon fleft"></i><p class="f14 tleft pb5 pl30">${company.address}</p>
					<i class="fnormal phone_icon fleft"></i><p class="f18 tleft l_phone ">${company.phoneNo}</p>
				</div>
		</div>
		
		<div class="block clearfix">
			<div class="t1">主营产品</div>
			<div id="productInfo" class="index-image pt10">
				<ul id="productTab" class="nav nav-tabs" role="tablist">
				  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">Home</a></li>
				  <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">Profile</a></li>
				  <li role="presentation"><a href="#messages" role="tab" data-toggle="tab">Messages</a></li>
				  <li role="presentation"><a href="#settings" role="tab" data-toggle="tab">Settings</a></li>
				</ul>
				
				<!-- Tab panes -->
				<div class="tab-content">
				  <div role="tabpanel" class="tab-pane active" id="home">home</div>
				  <div role="tabpanel" class="tab-pane" id="profile">profile</div>
				  <div role="tabpanel" class="tab-pane" id="messages">messages</div>
				  <div role="tabpanel" class="tab-pane" id="settings">settings</div>
				</div>
			</div>
		</div>
		
		<div class="block clearfix">
			<div class="t1">公司证书</div>
			<div id="certificateInfo" class="index-image pt10"></div>
		</div>
		<div class="block clearfix">
			<div class="t1">防伪查询</div>
			<div id="antifakeInfo" class="index-image pt10"></div>
		</div>
    </div>
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/product/productCompany",function(module){module.init(${company.providersId});});	
	</script> 
</html>