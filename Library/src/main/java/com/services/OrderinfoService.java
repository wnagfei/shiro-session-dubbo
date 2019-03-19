package com.services;

import java.util.List;

import com.domain.Orderinfo;

public interface OrderinfoService {
	//增添预约信息
	int creatOrderinfo(Orderinfo orderinfo);
	//删除预约信息
	boolean deleteOrderinfo(String id);
	//删除所有预约信息
	boolean deleteAllOrderinfo();
	//根据用户名查询预约信息
	List getOrderinfoByUserId(Integer userId);
	//根据座位编号查询预约信息
	List getOrderinfoBySeatId(Integer seatId);
	//一键删除预约信息
	boolean deleteAll();

}
