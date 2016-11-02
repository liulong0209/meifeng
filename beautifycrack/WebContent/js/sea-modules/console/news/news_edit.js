/**
 * 后台新闻修改
 */
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//更新新闻
	function updateNews(state){
		$("form").data('bootstrapValidator').validate();
		if(!$("form").data('bootstrapValidator').isValid()){
			return false;
		}
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+"/console/newsmanager/update",       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					id:$("#newsId").val(),
					title:$("#newsTitle").val(),
					content:$("#newsContent").val(),
					state:state
				},
				beforeSend: function () {
						$.showLoadding({loadText:"执行中,请稍后...."});
				},
			    success: function (data) {
			    	var tips = "";
		    		if(state==0){
		    			tips = "保存";
		    		}else if(state==1){
		    			tips = "发布";
		    		}else{
		    			tips = "更新";
		    		}
			    	if(data && data.result==0)
			    	{
			    		require.async('bootstrap',function(){
							$('#tipsModule').find(".modal-body").empty().append(tips+"成功!");
							$('#tipsModule').modal("show");
							setTimeout("window.location.reload()",1000);
						})
			    	}
			    	else
			    	{
			    		require.async('bootstrap',function(){
							$('#tipsModule').find(".modal-body").empty().append(tips+"失败!");
							$('#tipsModule').modal("show");
						})
			    	}
				},
			  	error: function (data) {
			  		$.hideLoadding();
			        console.info("error: " + data.responseText);
			    },
			    complete: function () {
				    $.hideLoadding();
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
		                    message: '新闻标题验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '新闻标题不能为空'
		                        },
		                        stringLength: {
		                            max: 18,
		                            message: '新闻标题长度不能超过255个字符'
		                        },
		                    }
		                }
		            }
		        });
		})
	}
	
	//初始化
	function init(){
		 //暂时保存按钮事件绑定
		 $("#draft").click(function(){
			 updateNews(0);
		 });
		 
		 //直接发布按钮事件绑定
		 $("#publish").click(function(){
			 updateNews(1);
		 });
		 
		 //更新按钮事件绑定(更新表示已经发布，状态不用改变)
		 $("#update").click(function(){
			 updateNews();
		 });
		 
		 validator();
	}
	
	//对外输出接口
	exports.init = init;
})
