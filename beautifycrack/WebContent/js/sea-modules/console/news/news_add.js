/**
 * 后台新闻增加
 */
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//提交新闻增加
	function commitNews(state){
		$("form").data('bootstrapValidator').validate();
		if(!$("form").data('bootstrapValidator').isValid()){
			return false;
		}
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+"/console/newsmanager/add",       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
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
		    		}else{
		    			tips = "发布";
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
			 commitNews(0)
		 });
		 
		 //直接发布按钮事件绑定
		 $("#publish").click(function(){
			 commitNews(1)
		 });
		 
		 validator();
	}
	
	//对外输出接口
	exports.init = init;
})
