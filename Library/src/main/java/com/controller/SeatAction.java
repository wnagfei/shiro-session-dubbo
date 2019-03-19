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
	
	//获取所有的座位信息
	public String showAllSeats(){
		seatList=seatinfoService.getAllSeatinfo();
		return "showAllSeats";
	}
	
	//管理员根据座位编号查询座位信息
	public String showSeat(){
		seatList=seatinfoService.getSeatinfoById(seatId);
		if(seatList.size()==0){
			BaseTools.error("座位不存在", null, null);
			return "jump";
		}
		return "showSeat";
	}
	
	//用户根据座位编号查询座位信息
	public String showSeatMessage(){
		seatMessage=seatinfoService.getOrderinfoById(seatId);
		if(seatMessage.size()==0){
			BaseTools.error("座位不存在", null, null);
			return "jump";
		}
		return "showSeat";
	}
	
	//获取所有的空座位信息
	public String showEmptySeat(){
		emptySeatList=seatinfoService.getEmptySeatinfo();
		if(emptySeatList.size()==0){
			BaseTools.error("当前时间已无空座位", null, null);
			return "jump";
		}
		return "showEmptySeat";
	}

	//删除座位信息
	public String deleteSeat(){
		boolean isDeleteSeat=seatinfoService.deleteSeatinfo(seatId);
		if(isDeleteSeat){
			BaseTools.success("删除成功", null, null);
			
		}else{
			BaseTools.error("删除失败", null, null);
			
		}
		return "jump";
	}
	
	//添加座位信息
	public String insertSeat(){
		
		if((seatinfoService.getSeatinfoById(seatinfo.getSeatId())).size()!=0){
			BaseTools.error("座位已存在，添加失败！", null, null);
			return "jump";
		}
		seatinfo.setIsOrder("yes");
		seatinfo.setIsUsed("yes");
		int isInsert=seatinfoService.creatSeatinfo(seatinfo);
		if(isInsert==0){
			BaseTools.success("添加成功", null, null);
			
		}
		else {
			BaseTools.error("座位编号重复，添加失败！", null, null);
			
		}
		return "jump";
	}
	
	//管理员修改座位信息之前的显示
	public String showBeforeUpdate(){
		
		seatinfo=(Seatinfo)(seatinfoService.getSeatinfoByIdOnly(seatId).get(0));
		return "showBeforeUpdate";
	}
	
	//修改座位信息
	public String updateSeat(){
		System.out.println(seatinfo.getIsOrder()+" "+seatinfo.getIsUsed()+" "+seatinfo.getLocation());
		boolean isUpdate=seatinfoService.updateSeatinfo(seatinfo);
		if(isUpdate){
			
			BaseTools.success("修改成功", null, "show_all_seats");
		}
		else
			BaseTools.error("修改失败", null, null);
		return "jump";
	}
	
	//一键恢复座位可预约状态
	public String recoverySeat(){
		boolean isRecovery=seatinfoService.recoveryIsOrder();
		if(isRecovery)
			BaseTools.success("设置成功", null, "admin/iframeDefault.jsp");
		else
			BaseTools.error("设置失败", null, null);
		
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
