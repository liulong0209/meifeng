<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>施工工人-个人增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<link href="${contextPath}/style/css/fileinput.css" type="text/css" rel="stylesheet"/>	
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}//workermanager.do?type=2">施工工人-个人管理</a></li>
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="personName" class="control-label">姓名</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="personName" name="personName"  placeholder="姓名">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="introduction" class="control-label">个人简介</label>
			  	</div>
			    <div class="col-md-10">
			     	<textarea class="form-control" rows="12" placeholder="个人简介" id="introduction" name="introduction"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-2 pl0">
			    	<label for="contact" class="control-label">联系方式</label>
			  	</div>
			    <div class="col-md-5">
			     	<input type="text" class="form-control" id="contact" name="contact"  placeholder="联系方式">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label class="control-label">头像</label>
			  	</div>
			    <div class="col-md-10">
				    <label></label>
                    <input id="imgFile" name="imgFile" type="file"/>
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-2 pl0">
			    	<label for="address" class="control-label">服务区域</label>
			  	</div>
			    <div class="col-md-10">
			      <input type="text" class="form-control" id="address" name="address"  placeholder="服务区域">
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
		seajs.use("sea-modules/worker/person_add",function(module){module.init()})
	</script>
</html>