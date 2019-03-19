package com.controller;

import java.util.List;

import com.domain.Userinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserinfoService;
import com.utils.BaseTools;

public class UserAction extends ActionSupport{
	
	private Userinfo userinfo;	
	private UserinfoService userinfoService;
	private List<Userinfo> userList;//全部用户信息
	private List userinfoList;//个人信息
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
	
	//获取所有用户的信息
	public String showAllUsersMessage(){
		userList=userinfoService.getAllUserinfo();
		return "showAllUsers";
	}
	
	//查询单个用户的信息
	public String searchUserMessage(){
		userList=userinfoService.getUserinfoById(Integer.parseInt(userId));
		if(userinfoList.size()==0){
			BaseTools.error("用户不存在", null, null);
			return "jump";
		}
		return "searchUserRe";
	}
	//获取用户自己的信息
	public String showUserMessage(){
		userinfoList=userinfoService.getUserinfoById(Integer.parseInt(userId));
		return "showUser";
	}
	
	//删除用户信息
	public String deleteUser(){
		System.out.println(userId);
		boolean isDeleteUser=userinfoService.deleteUserinfo(Integer.parseInt(userId));
		if(isDeleteUser){
			BaseTools.success("删除成功", null, null);
			
		}else{
			BaseTools.error("删除失败", null, null);
			
		}
		return "jump";
	}

	//添加用户信息
	public String insertUser(){
		
		if(userinfoService.getUserinfoById(userinfo.getUserId()).size() != 0){
			BaseTools.error("添加失败，用户已存在", null, null);
			return "jump";
		}
		userinfo.setUserPw("123456");
		int isInsert=userinfoService.creatUserinfo(userinfo);
		if(isInsert==0){
			BaseTools.success("添加成功", null, null);
			
		}
		else {
			BaseTools.error("添加失败", null, null);
			
		}
		return "jump";
	}
	
	//用户修改自己的信息
	public String updateUserinfo(){
		System.out.println(userinfo.getUserName());
		boolean isUpdate=userinfoService.updateUserinfo(userinfo);
		if(isUpdate){
			System.out.println("updateUserinfo success");
			BaseTools.success("修改成功", null, "show_user_message?userId="+userinfo.getUserId());
		}
		else{
			BaseTools.error("修改失败", null, null);
			
		}
		return "jump";
	}
	
	//管理员修改用户信息之前的显示
	public String showBeforeUpdate(){
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
		return "showBeforeUpdate";
	}
	
	//管理员修改用户信息
	public String updateUser(){
		boolean isUpdate=userinfoService.updateUserinfo(userinfo);
		if(isUpdate){
			BaseTools.success("修改成功", null, "show_all_users");
			
		}
		else{
			BaseTools.error("修改失败", null, null);
			
		}
		return "jump";
	}
	
	//修改用户密码
	public String updatePassword(){
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
		if(userPw.equals(userinfo.getUserPw())){
			if(userPwNew.equals(userPwNewConfirm)){
				userinfo.setUserPw(userPwNew);
				userinfoService.updateUserinfo(userinfo);
				BaseTools.success("修改成功", null, "show_user_message?userId="+userinfo.getUserId());
				
			}
			else
				BaseTools.error("修改失败", null, null);
		}
		else
			BaseTools.error("密码不正确", null, null);
		return "jump";
	}
	
	//设置抢座好友
	public String setFriend(){
		if(userId.equals(friendId)){
			BaseTools.error("不能设置自己为好友", null, null);
			return "jump";
		}
		if(userinfoService.getUserinfoByIdOnly(Integer.parseInt(friendId)).size()==0){
			BaseTools.error("该用户不存在", null, null);
			return "jump";
		}
		userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(friendId)).get(0));
		if(friendPw.equals(userinfo.getUserPw())){
			userinfo=(Userinfo)(userinfoService.getUserinfoByIdOnly(Integer.parseInt(userId)).get(0));
			userinfo.setFriendId(Integer.parseInt(friendId));
			userinfoService.updateUserinfo(userinfo);
			BaseTools.success("设置成功", null, "show_user_message?userId="+userinfo.getUserId());
		}
		else
			BaseTools.error("设置失败", null, null);
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
