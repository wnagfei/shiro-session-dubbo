<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Userinfo" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
Integer userName=((Userinfo)session.getAttribute("userinfo")).getUserId();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>座位预约</title>
    
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
  	<h3 class="text-center">座位预约</h3>
    <form class="form-horizontal" role="form" action="order_seat?userId=<%=userName %>" 
    	method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">
			<div class="controls">
				<label class="col-sm-3 control-label" for="seatId">座位编号: </label>
				<div class="col-sm-7">
					<s:textfield name="orderinfo.seatId" maxlength="3" id="seatId" cssClass="form-control" />
				</div>
				<div id="submiter" class="control-group">
					<div class="controls col-sm-2">
						<input type="submit" value="预约 " class="btn btn-primary" />
					</div>
				</div>
			</div>
		</div><br/>
		
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
