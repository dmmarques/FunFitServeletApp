package com.funfit.bean;

import java.util.Date;

public class Batch {
	
	private int bid;
	private String typeofbatch;
	private String time;
	private Date creationDate;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTypeofbatch() {
		return typeofbatch;
	}
	public void setTypeofbatch(String typeofbatch) {
		this.typeofbatch = typeofbatch;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public Batch() {
		super();
	}
	
	public Batch(int bid, String typeofbatch, String time, Date creationDate) {
		super();
		this.bid = bid;
		this.typeofbatch = typeofbatch;
		this.time = time;
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", typeofbatch=" + typeofbatch + ", time=" + time + ", creationDate="
				+ creationDate + "]";
	}	

}
