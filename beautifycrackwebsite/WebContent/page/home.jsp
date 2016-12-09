<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap Styles-->
<link href="${contextPath}/style/css/bootstrap.min.css" rel="stylesheet" />
<link href="${contextPath}/style/css/font-awesome.css" rel="stylesheet" />
<link href="${contextPath}/style/css/jquery.alertable.css" rel="stylesheet" />
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
                    <a><i class="fa fa-user fa-fw"></i>您好：${sessionScope.userInfo.userName}</a>
                </li>
                <li>
                    <a href="javaScript:void('0')" id="logout"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                </li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
		<div id="sideNav"><i class="fa fa-caret-right"></i></div>
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/adsmanager.do"><i class="fa fa-dashboard"></i>轮播广告维护</a>
                    </li>
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/newsmanager.do"><i class="fa fa-desktop"></i>新闻动态管理</a>
                    </li>

					<li>
                        <a href="javaScript:void('0')" url="${contextPath}/companymanager.do"><i class="fa fa-bar-chart-o"></i>美缝公司管理</a>
                    </li>
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/workermanager.do"><i class="fa fa-qrcode"></i>施工工人管理</a>
                    </li>
                    
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/materialClass.do"><i class="fa fa-fw fa-file"></i>材料分类管理</a>
                    </li>
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/materialmanager.do"><i class="fa fa-table"></i>美缝材料管理</a>
                    </li>
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/toolsClass.do"><i class="fa fa-fw fa-file"></i>工具分类管理</a>
                    </li>
                    <li>
                        <a href="javaScript:void('0')" url="${contextPath}/toolsmanager.do"><i class="fa fa-edit"></i>美缝工具管理 </a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<iframe src="" width="100%" height="100%" scrolling="no" frameborder="no"></iframe>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
</body>
    <script src="${contextPath}/js/3th/jquery-3.1.0.min.js"></script>
    <script src="${contextPath}/js/3th/bootstrap.min.js"></script>
    <script src="${contextPath}/js/jquery.alertable.min.js"></script>
    <script src="${contextPath}/js/home.js"></script>
    <script type="text/javascript">
    	var contextPath = "${contextPath}";
    </script>
</html>