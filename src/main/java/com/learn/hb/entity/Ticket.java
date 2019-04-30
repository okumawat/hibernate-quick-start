package com.learn.hb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

public class Ticket implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6358628172217859598L;
	private int id;
	private String title;
	private String description;
	private int applicationId;
	private String status;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int id, String title, String description, int applicationId, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.applicationId = applicationId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+","+title+","+status;
	}
	
}
