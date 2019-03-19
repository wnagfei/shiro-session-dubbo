<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Seatinfo"%>
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
    
    <title>修改座位信息</title>
    
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
				修改座位信息
			</h3>
			<form action="update_seat" method="post" id="userForm"
			 class="form-horizontal">
				
					<div class="control-group">
						<label class="control-label" for="seatId">
							座位号：
						</label>
						<div class="controls">
							<input type="text" name="seatinfo.seatId" value="<s:property value="seatinfo.seatId"/>"
								 readonly="readonly" maxlength="3" id="seatId" class="form-control" />
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="location">
							位置：
						</label>
						<div class="controls">
							<input type="text" name="seatinfo.location" value="<s:property value="seatinfo.location"/>"
								maxlength="19" id="location" class="form-control" />
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="isOrder">
							是否可预约：
						</label>
						<div class="controls">
							<select name="seatinfo.isOrder" id="isOrder" class="form-control">
								<s:if test="seatinfo.isOrder =='yes'">
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
								
								<option value="yes" <%=select_yes %>>
									是
								</option>
								<option value="no" <%=select_no %>>
									否
								</option>
							</select>
						</div>
					</div> 
					<div class="control-group">
						<label class="control-label" for="isUsed">
							是否可用：
						</label>
						<div class="controls">
							<select name="seatinfo.isUsed" id="isUsed" class="form-control">
							<s:if test="seatinfo.isUsed =='yes'">
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
								<option value="yes" <%=select_yes %>>
									是
								</option>
								<option value="no" <%=select_no %>>
									否
								</option>
							</select>
						</div>
					</div> 
					<div><input type="submit" class="btn btn-primary" value="修改"></div>
			
			</form>
			</div>
			</div>
			</div>
  </body>
</html>
