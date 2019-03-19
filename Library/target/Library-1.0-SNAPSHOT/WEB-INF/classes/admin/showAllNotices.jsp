<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.domain.Noticeinfo"%>
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
    
    <title>公告信息</title>
    
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
    <h3 class="text-center">
				公告列表
			</h3>
			<table class="table table-hover table-bordered table-striped">
				<thead>
					<tr>
						<!-- <th class="text-center">编号</th> -->
						<th class="text-center">标题</th>
						<th class="text-center">副标题</th>
						<!-- <th class="text-center">内容</th>
						<th class="text-center">附件</th> -->
						<th class="text-center">发布日期</th>
						<th class="text-center">作者</th>
						<th class="text-center">查看详情</th>
						<th class="text-center">删除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="noticeList" var="notice" status="st">
				    
					<tr>
						<%-- <td class="text-center"><s:property value="#notice.id"/></td> --%>
						<td class="short_content"><s:property value="#notice.title"/></td>
						<td class="short_content"><s:property value="#notice.amallTitle"/></td>
						<%-- <td class="short_content"><s:property value="#notice.contents"/></td>
						<td><s:property value="#notice.accessory"/></td> --%>
						<td class="text-center"><s:property value="#notice.date"/></td>
						<td class="text-center"><s:property value="#notice.author"/></td>
						<td class="text-center">
							<a href="show_notice?id=<s:property value="#notice.id"/>" 
								type="submit" class="btn btn-success">查看</a>
						</td>
						<td>
							<a href="delete_notice?id=<s:property value="#notice.id"/>" 
								type="submit" class="btn btn-danger btn-sm" onclick="return confirm_delete();">删除</a>
						</td>				
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
	</div>
	</div>
	
	<!--jQuery -->
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/common.js"></script>
    <script type="text/javascript">
    short_content(10);
    </script>
  </body>
</html>
