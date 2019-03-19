package com.services;

import java.util.List;

import com.dao.BaseDaoHibImpl;
import com.domain.Noticeinfo;

public class NoticeinfoServiceImpl implements NoticeinfoService {
	
	private BaseDaoHibImpl<Noticeinfo> baseDao;

	public int creatNoticeinfo(Noticeinfo noticeinfo) {
		// TODO Auto-generated method stub
		baseDao.save(noticeinfo);
		return 0;
	}

	public boolean updateNoticeinfo(Noticeinfo noticeinfo) {
		// TODO Auto-generated method stub
		try {
			baseDao.update(noticeinfo);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public boolean deleteNoticeinfo(Integer id) {
		// TODO Auto-generated method stub
		try {
			baseDao.delete(Noticeinfo.class,id,"id");
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List getAllNoticeinfo() {
		// TODO Auto-generated method stub
		return baseDao.findAll(Noticeinfo.class);
	}
	
	public List getIndexNotice() {
		String hql="select notice from Noticeinfo notice order by notice.date desc limit 10";
		return baseDao.find(hql);
	}
	
	public Noticeinfo getNoticeinfoById(Integer id){
		
		return baseDao.get(Noticeinfo.class, id);
	}
	
	public BaseDaoHibImpl<Noticeinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Noticeinfo> baseDao) {
		this.baseDao = baseDao;
	}
}
