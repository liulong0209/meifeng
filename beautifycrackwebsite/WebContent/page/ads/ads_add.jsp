<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>轮播广告增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="#">轮播广告列表</a></li>
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form" enctype="multipart/form-data">
			  <input type="hidden" id="newsContent">
			  <div class="form-group pt10">
			  	<div class="col-xs-1 pl0">
			    	<label for="newsTitle" class="control-label">标题</label>
			  	</div>
			    <div class="col-xs-11">
			      <input type="text" class="form-control" id="newsTitle" name="title"  placeholder="标题">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label class="control-label">上传图片</label>
			  	</div>
			    <div class="col-md-11">
				    <label></label>
                    <input id="imgFile" type="file" multiple=true>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label for="newsTitle" class="control-label">排序号</label>
			  	</div>
			    <div class="col-xs-2">
			      <input type="number" class="form-control" id="newsTitle" name="title">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-md-offset-1 col-md-11">
					<p>
					  <button type="button" id="draft" class="btn btn-default btn-lg">暂时保存</button>
					  <button type="button" id="publish" class="btn btn-primary btn-lg">直接发布</button>
					</p>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/ads/ads_add",function(module){module.init()})
</script>
</html>