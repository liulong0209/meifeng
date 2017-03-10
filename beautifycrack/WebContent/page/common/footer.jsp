<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="foot clearfix">
	<div class="rows block clearfix">
		<div class="col-md-4 tcenter c80 yh">Copyright ©2016-2017</div>
		<div class="col-md-4 tcenter c80 yh">地址：郑州二七区中原区经开区</div>
		<div class="col-md-4 tcenter c80 yh">豫ICP备17007434号</div>
	</div>
</div> 
</body>
<script type="text/javascript" src="${contextPath}/js/3th/sea/sea.js"></script>
<script type="text/javascript">
	var userInfo = "${sessionScope.userInfo}";
	var contextPath = "${contextPath}";
 	//seajs的配置
	seajs.config({
		  base: "${contextPath}/js/",//基本路径
		  alias: {
		    "jquery": "3th/jquery/jquery-3.1.0.min.js",
		    "unSlide": "3th/jquery/plug-in/jquery.unslider.min.js", //jquery 滑动门插件
		    "custom": "3th/jquery/plug-in/jquery.custom.js", //自定义的jquery插件
		    "kkpager":"3th/kkpager.js", //分页组件
		    "zoomify": "3th/jquery/plug-in/jquery.zoomify.js",
		    "bootstrap": "3th/bootstrap.js",
		    "bootstrapValidator": "3th/bootstrapValidator.js"
		  }
		})
	//同步菜单样式
	seajs.use("sea-modules/common",function(module){module.syncMenuClass()})
	seajs.use("sea-modules/login",function(module){module.init()})
</script>