package com.funfit.bean;

public class Students {
	
	private int pid;
	private String fname;
	private String lname;
	private int age;
	private String phonenumber;
	private int bid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	public Students() {
		super();
	}
	
	public Students(int pid, String fname, String lname, int age, String phonenumber, int bid) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.phonenumber = phonenumber;
		this.bid = bid;
	}
	
	@Override
	public String toString() {
		return "Students [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", phonenumber="
				+ phonenumber + ", bid=" + bid + "]";
	}

}
