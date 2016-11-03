<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<title>美缝平台后台管理</title>
</head>
<body>
<div>
	<button type="button" class="btn btn-primary">发布新闻</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>标题</th>
		  <th>内容</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="newsList"></tbody>
	</table>
</div>	
</body>
<script type="text/javascript">
	var contextPath = "${contextPath}";
</script>
<script src="${contextPath}/js/3th/jquery-3.1.0.min.js"></script>
<script src="${contextPath}/js/3th/bootstrap.min.js"></script>
<script src="${contextPath}/js/module/news_list.js"></script>
</html>