<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap Styles-->
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contextPath}/style/css/font-awesome.css" rel="stylesheet" />
<link href="${contextPath}/style/css/login/form-elements.css" rel="stylesheet" />
<link href="${contextPath}/style/css/login/style.css" rel="stylesheet" />
<title>美缝平台后台管理</title>
</head>
<body>
 <!-- Top content -->
   <div class="top-content">
       <div class="inner-bg">
           <div class="container">
               <div class="row">
                   <div class="col-sm-8 col-sm-offset-2 text">
                       <h1><strong>美缝后台管理系统</strong></h1>
                   </div>
               </div>
               <div class="row">
                   <div class="col-sm-6 col-sm-offset-3 form-box">
                   	<div class="form-top">
                   		<div class="form-top-left">
                   			<h3>用户登录</h3>
                   		</div>
                   		<div class="form-top-right">
                   			<i class="fa fa-lock"></i>
                   		</div>
                       </div>
                       <div class="form-bottom">
                  <form role="form" method="post" class="login-form">
                  	<div class="form-group">
                  		<label class="sr-only" for="form-username">账号</label>
                      	<input type="text" name="form-username" placeholder="账号/手机号" class="form-username form-control" id="username">
                      </div>
                      <div class="form-group">
                      	<label class="sr-only" for="form-password">密码</label>
                      	<input type="password" name="form-password" placeholder="密码" class="form-password form-control" id="password">
                      </div>
                      <div class="form-group error-tips"></div>
                      <button type="button" class="btn" id="submit">登录</button>
                  </form>
                 </div>
                   </div>
               </div>
           </div>
       </div>
   </div>
   <script src="${contextPath}/js/3th/jquery-3.1.0.min.js"></script>
   <script src="${contextPath}/js/3th/bootstrap.min.js"></script>
   <script src="${contextPath}/js/3th/jquery.backstretch.min.js"></script>
   <script src="${contextPath}/js/login.js"></script>
   <script type="text/javascript">
   		var contextPath = "${contextPath}";
   </script>
</body>
</html>