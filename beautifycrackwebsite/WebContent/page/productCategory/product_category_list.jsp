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
<title>美缝工具/材料分类管理</title>
</head>
<body>
<ol class="breadcrumb">
	  <c:choose>
	  	<c:when test="${productType==0}">
	  		<li class="active">工具分类管理</li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="active">材料分类管理</li>
	  	</c:otherwise>
	  </c:choose>
</ol>
<div class="pt10 pl10">
	<button id="product_category_add" type="button" class="btn btn-primary">新增</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>分类名称</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="productCategoryList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
<input type="hidden" id="productType" value="${productType}">
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/productCategory/product_category_list",function(module){module.init();});
</script>
</html>