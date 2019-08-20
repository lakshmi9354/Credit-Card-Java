package com.ing.creditcardpayment.service;

import java.util.List;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;
import com.ing.creditcardpayment.exception.CreditCardNotFound;

public interface StatementService {
	public List<StatementDetailsDto> history(StatementsDto statementDto ) throws CreditCardNotFound;
}
