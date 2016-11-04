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
<title>施工工人列表</title>
</head>
<body>
<div class="pt10 pl10">
	<button type="button" class="btn btn-primary">新增</button>
</div>
<div class="pt10 pl10">
	<ul id="workerTab" class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active"><a href="javaScript:void('0')" role="tab" data-toggle="tab" val="1">团队</a></li>
  		<li role="presentation"><a href="javaScript:void('0')" role="tab" data-toggle="tab" val="2">个人</a></li>
	</ul>
</div>
<div class="tab-content">
  <div role="tabpanel" class="tab-pane active">
  	<div class="table-responsive">
		<table class="table table-hover">
		  <thead>
			<tr>
			  <th>#</th>
			  <th>名称</th>
			  <th>操作</th>
			</tr>
		  </thead>
		  <tbody id="workerList"></tbody>
		</table>
	</div>	
  </div>
</div>
<!-- 分页页码 -->
<div id="kkpager"></div>


</body>
<%@include file="../inc/footer.jsp" %> 
<script type="text/javascript">
	seajs.use("sea-modules/worker/worker_list",function(module){module.init();});
</script>
</html>