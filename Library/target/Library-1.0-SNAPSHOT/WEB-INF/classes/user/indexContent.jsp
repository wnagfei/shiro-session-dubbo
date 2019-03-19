<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Noticeinfo"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>学生首页</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/background.css">
	<style type="text/css">
		.opacity {
			opacity: 0.5;
		}
		.list-group-item {
			background:rgba(255, 255, 255, 0.05) none repeat scroll 0 0;
		}
		.panel {
		background:rgba(0, 0, 0, 0);
		}
	</style>
  </head>
  
  <body>
    <div class="container" style="margin-top:15px;width:100%;">
    	<div class="row">
    		<div class="col-md-9">
    		</div>
    		<div class="col-md-3">
    			<div class="panel panel-primary">
				    <div class="panel-heading">公告</div>
				    <s:iterator value="noticeList" var="item" status="st">
						<li class="list-group-item"><a href="show_notice?id=<s:property value="#item.id"/>" class="short_content" data-toggle="tooltip" title="<s:property value="#item.title"/>">
							<s:property value="#item.title"/>
						</a></li>
					</s:iterator>
				</div>
    		</div>
    	</div>
    </div>
    
    
    <!--jQuery -->
    <script src="js/jquery.min.js"></script>
    <!--Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/common.js"></script>
    <script type="text/javascript">
    short_content(14);
    $(function () { $("[data-toggle='tooltip']").tooltip(); });
    </script>
  </body>
</html>
