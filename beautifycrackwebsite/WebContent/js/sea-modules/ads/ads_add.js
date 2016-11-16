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
	
	//初始化
	function init(){
		initFileUpload();
	}
	
	//对外输出接口
	exports.init = init;
});