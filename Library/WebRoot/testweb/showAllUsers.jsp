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
    
    <title>用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">


  </head>
  
  <body>
    <h3 class="text-center">
				用户详情列表
			</h3>
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<th>
							1
						</th>
						<th>
							2
						</th>
						<th>
							3
						</th>
						<th>
							4
						</th>
						<th>
							5
						</th>
						<th>
							6
						</th>
						<th>
							7
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="userList" var="user" status="st">
				    
					<tr>
						<td><s:property value="#user.userId"/></td>
						<td><s:property value="#user.userPw"/></td>
						<td><s:property value="#user.userName"/></td>
						<td><s:property value="#user.userSex"/></td>
						<td><s:property value="#user.majorCode"/></td>
						<td><s:property value="#user.phoneNum"/></td>
						<td><s:property value="#user.email"/></td>				
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
  </body>
</html>
