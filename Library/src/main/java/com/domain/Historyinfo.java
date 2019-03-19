package com.domain;

/**
 * Historyinfo entity. @author MyEclipse Persistence Tools
 */

public class Historyinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String seatId;
	private String date;

	// Constructors

	/** default constructor */
	public Historyinfo() {
	}

	/** full constructor */
	public Historyinfo(Integer userId, String seatId, String date) {
		this.userId = userId;
		this.seatId = seatId;
		this.date = date;
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

	public String getSeatId() {
		return this.seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}