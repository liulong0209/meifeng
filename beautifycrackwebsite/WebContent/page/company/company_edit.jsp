<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>美缝公司增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}/companymanager.do">美缝公司列表</a></li>
	  <li class="active">编辑</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			<input type="hidden" id="providersId" value="${company.providersId}">
			<input type="hidden" id="logoId" value="${company.logo}">
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="companyName" class="control-label">公司名称</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="companyName" name="companyName"  placeholder="公司名称" value="${company.providerName}">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="introduction" class="control-label">公司简介</label>
			  	</div>
			    <div class="col-md-10">
			     	<textarea class="form-control" rows="12" placeholder="公司简介" id="introduction" name="introduction">${company.profile}</textarea>
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="contact" class="control-label">联系方式</label>
			  	</div>
			    <div class="col-md-5">
			     	<input type="text" class="form-control" id="contact" name="contact"  placeholder="联系方式" value="${company.phoneNo}">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">公司LOGO</label>
			  	</div>
			    <div class="col-md-10">
			    		<c:if test="${company.logo!=null && company.logo!=-1}">
		    			<div class="img-edit-show">
		    				<span class="glyphicon glyphicon-remove delete" id="delete"></span>
							<img src="${contextPath}/file/image/get.do?imageId=${company.logo}" class="img-thumbnail" width="500" height="300">
		    			</div>
		    			</c:if>
			    	
						<label></label>
					<c:choose>
			    		<c:when test="${company.logo!=null && company.logo!=-1}">
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
			    	<label for="address" class="control-label">公司地址</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="address" name="address"  placeholder="公司地址" value="${company.address }">
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
		seajs.use("sea-modules/company/company_edit",function(module){module.init()})
	</script>
</html>