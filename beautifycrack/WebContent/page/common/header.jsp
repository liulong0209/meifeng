<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="Keywords" content="美缝剂施工,瓷砖美缝剂,瓷砖美缝"  />
<meta name="description" content="美缝剂施工,瓷砖美缝,、提供最详实可信的美缝剂、美缝行业信  息,瓷砖美缝效果图,美缝选材等服务！">
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/kkpager_blue.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/master.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/base.css" type="text/css" rel="stylesheet" />
<title>美缝</title>
</head>
<body>
<!--头部-->
<div class="head">
	<div class="block yh f13">
   		<p class="tright mb0"><a id="login" href="javascript:void(0)" class="pl10 pr10">登录</a> | <a href="${contextPath}/register/index" class="pl10 pr10">注册</a></p>
  		<div class="box position_a clearfix">     
	   	<!--导航-->
		   	<div class="nav fleft ofHidden">
		       <ul>
		           <li><a href="${contextPath}">首页</a></li>
		           <li><a href="${contextPath}/news">新闻动态</a></li>
		           <li><a href="${contextPath}/company">美缝公司</a></li>
		           <li><a href="${contextPath}/worker">施工工人</a></li>
		           <li><a href="${contextPath}/material">美缝材料</a></li>
		           <li><a href="${contextPath}/tools">美缝工具</a></li>
		       </ul>
		   	</div>
   		</div>
   	</div>
</div>
<!-- 登录窗口 -->
<div id="loginModal" class="modal fade yh">
  <div class="modal-backdrop fade in" style="z-index:-1"></div>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title tcenter">用户登录</h4>
      </div>
      <div class="modal-body">
      	<form class="form-horizontal" role="form">
      		
        	<div class="form-group">
			    <label for="account" class="col-sm-2 control-label" style="padding:0"><i class="login_icon_account_b"></i></label>
			    <div class="col-sm-10 pl0">
			      <input type="email" class="form-control" id="account" placeholder="Email">
			    </div>
			 </div>
			 <div class="form-group">
			    <label for="password" class="col-sm-2 control-label" style="padding:0"><i class="login_icon_password_b"></i></label>
			    <div class="col-sm-10 pl0">
			      <input type="password" class="form-control" id="password" placeholder="Email">
			    </div>
			 </div>
		</form>
      </div>
      <div class="modal-footer tcenter">
        <button type="button" class="btn btn-primary">登录</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->