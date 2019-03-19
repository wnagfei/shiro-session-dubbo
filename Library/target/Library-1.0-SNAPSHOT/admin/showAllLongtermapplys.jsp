<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Longtermapplyinfo" %>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>长期座位申请信息</title>
    
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
  <div class="row" style="margin-bottom:15px;">
    <h3 class="text-center">长期座位申请信息列表</h3>
    <div>
    	<form class="form-horizontal" role="form" action="search_longtermapplyinfo" 
    		onsubmit="return validata(this);" method="post">
    		<label class="col-sm-3 control-label">输入要查询的申请者学号：</label>
    		<div class="col-sm-7">
    		<input id="userId" type="text" name="userId" class="form-control top">
    		</div>
    		<div class="col-sm-2">
    		<button class="btn btn-primary btn-block" type="submit">查询</button>
    		</div>
    	</form>
    </div>
    
    </div>
    <div class="row">
    <table class="table table-hover table-bordered table-striped text-center">
    	<thead>
    		<th width="10%" class="text-center">编号</th>
    		<th width="15%" class="text-center">申请者学号</th>
    		<th width="25%" class="text-center">申请座位</th>
    		<th width="30%" class="text-center">申请时长</th>
    		<th></th>
    	</thead>
    	<tbody>
    		<s:iterator value="longtermapplyList" var="longtermapply" status="st">
    		<tr>
    			<td><s:property value="#longtermapply.id"/></td>
    			<td><s:property value="#longtermapply.userId"/></td>
    			<td><s:property value="#longtermapply.seatId"/></td>
    			<td><s:property value="#longtermapply.time"/></td>
    			<td>
    				<s:if test="#longtermapply.isAgree == 'yes'">
    					<button class="btn btn-primary" disabled="disabled" type="button">已同意</button>
    				</s:if>
    				<s:else>
    					<a href="check_longtermapply?id=<s:property value="#longtermapply.id"/>" class="btn btn-primary">同意</a>
    				</s:else>
    				
    				<a href="delete_longtermapply?id=<s:property value="#longtermapply.id"/>&seatId=<s:property value="#longtermapply.seatId"/>" 
    					class="btn btn-danger" onclick="return confirm_delete();">删除</a>
    			</td>
    			</tr>
    		</s:iterator>
    	</tbody>
    </table>
    </div>
    </div>
    <script src="js/jquery.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
  	function validata(form) {
  		form = $(form);
  		var userId = form.find('#userId').val();
  		
  		if(! isNum(userId) || userId == '') {
  			alert("学号必须为数字");
  			form.find('#userId').focus();
  			return false;
  		}

  		return true;
  	}
  
  </script>
  </body>
</html>
