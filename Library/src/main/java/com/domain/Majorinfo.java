package com.domain;

/**
 * Majorinfo entity. @author MyEclipse Persistence Tools
 */

public class Majorinfo implements java.io.Serializable {

	// Fields

	private Integer majorCode;
	private String majorName;
	private Integer scademyCode;

	// Constructors

	/** default constructor */
	public Majorinfo() {
	}

	/** full constructor */
	public Majorinfo(Integer majorCode, String majorName, Integer scademyCode) {
		this.majorCode = majorCode;
		this.majorName = majorName;
		this.scademyCode = scademyCode;
	}

	// Property accessors

	public Integer getMajorCode() {
		return this.majorCode;
	}

	public void setMajorCode(Integer majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getScademyCode() {
		return this.scademyCode;
	}

	public void setScademyCode(Integer scademyCode) {
		this.scademyCode = scademyCode;
	}

}