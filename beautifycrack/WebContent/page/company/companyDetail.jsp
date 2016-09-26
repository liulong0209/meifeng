<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="Keywords" content="美缝剂施工,瓷砖美缝剂,瓷砖美缝"  />
<meta name="description" content="美缝剂施工,瓷砖美缝,、提供最详实可信的美缝剂、美缝行业信  息,瓷砖美缝效果图,美缝选材等服务！">
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/kkpager_blue.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/master.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/base.css" type="text/css" rel="stylesheet" />
<title>美缝公司</title>
</head>
<body>
	<%@include file="../common/header.jsp" %>  
	<!--公司列表页主体-->
	<div class="container yh">
    	<div class="block">
			<div class="fleft w310 box-shadow">
				<div class=" w160 pt20 pb20px margin-auto">
					<img src="${contextPath}/file/image/get/${company.logo}" width="160" height="110">
				</div>
				<div class="pt10">
					<p class="bold h30 pb30 f16 tcenter">${company.providerName}</p>
					<p class="f14 tleft pb5 pl10"><i class="fnormal c333">公司地址：</i>${company.address}</p>
					<p class="f14 tleft pb30 pl10"><i class="fnormal c333">联系方式：${company.phoneNo}</i></p>
				</div>
			</div>
			<div  class="fleft pl30">
				<div class="t1">公司简介</div>
				<div class="pt10 pb30">
					<p class="f14 tleft w800 text-indent28"><i class="fnormal c333"></i>${company.profile}</p>
				</div>
				
				<div class="t1">施工工人信息</div>
				<div id="workerInfo" class="pb30"></div>
				
				<div class="t1">施工案例</div>
				<div id="caseInfo" class="pb30"></div>
				
				<div class="t1">预约小区</div>
				<div id="bookingInfo" class="pb30"></div>
				
				<div class="t1">公司资质</div>
				<div id="qualificationInfo" class="pb30"></div>
				
				<div class="t1">客户评价</div>
				<div id="rateInfo" class="pb30"></div>
				
				<textarea class="form-control" rows="3" placeholder="请输入评价内容"></textarea>
				
			</div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
    	</div>
    </div>	
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/company/companyDetail",function(module){module.init(${company.providersId});});  	
	</script> 
</html>