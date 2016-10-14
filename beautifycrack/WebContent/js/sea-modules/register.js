/**
 * 首页相关js
 */
define(function(require, exports, module) {
	//通过 require 引入依赖
	require('jquery');
	
	//注册按钮事件绑定
	function bindEvent(){
		$("#registerbtn").click(function(){
			//$("form").submit();
			var a = $('form').data('bootstrapValidator').isValid();
			var b =a;
		})
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
		            	userName: {
		                    message: '用户名验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '用户名不能为空'
		                        },
		                        stringLength: {
		                            min: 4,
		                            max: 18,
		                            message: '用户名长度必须在4到18位之间'
		                        },
		                        regexp: {
		                            regexp: /^[a-zA-Z0-9_]+$/,
		                            message: '用户名只能包含大写、小写、数字和下划线'
		                        },
		                        remote: {
		                            message: '该用户名已被占用',
		                            url: contextPath+'/register/judgeAccount'
		                        }
		                    }
		                },
		                password: {
		                    validators: {
		                        notEmpty: {
		                            message: '密码不能为空'
		                        }
		                    }
		                },
		                confirmPassword: {
		                    validators: {
		                        notEmpty: {
		                            message: '确认密码不能为空'
		                        },
		                        identical: {
		                            field: 'password',
		                            message: '两次密码不一致'
		                        },
		                    }
		                },
		                phoneNo:{
		                	 validators: {
		                		 	notEmpty: {
			                            message: '手机号不能为空'
			                        },
			                        regexp: {
			                            regexp: /^1[34578]\d{9}$/,
			                            message: '手机号码有误'
			                        },
			                        remote: {
			                            message: '该手机号已注册',
			                            url: contextPath+'/register/judgePhone'
			                        }
			                        
		                	 }
		                }
		            }
		        });
		})
	}
	//初始化
	function init(){
		validator();
		bindEvent();
	}
	
	exports.init = init;
});