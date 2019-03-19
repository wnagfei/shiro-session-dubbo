<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图书馆座位分布图</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/background.css">

<style>
/* 轮播广告 */
.carousel {
	height: 650px;
	margin-bottom: 60px;
}

.carousel .item {
	height: 650px;
	background-color: #000;
}

.carousel .item img {
	width: 100%;
	height:100%;
}
</style>
</head>

<body style="min-height:650px">
	<div>
		<div id="ad-carousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#ad-carousel" data-slide-to="1"></li>
				<li data-target="#ad-carousel" data-slide-to="2"></li>
				<li data-target="#ad-carousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="images/cast.jpg" alt="1 slide">
				</div>
				<div class="item">
					<img src="images/cast.jpg" alt="2 slide">
				</div>
				<div class="item">
					<img src="images/cast.jpg" alt="3 slide">
				</div>
				<div class="item">
					<img src="images/cast.jpg" alt="4 slide">
				</div>
			</div>
			<a class="left carousel-control" href="#ad-carousel"
				data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#ad-carousel"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
