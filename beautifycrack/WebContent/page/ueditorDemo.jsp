<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain"> 这里写你的初始化内容</script>
</body>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container',{
            autoHeight: false,
            serverUrl : "<%=request.getContextPath() %>/ueditor",
            imageActionName:"fileUpload",
            imageUrl: "<%=request.getContextPath() %>/file/fileUpload",
            filePath: "<%=request.getContextPath() %>/file/fileUpload"
        });
    </script>
</html>