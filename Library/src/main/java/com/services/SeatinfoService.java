package com.services;

import java.util.List;

import com.domain.Seatinfo;

public interface SeatinfoService {
	//������λ��Ϣ
	int creatSeatinfo(Seatinfo seatinfo);
	//ɾ����λ��Ϣ
	boolean deleteSeatinfo(Integer id);
	//�޸���λ��Ϣ
    boolean updateSeatinfo(Seatinfo seatinfo);
    //��ȡ������λ����Ϣ
    List getAllSeatinfo();
    //������λ��Ų�ѯ��λ��Ϣ
    List getSeatinfoById(Integer seatId);
    //������λ��Ų鿴ԤԼ�����λ��Ϣ
    List getOrderinfoById(Integer seatId);
    //��ȡ����λ��Ϣ
    List getEmptySeatinfo();
    //������λ��Ż�ȡ��λ����Ϣ
    List getSeatinfoByIdOnly(Integer seatId);
    //����������λΪ��ԤԼ
    boolean recoveryIsOrder();

}
