package com.services;

import java.util.List;

import com.domain.Longtermapplyinfo;

public interface LongtermapplyinfoService {
	//��������λ����
	int creatLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo);
	//ɾ��������λ����
	boolean deleteLongtermapplyinfo(Integer id);
	//�����û�����ѯ������λ������Ϣ
	List getLongtermapplyinfoByUserId(Integer UserId);
	//�鿴���еĳ�����λ����
	List getAllLongtermapplyinfo();
	//����id��ȡ������λ������Ϣ
	List getLongtermapplyinfoById(Integer id);
	//���³���������Ϣ
	boolean updateLongtermapplyinfo(Longtermapplyinfo longtermapplyinfo);
	

}
