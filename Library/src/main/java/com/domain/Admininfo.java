package com.domain;

/**
 * Admininfo entity. @author MyEclipse Persistence Tools
 */

public class Admininfo implements java.io.Serializable {

	// Fields

	private String adminName;
	private String adminPw;

	// Constructors

	/** default constructor */
	public Admininfo() {
	}

	/** full constructor */
	public Admininfo(String adminName, String adminPw) {
		this.adminName = adminName;
		this.adminPw = adminPw;
	}

	// Property accessors

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPw() {
		return this.adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

}