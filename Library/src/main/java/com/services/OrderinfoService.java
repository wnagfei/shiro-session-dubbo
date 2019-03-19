package com.services;

import java.util.List;

import com.domain.Orderinfo;

public interface OrderinfoService {
	//����ԤԼ��Ϣ
	int creatOrderinfo(Orderinfo orderinfo);
	//ɾ��ԤԼ��Ϣ
	boolean deleteOrderinfo(String id);
	//ɾ������ԤԼ��Ϣ
	boolean deleteAllOrderinfo();
	//�����û�����ѯԤԼ��Ϣ
	List getOrderinfoByUserId(Integer userId);
	//������λ��Ų�ѯԤԼ��Ϣ
	List getOrderinfoBySeatId(Integer seatId);
	//һ��ɾ��ԤԼ��Ϣ
	boolean deleteAll();

}
