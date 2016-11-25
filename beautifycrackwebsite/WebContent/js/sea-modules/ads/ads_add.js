/**
 * 轮播广告列表
 */
 
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
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
		$("#draft").on("click",function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			addAds(0);
		});
		
		//直接发布
		$("#publish").click(function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			addAds(1);
		})
	}
	
	//新增轮播广告
	function addAds(state){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/ads/add.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					title:$("#adsTitle").val(),
					orderNo:$("#adsOrderNo").val(),
					state:state,
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
			    			$.alertable.alert('新增 失败!',{parentObj:window.parent.document});
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
		})
	}
	
	//初始化
	function init(){
		initFileUpload();
		bindEvent();
		validator();
	}
	
	//对外输出接口
	exports.init = init;
});