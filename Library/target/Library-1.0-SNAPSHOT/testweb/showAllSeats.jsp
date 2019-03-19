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
    
    <title>座位信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">


  </head>
  
  <body>
    <h3 class="text-center">
				座位详情列表
			</h3>
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<th>
							座位编号
						</th>
						<th>
							位置
						</th>
						<th>
							是否可预约
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="seatList" var="seat" status="st">
				    
					<tr>
						<td><s:property value="#seat.seatId"/></td>
						<td><s:property value="#seat.location"/></td>
						<td><s:property value="#seat.isOrder"/></td>			
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
  </body>
</html>
