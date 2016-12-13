<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>美缝材料增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}/materialmanager.do">美缝材料管理</a></li>
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="materialName" class="control-label">材料名称</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="materialName" name="materialName"  placeholder="材料名称">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="materialInfo" class="control-label">材料简介</label>
			  	</div>
			    <div class="col-md-10">
			     	<textarea class="form-control" rows="12" placeholder="材料简介" id="materialInfo" name="materialInfo"></textarea>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">材料图片</label>
			  	</div>
			    <div class="col-md-10">
				    <label></label>
                    <input id="imgFile" name="imgFile" type="file"/>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">材料类别</label>
			  	</div>
			    <div class="col-md-5">
			      <select class="form-control" name="materialType" id="materialType">
			      	  <option></option>
					  <c:forEach var="categori" items="${categoriList }">
					  	 <option value="${categori.id }">${categori.name }</option>
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
					  	 <option value="${providers.providersId }">${providers.providerName }</option>
					  </c:forEach>
				  </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-md-offset-2 col-md-10">
					<p>
					  <button type="button" id="add" class="btn btn-primary btn-lg">新增</button>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
    <%@include file="../inc/footer.jsp" %> 
    <script type="text/javascript">
		seajs.use("sea-modules/material/material_add",function(module){module.init()})
	</script>
</html>