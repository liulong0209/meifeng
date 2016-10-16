/**
 * 登录模块
 */
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//按钮事件绑定
	function buttonBindEvent(){
		var loginObj = $("#login");
		//没有登录按钮，就不执行了
		if(loginObj.length==0)
		{
			return;
		}
		loginObj.click(function(){
			showLoginModel();
		})
		
		//绑定校验
		validator();
		
		//登录提交
		$("#loginBtn").click(function(){
			$("#loginForm").data('bootstrapValidator').validate();
			if(!$("#loginForm").data('bootstrapValidator').isValid()){
				return false;
			}
			$.ajax({    
				url: contextPath+"/login",       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{account:$("#account").val(),password:$("#password").val()},
			    success: function (data) {
			    	if(data!=0)
			    	{
			    		$("#span-login").empty().append("用户名或密码错误");
			    		$("#loginErrorInfo").fadeIn();
			    	}
			    	else
			    	{
			    		location.reload();
			    	}
				},
			  	error: function (data) {
			        console.info("error: " + data.responseText);
			    }
			});
			
			return false;
		});
	}
	
	//显示登录框
	function showLoginModel(){
		require.async('bootstrap',function(){
				$("#loginModal").modal({
					backdrop:false,
					keyboard:false,
					show:true
				});
			});
	}
	
	
	//输入框校验
	function validator(){
		require.async('bootstrapValidator',function(){
			$('#loginForm').bootstrapValidator({
			message: 'This value is not valid',
		    feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
		            fields: {
		            	account: {
		                    validators: {
		                        notEmpty: {
		                            message: '用户名不能为空'
		                        }
		                    }
		                },
		                password: {
		                    validators: {
		                        notEmpty: {
		                            message: '密码不能为空'
		                        }
		                    }
		                }
		            }
		        });
		})
	}
	
	//初始化
	function init(){
		buttonBindEvent();
	}
	
	//对外输出接口
	exports.init = init;
	exports.showLoginModel = showLoginModel;
})
