<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="${contextPath}/style/css/headhesive.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/loadding.css" type="text/css" rel="stylesheet" />
<title>美缝剂施工,瓷砖美缝剂,瓷砖美缝</title>
</head>
<body>
  <!--头部-->
  <div class="header header-nav">
  	  <!-- 顶部第一行 -->
  	  <div class="header-first-box">
  	  	<div class="header-nav-first">
            <div class="nav-first-left" style="display: block;">
                <div id="nowTime"></div>
            </div>
            <div class="nav-first-right">
                <a class="nav-first-login" href="javascript:void(0)"><span class="glyphicon glyphicon-earphone pr5"></span>咨询热线：400-100-1000</a>
                <div class="division-thread"></div>
                 <c:choose>
			  		<c:when test="${sessionScope.userInfo.userName!=null}">
					<p class="tright mb0">
						您好：<a class="nav-first-login">${sessionScope.userInfo.userName}</a>
					</p>
				  </c:when>
				  <c:otherwise>
	   				 <a class="nav-first-reg" href="${contextPath}/register/index" target="_blank" rel="nofollow"><span class="glyphicon glyphicon-log-in pr5"></span>注册</a>
                	 <div class="division-thread"></div>
                	 <a class="nav-first-login" id="login" href="javascript:void(0)"><span class="glyphicon glyphicon-user pr5"></span>登录</a>
				  </c:otherwise>
				</c:choose>
        	</div>
        </div>
  	  </div>
  	  <!-- 导航内容 -->
  	  <div class="header-nav-content">
  	  	<div class="header-nav-box">
  	  		<div class="nav-content-left">
		  		<a href="">
			    	<span><image src="${contextPath}/style/images/logo.png"/></span>
			  	</a>
  	  		</div>
  	  		<div class="nav-content-right">
  	  			<ul class="nav-content-list">
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
      <form id="loginForm" class="form-horizontal" role="form">
	      <div class="modal-body">
	      		<div class="form-group">
				    <label for="userName" class="col-sm-2 control-label" style="padding:0"><i class="login_icon_account_b"></i></label>
				    <div class="col-sm-10 pl0">
				    	<input type="text" class="form-control" id="account" name="account" data-bv-remote-name="userName"  placeholder="请输入用户名">
				    </div>
				</div>
				 <div class="form-group">
				    <label for="password" class="col-sm-2 control-label" style="padding:0"><i class="login_icon_password_b"></i></label>
				    <div class="col-sm-10 pl0">
				        <input type="password" class="form-control" id="password" name="password" data-bv-remote-name="password"  placeholder="请输入密码">
				    </div>
				 </div>
				 <div id="loginErrorInfo" class="form-group tcenter errorbox ">
				 	<i>!</i>	
				 	<span id="span-login"></span>
				 </div>
	      </div>
	      <div class="modal-footer tcenter">
	        	<button type="submit" id="loginBtn" class="btn btn-primary">登录</button>
	      </div>
	 </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->