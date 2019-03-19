package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.Admininfo;
import com.domain.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.AdmininfoService;
import com.services.UserinfoService;
import com.utils.BaseTools;

public class LoginAction extends ActionSupport{
	
	private String usr;
	private String pwd;
	private String identity;
	private AdmininfoService admininfoService;
	private UserinfoService userinfoService;
	private Userinfo userinfo;
	private Admininfo admininfo;
	
	
	public String login(){
		//用户身份登录验证
		if(identity.equals("user"))
		{
			
//			if(userinfo==null){
//				BaseTools.error("用户名不存在", null, null);
//				return "err";
//			}
			if(userinfoService.getUserinfoById(Integer.parseInt(usr)).size() == 0){
				BaseTools.error("用户不存在", null, null);
				return "err";
			}
			if(userinfoService.getPwd(usr).equals(pwd)){
				
				HttpSession session=ServletActionContext.getRequest().getSession();	
				userinfo=(Userinfo) session.getAttribute("userinfo");
				return "usr";
			}
		}
		//管理员身份验证
		else if(identity.equals("admin"))
		{
			if(admininfoService.getAdmininfoById(usr)==null){
				BaseTools.error("用户名不存在", null, null);
				return "err";
			}
			if(admininfoService.getPwd(usr).equals(pwd))
			{
				HttpSession session=ServletActionContext.getRequest().getSession();	
				admininfo=(Admininfo) session.getAttribute("admininfo");
				return "adm";
			}
		}
		BaseTools.error("登录失败，密码错误", null, null);
		return "err";
	}
	
	public String signout(){
		Map attibutes = ActionContext.getContext().getSession();
		attibutes.clear();
		return "signout";
	}

	
	
	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public AdmininfoService getAdmininfoService() {
		return admininfoService;
	}

	public void setAdmininfoService(AdmininfoService admininfoService) {
		this.admininfoService = admininfoService;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Userinfo getUserinfo() {	
		return userinfo;
	}

	public Admininfo getAdmininfo() {
		return admininfo;
	}

	public void setAdmininfo(Admininfo admininfo) {
		this.admininfo = admininfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
