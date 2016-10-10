<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎注册</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	.top{
		width:1190px;
		margin:0 auto;
		height: 100px;
		line-height:100px;
		font-size: 24px;
    	color: #333;
    	font-family: "Microsoft YaHei",sans-serif;
	}
	.main{
		width:1190px;
		margin:0 auto;
		border: 7px solid #e5e5e5;
		padding: 0 0 20px 0;
	}
	.content{
		width:500px;
		margin: 0 auto;
	}
	.title{
		height: 50px;
	    line-height: 50px;
	    font-size: 18px;
	    text-align: center;
	    font-family: "Microsoft YaHei";
	}
</style>
</head>
<body>
	<div class="top">
		新用户注册
	</div>
	
	<div class="main">
		<div class="content">
			<div class="title">填写注册信息</div>
			<form role="form">
			  <div class="form-group">
			    <label for="exampleInputEmail1">用户名</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名" size="18">
			  	<span></span>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
			  	<span></span>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">确认密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入确认密码">
			  	<span></span>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">手机号</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入手机号" style="width: 220px;">
			  	<span></span>
			  </div>
			  	<button type="submit" class="btn btn-primary">立即注册</button>
			</form>
		</div>
	</div>
</body>
</html>