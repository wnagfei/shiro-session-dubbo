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
				座位详情列表
			</h3>
			<div>
				<p>输入要查询的座位编号</p>
				<form action="show_seat_message" method="post">
					<input type="text" name="seatId" class="form-control top">
					<button class="btn btn-lg btn-primary btn-block" type="submit">查询</button>
				</form>
			</div>
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<th>座位编号</th>
						<th>位置</th>
						<th>是否可预约</th>
						<th>预约者</th>
						<th>联系方式</th>
						<th>专业</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="seatMessage" var="seat" status="st">
				    
					<tr>
						<td><s:property value="#seat.seatId"/></td>
						<td><s:property value="#seat.location"/></td>
						<td>
						<s:if test="#seat.isOrder == 'no'">
							不可预约
						</s:if>
						<s:elseif test="#seat.isOrder == 'yes'">
							可预约
						</s:elseif>
						</td>
						<td><s:property value="#seat.userName"/></td>
						<td><s:property value="#seat.phoneNum"/></td>
						<td><s:property value="#seat.majorName"/></td>	
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
	</div>
	</div>
	</div>
  </body>
</html>
