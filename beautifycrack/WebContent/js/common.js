/**
 * 基础的js方法
 */
window.Common = (function($, module) {
	/**
	 * pageNo:当前页面
	 * totalPage:总数
	 * totalRecords:总记录数
	 */
	function loadPager(pageNo,totalPage,totalRecords){
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
				// do something
				//手动选中按钮
				this.selectPage(n);
				return false;
			},
			isGoPage:true
		},true);
	}
	
	module.loadPager = loadPager;
	
	return module
})($, window.Common || {})