package com.controller;

import java.util.List;

import com.domain.Historyinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.HistoryinfoService;
import com.utils.BaseTools;

public class HistoryAction extends ActionSupport{
	
	private Historyinfo historyinfo;
	private HistoryinfoService historyinfoService;
	private Integer userId;
	private Integer id;
	private List historyList;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//�����û�����ȡ��ʷ��¼
	public String showHistory(){
		System.out.println(userId);
		System.out.println(historyinfoService);
		historyList=historyinfoService.getHistoryinfoByUserId(userId);
		return "showHistory";
	}
	
	//ɾ����ʷ��¼��Ϣ
	public String deleteHistory() {
		boolean isDeleteHistory=historyinfoService.deleteHistoryinfo(id);
		if(isDeleteHistory){
			BaseTools.success("ɾ���ɹ�", null, null);
			
		}else{
			BaseTools.error("ɾ��ʧ��", null, null);
		}	
		return "jump";
	}
	
	//ɾ���û����е���ʷ��¼
	public String deleteAllHistorys(){
		
		boolean isDeleteHistory=historyinfoService.deleteAllHistorys(userId);
		if(isDeleteHistory){
			BaseTools.success("ɾ���ɹ�", null, null);
		}else
			BaseTools.error("ɾ��ʧ��", null, null);
		return "jump";
	}

	
	
	
	public Historyinfo getHistoryinfo() {
		return historyinfo;
	}

	public void setHistoryinfo(Historyinfo historyinfo) {
		this.historyinfo = historyinfo;
	}

	public HistoryinfoService getHistoryinfoService() {
		return historyinfoService;
	}

	public void setHistoryinfoService(HistoryinfoService historyinfoService) {
		this.historyinfoService = historyinfoService;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List historyList) {
		this.historyList = historyList;
	}

}
