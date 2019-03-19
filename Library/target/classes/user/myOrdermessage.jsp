<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Orderinfo" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>预约情况</title>
    
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
  		<h3 class="text-center">我的预约情况</h3>
  		<table class="table table-hover table-bordered table-striped text-center">
  			<tbody>
  			<s:iterator value="myOrderinfo" var="myOrder" status="st">
  			<tr>
  				<th>座位编号</th>
  				<td><s:property value="#myOrder.seatId"/></td>
  			</tr>
  			<tr>
  				<th>位置</th>
  				<td><s:property value="#myOrder.location"/></td>
  			</tr>
  			</s:iterator>
  			</tbody>
  		</table>
  		<div style="margin:0 auto;width:25%;">
  			<a href="delete_order?id=<s:property value="#myOrder.id"/>&seatId=<s:property value="#myOrder.seatId"/>" 
  				class="btn btn-primary">取消预约</a>
  		</div>
  	</div>
  	</div>
  	</div>
  </body>
</html>
