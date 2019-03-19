package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Longtermapplyinfo;

public class LongtermapplyinfoServiceImpl implements LongtermapplyinfoService {
	
	private BaseDaoHibImpl<Longtermapplyinfo> baseDao;

	public int creatLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo) {
		// TODO Auto-generated method stub
		baseDao.save(longtermapplyinfo);
		return 0;
	}

	public boolean deleteLongtermapplyinfo(Integer id) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Longtermapplyinfo.class, id,"id");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List getLongtermapplyinfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		String hql="select l from Longtermapplyinfo l where l.userId="+ userId;
		return baseDao.find(hql);
	}
	
	public List getLongtermapplyinfoById(Integer id){
		String hql="select l from Longtermapplyinfo l where l.id="+id;
		return baseDao.find(hql);
	}
	
	public List getAllLongtermapplyinfo(){
		return baseDao.findAll(Longtermapplyinfo.class);
	}

	public boolean updateLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo){
		try {
			baseDao.update(longtermapplyinfo);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	
	public BaseDaoHibImpl<Longtermapplyinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Longtermapplyinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
