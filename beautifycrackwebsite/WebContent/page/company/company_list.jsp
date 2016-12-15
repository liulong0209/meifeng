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
<title>美缝平台后台管理</title>
</head>
<body>
<ol class="breadcrumb">
	  <li class="active">美缝公司管理</li>
</ol>
<div class="pt10 pl10">
	<button id="addCompany" type="button" class="btn btn-primary">新增</button>
	<button id="worker" type="button" class="btn btn-info" disabled="disabled">公司工人</button>
	<button id="case" type="button" class="btn btn-info" disabled="disabled">施工案例</button>
	<button id="book" type="button" class="btn btn-info" disabled="disabled">预约小区</button>
	<button id="qualification" type="button" class="btn btn-info" disabled="disabled">公司资质</button>
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
	seajs.use("sea-modules/company/company_list",function(module){module.init();});
</script>
</html>