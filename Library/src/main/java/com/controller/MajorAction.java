package com.controller;

import java.util.List;

import com.domain.Majorinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.MajorinfoService;
import com.utils.BaseTools;

public class MajorAction extends ActionSupport{
	
	private Majorinfo majorinfo;
	private MajorinfoService majorinfoService;
	private List majorinfoList;
	private String majorCode;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//添加专业信息
	public String insertMajor(){
		
		if(majorinfoService.getMajorinfoByCode(majorinfo.getMajorCode()).size()!=0){
			BaseTools.error("专业已存在", null, null);
			return "jump";
		}
		int isInsert=majorinfoService.creatMajorinfo(majorinfo);
		if(isInsert==0)
			BaseTools.success("添加成功", null, null);
		else
			BaseTools.error("添加失败", null, null);
		return "jump";
	}
	
	//显示所有的专业信息
	public String showAllMajor(){
		majorinfoList=majorinfoService.getAllMajorinfo();
		return "showAllMajor";
	}

	//删除专业信息
	public String deleteMajorinfo(){
		System.out.println(majorCode);
		boolean isDeleteMajorinfo=majorinfoService.deleteMajorinfo(Integer.parseInt(majorCode));
		if(isDeleteMajorinfo)
			BaseTools.success("删除成功", null, null);
		else
			BaseTools.error("山粗失败", null, null);
		return "jump";
	}
	
	
	
	public Majorinfo getMajorinfo() {
		return majorinfo;
	}

	public void setMajorinfo(Majorinfo majorinfo) {
		this.majorinfo = majorinfo;
	}

	public MajorinfoService getMajorinfoService() {
		return majorinfoService;
	}

	public void setMajorinfoService(MajorinfoService majorinfoService) {
		this.majorinfoService = majorinfoService;
	}

	public List getMajorinfoList() {
		return majorinfoList;
	}

	public void setMajorinfoList(List majorinfoList) {
		this.majorinfoList = majorinfoList;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

}
