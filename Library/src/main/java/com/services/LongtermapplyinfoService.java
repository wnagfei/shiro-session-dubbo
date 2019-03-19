package com.services;

import java.util.List;

import com.domain.Longtermapplyinfo;

public interface LongtermapplyinfoService {
	//增添长期座位申请
	int creatLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo);
	//删除长期座位申请
	boolean deleteLongtermapplyinfo(Integer id);
	//根据用户名查询长期座位申请信息
	List getLongtermapplyinfoByUserId(Integer UserId);
	//查看所有的长期座位申请
	List getAllLongtermapplyinfo();
	//根据id获取长期座位申请信息
	List getLongtermapplyinfoById(Integer id);
	//更新长期申请信息
	boolean updateLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo);
	

}
