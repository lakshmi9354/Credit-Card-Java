package com.ing.creditcardpayment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StatementDto {

	
	private Long creditCardNumber;
	private Double amount;
	private String transactionType;
	private String expiryDate;
	private String reason;
	private String cardType;
	
}
