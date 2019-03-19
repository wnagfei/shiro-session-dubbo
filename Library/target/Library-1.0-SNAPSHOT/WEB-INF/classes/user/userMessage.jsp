<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Userinfo"%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/background.css">

  </head>
  
  <body>
  <div class="container">
  <div class="row">
  <div class="col-md-6 col-md-offset-3">
    <h3 class="text-center">
				个人信息
			</h3>
			<table class="table table-hover table-bordered table-striped text-center">
				<tbody>
					<s:iterator value="userinfoList" var="user" status="st">
					<tr>
						<th>学号</th>
						<td><s:property value="#user.userId"/></td>
					</tr>
					<tr>
						<th>姓名</th>
						<td><s:property value="#user.userName"/></td>
					</tr>
					<tr>
						<th>性别</th>
						<td>
							<s:if test="#user.userSex == 'male'">
								男
							</s:if>
							<s:else>
								女
							</s:else>
						</td>
					<tr>
						<th>联系方式</th>
						<td><s:property value="#user.phoneNum"/></td>
					</tr>
					<tr>
						<th>电子邮箱</th>
						<td><s:property value="#user.email"/></td>
					</tr>
					<tr>
						<th>学院</th>
						<td><s:property value="#user.scademyName"/></td>					
					</tr>
					<tr>
						<th>专业</th>
						<td><s:property value="#user.majorName"/></td>
					</tr>
					<tr>
						<th>好友帐号</th>
						<td><s:property value="#user.friendId"/></td>
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
			<div style="margin:0 auto;width:60%;">
				<a href="show_user_message_before_delete?userId=<s:property value="#user.userId"/>" class="btn btn-primary">修改信息</a>
				<a href="user/setFriend.jsp" class="btn btn-default">设置好友</a>
				<a href="user/updatePassword.jsp" class="btn btn-default">修改密码</a>
			</div>
			</div>
			</div>
			</div>
  </body>
</html>
