<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>美缝工具增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}/toolsmanager.do">美缝工具管理</a></li>
	  <li class="active">编辑</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <input id="productId" type="hidden" value="${product.id}">
			  <input id="imgId" type="hidden" value="${product.imgId}">
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="toolsName" class="control-label">工具名称</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="toolsName" name="toolsName"  placeholder="工具名称" value="${product.productName}">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="toolsInfo" class="control-label">工具简介</label>
			  	</div>
			    <div class="col-md-10">
			     	<textarea class="form-control" rows="12" placeholder="工具简介" id="toolsInfo" name="toolsInfo">${product.profile}</textarea>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">工具图片</label>
			  	</div>
			    <div class="col-md-10">
				    <c:if test="${product.imgId!=null && product.imgId!=-1}">
		    			<div class="img-edit-show">
		    				<span class="glyphicon glyphicon-remove delete" id="delete"></span>
							<img src="${contextPath}/file/image/get.do?imageId=${product.imgId}" class="img-thumbnail" width="500" height="300">
		    			</div>
		    			</c:if>
			    	
						<label></label>
					<c:choose>
			    		<c:when test="${product.imgId!=null && product.imgId!=-1}">
		    			<input id="imgFile" name="imgFile" type="file" style="display:none">
		    			</c:when>
			    		<c:otherwise>
			    		<input id="imgFile" name="imgFile" type="file">
			    		</c:otherwise>
			    	</c:choose>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">工具类别</label>
			  	</div>
			    <div class="col-md-5">
			      <select class="form-control" name="toolsType" id="toolsType">
			      	  <option></option>
					  <c:forEach var="categori" items="${categoriList }">
					  	 <c:choose>
					  	 	<c:when test="${categori.id==product.category}">
					  	 		<option value="${categori.id }" selected="selected">${categori.name }</option>
					  	 	</c:when>
					  	 	<c:otherwise>
					  	 		<option value="${categori.id }">${categori.name }</option>
					  	 	</c:otherwise>
					  	 </c:choose>
					  </c:forEach>
				  </select>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="newsTitle" class="control-label">所属公司</label>
			  	</div>
			    <div class="col-md-5">
			      <select class="form-control" name="providers" id="providers">
			      	  <option></option>
					   <c:forEach var="providers" items="${providersList }">
					   	 <c:choose>
					  	 	<c:when test="${providers.providersId==product.providersId}">
					  	 		<option value="${providers.providersId }" selected="selected">${providers.providerName }</option>
					  	 	</c:when>
					  	 	<c:otherwise>
					  	 		<option value="${providers.providersId }">${providers.providerName }</option>
					  	 	</c:otherwise>
					  	 </c:choose>
					  </c:forEach>
				  </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-md-offset-2 col-md-10">
					<p>
					  <button type="button" id="update" class="btn btn-primary btn-lg">更新</button>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
    <%@include file="../inc/footer.jsp" %> 
    <script type="text/javascript">
		seajs.use("sea-modules/tools/tools_edit",function(module){module.init()})
	</script>
</html>