<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="Keywords" content="美缝剂施工,瓷砖美缝剂,瓷砖美缝"  />
<meta name="description" content="美缝剂施工,瓷砖美缝,、提供最详实可信的美缝剂、美缝行业信  息,瓷砖美缝效果图,美缝选材等服务！">
<link href="${contextPath}/style/css/kkpager_blue.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/master.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/base.css" type="text/css" rel="stylesheet" />
<title>美缝公司</title>
</head>
<body>
	<%@include file="../common/header.jsp" %>  
	<!--公司列表页主体-->
	<div class="container yh">
    	<div class="block relative">
    		<div class="navmenu">施工工人</div>
			<div class="text-list yh">
				<ul id="workerList"></ul>
    		</div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
    	</div>
    </div>	
	<%@include file="../common/footer.jsp" %>  	
		<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/worker",function(module){module.init();});
	</script> 
</html>