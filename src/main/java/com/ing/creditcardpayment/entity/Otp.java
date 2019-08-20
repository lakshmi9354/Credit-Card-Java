package com.ing.creditcardpayment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Otp implements Serializable {

	
private static final long serialVersionUID = 7771935079393339853L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int otpId;
	private int otpNo;
	private Date date;
	private String status;
	private int creditCardId;
	public int getOtpId() {
		return otpId;
	}
	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}
	public int getOtpNo() {
		return otpNo;
	}
	public void setOtpNo(int otpNo) {
		this.otpNo = otpNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
