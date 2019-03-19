package com.services;

import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.BaseDaoHibImpl;
import com.domain.Userinfo;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class UserinfoServiceImpl implements UserinfoService {
	
	private BaseDaoHibImpl<Userinfo> baseDao;

	public String getPwd(String usr) {
		// TODO Auto-generated method stub
		Userinfo userinfo=baseDao.get(Userinfo.class, Integer.parseInt(usr));
		if(userinfo!=null){
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("userinfo", userinfo);
			return userinfo.getUserPw();
		}
		else 
			return "#";
	}

	public int creatUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		baseDao.save(userinfo);
		return 0;
	}

	public boolean deleteUserinfo(Integer userId) {
		// TODO Auto-generated method stub
		System.out.println(userId);
		try {
			baseDao.delete(Userinfo.class,userId,"userId");
		} catch (Exception e) {
			// TODO: handle exception
			
			return false;
		}
		return true;
	}

	public boolean updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		try {
			System.out.println(userinfo);
			baseDao.update(userinfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List getAllUserinfo() {
		// TODO Auto-generated method stub
		String hql="select new map(u.userId as userId,u.userName as userName,u.userSex as userSex,u.phoneNum as phoneNum,u.email as email,u.friendId as friendId,m.majorName as majorName,s.scademyName as scademyName) " +
				"from Userinfo u,Majorinfo m,Scademyinfo s where u.majorCode=m.majorCode and m.scademyCode=s.scademyCode";
		return baseDao.find(hql);
	}

	public List getUserinfoById(Integer userId) {
		// TODO Auto-generated method stub
		String hql="select new map(u.userId as userId,u.userPw as userPw,u.userName as userName,u.userSex as userSex,u.phoneNum as phoneNum,u.email as email,u.friendId as friendId,u.majorCode as majorCode,m.majorName as majorName,s.scademyName as scademyName) from Userinfo u,Majorinfo m,Scademyinfo s where u.userId="
				+ userId +" and u.majorCode=m.majorCode and m.scademyCode=s.scademyCode";
		return baseDao.find(hql);
	}
	
	public List getUserinfoByIdOnly(Integer userId){
		
		String hql="select u from Userinfo u where u.userId="+userId;
		return baseDao.find(hql);
	}

	
	public BaseDaoHibImpl<Userinfo> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoHibImpl<Userinfo> baseDao) {
		this.baseDao = baseDao;
	}

}
