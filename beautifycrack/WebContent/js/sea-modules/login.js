/**
 * 登录模块
 */
define(function(require, exports, module){
	//引入jquery
	require('jquery');
	
	//按钮事件绑定
	function buttonBindEvent(){
		var loginObj = $("#login");
		//没有登录按钮，已经登录了
		if(loginObj.length==0)
		{
			return;
		}
		loginObj.click(function(){
			require.async('bootstrap',function(){
				$("#loginModal").modal({
					backdrop:false,
					keyboard:false,
					show:true
				});
			});
		})
	}
	
	//初始化
	function init(){
		buttonBindEvent();
	}
	
	//对外输出接口
	exports.init = init;
})
