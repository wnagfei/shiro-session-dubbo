<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Historyinfo"%>
<%@ page import="com.domain.Userinfo" %>
<%@page import="java.text.DecimalFormat"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
Integer userName=((Userinfo)session.getAttribute("userinfo")).getUserId();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>预约历史记录</title>
    
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
				预约历史记录
			</h3>
	<form action="delete_all_historys" method="post">
		<input name="userId" value="<%=userName %>" type="hidden">
		<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return confirm_delete();">删除所有记录</button>
	</form>
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<th>编号</th>
						<th>预约座位编号</th>
						<th>座位位置</th>
						<th>预约时间</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="historyList" var="history" status="st">
				    
					<tr>
						<td><s:property value="#history.id"/></td>
						<td><s:property value="#history.select"/></td>
						<td><s:property value="#history.location"/></td>
						<td><s:property value="#history.date"/></td>
						<form action="delete_history?id=<s:property value="#history.id"/>" method="post">
							<td><input class="btn btn-danger btn-sm" type="submit" value="删除" onclick="return confirm_delete();"></td>
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
