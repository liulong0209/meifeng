<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contextPath}/style/css/kkpager_blue.css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" rel="stylesheet" />
<title>产品供应公司</title>
</head>
<body>
<ol class="breadcrumb">
	  <li class="active">材料/工具提供公司管理</li>
</ol>
<div class="pt10 pl10">
	<button id="addCompany" type="button" class="btn btn-primary">新增</button>
	<button id="certificate" type="button" class="btn btn-info" disabled="disabled">公司证书</button>
	<button id="anti_fake" type="button" class="btn btn-info" disabled="disabled">防伪查询</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>公司名称</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="companyList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/productCompany/productCompany_list",function(module){module.init();});
</script>
</html>