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
		//更新
		$("#update").on("click",function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			
			require.async('custom',function(){
				$.ajax({    
					url: contextPath+'/providersResource/updateWorker.do',       
					type:'post',    
					cache:false,  			
					dataType:'json', 
					data:{
						id:$("#workerId").val(),
						name:$("#workerName").val(),
						imageData:$(".file-preview-image").attr("src"),
						original:$(".file-preview-image").attr("title")
					},
					beforeSend: function () {
						$.showLoadding({loadText:"执行中，请稍后...."});
				    },
				    success: function (data) {
				    	if(data.result=='0'){
				    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+"/providersResource/workerList.do?providersId="+$("#providersId").val());
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
				data:{"fileId":$("#avatar").val()},
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
				    		updateavatar();
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
	function updateavatar(){
		$.ajax({    
			url: contextPath+'/providersResource/updateWorker.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:$("#workerId").val(),avatar:-1},
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
            	name: {
                    message: '姓名验证失败',
                    validators: {
                        notEmpty: {
                            message: '姓名不能为空'
                        },
                        stringLength: {
                            max: 32,
                            message: '姓名长度不能超过32个字'
                        }
                    }
                }
            }
        });
		})
	}
	//初始化
	function init(){
		//编辑时没有头像，加载log上传插件
		var avatar =$("#avatar").val()
		if(avatar=="" || avatar==-1)
		{
			initFileUpload();
		}
		bindEvent();
		validator();
	}
	
	//对外输出接口
	exports.init = init;
})

