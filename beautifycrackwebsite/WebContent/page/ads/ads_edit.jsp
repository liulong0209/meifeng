<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>轮播广告编辑</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}/adsmanager.do">轮播广告列表</a></li>
	  <li class="active">编辑</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form" enctype="multipart/form-data" action="${contextPath}/ads/update.do" method="post" >
			  <input type="hidden" id="state" name="state" value="${ads.state}">
			  <input type="hidden" id="adsId" name="id" value="${ads.id}">
			  <div class="form-group pt10">
			  	<div class="col-xs-1 pl0">
			    	<label for="newsTitle" class="control-label">标题</label>
			  	</div>
			    <div class="col-xs-11">
			      <input type="text" class="form-control" id="adsTitle" name="title"  placeholder="标题" value="${ads.title }">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label class="control-label">上传图片</label>
			  	</div>
			    <div class="col-md-11">
			    	<c:choose>
			    		<c:when test="${ads.imgId!=null && ads.imgId!=-1}">
		    			<div class="img-edit-show">
		    				<span class="glyphicon glyphicon-remove delete" id="delete"></span>
							<img src="${contextPath}/file/image/get.do?imageId=${ads.imgId}" class="img-thumbnail" width="500" height="300">
		    			</div>
		    			</c:when>
			    	</c:choose>
			    	
						<label></label>
					<c:choose>
			    		<c:when test="${ads.imgId!=null && ads.imgId!=-1}">
		    			<input id="imgFile" name="imgFile" type="file" multiple=false style="display:none">
		    			</c:when>
			    		<c:otherwise>
			    		<input id="imgFile" name="imgFile" type="file" multiple=false>
			    		</c:otherwise>
			    	</c:choose>
                   		
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label for="newsTitle" class="control-label">排序号</label>
			  	</div>
			    <div class="col-xs-2">
			      <input type="number" class="form-control" id="adsOrderNo" name="orderNo"  value="${ads.orderNo }">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-md-offset-1 col-md-11">
					<p>
					  <c:choose>
			    		<c:when test="${ads.state==0}">
							<input type="button" id="draft" class="btn btn-default btn-lg" value="暂时保存"/>
					  		<input type="button" id="publish" class="btn btn-primary btn-lg" value="直接发布"></input>
			    		</c:when>
			    		<c:otherwise>
							  <input type="button" id="update" class="btn btn-primary btn-lg" value="更新">
			    		</c:otherwise>
			    	  </c:choose>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/ads/ads_edit",function(module){module.init("${ads.id}","${ads.imgId}")})
</script>
</html>