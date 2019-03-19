<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Majorinfo"%>
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
    
    <title>专业信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/background.css">


  </head>
  
  <body>
  <div class="container">
  <div class="row">
    <h3 class="text-center">
				专业详情列表
			</h3>
			<table class="table table-hover table-bordered table-striped text-center">
				<thead>
					<tr>
						<th class="text-center">专业代号</th>
						<th class="text-center">专业名称</th>
						<th class="text-center">所属学院代号</th>
						<th class="text-center">所属学院名称</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="majorinfoList" var="major" status="st">
				    
					<tr>
						<td><s:property value="#major.majorCode"/></td>
						<td><s:property value="#major.majorName"/></td>
						<td><s:property value="#major.scademyCode"/></td>
						<td><s:property value="#major.scademyName"/></td>
						<form action="delete_major?majorCode=<s:property value="#major.majorCode"/>" method="post">
						<td><input type="submit" class="btn btn-danger btn-sm" value="删除" onclick="return confirm_delete();"></td>	
						</form>		
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
	</div>
	</div>
	<script type="text/javascript" src="js/common.js"></script>
  </body>
</html>
