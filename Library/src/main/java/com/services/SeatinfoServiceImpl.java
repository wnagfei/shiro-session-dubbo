package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Seatinfo;

public class SeatinfoServiceImpl implements SeatinfoService {
	
	private BaseDaoHibImpl<Seatinfo> baseDao;

	public int creatSeatinfo(Seatinfo seatinfo) {
		// TODO Auto-generated method stub
		baseDao.save(seatinfo);
		return 0;
	}

	public boolean deleteSeatinfo(Integer id) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Seatinfo.class,id,"id");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public boolean updateSeatinfo(Seatinfo seatinfo) {
		// TODO Auto-generated method stub
		try {
			baseDao.update(seatinfo);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List getAllSeatinfo() {
		// TODO Auto-generated method stub
		return baseDao.findAll(Seatinfo.class);
	}

	public List getSeatinfoById(Integer seatId) {
		// TODO Auto-generated method stub
		String hql="select s from Seatinfo s where s.seatId="+seatId;
		return baseDao.find(hql);
	}

	public List getOrderinfoById(Integer seatId){
		
		String hql="select new map(s.seatId as seatId,s.location as location,s.isOrder as isOrder,u.userName as userName,u.phoneNum as phoneNum,m.majorName as majorName) from Seatinfo s,Orderinfo o,Userinfo u,Majorinfo m where s.seatId="
				+ seatId +" and s.seatId=o.seatId and o.userId=u.userId and u.majorCode=m.majorCode";
		return baseDao.find(hql);
	}
	
	public List getEmptySeatinfo() {
		// TODO Auto-generated method stub
		String hql="select s from Seatinfo s where s.isOrder='yes' and s.isUsed='yes'";
		return baseDao.find(hql);
	}
	
	public List getSeatinfoByIdOnly(Integer seatId){
		
		String hql="select s from Seatinfo s where s.seatId="+seatId;
		return baseDao.find(hql);
	}

	public boolean recoveryIsOrder(){
		try {
			baseDao.setFieldValue("seatinfo", "isOrder", "yes");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	
	public BaseDaoHibImpl<Seatinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Seatinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
