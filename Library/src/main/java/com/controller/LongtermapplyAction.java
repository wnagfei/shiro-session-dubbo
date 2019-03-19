package com.controller;

import java.util.List;

import com.domain.Longtermapplyinfo;
import com.domain.Seatinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.LongtermapplyinfoService;
import com.services.SeatinfoService;
import com.utils.BaseTools;

public class LongtermapplyAction extends ActionSupport{
	
	private Longtermapplyinfo longtermapplyinfo;	
	private LongtermapplyinfoService longtermapplyinfoService;
	private Seatinfo seatinfo;
	private SeatinfoService seatinfoService;
	private List myLongtermapplyinfo;
	private List longtermapplyList;
	private Integer userId;
	private Integer id;
	private Integer seatId;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	//��ӳ���������Ϣ
	public String insertLongtermapplyinfo(){
//		System.out.println(longtermapplyinfo.getId());
//		System.out.println(longtermapplyinfo.getSeatId());
//		System.out.println(longtermapplyinfo.getTime());
//		System.out.println(longtermapplyinfo.getUserId());
		//�ж��û��Ƿ��Ѿ����й�������λ����
		if(longtermapplyinfoService.getLongtermapplyinfoByUserId(longtermapplyinfo.getUserId()).size()!=0){
			BaseTools.error("���Ѿ��������", null, null);
			return "jump";
		}
		longtermapplyinfo.setIsAgree("no");
		int isInsert=longtermapplyinfoService.creatLongtermapplyinfo(longtermapplyinfo);
		if(isInsert==0)
			BaseTools.success("����ɹ�", null, "show_longtermapply_message?userId="+longtermapplyinfo.getUserId());
		else
			BaseTools.error("����ʧ��", null, null);
		return "jump";
	}
	
	//��ʾ���еĳ���������Ϣ
	public String showAllLongtermapplyinfo(){
		
		longtermapplyList=longtermapplyinfoService.getAllLongtermapplyinfo();
		return "showAllLongtermapply";
	}
	
	//�����û�����ѯ����������Ϣ
	public String searchLongtermapplyinfo(){
		
		longtermapplyList=longtermapplyinfoService.getLongtermapplyinfoByUserId(userId);
		return "searchLongtermapplyRe";
	}
	
	//�û���ѯ���˳���������Ϣ
	public String showLongtermapplyinfoByUserId(){
		
		myLongtermapplyinfo=longtermapplyinfoService.getLongtermapplyinfoByUserId(userId);
		if(myLongtermapplyinfo.size()==0){
			BaseTools.error("����δ���г�����λ����", null, null);
			return "jump";
		}
		return "showLongtermapply";
	}
	
	//ɾ��������λ������Ϣ
	public String deleteLongtermapply(){
		boolean isDeleteLongtermapply=longtermapplyinfoService.deleteLongtermapplyinfo(id);
		if(isDeleteLongtermapply){
			setSeatUsed(seatId);
			BaseTools.success("ɾ���ɹ�", null, null);
		}else{
			BaseTools.error("ɾ��ʧ��", null, null);
		}
		return "jump";
	}
	
	//����û�������λ����
	public String checkLongtermapply(){
		longtermapplyinfo=(Longtermapplyinfo)(longtermapplyinfoService.getLongtermapplyinfoById(id).get(0));
		longtermapplyinfo.setIsAgree("yes");
		Integer seatId=longtermapplyinfo.getSeatId();
		boolean isCheck=longtermapplyinfoService.updateLongtermapplyinfo(longtermapplyinfo);
		if(isCheck){
			setSeatNotUsed(seatId);
			BaseTools.success("��ͬ��", null, null);
		}
		else
			BaseTools.error("ʧ�ܣ�δ֪ԭ��", null, null);
		return "jump";
	}
	
	//������λΪ������
	public void setSeatNotUsed(Integer seatId){
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		seatinfo.setIsUsed("no");
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
	}
	
	//������λΪ����
	public void setSeatUsed(Integer seatId){
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		seatinfo.setIsUsed("yes");
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
	}

	
	
	public Longtermapplyinfo getLongtermapplyinfo() {
		return longtermapplyinfo;
	}

	public void setLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo) {
		this.longtermapplyinfo = longtermapplyinfo;
	}

	public LongtermapplyinfoService getLongtermapplyinfoService() {
		return longtermapplyinfoService;
	}

	public void setLongtermapplyinfoService(
			LongtermapplyinfoService longtermapplyinfoService) {
		this.longtermapplyinfoService = longtermapplyinfoService;
	}

	public List getMyLongtermapplyinfo() {
		return myLongtermapplyinfo;
	}

	public void setMyLongtermapplyinfo(List myLongtermapplyinfo) {
		this.myLongtermapplyinfo = myLongtermapplyinfo;
	}

	public List getLongtermapplyList() {
		return longtermapplyList;
	}

	public void setLongtermapplyList(List longtermapplyList) {
		this.longtermapplyList = longtermapplyList;
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

	public Seatinfo getSeatinfo() {
		return seatinfo;
	}

	public void setSeatinfo(Seatinfo seatinfo) {
		this.seatinfo = seatinfo;
	}

	public SeatinfoService getSeatinfoService() {
		return seatinfoService;
	}

	public void setSeatinfoService(SeatinfoService seatinfoService) {
		this.seatinfoService = seatinfoService;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	

}
