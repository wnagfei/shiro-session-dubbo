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
	
	//显示预约情况
	public String showOrderByUserId(){
		
		myOrderinfo=orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId));
		System.out.println(myOrderinfo);
		if(myOrderinfo.size()==0){
			BaseTools.error("您还未进行预约", null, null);
			return "jump";
		}
		return "showOrderMessage";
	}
	
	//预约座位
	public String SeatOrder(){
		//判断用户是否存在
		if(userId.equals("")){
			BaseTools.error("未设置好友", null, null);
			return "jump";
		}
		//判断用户是否已经预约过了
		if(orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId)).size()!=0){
			BaseTools.error("您已经预约过了", null, null);
			return "jump";
		}
		//判断座位是否存在
		if(seatinfoService.getSeatinfoByIdOnly(orderinfo.getSeatId()).size()==0){
			System.out.println("座位不存在");
			BaseTools.error("座位不存在", null, null);
			return "jump";
		}
		
		//随机延时一段时间
		Random random = new Random();
		Integer sleepTime=random.nextInt(2000);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//判断座位是否可用
		Seatinfo seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(orderinfo.getSeatId()).get(0));
		if(seatinfo.getIsUsed().equals("no")){
			BaseTools.error("座位不可用", null, null);
			return "jump";
		}
			
		//判断座位是否可预约
		if(seatinfo.getIsOrder().equals("no")){
			BaseTools.error("该座位已被预约", null, null);
			return "jump";
		}
		System.out.println("我执行了");
		orderinfo.setUserId(Integer.parseInt(userId));
		int isOrder=orderinfoService.creatOrderinfo(orderinfo);
		if(isOrder==0){
			this.creatHistory(Integer.parseInt(userId),orderinfo.getSeatId().toString());
			BaseTools.success("预约成功", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("预约失败", null, null);
		return "jump";
	}
	
	//在空座位列表中预约座位
	public String seatOrderFromEmpty(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Integer userId=((Userinfo) session.getAttribute("userinfo")).getUserId();
		//判断用户是否已经预约过了
		if(orderinfoService.getOrderinfoByUserId(userId).size()!=0){
			BaseTools.error("您已经预约过了", null, null);
			return "jump";
		}
		
		//随机延时一段时间
		Random random = new Random();
		Integer sleepTime=random.nextInt(2000);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//判断座位是否可预约
		if(orderinfoService.getOrderinfoBySeatId(Integer.parseInt(seatId)).size()!=0){
			BaseTools.error("该座位已被预约", null, null);
			return "error";
		}
		Orderinfo orderinfo=new Orderinfo();
		orderinfo.setSeatId(Integer.parseInt(seatId));
		orderinfo.setUserId(userId);
		int isOrder=orderinfoService.creatOrderinfo(orderinfo);
		if(isOrder==0){
			this.creatHistory(userId,seatId);
			this.setSeatNotOrder(Integer.parseInt(seatId));
			BaseTools.success("预约成功", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("预约失败", null, null);
		return "jump";
	}
	
	//一键预约座位
	public String orderByOneButton(){
		//判断用户是否存在
		if(userId.equals("")){
			BaseTools.error("未设置好友", null, null);
			return "jump";
		}
		//判断用户是否已经预约过了
		if(orderinfoService.getOrderinfoByUserId(Integer.parseInt(userId)).size()!=0){
			BaseTools.error("您已经预约过了", null, null);
			return "jump";
		}
		//随机产生座位号
		Random random = new Random();
		Integer seatId=random.nextInt(60)+1;
		Integer sleepTime;
		
		//判断座位是否可预约
		while(true){
			Seatinfo seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
			sleepTime=random.nextInt(1000);
			//随机延时一段时间
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
			BaseTools.success("预约成功", null, "show_order?userId="+userId);
		}
		else
			BaseTools.error("预约失败", null, null);
		return "jump";
	}
	
	//取消预约
	public String deleteOrderinfo(){
		
		boolean isDeleteOrder=orderinfoService.deleteOrderinfo(id);
		if(isDeleteOrder){
			setSeatOrder(Integer.parseInt(seatId));
			BaseTools.success("取消成功", null, "user/seatOrder.jsp");
		}
		else
			BaseTools.error("取消失败", null, null);
		return "jump";
	}
	
	//一键删除所有预约信息
	public String deleteByOneButton(){
		boolean isDelete=orderinfoService.deleteAll();
		if(isDelete)
			BaseTools.success("清空成功", null, "admin/iframeDefault.jsp");
		else
			BaseTools.error("清空失败", null, null);
		return "jump";
	}
	
	
	
	//预约时创建历史记录
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
	
	//设置座位为不可预约
	public void setSeatNotOrder(Integer seatId){
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		seatinfo.setIsOrder("no");
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
	}
	
	//设置座位为可预约
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
