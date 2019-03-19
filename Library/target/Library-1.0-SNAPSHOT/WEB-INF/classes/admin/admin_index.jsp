<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理界面</title>
<meta name="msapplication-TileColor" content="#5bc0de" />
<meta name="msapplication-TileImage" content="images/metis-tile.png" />

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.min.css">

<!-- Metis core stylesheet -->
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/metisMenu.min.css">
<link rel="stylesheet" href="css/style-switcher.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">

<script src="js/modernizr.min.js"></script>
</head>

<body>
	<div class="bg-dark dk" id="wrap">
		<div id="top">
			<jsp:include page="admin_top.jsp"></jsp:include>
		</div>
		<!-- /#top -->
		<div id="left" style="height:100%;">
			<jsp:include page="admin_left.jsp"></jsp:include>
		</div>
		<div id="content">
			<iframe name="content" width="100%" style="width:100%; min-height:650px;" border="0" frameborder="no" src="admin/iframeDefault.jsp">
			</iframe>
		</div>



	</div>





	<!-- 帮助 -->
	<jsp:include page="../help.jsp"></jsp:include>
	<!-- 版权 -->
	<jsp:include page="../footer.jsp"></jsp:include>



	<!--jQuery -->
	<script src="js/jquery.min.js"></script>

	<!--Bootstrap -->
	<script src="js/bootstrap.min.js"></script>

	<!-- MetisMenu -->
	<script src="js/metisMenu.min.js"></script>

	<!-- Screenfull -->
	<script src="js/screenfull.min.js"></script>

	<!-- Metis core scripts -->
	<script src="js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="js/app.js"></script>
</body>
</html>
