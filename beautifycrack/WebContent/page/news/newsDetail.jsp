<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>  
	<!--文字列表页主体-->
	<div class="container">
		<div class="block">
    		<div class="navmenu">新闻动态</div>
    		<div class="newsnr">
    			<h1 class="newstitle ellipsis display-block" title="${news.title}">${news.title}</h1>
    			<span class="newsxx">发布时间: ${publishTime}</span>
    			<div class="content yh">${news.content}</div>
    		</div>
    	</div>
    </div>	
<%@include file="../common/footer.jsp" %>  	
</body>
</html>