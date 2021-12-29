package com.instagram.Entity;

import java.math.BigInteger;

public class instagramUser {
	
	private  String name;
	private  String password;
	private  String email;
	private  String address;
	private  Long mobile; 
	private  int echoice;
	private  long otp;
	
	
	public long getOtp() {
		return otp;
	}
	public void setOtp(long otp) {
		this.otp = otp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public int getEchoice() {
		return echoice;
	}
	public void setEchoice(int echoice) {
		this.echoice = echoice;
	}
		

}
