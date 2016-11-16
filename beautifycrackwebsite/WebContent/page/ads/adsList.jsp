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
<title>轮播广告管理</title>
</head>
<body>
<ol class="breadcrumb">
	  <li class="active">轮播广告列表</li>
</ol>
<div class="pt10 pl10">
	<button id="addAds" type="button" class="btn btn-primary">新增</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>标题</th>
		  <th>图片</th>
		  <th>排序号</th>
		  <th>状态</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="adsList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/ads/ads_list",function(module){module.init();});
</script>
</html>