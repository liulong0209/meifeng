<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Bootstrap Styles-->
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contextPath}/style/css/font-awesome.css" rel="stylesheet" />
<link href="${contextPath}/style/css/custom-styles.css" rel="stylesheet" />
<link href='${contextPath}/style/css/googleapis.css' rel='stylesheet' />
<title>美缝平台后台管理</title>
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand"><i class="fa fa-comments"></i> <strong>美缝后台管理</strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a>
                        <i class="fa fa-user fa-fw"></i>您好：xxx
                    </a>
                </li>
                <li>
                    <a>
                        <i class="fa fa-sign-out fa-fw"></i>退出
                    </a>
                </li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a class="active-menu" href="index.html"><i class="fa fa-dashboard"></i> 轮播图片维护</a>
                    </li>
                    <li>
                        <a href="ui-elements.html"><i class="fa fa-desktop"></i> 新闻管理</a>
                    </li>
					<li>
                        <a href="chart.html"><i class="fa fa-bar-chart-o"></i> 美缝公司</a>
                    </li>
                    <li>
                        <a href="tab-panel.html"><i class="fa fa-qrcode"></i> 施工工人</a>
                    </li>
                    
                    <li>
                        <a href="table.html"><i class="fa fa-table"></i> 美缝材料</a>
                    </li>
                    <li>
                        <a href="form.html"><i class="fa fa-edit"></i> 美缝工具 </a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<iframe src="<%=request.getContextPath() %>/newsmanager" width="100%" height="100%" scrolling="no" frameborder="no"></iframe>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
</body>
    <script src="${contextPath}/js/jquery-3.1.0.min.js"></script>
    <script src="${contextPath}/js/bootstrap.min.js"></script>
    <!--  
    <script src="${contextPath}/js/jquery.metisMenu.js"></script>
    <script src="${contextPath}/js/custom-scripts.js"></script>
    -->
    <script type="text/javascript">
    	$(function(){
    		$("#sideNav").click(function(){
    			if($(this).hasClass('closed')){
    				$('.navbar-side').animate({left: '0px'});
    				$(this).removeClass('closed');
    				$('#page-wrapper').animate({'margin-left' : '260px'});
    				
    			}
    			else{
    			    $(this).addClass('closed');
    				$('.navbar-side').animate({left: '-260px'});
    				$('#page-wrapper').animate({'margin-left' : '0px'}); 
    			}
    		});
    	})
    </script>
</html>