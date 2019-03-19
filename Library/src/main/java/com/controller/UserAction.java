package com.controller;

import java.util.List;

import com.domain.Userinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserinfoService;
import com.utils.BaseTools;

public class UserAction extends ActionSupport{
	
	private Userinfo userinfo;	
	private UserinfoService userinfoService;
	private List<Userinfo> userList;//ȫ���û���Ϣ
	private List userinfoList;//������Ϣ
	private String userId;
	private String userPw;
	private String userPwNew;
	private String userPwNewConfirm;
	private String friendId;
	private String friendPw;
	
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//��ȡ�����û�����Ϣ
	public String showAllUsersMessage(){
		userList=userinfoService.getAllUserinfo();
		return "showAllUsers";
	}
	
	//��ѯ�����û�����Ϣ
	public String searchUserMessage(){
		userList=userinfoService.getUserinfoById(Integer.parseInt(userId));
		if(userinfoList.size()==0){
			BaseTools.error("�û�������", null, null);
			return "jump";
		}
		return "searchUserRe";
	}
	//��ȡ�û��Լ�����Ϣ
	public String showUserMessage(){
		userinfoList=userinfoService.getUserinfoById(Integer.parseInt(userId));
		return "showUser";
	}
	
	//ɾ���û���Ϣ
	public String deleteUser(){
		System.out.println(userId);
		boolean isDeleteUser=userinfoService.deleteUserinfo(Integer.parseInt(userId));
		if(isDeleteUser){
			BaseTools.success("ɾ���ɹ�", null, null);
			
		}else{
			BaseTools.error("ɾ��ʧ��", null, null);
			
		}
		return "jump";
	}

	//����û���Ϣ
	public String insertUser(){
		
		if(userinfoService.getUserinfoById(userinfo.getUserId()).size() != 0){
			BaseTools.error("���ʧ�ܣ��û��Ѵ���", null, null);
			return "jump";
		}
		userinfo.setUserPw("123456");
		int isInsert=userinfoService.creatUserinfo(userinfo);
		if(isInsert==0){
			BaseTools.success("��ӳɹ�", null, null);
			
		}
		else {
			BaseTools.error("���ʧ��", null, null);
			
		}
		return "jump";
	}
	
	//�û��޸��Լ�����Ϣ
	public String updateUserinfo(){
		System.out.println(userinfo.getUserName());
		boolean isUpdate=userinfoService.updateUserinfo(userinfo);
		if(isUpdate){
			System.out.println("updateUserinfo success");
			BaseTools.success("�޸ĳɹ�", null, "show_user_message?userId="+userinfo.getUserId());
		}
		else{
			BaseTools.error("�޸�ʧ��", null, null);
			
		}
		return "jump";
	}
	
	//����Ա�޸��û���Ϣ֮ǰ����ʾ
	public String showBeforeUpdate(){
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
		return "showBeforeUpdate";
	}
	
	//����Ա�޸��û���Ϣ
	public String updateUser(){
		boolean isUpdate=userinfoService.updateUserinfo(userinfo);
		if(isUpdate){
			BaseTools.success("�޸ĳɹ�", null, "show_all_users");
			
		}
		else{
			BaseTools.error("�޸�ʧ��", null, null);
			
		}
		return "jump";
	}
	
	//�޸��û�����
	public String updatePassword(){
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
		if(userPw.equals(userinfo.getUserPw())){
			if(userPwNew.equals(userPwNewConfirm)){
				userinfo.setUserPw(userPwNew);
				userinfoService.updateUserinfo(userinfo);
				BaseTools.success("�޸ĳɹ�", null, "show_user_message?userId="+userinfo.getUserId());
				
			}
			else
				BaseTools.error("�޸�ʧ��", null, null);
		}
		else
			BaseTools.error("���벻��ȷ", null, null);
		return "jump";
	}
	
	//������������
	public String setFriend(){
		if(userId.equals(friendId)){
			BaseTools.error("���������Լ�Ϊ����", null, null);
			return "jump";
		}
		if(userinfoService.getUserinfoByIdOnly(Integer.parseInt(friendId)).size()==0){
			BaseTools.error("���û�������", null, null);
			return "jump";
		}
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(friendId)).get(0));
		if(friendPw.equals(userinfo.getUserPw())){
			userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
			userinfo.setFriendId(Integer.parseInt(friendId));
			userinfoService.updateUserinfo(userinfo);
			BaseTools.success("���óɹ�", null, "show_user_message?userId="+userinfo.getUserId());
		}
		else
			BaseTools.error("����ʧ��", null, null);
		return "jump";
	}

	
	
	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public List<Userinfo> getUserList() {
		return userList;
	}

	public void setUserList(List<Userinfo> userList) {
		this.userList = userList;
	}

	public List getUserinfoList() {
		return userinfoList;
	}

	public void setUserinfoList(List userinfoList) {
		this.userinfoList = userinfoList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserPwNew() {
		return userPwNew;
	}

	public void setUserPwNew(String userPwNew) {
		this.userPwNew = userPwNew;
	}

	public String getUserPwNewConfirm() {
		return userPwNewConfirm;
	}

	public void setUserPwNewConfirm(String userPwNewConfirm) {
		this.userPwNewConfirm = userPwNewConfirm;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getFriendPw() {
		return friendPw;
	}

	public void setFriendPw(String friendPw) {
		this.friendPw = friendPw;
	}
	
}
