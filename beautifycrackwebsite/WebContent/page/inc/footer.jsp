<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		    "bootstrapValidator": "3th/bootstrapValidator.js",
		    "fileinput": "3th/fileinput.min.js",
		    "alertable": "3th/jquery.alertable.min.js"
		  }
		})
</script>