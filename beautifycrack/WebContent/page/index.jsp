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
		<div class="t1">
			<a href="${contextPath}/material" class="fright f12">更多>></a>
			美缝材料
		</div>
		<div id="materialList" class="index-image clearfix pt15 "></div>
	</div>
	
	<!--美缝工具-->
	<div class="clearfix ofHidden block yh pt20">
		<div class="t1">
			<a href="${contextPath}/tools" class="fright f12">更多>></a>
			美缝工具
		</div>
		<div id="toolsList" class="index-image clearfix pt15 "></div>
	</div>
	
    <div class="clearfix ofHidden block yh pt20">
    	<div class="index_left fleft">			
			<div class="t1">美缝公司<a href="${contextPath}/company" class="fright f12 pr30">更多>></a></div>
			<ul id="company" class="pt15"></ul>
			
			<div class="clearfix"></div>
			
			<div class="t1">施工人员<a href="${contextPath}/worker" class="fright f12 pr30">更多>></a></div>
			<ul id="worker" class="pt15 pb20"></ul>
			
			<div class="clearfix"></div>
 
        </div>
	        
        <!--新闻动态-->
    	<div class="index_right fright pb20">
        	<div class="t1">新闻动态<a href="${contextPath}/news/list" class="fright f12">更多>></a></div>
            <ul id="newsli" class="alzs clearfix ofHidden"></ul>
        </div>
    </div>
    
	<%@include file="common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/index",function(module){module.init();});
	</script>    	
</html>