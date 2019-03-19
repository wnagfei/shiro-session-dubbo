<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
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
			src="images/adminPortrait.jpg"> <span
			class="label label-danger user-label">16</span> </a>
		<div class="media-body">
			<h5 class="media-heading">Welcome Back!</h5>
			<ul class="list-unstyled user-info">
				<li>Administrator</li>
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
	<li class=""><a href="admin/iframeDefault.jsp" target="content"> <i
			class="fa fa-dashboard"></i><span class="link-title">&nbsp;首页</span>
	</a>
	</li>
	<li class=""><a href="javascript:;"> <i
			class="fa fa-building "></i> <span class="link-title">用户信息管理</span>
			<span class="fa arrow"></span> </a>
		<ul>
			<li><a href="show_all_users" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 查看用户信息 </a>
			</li>
			<li><a href="admin/insertUser.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 添加用户信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-tasks"></i>
			<span class="link-title">座位信息管理</span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_all_seats" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查看座位信息 </a>
			</li>
			<li><a href="admin/insertSeat.jsp" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					添加座位信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-pencil"></i>
			<span class="link-title"> 公告信息管理 </span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_all_notices" target="content"> <i class="fa fa-angle-right"></i>&nbsp;
					查看公告 </a>
			</li>
			<li><a href="admin/insertNotice.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 发布公告 </a>
			</li>			
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-pencil"></i>
			<span class="link-title"> 学院信息管理 </span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_all_scademyinfo" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 查看学院信息 </a>
			</li>
			<li><a href="admin/insertScademy.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 添加学院信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-pencil"></i>
			<span class="link-title"> 专业信息管理 </span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_all_majorinfo" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 查看专业信息 </a>
			</li>
			<li><a href="admin/insertMajor.jsp" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 添加专业信息 </a>
			</li>
		</ul>
	</li>
	<li class=""><a href="javascript:;"> <i class="fa fa-pencil"></i>
			<span class="link-title"> 其他管理 </span> <span class="fa arrow"></span>
	</a>
		<ul>
			<li><a href="show_all_longtermapplyinfo" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 查看长期座位申请信息 </a>
			</li>
			<li><a href="delete_all" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 一键清空预约信息 </a>
			</li>
			<li><a href="recovery_seat" target="content"> <i
					class="fa fa-angle-right"></i>&nbsp; 一键恢复座位可预约状态 </a>
			</li>
		</ul>
	</li>
</ul>
<!-- /#menu -->
