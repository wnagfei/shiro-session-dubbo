package com.services;

import java.util.List;

import com.domain.Majorinfo;

public interface MajorinfoService {
	
	//����רҵ��Ϣ
	int creatMajorinfo(Majorinfo majorinfo);
	//ɾ��רҵ��Ϣ
	boolean deleteMajorinfo(Integer MajorCode);
	//��ȡ���е�רҵ��Ϣ
	List getAllMajorinfo();
	//����רҵ�����ȡרҵ��Ϣ
	List getMajorinfoByCode(Integer majorCode);

}
