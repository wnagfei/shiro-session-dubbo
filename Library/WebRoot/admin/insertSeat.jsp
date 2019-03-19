<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加座位信息</title>
    
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
  	<h3 class="text-center">添加座位信息</h3>
    <form action="insert_seat_message" method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="seatId">座位编号: </label>
				<s:textfield name="seatinfo.seatId" maxlength="3" id="seatId" cssClass="form-control" />
			</div>
		</div><br/>
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="location">位置: </label>
				<s:textfield name="seatinfo.location" maxlength="19" id="location" cssClass="form-control" />
			</div>
		</div><br/>
		<div id="submiter" class="control-group">
			<div class="controls text-center">
				<input type="submit" value="添加 " style="width:100px" class="btn btn-primary" />
			</div>
		</div>
    </form>
  </div>
  </div>
  </div>
  <script src="js/jquery.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var seatId = form.find('#seatId').val();
  		var location = form.find('#location').val();
  		
  		if(! isNum(seatId) || seatId == '') {
  			alert("学号必须为数字");
  			form.find('#seatId').focus();
  			return false;
  		}
  		
  		if(location == '') {
  			alert("位置不能为空");
  			form.find('#location').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
