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
    
    <title>添加学院信息</title>
    
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
  	<h3 class="text-center">添加学院信息</h3>
    <form action="insert_scademy_message" method="post" id="form" onsubmit="return validata(this);">
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="scademyCode">学院编号: </label>
				<s:textfield name="scademyinfo.scademyCode" maxlength="2" id="scademyCode" cssClass="form-control" />
			</div>
		</div><br/>
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="scademyName">学院名称: </label>
				<s:textfield name="scademyinfo.scademyName" maxlength="19" id="scademyName" cssClass="form-control" />
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
  		var scademyCode = form.find('#scademyCode').val();
  		var scademyName = form.find('#scademyName').val();
  		
  		if(! isNum(scademyCode) || scademyCode == '') {
  			alert("学院代码必须为数字");
  			form.find('#scademyCode').focus();
  			return false;
  		}
  		
  		if(! isChinese(scademyName) || scademyName == '') {
  			alert("学院名称必须为汉字");
  			form.find('#scademyName').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
