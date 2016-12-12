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
<title>美缝材料管理</title>
</head>
<body>
<ol class="breadcrumb">
	  <li class="active">美缝材料管理</li>
</ol>
<div class="pt10 pl10">
	<button id="addMaterial" type="button" class="btn btn-primary">新增</button>
</div>
<div class="table-responsive">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>材料名称</th>
		  <th>分类</th>
		  <th>所属公司</th>
		  <th>操作</th>
		</tr>
	  </thead>
	  <tbody id="materialList"></tbody>
	</table>
	<!-- 分页页码 -->
    <div id="kkpager"></div>
</div>	
</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/material/material_list",function(module){module.init();});
</script>
</html>