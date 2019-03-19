package com.controller;

import java.util.List;

import com.domain.Seatinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.SeatinfoService;
import com.utils.BaseTools;

public class SeatAction extends ActionSupport{
	
	private Seatinfo seatinfo;
	private SeatinfoService seatinfoService;
	private List<Seatinfo> seatList;
	private List<Seatinfo> emptySeatList;
	private List seatMessage;
	private Integer seatId;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//��ȡ���е���λ��Ϣ
	public String showAllSeats(){
		seatList=seatinfoService.getAllSeatinfo();
		return "showAllSeats";
	}
	
	//����Ա������λ��Ų�ѯ��λ��Ϣ
	public String showSeat(){
		seatList=seatinfoService.getSeatinfoById(seatId);
		if(seatList.size()==0){
			BaseTools.error("��λ������", null, null);
			return "jump";
		}
		return "showSeat";
	}
	
	//�û�������λ��Ų�ѯ��λ��Ϣ
	public String showSeatMessage(){
		seatMessage=seatinfoService.getOrderinfoById(seatId);
		if(seatMessage.size()==0){
			BaseTools.error("��λ������", null, null);
			return "jump";
		}
		return "showSeat";
	}
	
	//��ȡ���еĿ���λ��Ϣ
	public String showEmptySeat(){
		emptySeatList=seatinfoService.getEmptySeatinfo();
		if(emptySeatList.size()==0){
			BaseTools.error("��ǰʱ�����޿���λ", null, null);
			return "jump";
		}
		return "showEmptySeat";
	}

	//ɾ����λ��Ϣ
	public String deleteSeat(){
		boolean isDeleteSeat=seatinfoService.deleteSeatinfo(seatId);
		if(isDeleteSeat){
			BaseTools.success("ɾ���ɹ�", null, null);
			
		}else{
			BaseTools.error("ɾ��ʧ��", null, null);
			
		}
		return "jump";
	}
	
	//�����λ��Ϣ
	public String insertSeat(){
		
		if((seatinfoService.getSeatinfoById(seatinfo.getSeatId())).size()!=0){
			BaseTools.error("��λ�Ѵ��ڣ����ʧ�ܣ�", null, null);
			return "jump";
		}
		seatinfo.setIsOrder("yes");
		seatinfo.setIsUsed("yes");
		int isInsert=seatinfoService.creatSeatinfo(seatinfo);
		if(isInsert==0){
			BaseTools.success("��ӳɹ�", null, null);
			
		}
		else {
			BaseTools.error("��λ����ظ������ʧ�ܣ�", null, null);
			
		}
		return "jump";
	}
	
	//����Ա�޸���λ��Ϣ֮ǰ����ʾ
	public String showBeforeUpdate(){
		
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		return "showBeforeUpdate";
	}
	
	//�޸���λ��Ϣ
	public String updateSeat(){
		System.out.println(seatinfo.getIsOrder()+" "+seatinfo.getIsUsed()+" "+seatinfo.getLocation());
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
		if(isUpdate){
			
			BaseTools.success("�޸ĳɹ�", null, "show_all_seats");
		}
		else
			BaseTools.error("�޸�ʧ��", null, null);
		return "jump";
	}
	
	//һ���ָ���λ��ԤԼ״̬
	public String recoverySeat(){
		boolean isRecovery=seatinfoService.recoveryIsOrder();
		if(isRecovery)
			BaseTools.success("���óɹ�", null, "admin/iframeDefault.jsp");
		else
			BaseTools.error("����ʧ��", null, null);
		
		return "jump";
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

	public List<Seatinfo> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seatinfo> seatList) {
		this.seatList = seatList;
	}

	public List<Seatinfo> getEmptySeatList() {
		return emptySeatList;
	}

	public void setEmptySeatList(List<Seatinfo> emptySeatList) {
		this.emptySeatList = emptySeatList;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public List getSeatMessage() {
		return seatMessage;
	}

	public void setSeatMessage(List seatMessage) {
		this.seatMessage = seatMessage;
	}	
	
}
