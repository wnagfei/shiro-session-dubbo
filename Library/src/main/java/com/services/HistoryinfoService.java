package com.services;

import java.util.List;

import com.domain.Historyinfo;

public interface HistoryinfoService {
	//������ʷ��¼��Ϣ
	int creatHistoryinfo(Historyinfo historyinfo);
	//ɾ����ʷ��¼��Ϣ
	boolean deleteHistoryinfo(Integer id);
	//��ȡ������ʷ��¼��Ϣ
	List getAllHistoryinfo();
	//�����û��ʺŻ�ȡ��ʷ��¼��Ϣ
	List getHistoryinfoByUserId(Integer userId);
	//ɾ���û����е���ʷ��¼
	boolean deleteAllHistorys(Integer userId);

}
