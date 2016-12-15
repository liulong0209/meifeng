<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工人信息增加</title>
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
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			 <input type="hidden" id="providersId" value="${providers.providersId }">
			  <div class="form-group pt10">
			  	<div class="col-xs-1 pl0">
			    	<label for="workerName" class="control-label">姓名</label>
			  	</div>
			    <div class="col-xs-11">
			      <input type="text" class="form-control" id="workerName" name="name"  placeholder="标题">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label class="control-label">头像</label>
			  	</div>
			    <div class="col-md-11">
				    <label></label>
                    <input id="imgFile" name="imgFile" type="file">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-md-offset-1 col-md-11">
					<p>
					  <button type="button" id="add" class="btn btn-primary btn-lg">增加</button>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/providersResource/worker_add",function(module){module.init()})
</script>
</html>