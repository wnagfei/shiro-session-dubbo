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
    
    <title>添加用户信息</title>
    
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
  	<h3 class="text-center">添加用户信息</h3>
    <form action="insert_user_message" method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="userId">学号: </label>
				<s:textfield name="userinfo.userId" maxlength="9" id="userId" cssClass="form-control" />
			</div>
		</div><br/>
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="userName">姓名: </label>
				<s:textfield name="userinfo.userName" maxlength="19" id="userName" cssClass="form-control" />
			</div>
		</div><br/>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="userSex">性别: </label>
				<div class="controls">
					<select name="userinfo.userSex" id="userSex" class="form-control">
						<option value="male">
							男
						</option>
						<option value="female">
							女
						</option>
					</select>
				</div>
			</div>
		</div><br/>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="majorCode">专业代码: </label>
				<s:textfield name="userinfo.majorCode" maxlength="2" id="majorCode" cssClass="form-control" />
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
  		var userId = form.find('#userId').val();
  		var userName = form.find('#userName').val();
  		var majorCode = form.find('#majorCode').val();
  		
  		if(! isNum(userId) || userId == '') {
  			alert("学号必须为数字");
  			form.find('#userId').focus();
  			return false;
  		}
  		
  		if(! isChinese(userName) || userName == '') {
  			alert("姓名必须为汉字");
  			form.find('#userName').focus();
  			return false;
  		}
  		
  		if(! isNum(majorCode) || majorCode == '') {
  			alert("专业代码必须为数字");
  			form.find('#majorCode').focus();
  			return false;
  		}
  		return true;
  	}
  
  </script>
  </body>
</html>
