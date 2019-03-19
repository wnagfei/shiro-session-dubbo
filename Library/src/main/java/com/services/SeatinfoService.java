package com.services;

import java.util.List;

import com.domain.Seatinfo;

public interface SeatinfoService {
	//增添座位信息
	int creatSeatinfo(Seatinfo seatinfo);
	//删除座位信息
	boolean deleteSeatinfo(Integer id);
	//修改座位信息
    boolean updateSeatinfo(Seatinfo seatinfo);
    //获取所有座位的信息
    List getAllSeatinfo();
    //根据座位编号查询座位信息
    List getSeatinfoById(Integer seatId);
    //根据座位编号查看预约后的座位信息
    List getOrderinfoById(Integer seatId);
    //获取空座位信息
    List getEmptySeatinfo();
    //根据座位编号获取座位表信息
    List getSeatinfoByIdOnly(Integer seatId);
    //设置所有座位为可预约
    boolean recoveryIsOrder();

}
