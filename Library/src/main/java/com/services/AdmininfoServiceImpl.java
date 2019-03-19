package com.services;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.BaseDaoHibImpl;
import com.domain.Admininfo;

public class AdmininfoServiceImpl implements AdmininfoService {
	
	private BaseDaoHibImpl<Admininfo> baseDao;

	public String getPwd(String usr) {
		// TODO Auto-generated method stub
		Admininfo admininfo = baseDao.get(Admininfo.class,usr);
		if(admininfo != null){
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("admininfo", admininfo);
			return admininfo.getAdminPw();
		}
		else return "#";
	}

	public int creatAdmininfo(Admininfo admininfo) {
		// TODO Auto-generated method stub
		baseDao.save(admininfo);
		return 0;
	}

	public Admininfo getAdmininfoById(String username){
		
		return baseDao.get(Admininfo.class, username);
	}
	
	public boolean updateAdmininfo(Admininfo admininfo) {
		// TODO Auto-generated method stub
		try {
			baseDao.update(admininfo);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public BaseDaoHibImpl<Admininfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Admininfo> baseDao) {
		this.baseDao = baseDao;
	}

}
