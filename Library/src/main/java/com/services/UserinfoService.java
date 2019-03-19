package com.services;

import java.util.List;

import com.domain.Userinfo;

public interface UserinfoService {
	//获取密码
	String getPwd(String usr);
	//增添用户信息
	int creatUserinfo(Userinfo userinfo);
	//删除用户信息
	boolean deleteUserinfo(Integer userId);
	//修改用户信息
	boolean updateUserinfo(Userinfo userinfo);
	//获取所有用户信息
	List getAllUserinfo();
	//根据用户名查询用户信息
	List getUserinfoById(Integer userId);
	//根据用户名查询用户表信息
	List getUserinfoByIdOnly(Integer userId);

}
