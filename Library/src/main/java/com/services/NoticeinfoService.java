package com.services;

import java.util.List;

import com.domain.Noticeinfo;

public interface NoticeinfoService {
	//��������Ϣ
	int creatNoticeinfo(Noticeinfo noticeinfo);
	//�޸Ĺ�����Ϣ
	boolean updateNoticeinfo(Noticeinfo noticeinfo);
	//ɾ��������Ϣ
	boolean deleteNoticeinfo(Integer id);
	//��ȡ���й�����Ϣ
	List getAllNoticeinfo();
	//���ݹ����Ż�ȡ������Ϣ
	Noticeinfo getNoticeinfoById(Integer id);
	//��ȡ��ҳ�����б�
	List getIndexNotice();
}
