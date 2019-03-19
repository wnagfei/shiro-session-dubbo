<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 公告模块 -->
    <a>发布公告</a><br/>
    <a href="show_all_notices" target="contentFrame">查看所有公告</a><br/>
    <a href="show_notice?id=1" target="contentFrame">查看一个公告</a><br/>
    <a>删除公告</a><br/><br/>
    
    <!-- 座位信息模块 -->
    <a>添加座位</a><br/>
    <a href="show_all_seats" target="contentFrame">查看所有座位信息</a><br/>
    <a>查询座位</a><br/>
    <a>修改座位信息</a><br/>
    <a>删除座位信息</a><br/><br/>
    
    <!-- 管理员模块 -->
    <a>修改信息</a><br/>
    <a>添加用户</a><br/>
    <a>删除用户</a><br/>
    <a href="show_all_users" target="contentFrame">查看所有用户信息</a><br/><br/>
    
    <!-- 用户信息模块 -->
    <a href="show_user_message?username=221200001" target="contentFrame">查看个人信息</a><br/>
    <a>修改个人信息</a><br/>
    <a>设置抢座好友</a><br/><br/>
    
    <!-- 长期座位信息模块 -->
    <a>长期座位申请</a><br/>
    <a>查看申请信息</a><br/>
    <a>删除长期申请信息</a><br/><br/>
    
    <!-- 座位预约模块 -->
    <a>座位预约</a><br/>
    <a href="show_empty_seat" target="contentFrame">空座位查询</a><br/>
    <a>查看预约情况</a><br/>
    <a>好友预约</a><br/><br/>
    
    <!-- 历史记录模块 -->
    <a>查看历史记录</a><br/>
    <a>删除历史记录</a><br/><br/>
    
  </body>
</html>
