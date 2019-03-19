package com.domain;

/**
 * Scademyinfo entity. @author MyEclipse Persistence Tools
 */

public class Scademyinfo implements java.io.Serializable {

	// Fields

	private Integer scademyCode;
	private String scademyName;

	// Constructors

	/** default constructor */
	public Scademyinfo() {
	}

	/** full constructor */
	public Scademyinfo(Integer scademyCode, String scademyName) {
		this.scademyCode = scademyCode;
		this.scademyName = scademyName;
	}

	// Property accessors

	public Integer getScademyCode() {
		return this.scademyCode;
	}

	public void setScademyCode(Integer scademyCode) {
		this.scademyCode = scademyCode;
	}

	public String getScademyName() {
		return this.scademyName;
	}

	public void setScademyName(String scademyName) {
		this.scademyName = scademyName;
	}

}