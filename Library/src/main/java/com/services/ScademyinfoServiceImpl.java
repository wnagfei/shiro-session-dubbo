package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Scademyinfo;

public class ScademyinfoServiceImpl implements ScademyinfoService {
	
	private BaseDaoHibImpl<Scademyinfo> baseDao;

	public int creatScademyinfo(Scademyinfo scademyinfo) {
		// TODO Auto-generated method stub
		baseDao.save(scademyinfo);
		return 0;
	}

	public boolean deleteScademyinfo(Integer scademyCode) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Scademyinfo.class, scademyCode,"scademyCode");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List getAllScademyinfo() {
		// TODO Auto-generated method stub
		return baseDao.findAll(Scademyinfo.class);
	}

	public List getScademyinfoByCode(Integer scademyCode){
		String hql="select s from Scademyinfo s where s.scademyCode="+scademyCode;
		System.out.println(hql);
		return baseDao.find(hql);
	}
	
	
	public BaseDaoHibImpl<Scademyinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Scademyinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
