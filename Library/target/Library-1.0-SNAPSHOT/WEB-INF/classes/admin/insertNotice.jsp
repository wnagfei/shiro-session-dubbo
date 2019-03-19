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
    
    <title>添加公告信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/summernote.css">
	<link rel="stylesheet" href="css/background.css">

  </head>
  
  <body>
  <div class="container">
  <div class="row">
  	<h3 class="text-center">添加公告信息</h3>
    <form action="insert_notice_message" method="post" id="form" onsubmit="return validata(this);" enctype="multipart/form-data">
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="title">标题: </label>
				<s:textfield name="noticeinfo.title" maxlength="19" id="title" cssClass="form-control" />
			</div>
		</div>
		<div class="control-group">			
			<div class="controls">
				<label class="control-label" for="amallTitle">副标题: </label>
				<s:textfield name="noticeinfo.amallTitle" maxlength="19" id="amallTitle" cssClass="form-control" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="author">作者: </label>
				<s:textfield name="noticeinfo.author" maxlength="19" id="author" cssClass="form-control" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="accessory">附件: </label>
				<input name="file" id="accessory" class="form-control" type="file" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="control-label" for="contents">内容: </label>
				<s:textarea name="noticeinfo.contents" maxlength="30" id="contents" cssClass="form-control" />
			</div>
		</div>
		
		<div id="submiter" class="control-group">
			<div class="controls text-center">
				<input type="submit" value="添加 " style="width:100px" class="btn btn-primary" />
			</div>
		</div>
    </form>
  </div>
  </div>
  
  
   <script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/summernote.min.js"></script>
   <script src="js/summernote-zh-CN.js"></script>
   <script src="js/common.js"></script>
   <script type="text/javascript">
   $(document).ready(function() {
        $('#contents').summernote({
          lang: 'zh-CN',
		  height: 300,                 // set editor height 
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  toolbar:[
		  	['style', ['style']],
	        ['font', ['bold', 'italic', 'underline', 'superscript', 'subscript', 'strikethrough', 'clear']],
	        ['fontname', ['fontname']],
	        ['fontsize', ['fontsize']], // Still buggy
	        ['color', ['color']],
	        ['para', ['ul', 'ol', 'paragraph']],
	        ['height', ['height']],
	        ['table', ['table']],
	        ['insert', ['link', 'hr']],
	        ['view', ['fullscreen', 'codeview']],
	        ['help', ['help']]
		  ]
		  });
    });
    
    function validata(form) {
  		form = $(form);
  		var author = form.find('#author').val();
  		var title = form.find('#title').val();
  		var contents = form.find('#contents').val();

  		if(title == '') {
  			alert("标题不能为空");
  			form.find('#title').focus();
  			return false;
  		}
  		if(! isChinese(author) || author == '') {
  			alert("作者必须为汉字");
  			form.find('#author').focus();
  			return false;
  		}
  		if(contents == '<p><br></p>') {
  			alert("内容不能为空");
  			form.find('#contents').focus();
  			return false;
  		}

  		return true;
  	}
    
   </script>
   
   
   
   
  </body>
</html>
