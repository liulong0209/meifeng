<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../common/header.jsp" %>  

	<div class="container yh">
		<div class="navmenu">美缝材料</div>
    	<div class="fleft leftmenu yh">
	       	<ul id="nav">
	       	<c:forEach var="product" items="${productCategory}" varStatus="status">
	       		<c:choose>
	       			<c:when test="${status.index==0}">
	       				<li><a href="javaScript:void('0')" class="select" categoryId="${product.id}">${product.name}</a></li>
	       			</c:when>
	       			<c:otherwise>
	       				<li><a href="javaScript:void('0')" categoryId="${product.id}">${product.name}</a></li>
	       			</c:otherwise>
	       		</c:choose>
	       	</c:forEach>
	       	</ul>
       	</div>
       	<div class="fleft">
       		<div class="w940 pb30">
       			<ul id="productList" class="minh256 clearfix"></ul>
	       		<!-- 分页页码 -->
	    		<div id="kkpager"></div>
       		</div>
       	</div>
    </div>	
<%@include file="../common/footer.jsp" %>  	
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/product/productList",function(module){module.init(${firstCategory});});
	</script> 
</html>