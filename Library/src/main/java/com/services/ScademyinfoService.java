package com.services;

import java.util.List;

import com.domain.Scademyinfo;

public interface ScademyinfoService {

	//创建学院信息
	int creatScademyinfo(Scademyinfo scademyinfo);
	//删除学院信息 
	boolean deleteScademyinfo(Integer scademyCode);
	//获取所有的学院信息
	List getAllScademyinfo();
	//根据学院代码获取学院信息
	List getScademyinfoByCode(Integer scademyCode);
}
