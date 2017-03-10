<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--施工人员列表页主体-->
<%@include file="../common/header.jsp" %>  
	<div class="container yh">
    	<div class="clearfix pt20">
    			<div class="fleft w235">
					<div class="w160 border_ccc margin-auto  pt20 pb20 pl20">
						<img src="${contextPath}/file/image/get/${worker.logo}" width="120" height="120" class="radius4">
					</div>
				</div>
				<div class="fleft w955 pl20">
					<p class="h30 pb30 f24">${worker.providerName}</p>
					<p class="f14 text-indent28 mb30 c333">${worker.profile}</p>
					<p class="f14 pb5"><span class="glyphicon glyphicon-home f18 mr10"></span>${worker.address}</p>
					<p class="f18 l_phone "><span class="glyphicon glyphicon-phone-alt mr10"></span>${worker.phoneNo}</p>
				</div>
		</div>
		<c:if test="${worker.type==1 }">
		<div class="clearfix pt20">
			<div class="t1">施工人员</div>
			<div id="workerInfo" class="index-image pt10"></div>
		</div>
		</c:if>
		<div class="clearfix pt20">
			<div class="t1">施工案例</div>
			<div id="caseInfo" class="index-image pt10"></div>
		</div>		
		<div id="evaluationCell" class="clearfix">
			<div class="t1">客户评价</div>
			<div id="evaluationInfo" class="pb30"></div>
			<!-- 分页页码 -->
    		<div id="kkpager"></div>
			<div class="pt20">
    			<div class="f24">我要评价</div>
    			<div class="radio f14">
				  <label><input type="radio" name="optionsRadios" value="2">好评</label>
				  <label><input type="radio" name="optionsRadios" value="1">中评</label>
				  <label><input type="radio" name="optionsRadios" value="0">差评</label>
				</div>
				<textarea class="form-control" rows="6" placeholder="我来说两句...."></textarea>
				<div class="tright pt10">
					<c:if test="${sessionScope.userInfo.userName==null}">
						<span><a id="wLogin" href="javascript:void(0)"><span class="glyphicon glyphicon-log-in pr5"></span>登录</a></span>
						<span>|</span>
						<span><a href="${contextPath}/register/index"><span class="glyphicon glyphicon-log-in pr5"></span>注册</a></span>
					</c:if>
					<button type="button" class="btn btn-success ml15" id="commit">发表评论</button>
				</div>
			</div>
		</div>		
    </div>
    
    <!--提示框  -->
    <div id="tipsModule" class="modal fade bs-example-modal-sm yh" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-sm">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	          <h4 class="modal-title" id="mySmallModalLabel">提示</h4>
	        </div>
	        <div class="modal-body f14"></div>
	        <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">知道了</button>
		    </div>
	      </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/worker/workerDetail",function(module){module.init("${worker.providersId}","${worker.type}");});  	
	</script> 
</html>