package com.domain;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */

public class Orderinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer seatId;

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** full constructor */
	public Orderinfo(Integer userId, Integer seatId) {
		this.userId = userId;
		this.seatId = seatId;
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

}