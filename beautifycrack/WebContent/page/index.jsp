<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/header.jsp" %>  
	<!--幻灯片-->
	<div class="banner" id="banner">
		<ul style="overflow: hidden">
			<c:forEach var="slide" items="${slideList}">
				<li>
					<a href=""><img src="${contextPath}/file/image/get/${slide.id}" height="450px" width="100%"></a>
				</li>
			</c:forEach>			
		</ul>
	</div> 

	<!--美缝材料-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="index-title pt20 pb30 tcenter">
			<h1>
				<span>美缝材料</span>
			</h1>
			<span class="c666 f16">最新最热的美缝材料，快来看看吧！</span>
		</div>
		<div id="materialList" class="rows minh405 index-image clearfix"></div>
	</div>
	
	<!--美缝工具-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="index-title pt20 pb30 tcenter">
			<h1>
				<span>美缝工具</span>
			</h1>
			<span class="c666 f16">最新最热的美缝工具，快来看看吧！</span>
		</div>
		<div id="toolsList" class="rows minh405 index-image  clearfix"></div>
	</div>
	
	<!--新闻动态-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="index-title pt20 pb30 tcenter">
			<h1>
				<span>新闻动态</span>
			</h1>
			<span class="c666 f16">美缝行业最新新闻</span>
		</div>
		<div class="w1190 margin-auto yh">
			<ul id="newsli" class="alzs clearfix ofHidden"></ul>
		</div>
	</div>
	
	<!--美缝公司-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="index-title pt20 pb30 tcenter">
			<h1>
				<span>美缝公司</span>
			</h1>
			<span class="c666 f16">多家美缝公司已入住</span>
		</div>
		<div id="company" class="rows minh210 clearfix"></div>
	</div>
	
	<!--施工人员-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="index-title pt20 pb30 tcenter">
			<h1>
				<span>施工人员</span>
			</h1>
			<span class="c666 f16">多名美缝人员为您服务</span>
		</div>
		<div id="worker" class="rows clearfix"></div>
	</div>
	
	<%@include file="common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/index",function(module){module.init();});
	</script>    	
</html>