package com.domain;

/**
 * Seatinfo entity. @author MyEclipse Persistence Tools
 */

public class Seatinfo implements java.io.Serializable {

	// Fields

	private Integer seatId;
	private String location;
	private String isOrder;
	private String isUsed;

	// Constructors

	/** default constructor */
	public Seatinfo() {
	}

	/** full constructor */
	public Seatinfo(Integer seatId, String location, String isOrder,
			String isUsed) {
		this.seatId = seatId;
		this.location = location;
		this.isOrder = isOrder;
		this.isUsed = isUsed;
	}

	// Property accessors

	public Integer getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsOrder() {
		return this.isOrder;
	}

	public void setIsOrder(String isOrder) {
		this.isOrder = isOrder;
	}

	public String getIsUsed() {
		return this.isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

}