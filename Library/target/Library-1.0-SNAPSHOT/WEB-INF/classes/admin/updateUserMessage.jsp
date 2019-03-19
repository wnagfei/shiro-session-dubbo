<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Userinfo"%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String select_yes = "";
String select_no = "";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户信息</title>
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
				修改用户信息
			</h3>
			<form action="update_user_by_admin" method="post" id="userForm"
			 class="form-horizontal" onsubmit="return validata(this);">
				
					<div class="control-group">
						<label class="control-label" for="userId">
							学号：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.userId" value="<s:property value="userinfo.userId"/>"
								 readonly="readonly" maxlength="9" id="userId" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="userinfo.userPw" value="<s:property value="userinfo.userPw"/>"
								readonly="readonly" maxlength="18" id="userPw" class="form-control" />
						</div>
					</div>  
					<div class="control-group">
						<label class="control-label" for="userName">
							姓名：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.userName" value="<s:property value="userinfo.userName"/>"
								maxlength="19" id="userName" class="form-control" />
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="userSex">
							性别：
						</label>
						<div class="controls">
							<select name="userinfo.userSex" id="userSex" class="form-control">
								<s:if test="userinfo.userSex =='male'">
									<% 
									select_yes = "selected=\"selected\"";
									select_no = "";
									%>
								</s:if>
								<s:else>
								<% 
									select_yes = "";
									select_no = "selected=\"selected\"";
								%>
								</s:else>
								<option value="male" <%=select_yes %>>
									男
								</option>
								<option value="female" <%=select_no %>>
									女
								</option>
							</select>
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="majorCode">
							专业代码：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.majorCode" value="<s:property value="userinfo.majorCode"/>" 
								maxlength="2" id="majorCode" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="friendId">
							好友帐号：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.friendId" value="<s:property value="userinfo.friendId"/>"
								readonly="readonly" maxlength="18" id="friendId" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="phoneNum">
							联系方式：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.phoneNum" value="<s:property value="userinfo.phoneNum"/>" 
								readonly="readonly" maxlength="18" id="phoneNum" Class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">
							电子邮箱：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.email" value="<s:property value="userinfo.email"/>" 
								readonly="readonly" maxlength="18" id="email" Class="form-control" />
						</div>
					</div>
					<div><input type="submit" class="btn btn-primary" value="修改"></div>
			
			</form>
			</div>
			</div>
			</div>
			<script src="js/jquery.min.js"></script>
  			<script src="js/common.js"></script>
  			<script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var userName = form.find('#userName').val();
  		var majorCode = form.find('#majorCode').val();
  		
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
