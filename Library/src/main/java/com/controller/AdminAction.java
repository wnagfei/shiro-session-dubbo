package com.controller;

import com.domain.Admininfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.AdmininfoService;

public class AdminAction extends ActionSupport{
	private Admininfo admininfo;
	private AdmininfoService admininfoService;
	private String username;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//创建管理员
	public String save() {
		boolean isSave = admininfoService.updateAdmininfo(admininfo);
		if (isSave) {
			return "success";
		} else {
			return "error";
		}
	}
	
	//更新管理员信息
	public String update(){	
		admininfo = admininfoService.getAdmininfoById(username);
		if (admininfo==null) {			
			return "null";
		}
		return "update";
	}

	public Admininfo getAdmininfo() {
		return admininfo;
	}

	public void setAdmininfo(Admininfo admininfo) {
		this.admininfo = admininfo;
	}

	public AdmininfoService getAdmininfoService() {
		return admininfoService;
	}

	public void setAdmininfoService(AdmininfoService admininfoService) {
		this.admininfoService = admininfoService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
