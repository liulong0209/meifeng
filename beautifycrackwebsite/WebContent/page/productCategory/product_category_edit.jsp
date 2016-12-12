<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>轮播广告增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <c:choose>
	  	<c:when test="${productCategory.type==0}">
	  		<li><a href="${contextPath}/toolsCategory.do?productType=0">工具分类管理</a></li>
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="${contextPath}/materialCategory.do?productType=1">材料分类管理</a></li>
	  	</c:otherwise>
	  </c:choose>
	  <li class="active">更新</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <input type="hidden" id="state" name="state">
			  <div class="form-group pt10">
			  	<div class="col-xs-1 pl0">
			    	<label for="categoryName" class="control-label">分类名称</label>
			  	</div>
			    <div class="col-xs-11">
			      <input type="text" class="form-control" id="categoryName" name="categoryName"  placeholder="分类名称" value="${productCategory.name}">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-md-offset-1 col-md-11">
					<p>
					  <button type="button" id="update" class="btn btn-primary btn-lg">更新</button>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
<input type="hidden" id=productType value="${productCategory.type}">
<input type="hidden" id="productCategoryId" value="${productCategory.id}">
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/productCategory/product_category_edit",function(module){module.init()})
</script>
</html>