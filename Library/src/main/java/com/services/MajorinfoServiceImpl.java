package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Majorinfo;

public class MajorinfoServiceImpl implements MajorinfoService {
	
	private BaseDaoHibImpl<Majorinfo> baseDao;

	public int creatMajorinfo(Majorinfo majorinfo) {
		// TODO Auto-generated method stub
		baseDao.save(majorinfo);
		return 0;
	}

	public boolean deleteMajorinfo(Integer MajorCode) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Majorinfo.class, MajorCode,"majorCode");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List getAllMajorinfo() {
		// TODO Auto-generated method stub
		String hql="select new map(m.majorCode as majorCode,m.majorName as majorName,m.scademyCode as scademyCode,s.scademyName as scademyName) " +
				"from Majorinfo m,Scademyinfo s where m.scademyCode=s.scademyCode";
		return baseDao.find(hql);
	}

	public List getMajorinfoByCode(Integer majorCode){
		String hql="select m from Majorinfo m where m.majorCode="+majorCode;
		return baseDao.find(hql);
	}
	
	
	
	public BaseDaoHibImpl<Majorinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Majorinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
