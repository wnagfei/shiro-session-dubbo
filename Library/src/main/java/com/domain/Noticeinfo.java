package com.domain;

/**
 * Noticeinfo entity. @author MyEclipse Persistence Tools
 */

public class Noticeinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String amallTitle;
	private String contents;
	private String accessory;
	private String date;
	private String author;

	// Constructors

	/** default constructor */
	public Noticeinfo() {
	}

	/** minimal constructor */
	public Noticeinfo(String title, String contents, String date, String author) {
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.author = author;
	}

	/** full constructor */
	public Noticeinfo(String title, String amallTitle, String contents,
			String accessory, String date, String author) {
		this.title = title;
		this.amallTitle = amallTitle;
		this.contents = contents;
		this.accessory = accessory;
		this.date = date;
		this.author = author;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAmallTitle() {
		return this.amallTitle;
	}

	public void setAmallTitle(String amallTitle) {
		this.amallTitle = amallTitle;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAccessory() {
		return this.accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}