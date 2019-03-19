<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Seatinfo"%>
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
    
    <title>空座位信息</title>
    
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
  <div class="col-md-6 col-md-offset-3">
    <h3 class="text-center">
				空座位详情列表
			</h3>
			<table class="table table-hover table-bordered table-striped text-center">
				<thead>
					<tr>
						<th class="text-center">
							座位编号
						</th>
						<th class="text-center">
							位置
						</th>
						<th class="text-center">
							预约
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="emptySeatList" var="seat" status="st">
				    
					<tr>
						<td><s:property value="#seat.seatId"/></td>
						<td><s:property value="#seat.location"/></td>
						<td><a href="order_seat_from_empty?seatId=<s:property value="#seat.seatId"/>" class="btn btn-primary">预约</a></td>			
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
			</div>
			</div>
			</div>
  </body>
</html>
