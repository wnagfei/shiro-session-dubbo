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

	//���ѧԺ��Ϣ
	public String insertScademy(){
		System.out.println(scademyinfo.getScademyCode());
		if(scademyinfoService.getScademyinfoByCode(scademyinfo.getScademyCode()).size()!=0){
			BaseTools.error("ѧԺ�Ѵ���", null, null);
			return "jump";
		}
		int isInsert=scademyinfoService.creatScademyinfo(scademyinfo);
		if(isInsert==0)
			BaseTools.success("��ӳɹ�", null, null);
		else
			BaseTools.error("���ʧ��", null, null);
		return "jump";
	}
	
	//��ʾ���е�ѧԺ��Ϣ
	public String showAllScademy(){
		
		scademyinfoList=scademyinfoService.getAllScademyinfo();
		return "showAllScademy";
	}
	
	//ɾ��ѧԺ��Ϣ
	public String deleteScademyinfo(){
		boolean isDeleteScademy=scademyinfoService.deleteScademyinfo(Integer.parseInt(scademyCode));
		if(isDeleteScademy)
			BaseTools.success("ɾ���ɹ�", null, null);
		else
			BaseTools.error("ɾ��ʧ��", null, null);
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
