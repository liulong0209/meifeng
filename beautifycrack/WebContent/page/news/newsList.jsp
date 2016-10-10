<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>  
	<!--新闻列表页主体-->
	<div class="container yh">
    	<div class="block relative">
    		<div class="navmenu">新闻动态</div>
			<ul id="newsList"></ul>
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