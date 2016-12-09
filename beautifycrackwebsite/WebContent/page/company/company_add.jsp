<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="newsTitle" class="control-label">公司名称</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="companyName" name="companyName"  placeholder="公司名称">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">公司简介</label>
			  	</div>
			    <div class="col-md-10">
			     	<textarea class="form-control" rows="12" placeholder="公司简介" id="introduction" name="introduction"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">联系方式</label>
			  	</div>
			    <div class="col-md-5">
			     	<input type="text" class="form-control" id="contact" name="contact"  placeholder="联系方式">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">公司LOGO</label>
			  	</div>
			    <div class="col-md-10">
				    <label></label>
                    <input id="imgFile" name="imgFile" type="file"/>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="newsTitle" class="control-label">公司地址</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="address" name="address"  placeholder="公司地址">
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
		seajs.use("sea-modules/company/company_add",function(module){module.init()})
	</script>
</html>