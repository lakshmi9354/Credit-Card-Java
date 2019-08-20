package com.ing.creditcardpayment.service;

import java.util.List;

import com.ing.creditcardpayment.dto.StatementDetailsDto;
import com.ing.creditcardpayment.dto.StatementDto;

public interface StatementService {
	public List<StatementDetailsDto> history(StatementDto statementDto );
}
