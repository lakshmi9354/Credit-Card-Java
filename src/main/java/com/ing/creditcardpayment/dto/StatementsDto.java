package com.ing.creditcardpayment.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class StatementsDto {
private Date fromDate;
private Date toDate;
private Long creditCardNumber;
private int userId;
}
