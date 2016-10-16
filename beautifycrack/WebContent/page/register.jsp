<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎注册</title>
<link href="${contextPath}/style/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${contextPath}/style/css/bootstrapValidator.min.css" type="text/css" rel="stylesheet" />
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
			<form class="form-horizontal" role="form">
			  <div class="form-group">
			    <label for="userName" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-10">
			    	<input type="text" class="form-control" id="userName" name="userName" data-bv-remote-name="userName"  placeholder="请输入用户名" size="18">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			    	<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-10">
			    	<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="phoneNo" class="col-sm-2 control-label">手机号</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="phoneNo" name="phoneNo" data-bv-remote-name="phoneNo" placeholder="请输入手机号">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			     	<button type="submit" id="registerbtn" class="btn btn-primary">立即注册</button>
			    </div>
			  </div>
			  <div id="registErrorInfo" class="form-group tcenter errorbox ">
				 	<i>!</i>	
				 	<span id="span-regist"></span>
				 </div>
			</form>
		</div>
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
		    "bootstrap": "3th/bootstrap.js",
		    "bootstrapValidator": "3th/bootstrapValidator.js"
		  }
		})
	seajs.use("sea-modules/register",function(module){module.init()})
</script>
</html>