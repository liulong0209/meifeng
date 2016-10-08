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
<link href="${contextPath}/style/css/kkpager_blue.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/master.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/base.css" type="text/css" rel="stylesheet" />
<title>美缝</title>
</head>
<body>
	<%@include file="../common/header.jsp" %>  

	<div class="container yh">
		<div class="navmenu">美缝材料</div>
    	<div class="fleft leftmenu yh">
	       	<ul>
	       	<c:forEach var="material" items="${materialCategory}" varStatus="status">
	       		<c:choose>
	       			<c:when test="${status.index==0}">
	       				<li><a href="javaScript:void('0')" class="select">${material.name}</a></li>
	       			</c:when>
	       			<c:otherwise>
	       				<li><a href="javaScript:void('0')">${material.name}</a></li>
	       			</c:otherwise>
	       		</c:choose>
	       	</c:forEach>
	       	</ul>
       	</div>
       	<div class="fleft">
       		<div style="width:940px;">
       			<ul id="materialList" class="clearfix"></ul>
       		</div>
       		<!-- 分页页码 -->
    		<div id="kkpager"></div>
       	</div>
    </div>	
	<%@include file="../common/footer.jsp" %>  	
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/material/material",function(module){module.init(${firstCategory});});
	</script> 
</html>