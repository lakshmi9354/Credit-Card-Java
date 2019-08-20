package com.ing.creditcardpayment.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString @NoArgsConstructor
public class StatementDetailsDto {
	
	private Long creditCardNumber;
	private double amount;
	private String transactionType;
	private Date transactionDate;
	private String reason;
	private String message;
	}

