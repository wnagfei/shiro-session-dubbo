<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Userinfo"%>
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
    
    <title>长期座位申请</title>
    
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/background.css">

  </head>
  
  <body>
  <div class="container">
  <div class="row">
  <div class="col-md-6 col-md-offset-3">
  	<h3 class="text-center">长期座位申请</h3>
    <form action="insert_longtermapply" method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="userId">申请人学号: </label>
				<input type="text" name="longtermapplyinfo.userId" value="<%=userName %>"
					readonly="readonly" maxlength="9" id="userId" class="form-control" />
			</div>
		</div><br/>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="seatId">申请座位编号: </label>
				<s:textfield name="longtermapplyinfo.seatId" maxlength="2" id="seatId" cssClass="form-control" />
			</div>
		</div><br/>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="time">申请时长: </label>
				<s:textfield name="longtermapplyinfo.time" maxlength="4" id="time" cssClass="form-control" />
			</div>
		</div><br/>
		<div id="submiter" class="control-group">
			<div class="controls text-center">
				<input type="submit" value="提交申请 " class="btn btn-primary" />
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
  		var userId = form.find('#userId').val();
  		var seatId = form.find('#seatId').val();
  		var time = form.find('#time').val();

  		if( userId == ''||!isNum(userId)) {
  			alert("申请人学号必须为数字");
  			form.find('#userId').focus();
  			return false;
  		}	
  		
		if( seatId == ''||!isNum(seatId)) {
  			alert("座位编号必须为数字");
  			form.find('#seatId').focus();
  			return false;
  		}
  		
  		if( time == ''||!isNum(time)) {
  			alert("申请时长必须为数字");
  			form.find('#time').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
