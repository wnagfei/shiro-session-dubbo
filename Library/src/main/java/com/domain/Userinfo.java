package com.domain;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userPw;
	private String userName;
	private String userSex;
	private Integer majorCode;
	private String phoneNum;
	private String email;
	private Integer friendId;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(Integer userId, String userPw, String userName,
			String userSex, Integer majorCode) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userSex = userSex;
		this.majorCode = majorCode;
	}

	/** full constructor */
	public Userinfo(Integer userId, String userPw, String userName,
			String userSex, Integer majorCode, String phoneNum, String email,
			Integer friendId) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userSex = userSex;
		this.majorCode = majorCode;
		this.phoneNum = phoneNum;
		this.email = email;
		this.friendId = friendId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return this.userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getMajorCode() {
		return this.majorCode;
	}

	public void setMajorCode(Integer majorCode) {
		this.majorCode = majorCode;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

}