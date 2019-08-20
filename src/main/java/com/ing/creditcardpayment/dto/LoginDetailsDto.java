package com.ing.creditcardpayment.dto;

import lombok.Getter;
import lombok.Setter;


public class LoginDetailsDto {
	private String message;
	private Integer userId;
	private String status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
