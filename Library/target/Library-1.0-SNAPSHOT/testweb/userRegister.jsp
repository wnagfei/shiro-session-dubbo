<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	
	
	
	/*
	用途：检查输入字符串是否为空或者全部都是空格
	*/
	function isNull( str ){
		if ( str == "" ) 
		 checkName.style.color="red";
			 checkName.innerHTML="不能为空！";
		return false;
		
	}
	

	
		/* if(checkName()){
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//设置回调函数
			req.onreadystatechange = callbackForName;
			var url = "allUser/checkNameExist?name="+name.value;
			req.open("get",url,true);
			req.send(null);
			return true;
		}else{
			return false;
		}
		
	}
	function callbackForName(){
		var state = req.readyState;
		if(state==4){
			var doms = req.responseXML;
			var user = doms.getElementsByTagName("user");
			if(user[0].getElementsByTagName("name")[0].firstChild.data=="exist"){//用户名已经存在
				/* window.open("exist.jsp","fail","width=180,height=120,left=200,top=180"); */
		/* 		alert("用户名已经存在");
			}else{
				/* window.open("notExist.jsp","success","width=180,height=120,left=200,top=180"); */
	/* 			alert("用户名可以使用");
			}
		}
	} */
	
	
	function checkForm(){
		if(register_form.userId.value==""||register_form.password1.value==""||register_form.password2.value==""||register_form.identityNum.value==""||register_form.email.value==""
		||register_form.mphone.value==""||register_form.address.value==""||register_form.userInroduction.value==""||register_form.photoId.value==""){
			alert("您有未填项，请输入");
			return false;
		} 
		else if(checkName()==false){
			alert("用户名输入不合法！请重新输入");
			return false;
		}
		else if(checkNE()==false){
			alert("您输入的用户名已被注册，请重新输入");
			return false;
		}
		else if(checkPassword()==false){
			alert("密码输入不合法！，请重新输入");
			return false;
		}
		else if(checkPwd()==false){
			alert("确认密码输入不合法！请重新输入");
			return false;
		}
		else if(checkMail()==false){
			alert("邮箱输入不合法！请重新输入");
			return false;
		}
		else if(checkMPhone()==false){
			alert("电话输入不合法！请重新输入");
			return false;
		}
		else if(checkAddress()==false){
			alert("地址输入不合法！请重新输入");
			return false;
		}
		
	
	}
	
	function checkNE(){
		var userId = document.getElementById("userId").value;
		var checkNE = document.getElementById("checkNE");
		$.ajax({
				url : "allUser/checkAjax.action", // 后台处理程序
				type : "post", // 数据发送方式
				
				async : true,
				data:  {"userId":userId},
				error : function() 
				{
					alert("错误");
				},
				
				success : function(data) {
					if(data=="true")
					{
						alert("用户名可以使用!"); 
						/*  checkNE.style.color="green";
			 			checkNE.innerHTML="用户名可以使用!"; */
						return true;	
					}
					else{
						alert("该用户已被注册，请重新输入"); 
						/*  checkNE.style.color="red";
			 			 checkNE.innerHTML="该用户已被注册，请重新输入"; */
						return false;
					}
					
			}	
			});
		}
		
	
	
	//必须同意协议后才可注册
	/* function enable(){
		var terms = document.getElementById("terms");
		var register = document.getElementById("register");
		if(terms.checked){
			register.disabled=false;
		}else{
			register.disabled=true;
		}
	} */
	//检查用户名是否合法,只能由英文字母、数字和下划线组成，且开头不能为数字
	function checkName(){
		var name = document.getElementById("userId");
		var pic = document.getElementById("pic");
		var checkName = document.getElementById("checkName");
		var patrn=/^[a-zA-Z_]{1}\w{5,16}$/; 
		if ( name.value == "" ) 
	 	{
	 		checkName.style.color="red";
			checkName.innerHTML="不能为空！";
			return false;
		}
			else if(!patrn.exec(name.value)){
			 checkName.style.color="red";
			 checkName.innerHTML="用户名输入有误!";
			 return false;
			}
			else{	
			 checkName.style.color="green";
			 checkName.innerHTML="√ 输入正确";
			 return true;
			}
		
	};
	
	//检查密码,只能由英文字母和数字组成
	function checkPassword(){
		var password1 = document.getElementById("password1");
		var pwdRemind = document.getElementById("pwdRemind");
		var patrn=/^[a-z,A-Z,0-9]{6,15}$/;
		if ( password1.value == "" ) 
	 	{
	 		pwdRemind.style.color="red";
			pwdRemind.innerHTML="不能为空！";
			return false;
		}
		else if (!patrn.exec(password1.value)){
			pwdRemind.style.color="red";
			pwdRemind.innerHTML="密码格式输入有误!";
			return false;
		}else{
			pwdRemind.style.color="green";
			pwdRemind.innerHTML="√ 输入正确";
			return true;
		}
	};
	//确认密码
	function checkPwd(){
		var password1 = document.getElementById("password1");
		var password2 = document.getElementById("password2");
		var checkPwd = document.getElementById("checkPwd");
		var patrn=/^[a-z,A-Z,0-9]{6,15}$/;
		if ( password2.value == "" ) 
	 	{
	 		checkPwd.style.color="red";
			checkPwd.innerHTML="不能为空！";
			return false;
		}
		else if (!patrn.exec(password2.value)){
			checkPwd.style.color="red";
			checkPwd.innerHTML="密码格式输入有误!";
			return false;}
		else if(password1.value!=password2.value){
			checkPwd.style.color="red";
			checkPwd.innerHTML="两次密码输入不一致!";
			return false;
		}else{
			checkPwd.style.color="green";
			checkPwd.innerHTML="两次密码输入一致!";
			return true;
		}
	}
	//验证邮箱格式
	function checkMail(){
		var email = document.getElementById("email");
		var patrn=/((\w)|[-]|[.])+@(((\w)|[-])+[.])+[a-z]{2,4}$/;
		var checkMail = document.getElementById("checkMail");
		if ( email.value == "" ) 
	 	{
	 		checkMail.style.color="red";
			checkMail.innerHTML="不能为空！";
			return false;
		}
		else if(!patrn.exec(email.value)){
			checkMail.style.color="red";
			checkMail.innerHTML="邮箱格式输入有误!";
			return false;
		}else{
			checkMail.style.color="green";
			checkMail.innerHTML="√ 邮箱输入正确!";
			return true;
		}
	};
	
	//校验移动电话号码
	function checkMPhone(){
		var phone = document.getElementById("mphone");
		var checkMphone = document.getElementById("checkMphone");
		var patrn=/^1[356]\d{9}|01[356]\d{9}$/;
		if ( phone.value == "" ) 
	 	{
	 		checkMphone.style.color="red";
			checkMphone.innerHTML="不能为空！";
			return false;
		}
		
		else if (!patrn.exec(phone.value)){
			checkMphone.style.color="red";
			checkMphone.innerHTML="手机格式不正确";
			return false;
		}else{
			checkMphone.style.color="green";
			checkMphone.innerHTML="√ 输入正确";
			return true;
		}
	};
	
	//判断地址
	function checkAddress(){
		var address = document.getElementById("address");
		var checkAddress = document.getElementById("checkAddress");
		if ( address.value == "" ) 
	 	{
	 		checkAddress.style.color="red";
			checkAddress.innerHTML="不能为空！";
			return false;
		}
		else{
			checkAddress.style.color="green";
			checkAddress.innerHTML="√ 输入正确";
			return true;
		}
	};
	
	 function checkCard(){
		var identitynum = document.getElementById("identityNum").value;
		/* var pic = document.getElementById("pic");
		var checkName = document.getElementById("checkName");
		var patrn=/^[a-zA-Z_]{1}\w{5,16}$/; */
		var checkCard = document.getElementById("checkCard");
		  var vcity={ 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
            21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",  
            33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",  
            42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",  
            51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",  
            63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"  
           };   
       var province = identitynum.substr(0,2); 
        var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/; 
        var len = identitynum.length; 
         
		if (identitynum == "" ) 
	 	{
	 		checkCard.style.color="red";
			checkCard.innerHTML="不能为空！";
			return false;
		}
		//身份证长度
		 else if(!reg.exec(identitynum)){
		     checkCard.style.color="red";
			 checkCard.innerHTML="身份证格式有误";
			 return false;
		}
		
		//判断省份
		else if(!vcity[identitynum.substr(0,2)]){
		     checkCard.style.color="red";
			 checkCard.innerHTML="身份证省份输入有误";
			 return false;
		} 
		else if(checkBirthday(identitynum)==false){
			 checkCard.style.color="red";
			 checkCard.innerHTML="身份证中生日有误";
			 return false;
		}
		//检验校验位	
		else if(checkParity(identitynum) === false){
			 checkCard.style.color="red";
			 checkCard.innerHTML="身份证校验位有误";
			 return false;
		}	 
		else
		{	
			checkCard.style.color="green";
			checkCard.innerHTML="√ 输入正确";
			return true;
		}

	}
	
	 checkBirthday=function(identitynum)  
		{  
		    var len = identitynum.length;  
		    //身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字  
		    if(len == '15')  
		    {  
		        var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;   
		        var arr_data = identitynum.match(re_fifteen);  
		        var year = arr_data[2];  
		        var month = arr_data[3];  
		        var day = arr_data[4];  
		        var birthday = new Date('19'+year+'/'+month+'/'+day);  
		        return verifyBirthday('19'+year,month,day,birthday);  
		    }  
		    //身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X  
		    if(len == '18')  
		    {  
		        var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;  
		        var arr_data = identitynum.match(re_eighteen);  
		        var year = arr_data[2];  
		        var month = arr_data[3];  
		        var day = arr_data[4];  
		        var birthday = new Date(year+'/'+month+'/'+day);  
		        return verifyBirthday(year,month,day,birthday);  
		    }  
		    return false;  
		};
	verifyBirthday=	function(year,month,day,birthday)  
			{  
			    var now = new Date();  
			    var now_year = now.getFullYear();  
			    //年月日是否合理  
			    if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day)  
			    {  
			        //判断年份的范围（3岁到100岁之间)  
			        var time = now_year - year;  
			        if(time >= 3 && time <= 100)  
			        {  
			            return true;  
			        }  
			        return false;  
			    }  
			    return false;  
			};  	
		 checkParity= function(identitynum)  
			{  
			    //15位转18位  
			    identitynum = changeFivteenToEighteen(identitynum);  
			    var len = identitynum.length;  
			    if(len == '18')  
			    {  
			        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   
			        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');   
			        var cardTemp = 0, i, valnum;   
			        for(i = 0; i < 17; i ++)   
			        {   
			            cardTemp += identitynum.substr(i, 1) * arrInt[i];   
			        }   
			        valnum = arrCh[cardTemp % 11];   
			        if (valnum == identitynum.substr(17, 1))   
			        {  
			            return true;  
			        }  
			        return false;  
			    }  
			    return false;  
			};  
			  
			//15位转18位身份证号  
		 changeFivteenToEighteen = function(identitynum)  
			{  
			    if(identitynum.length == '15')  
			    {  
			        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   
			        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');   
			        var cardTemp = 0, i;     
			        identitynum = identitynum.substr(0, 6) + '19' + identitynum.substr(6, card.length - 6);  
			        for(i = 0; i < 17; i ++)   
			        {   
			            cardTemp += identitynum.substr(i, 1) * arrInt[i];   
			        }   
			        identitynum += arrCh[cardTemp % 11];   
			        return identitynum;  
			    }  
			    return identitynum;  
			};  
	
	//必须所有信息填写正确才能成功提交信息
	/*  function checkAll(){
		document.register_form.submit();
	}  */
	
	//清楚用户名错误提示
	function clearRN(){
		var checkName = document.getElementById("checkName");
		checkName.style.color="black";
		checkName.innerHTML="英文字母或下划线(6-15)字符组成";
	}
	//清楚密码验证错误提示
	function clearPwd(){
		var checkPwd = document.getElementById("checkPwd");
		var pwdRemind = document.getElementById("pwdRemind");
		checkPwd.style.color="black";
		checkPwd.innerHTML="由英文字母和数字(6-15)字符组成";
		pwdRemind.innerHTML="";
	}
	//清除邮箱错误提示
	function clearMail(){
		var checkMail = document.getElementById("checkMail");
		checkMail.style.color="black";
		checkMail.innerHTML="请输入正确的邮箱地址";
	}
	
	//清除移动电话错误提示
	function clearMphoneR(){
		var checkMphone = document.getElementById("checkMphone");
		checkMphone.style.color="black";
		checkMphone.innerHTML="请输入正确移动电话号码";
	}
	
	</script>
	<style>
	tr {margin-top:10px};
	</style>
	<link rel="stylesheet" href="css/button.css">
	
  </head>
  
  <body>
  
  	<div style="margin-left:400px">
 		<h1>用户注册</h1> 
	</div>
	<a href="allUser/projectList.jsp" style="margin-left:500px"><input type="button"  value="返回首页" style="margin-left:40px"  class="button small"
	
                     /></a>
  	<div style="margin-left:300px;margin-top:20px">
 	<!-- name="userIdregister_form"  onsubmit="checkForm(register_form)"-->
      <s:form action="createNewuser" namespace="/allUser" method="post" name="register_form" onsubmit="return checkForm(register_form)">          
          <table style="height:400px">
               <tr>
                    <td class="label">用户名:</td>
                    <td><input type="text" id="userId" name="user.userId" onblur="checkName()" onfocus="clearRN()"/></td>
                    <td id="checkName" class="remind"><span style="color: red">*</span><span style="color:black">由英文字母、数字或下划线(6-16)字符组成,且不能以数字开头</span></td>
                </tr>
               <%--   <input type="hidden" name="userId" value='<%=user.userId%>'/>    --%>
               <tr>
                    <td>&nbsp;</td>
                    <td><input type="button" value="检查用户名是否存在" id="checkNameExist" onclick="checkNE()" /></td>
                    <td>&nbsp;</td>
               </tr>
               
             	<tr>
                    <td class="label">密码:</td>
                    <td><input type="password" id="password1" name="user.userpassWord" class="contact_input" onblur="checkPassword()" onfocus="clearPwd()" /></td>
                    <td id="pwdRemind" class="remind"><span style="color: red">*</span><span style="color:black">由英文字母和数字(6-16)字符组成</span></td>
                </tr>
                <tr>
                	<td class="label">确认密码:</td>
                    <td> <input type="password" id="password2"  class="contact_input" onblur="checkPwd()" onfocus="clearPwd()" /></td>
                    <td id="checkPwd" class="remind">&nbsp;</td>
                 </tr>
                 <tr>
                	<td class="label">身份证号:</td>
                    <td> <input type="text" id="identityNum" name="user.identityNum" class="contact_input" onblur="checkCard()" /></td>
                    <td id="checkCard" class="remind">&nbsp;</td>
                 </tr>
                 <tr>
                    <td class="label">电子邮箱:</td>
                    <td><input type="text" id="email" name="user.email" class="contact_input" onblur="checkMail()" onfocus="clearMail()" /></td>
                    <td id="checkMail" class="remind"><span style="color: red">*</span><span style="color:black">请输入正确的邮箱地址，如:<span style="color: aqua">lovo@gmail.cn</span></td>
                 </tr>
                 <tr>
                    <td class="label">地址:</td>
                    <td><input type="text" id="address" name="user.address" class="contact_input" onblur="checkAddress()"/></td>
                    <td id="checkAddress" class="remind">&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="label">移动电话:</td>
                    <td><input type="text" id="mphone" name="user.contactWay" class="contact_input" onblur="checkMPhone()" onfocus="clearMphoneR()" /></td>
                    		<td id="checkMphone" class="remind">&nbsp;</td>
                  </tr>
                  <tr>
                                     
                  		<td class="label">个人简介:</td>
                    	<td><textarea cols=25 rows=5 placeholder="介绍一下自己" id="userInroduction" name="user.userInroduction"></textarea></td>
                   		
                  </tr>
                 <!--  <tr>
                    <td class="label">个人图片:</td>
                    <td><input type="text" id="photoId" name="user.photoId" class="contact_input" /></td>
                    		
                  </tr> -->
                  
              <!--  <tr>
                    <td class="label">&nbsp;</td>
                    <td class="terms"><input type="checkbox" id="terms" name="terms" onclick="enable()" />
                        我同意你的所有 <a href="">条款</a> </td>
                    	<td class="remind">&nbsp;</td>
                   </tr>
                   <tr>
                    <td class="label">&nbsp;</td>
                    <td><input type="submit" id="register" name="register" class="register" value="注册" 
                    disabled="disabled" onclick="checkAll()" /></td>
                    <td class="remind">&nbsp;</td>
                   </tr>  -->
             <!-- <tr>
              <td>     
               <div class="control-group controls">
				
				<button type="submit" class="btn btn-primary">
					添加
				</button>
			</div>
			</td>
			</tr> -->
			<tr>
                    <td class="label" >&nbsp;</td>
                    <td><input type="submit"  value="注册" style="margin-left:40px"  class="button medium"
                    
                     /></td>
                    <td class="remind">&nbsp;</td>
                   
            </tr>  
             </table> 
          </s:form>     
         </div>         	
                    	
  </body>
</html>
