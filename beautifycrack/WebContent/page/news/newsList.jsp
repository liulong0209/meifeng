<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>  
	<!--新闻列表页主体-->
	<div class="container yh">
    	<div class="relative">
    		<div class="navmenu">新闻动态</div>
    		
    		<div class="w1190 margin-auto yh">
			<ul id="newsli" class="alzs clearfix ofHidden"></ul>
			</div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
    	</div>
    </div>	
<%@include file="../common/footer.jsp" %>  	
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/news",function(module){module.init();});
	</script> 
</html>