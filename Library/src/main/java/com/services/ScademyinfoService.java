package com.services;

import java.util.List;

import com.domain.Scademyinfo;

public interface ScademyinfoService {

	//����ѧԺ��Ϣ
	int creatScademyinfo(Scademyinfo scademyinfo);
	//ɾ��ѧԺ��Ϣ 
	boolean deleteScademyinfo(Integer scademyCode);
	//��ȡ���е�ѧԺ��Ϣ
	List getAllScademyinfo();
	//����ѧԺ�����ȡѧԺ��Ϣ
	List getScademyinfoByCode(Integer scademyCode);
}
