package com.ing.creditcardpayment.exception;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorReponse implements Serializable{

	private static final long serialVersionUID = 7528478436331293543L;
	
	private String message;
	private Integer statusCode;
	public ErrorReponse(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public ErrorReponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
