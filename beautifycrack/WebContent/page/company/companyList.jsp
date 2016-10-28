<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>  
	<!--公司列表页主体-->
	<div class="container yh">
    	<div class="relative">
    		<div class="navmenu">美缝公司</div>
			<div class="text-list yh">
				<ul id="companyList"></ul>
    		</div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
    	</div>
    </div>	
<%@include file="../common/footer.jsp" %>  	
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/company/company",function(module){module.init();});
	</script> 
</html>