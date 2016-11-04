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
<title>新闻管理</title>
</head>
<body>
<div class="pt10 pl10">
	<button type="button" class="btn btn-primary">发布新闻</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>标题</th>
		  <th>状态</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="newsList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
</body>
<script type="text/javascript" src="${contextPath}/js/3th/sea/sea.js"></script>
<script type="text/javascript">
	var contextPath = "${contextPath}";
 	//seajs的配置
	seajs.config({
		  base: "${contextPath}/js/",//基本路径
		  alias: {
		    "jquery": "3th/jquery/jquery-3.1.0.min.js",
		    "custom": "3th/jquery/plug-in/jquery.custom.js", //自定义的jquery插件
		    "kkpager":"3th/kkpager.js", //分页组件
		    "bootstrap": "3th/bootstrap.js",
		    "bootstrapValidator": "3th/bootstrapValidator.js"
		  }
		})
	seajs.use("sea-modules/news/news_list",function(module){module.init();});
</script>
</html>