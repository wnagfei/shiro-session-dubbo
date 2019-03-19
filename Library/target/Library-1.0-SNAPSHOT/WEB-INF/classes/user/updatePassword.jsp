<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Userinfo" %>
<%
	Integer userName=((Userinfo)session.getAttribute("userinfo")).getUserId();
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>修改密码</title>

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
				<h3 class="text-center">修改密码</h3>
				<div>
					<form action="update_userPw?userId=<%=userName %>" method="post" 
						onsubmit="return validata(this);">
						<p>输入原密码：</p>
						<input type="password" name="userPw" id="userPw" maxlength="19" class="form-control top"><br/>
						<p>输入新密码：</p>
						<input type="password" name="userPwNew" id="userPwNew" maxlength="19" class="form-control top"><br/>
						<p>重复新密码：</p>
						<input type="password" name="userPwNewConfirm" id="userPwNewConfirm" maxlength="19" class="form-control top"><br/>
						<button class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var userPw = form.find('#userPw').val();
  		var userPwNew = form.find('#userPwNew').val();
  		var userPwNewConfirm = form.find('#userPwNewConfirm').val();

  		if( userPw == '') {
  			alert("原密码不能为空");
  			form.find('#userPw').focus();
  			return false;
  		}	
  		
  		if( userPwNew == '') {
  			alert("新密码不能为空");
  			form.find('#userPwNew').focus();
  			return false;
  		}
  		
  		if( userPwNewConfirm == '') {
  			alert("请重新输入新密码");
  			form.find('#userPwNewConfirm').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
</body>
</html>
