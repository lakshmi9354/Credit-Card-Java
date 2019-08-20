package com.ing.creditcardpayment.service;

import java.util.List;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementsDto;

public interface StatementService {
	public List<StatementDetailsDto> history(StatementsDto statementDto );
}
