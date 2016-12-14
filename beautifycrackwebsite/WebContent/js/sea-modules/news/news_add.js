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
				url: contextPath+"/news/add.do",       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					title:$("#newsTitle").val(),
					subtitle:$("#newsSubTitle").val(),
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
			    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+"/newsmanager.do");
			    	}
			    	else
			    	{
			    		require.async('alertable',function(){
			    			$.alertable.alert(tips+'失败!',{parentObj:window.parent.document});
			    		});
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
		                            max: 255,
		                            message: '新闻标题长度不能超过255个字符'
		                        },
		                    }
		                },
		                subtitle: {
		                    message: '新闻副标题验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '新闻副标题不能为空'
		                        },
		                        stringLength: {
		                            max: 500,
		                            message: '新闻标副题长度不能超过500个字符'
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
