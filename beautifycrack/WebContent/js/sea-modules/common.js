/**
 * 基础的js方法
 */
define(function(require, exports, module){
	/**
	 * pageNo:当前页面
	 * totalPage:总数
	 * totalRecords:总记录数
	 */
	function loadPager(pageNo,totalPage,totalRecords,queryMethodName,href){
		//引入分页组件模块
		var kkpager = require("kkpager").kkpager
		//生成分页
		//有些参数是可选的，比如lang，若不传有默认值
		kkpager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			mode : 'click',//默认值是link，可选link或者click
			click : function(n){
				//执行查询方法
				eval(queryMethodName(n)); 
				//手动选中按钮
				this.selectPage(n);
				return false;
			},
			//getHref是在click模式下链接算法
			getHref : function(n){
				if(!href)
				{
					return '#';
				}
		        return '#'+href;
		    },
			isGoPage:false
		},true);
	}
	
	//同步菜单样式
	function syncMenuClass(){
		
		String.prototype.endWith=function(endStr){
	      var d=this.length-endStr.length;
	      return (d>=0&&this.lastIndexOf(endStr)==d)
	    }
		
		require.async("jquery",function(){
			//如果当前url以上下文根结尾，说明是首页
			if((String(window.location)).endWith(contextPath+"/"))
			{
				$(".nav a").first().addClass("active"); 
				return;
			}
			//切割当前url
			$(".nav a").each(function(){  
				var $this = $(this); 
				var href =$this.attr("href");
				//用“/”分割href
				var arr = href.split("/");
				if(href!=contextPath &&(String(window.location)).indexOf("/"+arr[arr.length-1])>0)
				{
					$this.addClass("active"); 
					return false;
				}
			});  
		})
	}
	
	exports.loadPager = loadPager;
	exports.syncMenuClass = syncMenuClass;
})