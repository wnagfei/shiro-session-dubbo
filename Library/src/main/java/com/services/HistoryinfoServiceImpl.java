package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Historyinfo;

public class HistoryinfoServiceImpl implements HistoryinfoService {
	
	private BaseDaoHibImpl<Historyinfo> baseDao;

	public int creatHistoryinfo(Historyinfo historyinfo) {
		// TODO Auto-generated method stub
		baseDao.save(historyinfo);
		return 0;
	}

	public boolean deleteHistoryinfo(Integer id) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Historyinfo.class,id,"id");
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return true;
	}

	public List getAllHistoryinfo() {
		// TODO Auto-generated method stub
		return baseDao.findAll(Historyinfo.class);
	}
	
	public List getHistoryinfoByUserId(Integer userId){
		String hql="select new map(h.id as id,h.userId as userId,h.seatId as seatId,h.date as date,s.location as location) from Historyinfo h,Seatinfo s where h.userId="
				+ userId+" and h.seatId=s.seatId";
		return baseDao.find(hql);
	}
	
	public boolean deleteAllHistorys(Integer userId){
		
		try {
			baseDao.delete(Historyinfo.class, userId, "userId");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
	public BaseDaoHibImpl<Historyinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Historyinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
