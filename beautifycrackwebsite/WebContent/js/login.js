
jQuery(document).ready(function() {
	if(timeout=='timeout'){
		window.top.location.replace(contextPath);
	}
    /*
        Fullscreen background
    */
    $.backstretch(contextPath+"/style/css/images/login_bg.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('#submit').click(function() {
    	$(this).parent().find('input[type="text"], input[type="password"]').each(function(){
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    	if($("#userName").val()=="" || $("#password").val()==""){
    		return false;
    	}
    	
    	$.ajax({    
			url: contextPath+"/login.do",       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			beforeSend: function () {
				$('#submit').text("登录中...")
				$('#submit').attr("disabled",true);
			},
			data:{
				userName:$("#username").val(),
				password:$("#password").val()
			},
		    success: function (data) {
		    	if(data.result==0){
		    		window.location.href=contextPath+"/home.do";
		    	}else{
		    		$(".error-tips").html("用户名或密码错误");
		    		$('#submit').text("登录中")
					$('#submit').attr("disabled",false);
		    		return false;
		    	}
			},
		  	error: function (data) {
		  		$('#submit').text("登录中")
				$('#submit').attr("disabled",false);
		        console.info("error: " + data.responseText);
		    }
		});
    	
    });
    
    
});
