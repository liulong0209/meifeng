(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery"], factory );
	} else if (typeof module === "object" && module.exports) {
		module.exports = factory( require( "jquery" ) );
	} else {
		factory( jQuery );
	}
}
(function($){
  $.formatDate = function(pattern,date){
    //如果不设置，默认为当前时间
    if(!date) date = new Date();
    if(typeof(date) ==="string"){
       if(date=="")  date = new Date();
        else  date = new Date(date.replace(/-/g,"/"));
    }	
    /*补00*/
    var toFixedWidth = function(value){
       var result = 100+value;
       return result.toString().substring(1);
    };
    
    /*配置*/
    var options = {
        regeExp:/(yyyy|M+|d+|h+|m+|s+|ee+|ws?|p)/g,
        months: ['January','February','March','April','May',
                 'June','July', 'August','September',
              'October','November','December'],
        weeks: ['Sunday','Monday','Tuesday',
                'Wednesday','Thursday','Friday',
              'Saturday']
    };
    
    /*时间切换*/
    var swithHours = function(hours){
      return hours<12?"AM":"PM";
    };
    
    /*配置值*/
    var pattrnValue = {
        "yyyy":date.getFullYear(),                      //年份
        "MM":toFixedWidth(date.getMonth()+1),           //月份
        "dd":toFixedWidth(date.getDate()),              //日期
        "hh":toFixedWidth(date.getHours()),             //小时
        "mm":toFixedWidth(date.getMinutes()),           //分钟
        "ss":toFixedWidth(date.getSeconds()),           //秒
        "ee":options.months[date.getMonth()],           //月份名称
        "ws":options.weeks[date.getDay()],              //星期名称
        "M":date.getMonth()+1,
            "d":date.getDate(),
            "h":date.getHours(),
            "m":date.getMinutes(),
            "s":date.getSeconds(),
            "p":swithHours(date.getHours())
    };
    
    return pattern.replace(options.regeExp,function(){
         return  pattrnValue[arguments[0]];
    });
  };
  
  //加载中模态框扩展方法
  jQuery.extend({
		//显示加载中
		showLoadding:function(options){
			var settings = {
		            loadText: "加载中，请稍候..."
		        };
		    $.extend(settings, options);
			$("#loadding").remove();
			var laddingDiv="<div id='loadding' style='position: fixed;width: 200px;background-color: #000;opacity: 0.4;top: 240px;left: 40%;z-index: 1000'>"
				laddingDiv+=  "<div style='position: relative;top: 115px;color: #fff;text-align: center;'>"+settings.loadText+"</div>";
				laddingDiv+=  "<div class='sk-fading-circle'>";
			    laddingDiv+=    "<div class='sk-circle1 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle2 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle3 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle4 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle5 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle6 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle7 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle8 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle9 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle10 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle11 sk-circle'></div>";
			    laddingDiv+=    "<div class='sk-circle12 sk-circle'></div>";
			    laddingDiv+=  "</div>";
			    laddingDiv+="</div>";
			$("body").prepend(laddingDiv)
		},
		//隐藏加载中
		hideLoadding:function(){
			$("#loadding").remove();
		},
		showEllipsis:function(value,length)
        {
        	/**参数说明：
        	 * 根据长度截取先使用字符串，超长部分追加…
        	 * value 对象字符串
        	 * length 目标字节长度
        	 * 返回值： 处理结果字符串
        	 */
        	//未定义返回空字符串
        	if(!value){
        		return "";
        	}
        	//length属性读出来的汉字长度为1
    	    if(value.length*2 <= length) 
    	    {
    	        return value;
    	    }
    	    var strlen = 0;
    	    var s = "";
    	    for(var i = 0;i < value.length; i++) 
    	    {
    	        s = s + value.charAt(i);
    	        if (value.charCodeAt(i) > 128) 
    	        {
    	            strlen = strlen + 2;
    	            if(strlen >= length)
    	            {
    	                return s.substring(0,s.length-1) + "...";
    	            }
    	        } 
    	        else 
    	        {
    	            strlen = strlen + 1;
    	            if(strlen >= length)
    	            {
    	                return s.substring(0,s.length-2) + "...";
    	            }
    	        }
    	    }
    	    return s;
        }
	});
  
}));