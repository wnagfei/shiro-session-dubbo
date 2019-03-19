package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Orderinfo;

public class OrderinfoServiceImpl implements OrderinfoService {
	
	private BaseDaoHibImpl<Orderinfo> baseDao;

	public int creatOrderinfo(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		baseDao.save(orderinfo);
		return 0;
	}

	public boolean deleteOrderinfo(String id) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Orderinfo.class, id,"id");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public boolean deleteAllOrderinfo() {
		// TODO Auto-generated method stub
		return false;
	}

	public List getOrderinfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		String hql="select new map(s.seatId as seatId,s.location as location,s.isOrder as isOrder,s.isUsed as isUsed,o.id as id) from Seatinfo s,Orderinfo o where o.userId="
				+ userId +" and o.seatId=s.seatId";
		return baseDao.find(hql);
	}
	
	public List getOrderinfoBySeatId(Integer seatId){
		String hql="select new map(u.userId as userId,u.userName as userName,u.userSex as userSex,u.phoneNum as phoneNum,u.email as email,m.majorName as majorName,s.scademyName as scademyName) from Orderinfo o,Userinfo u,Scademyinfo s,Majorinfo m " +
				"where u.majorCode=m.majorCode and m.scademyCode=s.scademyCode and o.userId=u.userId and o.seatId="+seatId;
		return baseDao.find(hql);
	}

	public boolean deleteAll(){
		try {
			baseDao.deleteAll("orderinfo");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public BaseDaoHibImpl<Orderinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Orderinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
