<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="Keywords" content="美缝剂施工,瓷砖美缝剂,瓷砖美缝"  />
<meta name="description" content="美缝剂施工,瓷砖美缝,、提供最详实可信的美缝剂、美缝行业信  息,瓷砖美缝效果图,美缝选材等服务！">
<title>新闻动态</title>
<link href="${contextPath}/style/css/kkpager_blue.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/master.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/base.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="../common/header.jsp" %>  
	<!--文字列表页主体-->
	<div class="container yh">
    	<div class="block">
    		<div class="navmenu">新闻动态</div>
			<ul id="newsList"></ul>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
    	</div>
    </div>	
	<%@include file="../common/footer.jsp" %>  	
</body>
<script type="text/javascript" src="${contextPath}/js/3th/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.date.js"></script>
<script type="text/javascript" src="${contextPath}/js/3th/kkpager.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/news/newsList.js"></script>
<script type="text/javascript" src="${contextPath}/js/common.js"></script>
<script type="text/javascript">
	var contextPath = "${contextPath}";
</script>
</html>