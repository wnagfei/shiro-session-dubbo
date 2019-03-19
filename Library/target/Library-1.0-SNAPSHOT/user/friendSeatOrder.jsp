<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Userinfo" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
Integer friendId=((Userinfo)session.getAttribute("userinfo")).getFriendId();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>好友座位预约</title>
    
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
  	<h3 class="text-center">好友座位预约</h3>
    <form action="order_seat?userId=<%=friendId %>" method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">
			<div class="controls">
				<label class="control-label col-sm-3" for="seatId">输入要预约的座位编号: </label>
				<div class="col-sm-6">
					<s:textfield name="orderinfo.seatId" maxlength="3" id="seatId" cssClass="form-control" />
				</div>
				<div id="submiter" class="control-group col-sm-1">
					<input type="submit" value="预约 " class="btn btn-primary" />
				</div>
				<div class="control-group clo-sm-2">
					<a href="order_by_one_button?userId=<%=friendId %>" class="btn btn-success">一键预约</a>
				</div>
			</div>
		</div>
		
    </form>
    
  </div>
  </div>
  <script src="js/jquery.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var seatId = form.find('#seatId').val();

  		if( seatId == '') {
  			alert("座位编号不能为空");
  			form.find('#seatId').focus();
  			return false;
  		}	
  		
  		if( !isNum(seatId)) {
  			alert("座位编号必须为数字");
  			form.find('#seatId').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
