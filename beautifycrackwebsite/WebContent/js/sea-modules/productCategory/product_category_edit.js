/**
 * 工具/材料编辑
 */
define(function(require,exports,module){
	//引入jquery
	require('jquery');
	
	//事件绑定
	function eventBind(){
		$("#update").click(function(){
			$("form").data('bootstrapValidator').validate();
			if(!$("form").data('bootstrapValidator').isValid()){
				return false;
			}
			update();
		})
	}
	
	//更新
	function update(){
		require.async('custom',function(){
			$.ajax({    
				url: contextPath+'/productCategory/update.do',       
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{
					id:$("#productCategoryId").val(),
					name:$("#categoryName").val()
				},
				beforeSend: function () {
					$.showLoadding({loadText:"执行中，请稍后...."});
			    },
			    success: function (data) {
			    	if(data.result=='0'){
			    		var url="";
			    		if($("#productType").val()==0){
			    			url="/toolsCategory.do?productType=0";
			    		}else{
			    			url="/materialCategory.do?productType=1"
			    		}
			    		$("#page-inner iframe",window.parent.document).attr("src",contextPath+url);
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
            	categoryName: {
                    message: '分类名称失败',
                    validators: {
                        notEmpty: {
                            message: '分类名称不能为空'
                        },
                        stringLength: {
                            max: 32,
                            message: '分类名称长度不能超过32个字'
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
		eventBind();
	}
	
	//对外输出接口
	exports.init = init;
})

