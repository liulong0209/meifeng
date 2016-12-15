<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工人信息编辑</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	 <c:if test="${providers.type==0 }">
	  <li><a href="${contextPath}/companymanager.do">美缝公司管理</a></li>
	  </c:if>
	  <c:if test="${providers.type==1 }">
	  <li><a href="${contextPath}/workermanager.do?type=1">施工工人管理-团队</a></li>
	  </c:if>
	  <li><a href="${contextPath}/providersResource/workerList.do?providersId=${providers.providersId}">${providers.providerName }的工人</a></li>
	  <li class="active">编辑</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			 <input type="hidden" id="providersId" value="${providers.providersId }">
			 <input type="hidden" id="workerId" value="${worker.id }">
			 <input type="hidden" id="avatar" value="${worker.avatar }">
			  <div class="form-group pt10">
			  	<div class="col-xs-1 pl0">
			    	<label for="workerName" class="control-label">姓名</label>
			  	</div>
			    <div class="col-xs-11">
			      <input type="text" class="form-control" id="workerName" name="name"  placeholder="标题" value="${worker.name}">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label class="control-label">头像</label>
			  	</div>
			    <div class="col-md-11">
				    <c:if test="${worker.avatar!=null && worker.avatar!=-1}">
		    			<div class="img-edit-show">
		    				<span class="glyphicon glyphicon-remove delete" id="delete"></span>
							<img src="${contextPath}/file/image/get.do?imageId=${worker.avatar}" class="img-thumbnail" width="500" height="300">
		    			</div>
		    			</c:if>
			    	
						<label></label>
					<c:choose>
			    		<c:when test="${worker.avatar!=null && worker.avatar!=-1}">
		    			<input id="imgFile" name="imgFile" type="file" style="display:none">
		    			</c:when>
			    		<c:otherwise>
			    		<input id="imgFile" name="imgFile" type="file">
			    		</c:otherwise>
			    	</c:choose>
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
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/providersResource/worker_edit",function(module){module.init()})
</script>
</html>