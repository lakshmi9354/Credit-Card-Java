package com.ing.creditcardpayment.service;

import com.ing.creditcardpayment.dto.ResponseDto;
import com.ing.creditcardpayment.dto.StatementDto;

public interface PayService {
	
	public ResponseDto addTransaction(StatementDto statementDto);

}
