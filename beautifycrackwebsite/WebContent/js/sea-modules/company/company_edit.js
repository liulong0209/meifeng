/**
 * 美缝公司更新
 */
define(function(require,exports,module){
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
		$("#update").on("click",function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			
			require.async('custom',function(){
				$.ajax({    
					url: contextPath+'/providers/update.do',       
					type:'post',    
					cache:false,  			
					dataType:'json', 
					data:{
						providersId:$("#providersId").val(),
						providerName:$("#companyName").val(),
						profile:$("#introduction").val(),
						phoneNo:$("#contact").val(),
						address:$("#address").val(),
						type:0,
						serviceType:0,
						imageData:$(".file-preview-image").attr("src"),
						original:$(".file-preview-image").attr("title")
					},
					beforeSend: function () {
						$.showLoadding({loadText:"执行中，请稍后...."});
				    },
				    success: function (data) {
				    	if(data.result=='0'){
				    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+"/companymanager.do");
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
		});
		
		//图片删除
		$("#delete").click(function(){
			require.async('alertable',function(){
				$.alertable.confirm('确认删除嘛!',{parentObj:window.parent.document}).then(function() {
					//删除logo
					deleteLogo();
			    }, function() {
			         return;      
			    });
			})
		})
	}
	
	function deleteLogo(){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/file/delete.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{"fileId":$("#logoId").val()},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result=='0'){
			    		require.async('alertable',function(){
			    			$.alertable.alert('删除成功!',{parentObj:window.parent.document});
			    			//页面删除图片元素
				    		$(".img-edit-show").remove();
				    		
				    		$("#imgFile").show();
				    		//加载图片上传组件
				    		initFileUpload();
				    		
				    		//更改数据里img_id
				    		updatelogo();
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
	function updatelogo(){
		$.ajax({    
			url: contextPath+'/providers/ajaxUpdate.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{providersId:$("#providersId").val(),logo:-1},
		    success: function (data) {
		    	
		    },
		    error: function (data) {
		        console.info("error: " + data.responseText);
		    }});
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
            	companyName: {
                    message: '公司名称验证失败',
                    validators: {
                        notEmpty: {
                            message: '公司名称不能为空'
                        },
                        stringLength: {
                            max: 50,
                            message: '公司名称长度不能超过50个字'
                        }
                    }
                },
                introduction: {
                    message: '公司简介验证失败',
                    validators: {
                        notEmpty: {
                            message: '公司简介不能为空'
                        },
                        stringLength: {
                            max: 1000,
                            message: '公司简介长度不能超过1000个字'
                        }
                    }
                },
                contact: {
                    message: '联系方式验证失败',
                    validators: {
                        notEmpty: {
                            message: '联系方式不能为空'
                        },
                        stringLength: {
                            max: 50,
                            message: '联系方式长度不能超过50个字'
                        }
                    }
                },
                address: {
                    message: '公司地址验证失败',
                    validators: {
                        notEmpty: {
                            message: '公司地址不能为空'
                        },
                        stringLength: {
                            max: 100,
                            message: '公司地址长度不能超过100个字'
                        }
                    }
                }
            }
        });
		})
	}
	
	//初始化
	function init(){
		//编辑时没有logo，加载log上传插件
		var logoId =$("#logoId").val()
		if(logoId=="" || logoId==-1)
		{
			initFileUpload();
		}
		bindEvent();
		validator();
	}
	
	//对外输出接口
	exports.init = init;
})

