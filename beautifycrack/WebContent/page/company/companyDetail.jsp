<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!--公司列表页主体-->
<%@include file="../common/header.jsp" %>  
	<div class="container yh">
    	<div class="block clearfix ">
    			<div class="fleft w235">
					<div class="w160 border_ccc margin-auto  pt20 pb20 pl20">
						<img src="${contextPath}/file/image/get/${company.logo}" width="120" height="120" class="radius4">
					</div>
				</div>
				<div class="fleft w955">
					<p class="h30 pb30 f24">${company.providerName}</p>
					<p class="f14 tleft text-indent28 mb30 c333">${company.profile}</p>
					<i class="fnormal address_icon fleft"></i><p class="f14 tleft pb5 pl30">${company.address}</p>
					<i class="fnormal phone_icon fleft"></i><p class="f18 tleft l_phone ">${company.phoneNo}</p>
				</div>
		</div>

		<div class="block clearfix">
			<div class="t1">施工工人信息</div>
			<div id="workerInfo" class="index-image pt10"></div>
		</div>
		<div class="block clearfix">
			<div class="t1">施工案例</div>
			<div id="caseInfo" class="index-image pt10"></div>
		</div>		
		<div class="block clearfix">
			<div class="t1">预约小区</div>
			<div id="bookingInfo" class="index-image pt10"></div>
		</div>	
		<div class="block clearfix">
			<div class="t1">公司资质</div>
			<div id="qualificationInfo" class="index-image pt10"></div>
		</div>
		<div id="evaluationCell" class="block clearfix">
			<div class="t1">客户评价</div>
			<div id="evaluationInfo"></div>
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
						<span><a id="cLogin" href="javascript:void(0)">登录</a></span>
						<span>|</span>
						<span><a href="${contextPath}/register/index">注册</a></span>
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
	      </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	<%@include file="../common/footer.jsp" %>
	<script type="text/javascript">
		//加载入口模块
		seajs.use("sea-modules/company/companyDetail",function(module){module.init(${company.providersId});});	
	</script> 
</html>