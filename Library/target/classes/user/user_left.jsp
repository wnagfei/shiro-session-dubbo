<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.domain.Userinfo" %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
Integer userName=((Userinfo)session.getAttribute("userinfo")).getUserId();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="media user-media bg-dark dker">
	<div class="user-media-toggleHover">
		<span class="fa fa-user"></span>
	</div>
	<div class="user-wrapper bg-dark">
		<a class="user-link" href=""> <img
			class="media-object img-thumbnail user-img" alt="User Picture"
			src="images/userPortrait.jpg"> <span
			class="label label-danger user-label">16</span> </a>
		<div class="media-body">
			<h5 class="media-heading"><s:property value="userinfo.userName"/>&nbsp;&nbsp;
				<s:if test="userinfo.userSex == 'male'">男</s:if>
				<s:else>女</s:else>
			</h5>
			<ul class="list-unstyled user-info">
				<li><h5></h5><s:property value="userinfo.userId"/></a>
				</li>
				<li>Last Access : <br> <small> <i
						class="fa fa-calendar"></i>&nbsp;16 Mar 16:32</small></li>
			</ul>
		</div>
	</div>
</div>

<!-- #menu -->
<ul id="menu" class="bg-blue dker">
	<li class="nav-header">Menu</li>
	<li class="nav-divider"></li>
	<li class=""><a href="index_notices" target="content"> <i
			class="fa fa-dashboard"></i><span class="link-title">&nbsp;首页</span>
	</a>
	</li>
	<li class=""><a href="show_user_message?userId=<%=userName %>" target="content"> <i
			class="fa fa-dashboard"></i><span class="link-title">&nbsp;个人信息</span>
	</a>
	</li>
	<li class=""><a href="javascript:;"> <i
			class="fa fa-building "></i> <span class="link-title">座位信息查询</span>
			<span class="fa arrow"></span> </a>
		<ul>
			<li><a href="show_empty_seat" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查询空座位 </a>
			</li>
			<li><a href="user/seatImages.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 座位分布图 </a>
			</li>
			<li><a href="user/searchSeat.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 查询座位信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-tasks"></i>
			<span class="link-title">座位预约</span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="user/seatOrder.jsp" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					座位预约 </a>
			</li>
			<li><a href="order_by_one_button?userId=<%=userName %>" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					一键预约座位 </a>
			</li>
			<li><a href="user/friendSeatOrder.jsp" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					好友座位预约 </a>
			</li>
			<li><a href="show_order?userId=<%=userName %>" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查看预约情况 </a>
			</li>
			
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-tasks"></i>
			<span class="link-title">长期座位预约</span> <span class="fa arrow"></span>
	</a>
		<ul>
		<li><a href="user/longTermApply.jsp" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					长期座位申请 </a>
			</li>
		<li><a href="show_longtermapply_message?userId=<%=userName %>" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查看长期座位申请信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-tasks"></i>
			<span class="link-title">其他</span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_history?userId=<%=userName %>" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查看预约记录 </a>
			</li>
			<li><a href="user/updatePassword.jsp" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					修改密码 </a>
			</li>
		</ul>	
	</li>
</ul>
<!-- /#menu -->
