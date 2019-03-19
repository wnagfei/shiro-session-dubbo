<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Noticeinfo" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告详情</title>
    
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/background.css">

  </head>
  
  <body>
  	<div class="container">
  		<div style="margin-top: 15px;" class="panel panel-info">
                <div style="padding-top: 1px; padding-bottom: 1px;" class="panel-heading text-center">
                <h3><s:property value="noticeinfo.title"/><small><s:property value="noticeinfo.amallTitle"/></small></h3>
                </div><!--文章标题-->
                <div class="panel-body">
                	<s:property value="noticeinfo.contents" escape="false" />
                	
                	
                	<p>
                	<s:if test="noticeinfo.accessory != null || ''.equals(noticeinfo.accessory)">
                		附件：
                		<a href="<%=basePath %>upload/<s:property value="noticeinfo.accessory"/>"><s:property value="noticeinfo.accessory"/></a>
                	</s:if>
                	</p>
				</div>
                <div class="panel-footer text-right"><br>
                    <p>发布人：<s:property value="noticeinfo.author"/></p>
                    <p>日期：<s:property value="noticeinfo.date"/></p>
                </div>
              </div>
  	</div>
  </body>
</html>
