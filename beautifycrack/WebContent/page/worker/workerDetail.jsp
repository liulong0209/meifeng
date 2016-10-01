<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>美缝</title>
</head>
<body>
	<!--公司列表页主体-->
	<%@include file="../common/header.jsp" %>  
	<div class="container yh">
    	<div class="block clearfix ">
    			<div class="fleft w235">
					<div class="w160 border_ccc margin-auto  pt20 pb20 pl20">
						<img src="${contextPath}/file/image/get/${worker.logo}" width="120" height="120" class="radius4">
					</div>
				</div>
				<div class="fleft w955">
					<p class="h30 pb30 f24">${worker.providerName}</p>
					<p class="f14 tleft text-indent28 mb30 c333">${worker.profile}</p>
					<i class="fnormal address_icon fleft"></i><p class="f14 tleft pb5 pl30">${worker.address}</p>
					<i class="fnormal phone_icon fleft"></i><p class="f18 tleft l_phone ">${worker.phoneNo}</p>
				</div>
		</div>
		<c:if test="${worker.type==1 }">
		<div class="block clearfix">
			<div class="t1">施工人员</div>
			<div id="workerInfo" class="index-image pt10"></div>
		</div>
		</c:if>
		<div class="block clearfix">
			<div class="t1">施工案例</div>
			<div id="caseInfo" class="index-image pt10"></div>
		</div>		
		<div id="evaluationCell" class="block clearfix">
			<div class="t1">客户评价</div>
			<div id="evaluationInfo" class="pb30"></div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
			<textarea class="form-control" rows="3" placeholder="我来说两句...."></textarea>
			<div class="tright pt10">
				<button type="button" class="btn btn-success" id="commit">发表评论</button>
			</div>
		</div>		
    </div>
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/worker/workerDetail",function(module){module.init("${worker.providersId}","${worker.type}");});  	
	</script> 
</html>