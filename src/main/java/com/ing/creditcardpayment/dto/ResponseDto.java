package com.ing.creditcardpayment.dto;

public class ResponseDto {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDto(String message) {
		super();
		this.message = message;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
