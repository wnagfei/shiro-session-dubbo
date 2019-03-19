package com.services;

import java.util.List;

import com.domain.Noticeinfo;

public interface NoticeinfoService {
	//增添公告信息
	int creatNoticeinfo(Noticeinfo noticeinfo);
	//修改公告信息
	boolean updateNoticeinfo(Noticeinfo noticeinfo);
	//删除公告信息
	boolean deleteNoticeinfo(Integer id);
	//获取所有公告信息
	List getAllNoticeinfo();
	//根据公告编号获取公告信息
	Noticeinfo getNoticeinfoById(Integer id);
	//获取首页公告列表
	List getIndexNotice();
}
