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
  <div class="row" style="margin-bottom:15px;">
    <h3 class="text-center">
				座位详情列表
			</h3>
			<div>
				<form action="show_seat" method="post" class="form-horizontal" role="form" onsubmit="return validata(this);">
				<label class="col-sm-4 control-label">输入要查询的座位编号：</label>
				<div class="col-sm-6">
					<input type="text" maxlength="3" name="seatId" id="seatId" class="form-control top">
				</div>
				<div class="col-sm-2">
					<button class="btn btn-primary btn-block" type="submit">查询</button>
				</div>
				</form>
			</div>
			</div>
			<div class="row">
			<table class="table table-hover table-bordered table-striped text-center">
				<thead>
					<tr>
						<th width="15%" class="text-center">座位编号</th>
						<th width="35%" class="text-center">位置</th>
						<th width="15%" class="text-center">是否可预约</th>
						<th width="15%" class="text-center">是否可用</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="seatList" var="seat" status="st">
				    
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
						<td>
						<s:if test="#seat.isUsed == 'no'">
							不可用
						</s:if>
						<s:elseif test="#seat.isUsed == 'yes'">
							可用
						</s:elseif>
						</td>
						<td>
							<a href="show_seat_before_update?seatId=<s:property value="#seat.seatId"/>" 
								class="btn btn-primary btn-sm" type="submit" >修改</a>
							<a href="delete_seat?seatId=<s:property value="#seat.seatId"/>" 
								class="btn btn-danger btn-sm" type="submit" onclick="return confirm_delete();">删除</a>
						</td>	
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
	</div>
	</div>
	</div>
	<script src="js/jquery.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var seatId = form.find('#seatId').val();
  		
  		if(seatId == '') {
  			alert("学号不能为空");
  			form.find('#seatId').focus();
  			return false;
  		}
  		
  		if(! isNum(seatId)) {
  			alert("学号必须为数字");
  			form.find('#seatId').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
