package com.services;

import java.util.List;

import com.domain.Userinfo;

public interface UserinfoService {
	//��ȡ����
	String getPwd(String usr);
	//�����û���Ϣ
	int creatUserinfo(Userinfo userinfo);
	//ɾ���û���Ϣ
	boolean deleteUserinfo(Integer userId);
	//�޸��û���Ϣ
	boolean updateUserinfo(Userinfo userinfo);
	//��ȡ�����û���Ϣ
	List getAllUserinfo();
	//�����û�����ѯ�û���Ϣ
	List getUserinfoById(Integer userId);
	//�����û�����ѯ�û�����Ϣ
	List getUserinfoByIdOnly(Integer userId);

}
