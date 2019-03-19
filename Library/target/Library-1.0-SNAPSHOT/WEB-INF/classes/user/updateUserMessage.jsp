<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Userinfo"%>
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
    
    <title>个人信息</title>
    
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
				个人信息
			</h3>
			<form action="update_user_by_yourself" method="post" id="userForm"
			 class="form-horizontal" onsubmit="return validata(this);">
				<s:iterator value="userinfoList" var="user" status="st">
					<div class="control-group">
						<label class="control-label" for="userId">
							学号：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.userId" value="<s:property value="#user.userId"/>"
								readonly="readonly" maxlength="18" id="userId" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="userinfo.userPw" value="<s:property value="#user.userPw"/>"
								readonly="readonly" maxlength="18" id="userPw" class="form-control" />
						</div>
					</div>  
					<div class="control-group">
						<label class="control-label" for="userName">
							姓名：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.userName" value="<s:property value="#user.userName"/>"
								readonly="readonly" maxlength="18" id="userName" class="form-control" />
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="userSex">
							性别：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.userSex" value="<s:property value="#user.userSex"/>"
								readonly="readonly" maxlength="18" id="userSex" class="form-control" />
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="scademyName">
							学院：
						</label>
						<div class="controls">
							<input type="text"  value="<s:property value="#user.scademyName"/>"
								readonly="readonly" maxlength="18" id="scademyName"  class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="userinfo.majorCode" value="<s:property value="#user.majorCode"/>"
								readonly="readonly" maxlength="18" id="majorCode" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="majorName">
							专业：
						</label>
						<div class="controls">
							<input type="text"  value="<s:property value="#user.majorName"/>"
								readonly="readonly" maxlength="18" id="majorName" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="friendId">
							好友帐号：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.friendId" value="<s:property value="#user.friendId"/>"
								readonly="readonly" maxlength="18" id="friendId" class="form-control" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="phoneNum">
							联系方式：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.phoneNum" value="<s:property value="#user.phoneNum"/>"
								maxlength="11" id="phoneNum" class="form-control" />
							<%-- <s:textfield name="userinfo.phoneNum" maxlength="30" value="<s:property value="#user.phoneNum"/>"
									id="phoneNum" cssClass="form-control" /> --%>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">
							电子邮箱：
						</label>
						<div class="controls">
							<input type="text" name="userinfo.email" value="<s:property value="#user.email"/>"
								maxlength="29" id="email" class="form-control" />
							<%-- <s:textfield name="userinfo.email" maxlength="30" value="<s:property value="#user.email"/>"
									id="email" cssClass="form-control" /> --%>
						</div>
					</div>
					<div><input type="submit" class="btn btn-primary" value="修改"></div>
				</s:iterator>
			</form>
			</div>
			</div>
			</div>
			<script src="js/jquery.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var phoneNum = form.find('#phoneNum').val();
  		var email = form.find('#email').val();

  		if( phoneNum != '' && !isPhoneNum(phoneNum) ) {
  			alert("请输入正确的手机号");
  			form.find('#phoneNum').focus();
  			return false;
  		}
  		
  		if( email != '' && !isEmail(email) ) {
  			alert("请输入正确的邮箱");
  			form.find('#email').focus();
  			return false;
  		}
	

  		return true;
  	}
  
  </script>
  </body>
</html>
