package com.services;

import java.util.List;

import com.domain.Historyinfo;

public interface HistoryinfoService {
	//增添历史记录信息
	int creatHistoryinfo(Historyinfo historyinfo);
	//删除历史记录信息
	boolean deleteHistoryinfo(Integer id);
	//获取所有历史记录信息
	List getAllHistoryinfo();
	//根据用户帐号获取历史记录信息
	List getHistoryinfoByUserId(Integer userId);
	//删除用户所有的历史记录
	boolean deleteAllHistorys(Integer userId);

}
