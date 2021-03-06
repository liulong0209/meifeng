/**
 * 美缝工具新增
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
		//新增保存
		$("#add").on("click",function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			
			require.async('custom',function(){
				$.ajax({    
					url: contextPath+'/product/add.do',       
					type:'post',    
					cache:false,  			
					dataType:'json', 
					data:{
						productName:$("#toolsName").val(),
						profile:$("#toolsInfo").val(),
						category:$("#toolsType").val(),
						providersId:$("#providers").val(),
						imageData:$(".file-preview-image").attr("src"),
						original:$(".file-preview-image").attr("title")
					},
					beforeSend: function () {
						$.showLoadding({loadText:"执行中，请稍后...."});
				    },
				    success: function (data) {
				    	if(data.result=='0'){
				    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+"/toolsmanager.do");
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
            	toolsName: {
                    message: '工具名称验证失败',
                    validators: {
                        notEmpty: {
                            message: '工具名称不能为空'
                        },
                        stringLength: {
                            max: 32,
                            message: '工具名称长度不能超过32个字'
                        }
                    }
                },
                toolsInfo: {
                    message: '工具简介验证失败',
                    validators: {
                        notEmpty: {
                            message: '工具简介不能为空'
                        },
                        stringLength: {
                            max: 1000,
                            message: '工具简介长度不能超过1000个字'
                        }
                    }
                },
                toolsType: {
                    message: '工具类别验证失败',
                    validators: {
                        notEmpty: {
                            message: '工具类别不能为空'
                        }
                    }
                },
                providers: {
                    message: '所属公司验证失败',
                    validators: {
                        notEmpty: {
                            message: '所属公司不能为空'
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
})

