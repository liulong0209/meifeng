<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contextPath}/style/css/kkpager_blue.css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<title>预约小区列表</title>
</head>
<body>
<ol class="breadcrumb">
	  <li><a href="${contextPath}/companymanager.do">美缝公司管理</a></li>
	  <li class="active">${providers.providerName }</li>
</ol>
<div class="pt10 pl10">
	<button id="addBooking" type="button" class="btn btn-primary">新增</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>预约小区名称</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="bookingList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
<input type="hidden" id="providersId" value="${providers.providersId }">
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/providersResource/booking_list",function(module){module.init();});
</script>
</html>