package com.domain;

/**
 * Longtermapplyinfo entity. @author MyEclipse Persistence Tools
 */

public class Longtermapplyinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer seatId;
	private String isAgree;
	private Integer time;

	// Constructors

	/** default constructor */
	public Longtermapplyinfo() {
	}

	/** full constructor */
	public Longtermapplyinfo(Integer userId, Integer seatId, String isAgree,
			Integer time) {
		this.userId = userId;
		this.seatId = seatId;
		this.isAgree = isAgree;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getIsAgree() {
		return this.isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}