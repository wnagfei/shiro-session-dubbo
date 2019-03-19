<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="msapplication-TileColor" content="#5bc0de" />
<meta name="msapplication-TileImage" content="images/metis-tile.png" />

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.min.css">

<!-- Metis core stylesheet -->
<link rel="stylesheet" href="css/main.css">
<style>
html,body {
	margin: 0px;
	height: 100%;
}
</style>
</head>
<body class="login">
	<div class="form-signin">
		<div class="text-center">
			<h2>图书馆座位预约系统</h2>
		</div>
		<hr>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="login_action" method="post"
					onsubmit="return validata(this);">
					<p class="text-muted text-center">输入用户名与密码</p>
					<input id="usr" type="text" name="usr" placeholder="用户名"
						class="form-control top"> <input id="pwd" type="password"
						name="pwd" placeholder="密码" class="form-control bottom">
					<div class="text-center">
						<label><input type="radio" name="identity" value="user"
							checked="checked" />用户身份</label> <label><input type="radio"
							name="identity" value="admin" />管理身份</label>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox"> 记住我 </label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
				</form>
			</div>
			<div id="forgot" class="tab-pane">
				<form action="index.html">
					<p class="text-muted text-center">输入你的邮箱</p>
					<input type="email" placeholder="mail@domain.com"
						class="form-control"> <br>
					<button class="btn btn-lg btn-danger btn-block" type="submit">找回密码</button>
				</form>
			</div>
		</div>
		<hr>
		<div class="text-center">
			<ul class="list-inline">
				<li><a class="text-muted" href="#login" data-toggle="tab">登录系统</a>
				</li>
				<li><a class="text-muted" href="#forgot" data-toggle="tab">忘记密码</a>
				</li>
			</ul>
		</div>
	</div>

	<!--jQuery -->
	<script src="js/jquery.min.js"></script>

	<!--Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
      (function($) {
        $(document).ready(function() {
          $('.list-inline li > a').click(function() {
            var activeForm = $(this).attr('href') + ' > form';
            //console.log(activeForm);
            $(activeForm).addClass('animated fadeIn');
            //set timer to 1 seconds, after that, unload the animate animation
            setTimeout(function() {
              $(activeForm).removeClass('animated fadeIn');
            }, 1000);
          });
        });
      })(jQuery);
      
      
      function validata(form) {
  		form = $(form);
  		var usr = form.find('#usr').val();
  		var pwd = form.find('#pwd').val();

  		if( usr == '' ) {
  			alert("用户名不能为空");
  			form.find('#usr').focus();
  			return false;
  			}
  		
  		if( pwd == '') {
  			alert("密码不能为空");
  			form.find('#pwd').focus();
  			return false;
  			}
  			
  		return true;
  		}
    </script>
</body>
</html>