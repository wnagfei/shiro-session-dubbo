package com.controller;

import java.util.List;

import com.domain.Scademyinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ScademyinfoService;
import com.utils.BaseTools;

public class ScademyAction extends ActionSupport{
	
	private Scademyinfo scademyinfo;
	private ScademyinfoService scademyinfoService;
	private List scademyinfoList;
	private String scademyCode;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	//添加学院信息
	public String insertScademy(){
		System.out.println(scademyinfo.getScademyCode());
		if(scademyinfoService.getScademyinfoByCode(scademyinfo.getScademyCode()).size()!=0){
			BaseTools.error("学院已存在", null, null);
			return "jump";
		}
		int isInsert=scademyinfoService.creatScademyinfo(scademyinfo);
		if(isInsert==0)
			BaseTools.success("添加成功", null, null);
		else
			BaseTools.error("添加失败", null, null);
		return "jump";
	}
	
	//显示所有的学院信息
	public String showAllScademy(){
		
		scademyinfoList=scademyinfoService.getAllScademyinfo();
		return "showAllScademy";
	}
	
	//删除学院信息
	public String deleteScademyinfo(){
		boolean isDeleteScademy=scademyinfoService.deleteScademyinfo(Integer.parseInt(scademyCode));
		if(isDeleteScademy)
			BaseTools.success("删除成功", null, null);
		else
			BaseTools.error("删除失败", null, null);
		return "jump";
	}
	

	public Scademyinfo getScademyinfo() {
		return scademyinfo;
	}

	public void setScademyinfo(Scademyinfo scademyinfo) {
		this.scademyinfo = scademyinfo;
	}

	public ScademyinfoService getScademyinfoService() {
		return scademyinfoService;
	}

	public void setScademyinfoService(ScademyinfoService scademyinfoService) {
		this.scademyinfoService = scademyinfoService;
	}

	public List getScademyinfoList() {
		return scademyinfoList;
	}

	public void setScademyinfoList(List scademyinfoList) {
		this.scademyinfoList = scademyinfoList;
	}

	public String getScademyCode() {
		return scademyCode;
	}

	public void setScademyCode(String scademyCode) {
		this.scademyCode = scademyCode;
	}
	
}
