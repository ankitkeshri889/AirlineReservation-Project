package com.pojo;

import java.sql.Date;

public class Payment {
	 int pay_id = 100;
	int pnr_no;
	long phone;
	int price;
	Date pay_date;
	String f_code;
	
//	public Payment(){
//		pay_id++;
//	}
	
	public int getPay_id() {
		return pay_id++;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getPnr_no() {
		return pnr_no;
	}
	public void setPnr_no(int pnr_no) {
		this.pnr_no = pnr_no;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date date) {
		this.pay_date = date;
	}
	public String getF_code() {
		return f_code;
	}
	public void setF_code(String f_code) {
		this.f_code = f_code;
	}
	
	
	
}
