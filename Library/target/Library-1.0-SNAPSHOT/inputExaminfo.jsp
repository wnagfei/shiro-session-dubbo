<%@ page language="java" import="java.util.*,com.domain.*"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>考试申请</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

</head>

<body>

	<form action="create_examinfo" method="post" id="form"
		onsubmit="validata()">
		<div>
			<legend>
				<span> 考试申请 </span>
			</legend>
		</div>
		<div class="control-group">
			<label class="control-label" for="idcardno"> 主键： </label>
			<div class="controls">
				<s:textfield name="examinfo.id" maxlength="18" id="idcardno" />
				<%-- 					<input type="text" name="IDCardNo" value="<s:property value='client.IDCardNO'/>"
						readonly="readonly" maxlength="18" id="idcardno" /> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="idcardno"> 课程编号： </label>
			<div class="controls">
				<s:textfield name="examinfo.courseId" maxlength="18" id="idcardno" />
				<%-- 					<input type="text" name="IDCardNo" value="<s:property value='client.IDCardNO'/>"
						readonly="readonly" maxlength="18" id="idcardno" /> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="clientname"> 教师工号： </label>
			<div class="controls">
				<s:textfield name="examinfo.teacId" maxlength="30" id="clientname" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="clientphone">学年学期: </label>
			<div class="controls">
				<s:textfield name="examinfo.xnxq" maxlength="20"
					id="clientphone" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="clientaddress"> 考试时间: </label>
			<div class="controls">
				<s:textfield name="examinfo.time" maxlength="20"
					id="clientaddress" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="clientaddress"> 考试地点: </label>
			<div class="controls">
				<s:textfield name="examinfo.place" maxlength="20"
					id="clientaddress" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="clientaddress"> 备注: </label>
			<div class="controls">
				<s:textfield name="examinfo.bak" maxlength="20"
					id="clientaddress" />
			</div>
		</div>
		<div id="submiter" class="control-group">
			<div class="controls">
				<input type="submit" value="提交申请 " class="btn btn-primary" />
			</div>
		</div>
		
	</form>
</body>
</html>
