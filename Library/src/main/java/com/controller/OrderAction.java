package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.domain.Historyinfo;
import com.domain.Orderinfo;
import com.domain.Seatinfo;
import com.domain.Userinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.HistoryinfoService;
import com.services.OrderinfoService;
import com.services.SeatinfoService;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.utils.BaseTools;

public class OrderAction extends ActionSupport{
	
	private Orderinfo orderinfo;
	private OrderinfoService orderinfoService;
	private Seatinfo seatinfo;
	private SeatinfoService seatinfoService;
	private Historyinfo historyinfo;
	private HistoryinfoService historyinfoService;
	private List myOrderinfo;
	private String id;
	private String userId;
	private String seatId;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//��ʾԤԼ���
	public String showOrderByUserId(){
		
		myOrderinfo=orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId));
		System.out.println(myOrderinfo);
		if(myOrderinfo.size()==0){
			BaseTools.error("����δ����ԤԼ", null, null);
			return "jump";
		}
		return "showOrderMessage";
	}
	
	//ԤԼ��λ
	public String SeatOrder(){
		//�ж��û��Ƿ����
		if(userId.equals("")){
			BaseTools.error("δ���ú���", null, null);
			return "jump";
		}
		//�ж��û��Ƿ��Ѿ�ԤԼ����
		if(orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId)).size()!=0){
			BaseTools.error("���Ѿ�ԤԼ����", null, null);
			return "jump";
		}
		//�ж���λ�Ƿ����
		if(seatinfoService.getSeatinfoByIdOnly(orderinfo.getSeatId()).size()==0){
			System.out.println("��λ������");
			BaseTools.error("��λ������", null, null);
			return "jump";
		}
		
		//�����ʱһ��ʱ��
		Random random = new Random();
		Integer sleepTime=random.nextInt(2000);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//�ж���λ�Ƿ����
		Seatinfo seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(orderinfo.getSeatId()).get(0));
		if(seatinfo.getIsUsed().equals("no")){
			BaseTools.error("��λ������", null, null);
			return "jump";
		}
			
		//�ж���λ�Ƿ��ԤԼ
		if(seatinfo.getIsOrder().equals("no")){
			BaseTools.error("����λ�ѱ�ԤԼ", null, null);
			return "jump";
		}
		System.out.println("��ִ����");
		orderinfo.setUserId(Integer.parseInt(userId));
		int isOrder=orderinfoService.creatOrderinfo(orderinfo);
		if(isOrder==0){
			this.creatHistory(Integer.parseInt(userId),orderinfo.getSeatId().toString());
			BaseTools.success("ԤԼ�ɹ�", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("ԤԼʧ��", null, null);
		return "jump";
	}
	
	//�ڿ���λ�б���ԤԼ��λ
	public String seatOrderFromEmpty(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Integer userId=((Userinfo) session.getAttribute("userinfo")).getUserId();
		//�ж��û��Ƿ��Ѿ�ԤԼ����
		if(orderinfoService.getOrderinfoByUserId(userId).size()!=0){
			BaseTools.error("���Ѿ�ԤԼ����", null, null);
			return "jump";
		}
		
		//�����ʱһ��ʱ��
		Random random = new Random();
		Integer sleepTime=random.nextInt(2000);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//�ж���λ�Ƿ��ԤԼ
		if(orderinfoService.getOrderinfoBySeatId(Integer.parseInt(seatId)).size()!=0){
			BaseTools.error("����λ�ѱ�ԤԼ", null, null);
			return "error";
		}
		Orderinfo orderinfo=new Orderinfo();
		orderinfo.setSeatId(Integer.parseInt(seatId));
		orderinfo.setUserId(userId);
		int isOrder=orderinfoService.creatOrderinfo(orderinfo);
		if(isOrder==0){
			this.creatHistory(userId,seatId);
			this.setSeatNotOrder(Integer.parseInt(seatId));
			BaseTools.success("ԤԼ�ɹ�", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("ԤԼʧ��", null, null);
		return "jump";
	}
	
	//һ��ԤԼ��λ
	public String orderByOneButton(){
		//�ж��û��Ƿ����
		if(userId.equals("")){
			BaseTools.error("δ���ú���", null, null);
			return "jump";
		}
		//�ж��û��Ƿ��Ѿ�ԤԼ����
		if(orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId)).size()!=0){
			BaseTools.error("���Ѿ�ԤԼ����", null, null);
			return "jump";
		}
		//���������λ��
		Random random = new Random();
		Integer seatId=random.nextInt(60)+1;
		Integer sleepTime;
		
		//�ж���λ�Ƿ��ԤԼ
		while(true){
			Seatinfo seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
			sleepTime=random.nextInt(1000);
			//�����ʱһ��ʱ��
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			if(seatinfo.getIsOrder().equals("yes")&&seatinfo.getIsUsed().equals("yes"))
				break;
			seatId=random.nextInt(60)+1;
		}
		Orderinfo orderinfo=new Orderinfo();
		orderinfo.setUserId(Integer.parseInt(userId));
		orderinfo.setSeatId(seatId);
		int isOrder=orderinfoService.creatOrderinfo(orderinfo);
		if(isOrder==0){
			this.creatHistory(Integer.parseInt(userId),seatId.toString());
			BaseTools.success("ԤԼ�ɹ�", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("ԤԼʧ��", null, null);
		return "jump";
	}
	
	//ȡ��ԤԼ
	public String deleteOrderinfo(){
		
		boolean isDeleteOrder=orderinfoService.deleteOrderinfo(id);
		if(isDeleteOrder){
			setSeatOrder(Integer.parseInt(seatId));
			BaseTools.success("ȡ���ɹ�", null, "user/seatOrder.jsp");
		}
		else
			BaseTools.error("ȡ��ʧ��", null, null);
		return "jump";
	}
	
	//һ��ɾ������ԤԼ��Ϣ
	public String deleteByOneButton(){
		boolean isDelete=orderinfoService.deleteAll();
		if(isDelete)
			BaseTools.success("��ճɹ�", null, "admin/iframeDefault.jsp");
		else
			BaseTools.error("���ʧ��", null, null);
		return "jump";
	}
	
	
	
	//ԤԼʱ������ʷ��¼
	public void creatHistory(Integer userId,String seatId){
		System.out.println("11111");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Historyinfo historyinfo =new Historyinfo();
		historyinfo.setUserId(userId);
		historyinfo.setSeatId(seatId);
		historyinfo.setDate(sdf.format(new Date()));
		System.out.println(historyinfo);
		int isInsert=historyinfoService.creatHistoryinfo(historyinfo);
		System.out.println(isInsert);
		/*if(isInsert==0)
			return true;
		else
			return false;*/
	}
	
	//������λΪ����ԤԼ
	public void setSeatNotOrder(Integer seatId){
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		seatinfo.setIsOrder("no");
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
	}
	
	//������λΪ��ԤԼ
	public void setSeatOrder(Integer seatId){
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		seatinfo.setIsOrder("yes");
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
	}

	
	
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public OrderinfoService getOrderinfoService() {
		return orderinfoService;
	}

	public void setOrderinfoService(OrderinfoService orderinfoService) {
		this.orderinfoService = orderinfoService;
	}

	public List getMyOrderinfo() {
		return myOrderinfo;
	}

	public void setMyOrderinfo(List myOrderinfo) {
		this.myOrderinfo = myOrderinfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
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
	
}
