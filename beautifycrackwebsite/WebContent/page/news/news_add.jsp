<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻增加</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/inner-base.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="${contextPath}/newsmanager.do">新闻动态列表</a></li>
	  <li class="active">新增</li>
	</ol>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
			  <input type="hidden" id="newsContent">
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label for="newsTitle" class="control-label">标题</label>
			  	</div>
			    <div class="col-md-11">
			      <input type="text" class="form-control" id="newsTitle" name="title"  placeholder="新闻标题">
			    </div>
			  </div>
			  <div class="form-group pt10">
			  	<div class="col-md-1 pl0">
			    	<label for="newsSubTitle" class="control-label">副标题</label>
			  	</div>
			    <div class="col-md-11">
			      <input type="text" class="form-control" id="newsSubTitle" name="subtitle"  placeholder="新闻副标题">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-md-1 pl0">
			    	<label class="control-label">内容</label>
			  	</div>
			    <div class="col-md-11">
			      <!-- 加载编辑器的容器 -->
			    <script id="container" type="text/plain">这里编辑新闻</script>
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
    <!-- 配置文件 -->
    <script type="text/javascript" src="${contextPath}/js/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${contextPath}/js/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
    <script type="text/javascript">
       var ue = UE.getEditor('container',{
    	   autoHeightEnabled: false,
           initialFrameHeight:550,
           serverUrl : "${contextPath}/ueditor.do"
       });
       //失去焦点是将内容赋给隐藏域
       ue.on('blur',function(){
    	   $("#newsContent").val(ue.getContent());
       });
    </script>
    <%@include file="../inc/footer.jsp" %> 
    <script type="text/javascript">
		seajs.use("sea-modules/news/news_add",function(module){module.init()})
	</script>
</html>