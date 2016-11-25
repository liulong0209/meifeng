/**
 * 轮播广告列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	var ads_id,img_id;
	//初始化文件上传
	function initFileUpload(){
		require.async('fileinput',function(){
			$("#imgFile").fileinput({
				showUpload: false,
				showCaption: false,
				browseClass: "btn btn-primary btn-lg",
				fileType: "any",
				previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
			});
		})
	}
	
	//事件绑定
	function bindEvent(){
		//保存草稿
		$("#draft").click(function(){
			updateAds(0);
		})
		//直接发布
		$("#publish").click(function(){
			updateAds(1);
		});
		
		//直接发布
		$("#update").click(function(){
			updateAds(1);
		})
		
		$("#delete").click(function(){
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					//删除图片
					deleteImg(img_id);
			    }, function() {
			         return;      
			    });
			})
		})
	}
	
	function deleteImg(img_id){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/file/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"fileId":img_id},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result=='0'){
			    		require.async('alertable',function(){
			    			$.alertable.alert('删除成功!',{parentObj:window.parent.document});
			    			//页面删除图片元素
				    		$(".img-edit-show").remove();
				    		//加载图片上传组件
				    		initFileUpload();
				    		
				    		//更改数据里img_id
				    		updateAdsImg(-1);
			    		})
			    	}else{
			    		require.async('alertable',function(){
			    			$.alertable.alert('删除失败!',{parentObj:window.parent.document});
			    		})
			    	}
			    },
			    complete: function () {
			    	$.hideLoadding();
			    },
			    error: function (data) {
			    	$.hideLoadding();
			        console.info("error: " + data.responseText);
			    }

			});
		});
	}
	
	//删除图片是更新imgid字段为-1
	function updateAdsImg(){
		$.ajax({    
			url: contextPath+'/ads/ajaxUpdate.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:ads_id,imgId:-1},
		    success: function (data) {
		    	
		    },
		    error: function (data) {
		        console.info("error: " + data.responseText);
		    }});
	}
	
	//新增轮播广告
	function updateAds(state){
		$("form").data('bootstrapValidator').validate();
		if(!$("form").data('bootstrapValidator').isValid()){
			return false;
		}
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/ads/update.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					id:$("#adsId").val(),
					title:$("#adsTitle").val(),
					orderNo:$("#adsOrderNo").val(),
					state:state!=null?state:$("#state").val(),
					imageData:$(".file-preview-image").attr("src"),
					original:$(".file-preview-image").attr("title")
				},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result=='0'){
			    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+"/adsmanager.do");
			    	}else{
			    		require.async('alertable',function(){
			    			$.alertable.alert('更新 失败!',{parentObj:window.parent.document});
			    		})
			    	}
			    },
			    complete: function () {
			    	$.hideLoadding();
			    },
			    error: function (data) {
			    	$.hideLoadding();
			        console.info("error: " + data.responseText);
			    }

			});
		});
	}
	//输入框校验
	function validator(){
		require.async('bootstrapValidator',function(){
			$('form').bootstrapValidator({
				message: 'This value is not valid',
			    feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
			    },
	            fields: {
	            	title: {
	                    message: '标题验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '标题不能为空'
	                        },
	                        stringLength: {
	                            max: 25,
	                            message: '标题长度不能超过25个字'
	                        }
	                    }
	                }
	            }
	        });
		});
	}
	
	//初始化
	function init(adsID,imgId){
		//编辑时没有图片，加载图片上传插件
		if(!imgId || imgId==-1)
		{
			initFileUpload();
		}
		
		img_id = imgId;
		ads_id = adsID;
		
		bindEvent();
		
		validator();
	}
	
	//对外输出接口
	exports.init = init;
});