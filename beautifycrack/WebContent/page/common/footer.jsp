<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="foot clearfix">
	<div class="block">
        <div class="fleft">
            <p><a href="" class="a1">联系我们</a>|<a href="" class="a2">公司诚聘</a>|<a href="" class="a3">合作伙伴</a>|<a href="" class="a4">网站地图</a></p>
            <p>Copyright © 2014-2016</p>
            <p>版权所有  淮安澍天装饰工程有限公司</p>
        </div>
        
        <div class="fright">
        	<p class="p1">装修热线：0517-85158777</p>
            <p class="p2">邮箱：2079491718@qq.com</p>
        </div>
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